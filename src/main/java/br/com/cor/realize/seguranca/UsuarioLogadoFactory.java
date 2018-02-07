package br.com.correios.realize.seguranca;

import br.com.correios.componente.idautorizador.usuario.*;
import br.com.correios.realize.constantes.MensagemID;
import br.com.correios.realize.excecao.CorreiosException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class UsuarioLogadoFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(Usuario.class);

    private static final String GRUPO_USUARIO_EXTERNO_PESSOA_FISICA = "CLIENTE CS PF";

    private static final String IDIOMA = "P";

    @Autowired
    private IdAutorizadorUsuarioService autorizadorServico;


    public void constroiUsuarioLogado(HttpServletRequest request, Usuario usuario) throws CorreiosException {

        if (request.getUserPrincipal() == null) {
            return;
        }

        adicionaUsuarioExternoOuInternoAoUsuario(usuario, request);

        adicionaMenuAoUsuario(usuario);

        adicionaGruposAoUsuario(usuario);

        adicionaFuncionalidadesAoUsuario(usuario);

        adicionaSistemasPermitidosPara(usuario);

        usuario.setIp(request.getRemoteAddr());

        LOGGER.info("Usuario montado:" + usuario.getNome());
    }

    private void adicionaSistemasPermitidosPara(Usuario usuario) throws CorreiosException {
        try {
            UsuarioExterno usuarioExterno = usuario.getUsuarioExterno();
            if (usuarioExterno != null && usuarioExterno.getUsuarioInterno() == null) {
                List<Sistema> sistemas = autorizadorServico.listarSistemasDoUsuarioExterno(usuarioExterno.getIdCorreios());
                List<Sistema> maisSistemas = autorizadorServico.listarSistemasExternosPublicosPorTipoUsuario(usuarioExterno.getIdCorreios());
                usuario.getSistemas().addAll(sistemas.stream().map(Sistema::getIProjTI).collect(Collectors.toList()));
                usuario.getSistemas().addAll(maisSistemas.stream().map(Sistema::getIProjTI).collect(Collectors.toList()));
            } else {
                List<Sistema> sistemas = autorizadorServico.listarSistemasAtivosDoUsuarioInterno(usuario.getUsuarioInterno().getId());
                List<VWSistema> vwSistemas = sistemas.stream().map(Sistema::getIProjTI).collect(Collectors.toList());
                usuario.getSistemas().addAll(vwSistemas);
            }
        } catch (ComponenteException e) {
            LOGGER.error(e.getMessage(), e);
            throw new CorreiosException(MensagemID.ERRO_GRAVE, e.getMessage());
        }
    }

    private void adicionaFuncionalidadesAoUsuario(Usuario usuario) throws CorreiosException {
        for (Grupo g : usuario.getGrupos()) {
            try {
                List<Funcionalidade> funcionalidades = autorizadorServico.listarFuncionalidadesAutorizadasDoGrupo(g.getId().getIdGrupo());
                usuario.getFuncionalidades().addAll(funcionalidades);
            } catch (ComponenteException e) {
                throw new CorreiosException(e);
            }

        }
        usuario.setUlsDasFuncionalidades(new ArrayList<String>());
        for (Funcionalidade f : usuario.getFuncionalidades()) {
            usuario.getUlsDasFuncionalidades().add(f.getUrl().replaceAll("jsf", "xhtml"));
        }

    }


    private void adicionaUsuarioExternoOuInternoAoUsuario(Usuario usuario, HttpServletRequest request)
            throws CorreiosException {

        UsuarioExterno usuarioExterno = null;
        UsuarioInterno usuarioInterno = null;
        try {
            usuarioExterno = autorizadorServico.getUsuarioExterno(request.getUserPrincipal().getName());
            usuario.setUsuarioExterno(usuarioExterno);
            if (usuarioExterno == null) {
                usuarioInterno = autorizadorServico.getUsuarioInternoAtivoPeloLogin(request.getUserPrincipal().getName());
                usuario.setUsuarioInterno(usuarioInterno);
            }
        } catch (ComponenteException e) {
            throw new CorreiosException(e);
        } catch (WebServiceException e) {
            LOGGER.error("Erro na chamada do WS do IdAutorizador", e);
            throw new CorreiosException(MensagemID.ERRO_GRAVE, "O Realize não está conseguindo se comunicar com IDCorreios");
        }
        if (usuarioExterno == null && usuarioInterno == null) {
            throw new CorreiosException("acesso.negado");
        }
    }

    private void adicionaGruposAoUsuario(Usuario usuario)
            throws CorreiosException {
        try {
            if (usuario.getUsuarioExterno() != null && usuario.getUsuarioExterno().getUsuarioExternoPJ() == null) {
                List<Grupo> gruposAutorizadosDoUsuarioPF = autorizadorServico
                        .listarGruposHabilitadosDoUsuarioExternoNoSistema(usuario.getUsuarioExterno().getIdCorreios());
                usuario.getGrupos().addAll(gruposAutorizadosDoUsuarioPF);

            } else if (usuario.getUsuarioExterno() != null
                    && usuario.getUsuarioExterno().getUsuarioInterno() == null) {
                List<Grupo> gruposAutorizadosDoUsuarioPF = autorizadorServico
                        .listarGruposAutorizadosDoUsuarioPF(usuario
                                .getUsuarioExterno().getUsuarioExternoPJ()
                                .getIdCorreios(), usuario.getUsuarioExterno()
                                .getIdCorreios());
                usuario.getGrupos().addAll(gruposAutorizadosDoUsuarioPF);
            } else {
                List<Grupo> gruposAutorizadosDoUsuarioInternoNoSistema = autorizadorServico
                        .listarGruposAutorizadosDoUsuarioInternoNoSistema(usuario
                                .getUsuarioInterno().getId());
                usuario.getGrupos().addAll(
                        gruposAutorizadosDoUsuarioInternoNoSistema);
            }
        } catch (ComponenteException e) {
            throw new CorreiosException(e);
        }
    }

    private void adicionaMenuAoUsuario(Usuario usuario) throws CorreiosException {
        try {
            if (usuario.getUsuarioExterno() != null && usuario.getUsuarioExterno().getUsuarioExternoPJ() == null) {
                List<Integer> listaIdGrupo = recuperaListaIdGrupo(GRUPO_USUARIO_EXTERNO_PESSOA_FISICA);

                List<ItemMenu> itensMenuIdiomaAutorizadosDoUsuarioPF = autorizadorServico.listarItensMenuIdiomaAtivosDosGrupos(
                        listaIdGrupo, IDIOMA);
                usuario.setItensDeMenu(itensMenuIdiomaAutorizadosDoUsuarioPF);

            } else if (usuario.getUsuarioExterno() != null
                    && usuario.getUsuarioExterno().getUsuarioExternoPJ() != null
                    && usuario.getUsuarioExterno().getUsuarioInterno() == null) {

                List<ItemMenu> itensMenuIdiomaAutorizadosDoUsuarioPF = autorizadorServico
                        .listarItensMenuIdiomaAutorizadosDoUsuarioPF(usuario.getUsuarioExterno().getUsuarioExternoPJ().getIdCorreios(),
                                usuario.getLogin(), IDIOMA);
                usuario.setItensDeMenu(itensMenuIdiomaAutorizadosDoUsuarioPF);
            } else {
                List<ItemMenu> menuIdiomaAutorizadosDoUsuarioInterno = autorizadorServico.listarItensMenuIdiomaAutorizadosDoUsuarioInterno(
                        usuario.getUsuarioInterno().getId(), IDIOMA);
                usuario.setItensDeMenu(menuIdiomaAutorizadosDoUsuarioInterno);
            }
        } catch (ComponenteException e) {
            throw new CorreiosException(e);
        }
    }

    private List<Integer> recuperaListaIdGrupo(String nomeGrupo) throws ComponenteException {
        Grupo grupo = autorizadorServico.getGrupoPeloNome(nomeGrupo);

        List<Integer> listaIdGrupo = new ArrayList<>();
        listaIdGrupo.add(grupo.getId().getIdGrupo());
        return listaIdGrupo;
    }


}

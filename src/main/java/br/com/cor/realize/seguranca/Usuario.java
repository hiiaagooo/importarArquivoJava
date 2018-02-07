package br.com.correios.realize.seguranca;

import br.com.correios.componente.idautorizador.usuario.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;
import java.util.List;

@Component("usuario")
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Usuario implements javax.servlet.http.HttpSessionBindingListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Usuario.class);

    private static final int QUATRO = 4;

    private static final int TRES = 3;

    private static final int DOIS = 2;

    private static final int UM = 1;

    private List<Grupo> grupos = new ArrayList<>();

    private List<Funcionalidade> funcionalidades = new ArrayList<>();

    private List<String> ulsDasFuncionalidades;

    private List<ItemMenu> itensDeMenu = new ArrayList<>();

    private List<ItemMenuDecorator> menu;

    private List<UsuarioExternoPJ> usuariosExternosPJ = new ArrayList<>();

    private List<VWSistema> sistemas = new ArrayList<>();

    private String nome;
    private String login;
    private String email;
    private String siglaLotacao;
    private String ip;
    private UsuarioExterno usuarioExterno;
    private UsuarioInterno usuarioInterno;


    public boolean isAutorizado(String url) {
        return ulsDasFuncionalidades.contains(url);
    }


    /**
     * @return the grupos
     */
    public List<Grupo> getGrupos() {
        return grupos;
    }


    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }


    /**
     * @return the usuariosExternosPJ
     */
    public List<UsuarioExternoPJ> getUsuariosExternosPJ() {
        return usuariosExternosPJ;
    }


    /**
     * @param usuariosExternosPJ the usuariosExternosPJ to set
     */
    public void setUsuariosExternosPJ(List<UsuarioExternoPJ> usuariosExternosPJ) {
        this.usuariosExternosPJ = usuariosExternosPJ;
    }


    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }


    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }


    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }


    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }


    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }


    /**
     * @return the siglaLotacao
     */
    public String getSiglaLotacao() {
        return siglaLotacao;
    }


    /**
     * @param siglaLotacao the siglaLotacao to set
     */
    public void setSiglaLotacao(String siglaLotacao) {
        this.siglaLotacao = siglaLotacao;
    }


    /**
     * @return the itensDeMenu
     */
    public List<ItemMenu> getItensDeMenu() {
        return itensDeMenu;
    }

    public void setItensDeMenu(List<ItemMenu> itensDeMenu) {
        this.itensDeMenu = itensDeMenu;
        List<ItemMenuDecorator> itensDeMenuOrganizados = new ArrayList<>();

        itensDeMenu.stream().filter(item1 -> item1.getNivel() == UM).
                forEach(item1 -> {
                    ItemMenuDecorator itemMenuDec1 = new ItemMenuDecorator(item1);
                    itensDeMenuOrganizados.add(itemMenuDec1);
                    itensDeMenu.stream().filter(
                            item2 -> item2.getNivel() == DOIS && item2.getIdItemMenuSup() == item1.getId().getIdItemMenu()).
                            forEach(item2 -> {
                                ItemMenuDecorator itemMenuDec2 = new ItemMenuDecorator(item2);
                                itemMenuDec1.getSubItens().add(itemMenuDec2);
                                itensDeMenu.stream().filter(
                                        item3 -> item3.getNivel() == TRES &&
                                                item3.getIdItemMenuSup() == item2.getId().getIdItemMenu()).
                                        forEach(item3 -> {
                                            ItemMenuDecorator itemMenuDec3 = new ItemMenuDecorator(item3);
                                            itemMenuDec2.getSubItens().add(itemMenuDec3);
                                            itensDeMenu.stream().filter(item4 -> item4.getNivel() == QUATRO &&
                                                    item3.getId().getIdItemMenu() == item4.getIdItemMenuSup()).
                                                    forEach(item4 -> itemMenuDec3.getSubItens().add(
                                                            new ItemMenuDecorator(item4)));
                                        });
                            });

                });


        setMenu(itensDeMenuOrganizados);

    }

    /**
     * @return the usuarioExterno
     */
    public UsuarioExterno getUsuarioExterno() {
        return usuarioExterno;
    }

    /**
     * @param usuarioExterno the usuarioExterno to set
     */
    public void setUsuarioExterno(UsuarioExterno usuarioExterno) {
        this.usuarioExterno = usuarioExterno;
        if (usuarioExterno != null) {
            nome = usuarioExterno.getNome();
            email = usuarioExterno.getEmail();
            login = usuarioExterno.getIdCorreios();
        }
    }

    /**
     * @return the menu
     */
    public List<ItemMenuDecorator> getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(List<ItemMenuDecorator> menu) {
        this.menu = menu;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        if (login == null) {
            if (other.login != null) {
                return false;
            }
        } else if (!login.equals(other.login)) {
            return false;
        }
        return true;
    }


    /**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent evt) {
        LOGGER.info(
                "Usuário " + getNome() != null ? getNome() : "" + " foi inserido na sessão");
    }

    /**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent evt) {
        LOGGER.info(
                "Usuário " + getNome() + " foi removido da sessão");
    }


    public void adicionaUsuarioExternoPJ(UsuarioExternoPJ usuarioExternoPJ) {
        this.usuariosExternosPJ.add(usuarioExternoPJ);
    }

    /**
     * @return the usuarioInterno
     */
    public UsuarioInterno getUsuarioInterno() {
        return usuarioInterno;
    }


    /**
     * @param usuarioInterno the usuarioInterno to set
     */
    public void setUsuarioInterno(UsuarioInterno usuarioInterno) {
        this.usuarioInterno = usuarioInterno;
        if (usuarioInterno != null) {
            nome = usuarioInterno.getUsuarioFuncionario() != null ? usuarioInterno.getUsuarioFuncionario().getNome() : usuarioInterno.getNome();
            email = usuarioInterno.getEmail();
            siglaLotacao = usuarioInterno.getUsuarioFuncionario() != null ? usuarioInterno.getUsuarioFuncionario().getSiglaLotacao() : usuarioInterno.getLotacao();
            login = usuarioInterno.getLogin();
        }
    }


    /**
     * @return the funcionalidades
     */
    public List<Funcionalidade> getFuncionalidades() {
        return funcionalidades;
    }


    /**
     * @param funcionalidades the funcionalidades to set
     */
    public void setFuncionalidades(List<Funcionalidade> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }


    /**
     * @return the ulsDasFuncionalidades
     */
    public List<String> getUlsDasFuncionalidades() {
        return ulsDasFuncionalidades;
    }


    /**
     * @param ulsDasFuncionalidades the ulsDasFuncionalidades to set
     */
    public void setUlsDasFuncionalidades(List<String> ulsDasFuncionalidades) {
        this.ulsDasFuncionalidades = ulsDasFuncionalidades;
    }


    /**
     * @return the sistemas
     */
    public List<VWSistema> getSistemas() {
        return sistemas;
    }


    /**
     * @param sistemas the sistemas to set
     */
    public void setSistemas(List<VWSistema> sistemas) {
        this.sistemas = sistemas;
    }


}

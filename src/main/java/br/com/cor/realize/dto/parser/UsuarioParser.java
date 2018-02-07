package br.com.correios.realize.dto.parser;

import br.com.correios.componente.idautorizador.usuario.UsuarioExterno;
import br.com.correios.componente.idautorizador.usuario.UsuarioExternoPJ;
import br.com.correios.componente.idautorizador.usuario.UsuarioInterno;
import br.com.correios.realize.dto.UsuarioDTO;
import br.com.correios.realize.dto.UsuarioExternoDTO;
import br.com.correios.realize.dto.UsuarioExternoPJDTO;
import br.com.correios.realize.dto.UsuarioInternoDTO;
import br.com.correios.realize.seguranca.Usuario;

public class UsuarioParser implements Parser<Usuario, UsuarioDTO> {

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        return null;
    }

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNome(),
                usuario.getLogin(),
                usuario.getEmail(),
                usuario.getSiglaLotacao(),
                usuario.getGrupos(),
                usuario.getUsuarioExterno() != null ? preencheUsuarioExternoDTO(usuario.getUsuarioExterno()) : null,
                usuario.getUsuarioInterno() != null ? preencheUsuarioInternoDTO(usuario.getUsuarioInterno()) : null);
        return usuarioDTO;
    }
    
	public UsuarioDTO obterDadosUsuario(Usuario usuario) {
		return new UsuarioDTO(usuario.getNome(), usuario.getLogin(), usuario.getEmail());
	}

    private UsuarioExternoDTO preencheUsuarioExternoDTO(UsuarioExterno usuarioExterno) {
        UsuarioExternoDTO usuarioExternoDTO = new UsuarioExternoDTO(usuarioExterno.getTipo(),
                usuarioExterno.getNome(),
                usuarioExterno.getEmail(),
                usuarioExterno.getEmailAlternativo(),
                usuarioExterno.getDdiMovel(),
                usuarioExterno.getDddMovel(),
                usuarioExterno.getFoneMovel(),
                usuarioExterno.getUsuarioInterno(),
                preencheUsuarioExternoPJDTO(usuarioExterno.getUsuarioExternoPJ()));

        return usuarioExternoDTO;
    }

    private UsuarioExternoPJDTO preencheUsuarioExternoPJDTO(UsuarioExternoPJ usuarioExternoPJ) {
        UsuarioExternoPJDTO usuario = new UsuarioExternoPJDTO(usuarioExternoPJ.getCnpj(),
                usuarioExternoPJ.getInscricaoEstadual(),
                usuarioExternoPJ.getNomeFantasia(),
                usuarioExternoPJ.getAn8(),
                usuarioExternoPJ.getSediadaForaBrasil(),
                usuarioExternoPJ.getIdCorreios());

        return usuario;
    }

    private UsuarioInternoDTO preencheUsuarioInternoDTO(UsuarioInterno usuarioInterno) {
        UsuarioInternoDTO usuarioInternoDTO = new UsuarioInternoDTO(usuarioInterno.getTipoUsuario(),
                usuarioInterno.getMatricula(),
                usuarioInterno.getCpf(),
                usuarioInterno.getNome(),
                usuarioInterno.getEmail(),
                usuarioInterno.getLogin(),
                usuarioInterno.getLotacao(),
                usuarioInterno.getUsuarioFuncionario());

        return usuarioInternoDTO;
    }
}

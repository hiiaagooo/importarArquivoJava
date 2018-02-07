package br.com.correios.realize.dto;

import br.com.correios.componente.idautorizador.usuario.Grupo;

import java.util.ArrayList;
import java.util.List;


public class UsuarioDTO {
    private String nome;
    private String login;
    private String email;
    private String siglaLotacao;

    private List<Grupo> grupos = new ArrayList<>();

    private UsuarioExternoDTO usuarioExterno;
    private UsuarioInternoDTO usuarioInterno;

    public UsuarioDTO(String nome, String login, String email,
                      String siglaLotacao, List<Grupo> grupos,
                      UsuarioExternoDTO usuarioExterno, UsuarioInternoDTO usuarioInterno) {
        super();
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.siglaLotacao = siglaLotacao;
        this.grupos = grupos;
        this.usuarioExterno = usuarioExterno;
        this.usuarioInterno = usuarioInterno;
    }
    
	public UsuarioDTO(String nome, String login, String email) {
		super();
		this.nome = nome;
		this.login = login;
		this.email = email;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiglaLotacao() {
        return siglaLotacao;
    }

    public void setSiglaLotacao(String siglaLotacao) {
        this.siglaLotacao = siglaLotacao;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public UsuarioExternoDTO getUsuarioExterno() {
        return usuarioExterno;
    }

    public void setUsuarioExterno(UsuarioExternoDTO usuarioExterno) {
        this.usuarioExterno = usuarioExterno;
    }

    public UsuarioInternoDTO getUsuarioInterno() {
        return usuarioInterno;
    }

    public void setUsuarioInterno(UsuarioInternoDTO usuarioInterno) {
        this.usuarioInterno = usuarioInterno;
    }

}

package br.com.correios.realize.dto;

import br.com.correios.componente.idautorizador.usuario.Funcionario;
import br.com.correios.componente.idautorizador.usuario.TipoUsuario;

public class UsuarioInternoDTO {

    private TipoUsuario tipoUsuario;
    private String matricula;
    private String cpf;
    private String nome;
    private String email;
    private String login;
    private String lotacao;
    private Funcionario usuarioFuncionario;

    public UsuarioInternoDTO(TipoUsuario tipoUsuario, String matricula,
                             String cpf, String nome, String email, String login,
                             String lotacao, Funcionario usuarioFuncionario) {
        super();
        this.tipoUsuario = tipoUsuario;
        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.lotacao = lotacao;
        this.usuarioFuncionario = usuarioFuncionario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public Funcionario getUsuarioFuncionario() {
        return usuarioFuncionario;
    }

    public void setUsuarioFuncionario(Funcionario usuarioFuncionario) {
        this.usuarioFuncionario = usuarioFuncionario;
    }
}

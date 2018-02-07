package br.com.correios.realize.dto;

public class UsuarioExternoDTO {

    private String tipo;
    private String nome;
    private String email;
    private String emailAlternativo;
    private String ddiMovel;
    private String dddMovel;
    private String foneMovel;
    private Integer usuarioInterno;
    private UsuarioExternoPJDTO usuarioExternoPJ;

    public UsuarioExternoDTO(String tipo, String nome, String email,
                             String emailAlternativo, String ddiMovel, String dddMovel,
                             String foneMovel, Integer usuarioInterno,
                             UsuarioExternoPJDTO usuarioExternoPJ) {
        super();
        this.tipo = tipo;
        this.nome = nome;
        this.email = email;
        this.emailAlternativo = emailAlternativo;
        this.ddiMovel = ddiMovel;
        this.dddMovel = dddMovel;
        this.foneMovel = foneMovel;
        this.usuarioInterno = usuarioInterno;
        this.usuarioExternoPJ = usuarioExternoPJ;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }

    public String getDdiMovel() {
        return ddiMovel;
    }

    public void setDdiMovel(String ddiMovel) {
        this.ddiMovel = ddiMovel;
    }

    public String getDddMovel() {
        return dddMovel;
    }

    public void setDddMovel(String dddMovel) {
        this.dddMovel = dddMovel;
    }

    public String getFoneMovel() {
        return foneMovel;
    }

    public void setFoneMovel(String foneMovel) {
        this.foneMovel = foneMovel;
    }

    public Integer getUsuarioInterno() {
        return usuarioInterno;
    }

    public void setUsuarioInterno(Integer usuarioInterno) {
        this.usuarioInterno = usuarioInterno;
    }

    public UsuarioExternoPJDTO getUsuarioExternoPJ() {
        return usuarioExternoPJ;
    }

    public void setUsuarioExternoPJ(UsuarioExternoPJDTO usuarioExternoPJ) {
        this.usuarioExternoPJ = usuarioExternoPJ;
    }

}

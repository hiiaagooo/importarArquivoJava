package br.com.correios.realize.dto;

import br.com.correios.componente.idautorizador.usuario.SimOuNao;

public class UsuarioExternoPJDTO {

    private String cnpj;
    private String inscricaoEstadual;
    private String nomeFantasia;
    private Long an8;
    private SimOuNao sediadaForaBrasil;
    private String idCorreios;

    public UsuarioExternoPJDTO(String cnpj, String inscricaoEstadual,
                               String nomeFantasia, Long an8, SimOuNao sediadaForaBrasil,
                               String idCorreios) {
        super();
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeFantasia = nomeFantasia;
        this.an8 = an8;
        this.sediadaForaBrasil = sediadaForaBrasil;
        this.idCorreios = idCorreios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Long getAn8() {
        return an8;
    }

    public void setAn8(Long an8) {
        this.an8 = an8;
    }

    public SimOuNao getSediadaForaBrasil() {
        return sediadaForaBrasil;
    }

    public void setSediadaForaBrasil(SimOuNao sediadaForaBrasil) {
        this.sediadaForaBrasil = sediadaForaBrasil;
    }

    public String getIdCorreios() {
        return idCorreios;
    }

    public void setIdCorreios(String idCorreios) {
        this.idCorreios = idCorreios;
    }
}

package br.com.correios.realize.util;

public class Mensagem {

    private String mensagem;

    private TipoMensagem tipoMensagem;

    public Mensagem(TipoMensagem tipo, String message) {
        mensagem = message;
        tipoMensagem = tipo;

    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the tipoMensagem
     */
    public TipoMensagem getTipoMensagem() {
        return tipoMensagem;
    }

    /**
     * @param tipoMensagem the tipoMensagem to set
     */
    public void setTipoMensagem(TipoMensagem tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    public enum TipoMensagem {INFO, AVISO, ERRO}


}

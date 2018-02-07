package br.com.correios.realize.util;

import java.util.ArrayList;
import java.util.List;

import br.com.correios.realize.util.Mensagem.TipoMensagem;


public class Resposta<T> {

    private T dados;
    private List<Mensagem> mensagens = new ArrayList<>();


    public Resposta(T data, List<Mensagem> msg) {
        this.dados = data;
        this.mensagens = msg;
    }

    public Resposta(T data, String msg, TipoMensagem tipoMensagem) {
        this.dados = data;
        this.mensagens = add(msg, tipoMensagem);
    }

    public Resposta(String msg, TipoMensagem tipoMensagem) {
        this.mensagens = add(msg, tipoMensagem);
    }

    public Resposta(T data) {
        this.dados = data;
    }

    public Resposta() {
    }

    public List<Mensagem> add(String msg, TipoMensagem tipoMensagem) {
        if (this.mensagens == null) {
            this.mensagens = new ArrayList<>();
        }
        Mensagem mensagem = new Mensagem(tipoMensagem, msg);
        this.mensagens.add(mensagem);
        return mensagens;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

}

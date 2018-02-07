//package br.com.correios.realize.model;
//
//import javax.persistence.*;
//
////@Entity
////@Table(name = "PARAMETRO")
//public class Parametro {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "PAR_NU")
//    private Integer id;
//
//    @Column(name = "PAR_NO", nullable = false)
//    private String nome;
//
//    @Column(name = "PAR_CONTEUDO", nullable = false)
//    private String valor;
//
//    @Column(name = "PAR_DESCRICAO", nullable = false)
//    private String descricao;
//
//    @Column(name = "PAR_TIPO")
//    private String tipoParametro;
//
//    public Parametro() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getValor() {
//        return valor;
//    }
//
//    public void setValor(String valor) {
//        this.valor = valor;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public String getTipoParametro() {
//        return tipoParametro;
//    }
//
//    public void setTipoParametro(String tipoParametro) {
//        this.tipoParametro = tipoParametro;
//    }
//}

package br.com.correios.realize.model.enums;

public enum TipoArquivoMetaEnum {

    A_VISTA(0L,"Á vista"),
    A_FATURAR(1L,"A faturar"),
    PROSPECCAO(2L,"Prospecção");

    private long codigo;
    private String descricao;

    TipoArquivoMetaEnum(long codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
}

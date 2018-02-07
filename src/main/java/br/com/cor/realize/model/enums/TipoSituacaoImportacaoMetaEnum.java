package br.com.correios.realize.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoSituacaoImportacaoMetaEnum {

    EP("Em processamento"),
    AP("A processar"),
    PF("Processado com falhas"),
    PS("Processado com sucesso");

    private String descricao;

    TipoSituacaoImportacaoMetaEnum(String descricao){
        this.descricao = descricao;
    }

    public String getChave(){
        return this.name();
    }

    public String getDescricao() {
        return descricao;
    }


}
package br.com.correios.realize.model.enums;

public enum TipoGerenciaEnum {

	TITULAR(1, "Titular", "Gerente da Agência"), 
	EVENTUAL(2, "Eventual", "Gerente Eventual");

	private Integer codigo;
	private String descricao;
	private String grupo;

	TipoGerenciaEnum(Integer codigo, String descricao, String grupo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.grupo = grupo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getGrupo() {
		return grupo;
	}

}

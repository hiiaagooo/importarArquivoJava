package br.com.correios.realize.dto;

public class UnidadeNegocioDTO {

	private String mcu;
	private String nome;

	public UnidadeNegocioDTO() {
		super();
	}

	public UnidadeNegocioDTO(String mcu, String nome) {
		super();
		this.mcu = mcu;
		this.nome = nome;
	}

	public String getMcu() {
		return mcu;
	}

	public void setMcu(String mcu) {
		this.mcu = mcu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

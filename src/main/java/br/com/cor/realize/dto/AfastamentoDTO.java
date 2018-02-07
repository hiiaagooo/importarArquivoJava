package br.com.correios.realize.dto;

import java.time.LocalDate;

public class AfastamentoDTO {
	private String id;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataFim;

	public AfastamentoDTO() {
		super();
	}

	public AfastamentoDTO(String id, String descricao, LocalDate dataInicio, LocalDate dataFim) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

}

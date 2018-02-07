package br.com.correios.realize.dto;

import br.com.correios.realize.model.enums.TipoGerenciaEnum;

public class GerenteAgenciaDTO {

	private String matricula;
	private String mcu;
	private String nome;
	private String funcao;
	private TipoGerenciaEnum tipoGerencia;
	private String matriculaResponsavel;

	public GerenteAgenciaDTO() {
		super();
	}
	
	

	public GerenteAgenciaDTO(String matricula, String mcu, String nome, String funcao, TipoGerenciaEnum tipoGerencia, String matriculaResponsavel) {
		super();
		this.matricula = matricula;
		this.mcu = mcu;
		this.nome = nome;
		this.funcao = funcao;
		this.tipoGerencia = tipoGerencia;
		this.matriculaResponsavel = matriculaResponsavel;
	}


	public GerenteAgenciaDTO(String matricula, String nome, String funcao, TipoGerenciaEnum tipoGerencia, String matriculaResponsavel) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.funcao = funcao;
		this.tipoGerencia = tipoGerencia;
		this.matriculaResponsavel = matriculaResponsavel;
	}


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getMatriculaResponsavel() {
		return matriculaResponsavel;
	}

	public void setMatriculaResponsavel(String matriculaResponsavel) {
		this.matriculaResponsavel = matriculaResponsavel;
	}

	public TipoGerenciaEnum getTipoGerencia() {
		return tipoGerencia;
	}

	public void setTipoGerencia(TipoGerenciaEnum tipoGerencia) {
		this.tipoGerencia = tipoGerencia;
	}
	
	public String getGrupo() {
		return tipoGerencia !=null ? tipoGerencia.getGrupo() : null;
	}

}

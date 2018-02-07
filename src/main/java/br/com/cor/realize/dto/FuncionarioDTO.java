package br.com.correios.realize.dto;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDTO {

	private String matricula;
	private String nome;
	private String funcao;
	private List<AfastamentoDTO> afastamentos = new ArrayList<AfastamentoDTO>();

	public FuncionarioDTO() {
		super();
	}

	public FuncionarioDTO(String matricula, String nome, String funcao, List<AfastamentoDTO> afastamentos) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.funcao = funcao;
		this.afastamentos = afastamentos;
	}

	public FuncionarioDTO(String matricula, String nome, String funcao) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.funcao = funcao;
		this.afastamentos = new ArrayList<AfastamentoDTO>();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public List<AfastamentoDTO> getAfastamentos() {
		return afastamentos;
	}

	public void setAfastamentos(List<AfastamentoDTO> afastamentos) {
		this.afastamentos = afastamentos;
	}

}

package br.com.correios.realize.dto;

import java.util.ArrayList;
import java.util.List;

public class ItemMenuDTO {
	private String nome;
	private String url;
	private Integer ordem;

	private List<ItemMenuDTO> filhos = new ArrayList<ItemMenuDTO>();

	/**
	 * Construtor sobrescrito
	 * 
	 * @param nome
	 * @param url
	 * @param ordem
	 * @param filhos
	 */
	public ItemMenuDTO(String nome, String url, Integer ordem, List<ItemMenuDTO> filhos) {
		super();
		this.nome = nome;
		this.url = url;
		this.ordem = ordem;
	}

	/**
	 * Construtor padrão
	 */
	public ItemMenuDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ItemMenuDTO> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<ItemMenuDTO> filhos) {
		this.filhos = filhos;
	}

}
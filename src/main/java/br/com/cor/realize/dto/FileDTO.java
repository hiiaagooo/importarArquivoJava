package br.com.correios.realize.dto;

public class FileDTO {
    private String nomeArquivo;
	private long tamanhoArquivo;
	private String tipoArquivo;
	private byte[] conteudoArquivo;
	
	
	public String getNomeArquivo() {
		return nomeArquivo;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public String getTipoArquivo() {
		return tipoArquivo;
	}
	public long getTamanhoArquivo() {
		return tamanhoArquivo;
	}
	public void setTamanhoArquivo(long tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
	}
	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}
	public byte[] getConteudoArquivo() {
		return conteudoArquivo;
	}
	public void setConteudoArquivo(byte[] conteudoArquivo) {
		this.conteudoArquivo = conteudoArquivo;
	}
	
}
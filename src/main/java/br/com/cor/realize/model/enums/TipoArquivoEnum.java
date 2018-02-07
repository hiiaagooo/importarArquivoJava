package br.com.correios.realize.model.enums;

public enum TipoArquivoEnum {
    CSV("text/csv",".csv","CSV"),
	JSON("application/json",".json","JSON");
	
	private String mimeType;
	
	private String extensao;
	
	private String descricao;
	
	TipoArquivoEnum(String mimeType, String extensao, String descricao){
		this.mimeType = mimeType;
		this.extensao = extensao;
		this.descricao = descricao;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getExtensao() {
		return extensao;
	}

	public static TipoArquivoEnum recuperarPorMimeType(String stringMimeType) {
		for (TipoArquivoEnum tipoArquivoEnumEnum : TipoArquivoEnum.values()) {
			if(tipoArquivoEnumEnum.getMimeType().equals(stringMimeType)){
				return tipoArquivoEnumEnum;
			}
		}
		return null;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
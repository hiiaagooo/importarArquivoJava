//package br.com.correios.realize.model;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import javax.persistence.*;
//
///**
// * The primary key class for the META_AGENCIA database table.
// *
// */
//@Embeddable
//public class MetaAgenciaPK implements Serializable {
//	//default serial version id, required for serializable classes.
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="MCMCU_AGENCIA")
//	private String mcmcuAgencia;
//
//	@Column(name="MAG_IN_TIPO_META")
//	private String magInTipoMeta;
//
//	@Column(name="DRKY_SEGMENTO_NEGOCIO")
//	private String drkySegmentoNegocio;
//
//	@Column(name="JSITM_PRODUTO")
//	private Long jsitmProduto;
//
//	@Column(name="MAG_AN")
//	private Long magAn;
//
//	@Column(name="MAG_ME")
//	private Long magMe;
//
//	public MetaAgenciaPK() {
//	}
//
//	public MetaAgenciaPK(String mcmcuAgencia, String magInTipoMeta, String drkySegmentoNegocio, Long jsitmProduto, Long anoReferencia, Long mesReferencia) {
//		this.mcmcuAgencia = mcmcuAgencia;
//		this.magInTipoMeta = magInTipoMeta;
//		this.drkySegmentoNegocio = drkySegmentoNegocio;
//		this.jsitmProduto = jsitmProduto;
//		this.magAn = anoReferencia;
//		this.magMe = mesReferencia;
//	}
//
//    public MetaAgenciaPK(String mcmcuAgencia, String magInTipoMeta, Long anoReferencia, Long mesReferencia) {
//		this.mcmcuAgencia = mcmcuAgencia;
//		this.magInTipoMeta = magInTipoMeta;
//		this.magAn = anoReferencia;
//		this.magMe = mesReferencia;
//    }
//
//    public String getMcmcuAgencia() {
//		return this.mcmcuAgencia;
//	}
//	public void setMcmcuAgencia(String mcmcuAgencia) {
//		this.mcmcuAgencia = mcmcuAgencia;
//	}
//	public String getMagInTipoMeta() {
//		return this.magInTipoMeta;
//	}
//	public void setMagInTipoMeta(String magInTipoMeta) {
//		this.magInTipoMeta = magInTipoMeta;
//	}
//	public String getDrkySegmentoNegocio() {
//		return this.drkySegmentoNegocio;
//	}
//	public void setDrkySegmentoNegocio(String drkySegmentoNegocio) {
//		this.drkySegmentoNegocio = drkySegmentoNegocio;
//	}
//	public Long getJsitmProduto() {
//		return this.jsitmProduto;
//	}
//	public void setJsitmProduto(Long jsitmProduto) {
//		this.jsitmProduto = jsitmProduto;
//	}
//	public Long getMagAn() {
//		return this.magAn;
//	}
//	public void setMagAn(Long magAn) {
//		this.magAn = magAn;
//	}
//	public Long getMagMe() {
//		return this.magMe;
//	}
//	public void setMagMe(Long magMe) {
//		this.magMe = magMe;
//	}
//
//	public boolean equals(Object other) {
//		if (this == other) {
//			return true;
//		}
//		if (!(other instanceof MetaAgenciaPK)) {
//			return false;
//		}
//		MetaAgenciaPK castOther = (MetaAgenciaPK)other;
//		return
//			this.mcmcuAgencia.equals(castOther.mcmcuAgencia)
//			&& this.magInTipoMeta.equals(castOther.magInTipoMeta)
//			&& this.drkySegmentoNegocio.equals(castOther.drkySegmentoNegocio)
//			&& (this.jsitmProduto == castOther.jsitmProduto)
//			&& (this.magAn == castOther.magAn)
//			&& (this.magMe == castOther.magMe);
//	}
//
//	public int hashCode() {
//		final int prime = 31;
//		int hash = 17;
//		hash = hash * prime + this.mcmcuAgencia.hashCode();
//		hash = hash * prime + this.magInTipoMeta.hashCode();
//		hash = hash * prime + this.drkySegmentoNegocio.hashCode();
//		hash = hash * prime + ((int) (this.jsitmProduto ^ (this.jsitmProduto >>> 32)));
//		hash = hash * prime + ((int) (this.magAn ^ (this.magAn >>> 32)));
//		hash = hash * prime + ((int) (this.magMe ^ (this.magMe >>> 32)));
//
//		return hash;
//	}
//}
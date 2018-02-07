package br.com.correios.realize.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PARAMETRO_META_ATENDENTE database table.
 * 
 */
@Embeddable
public class ParametroMetaAtendentePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ATRREGISTRO_COLABORADOR", insertable=false, updatable=false)
	private String atrregistroColaborador;

	@Column(name="MCMCU_AGENCIA", insertable=false, updatable=false)
	private String mcmcuAgencia;

	@Temporal(TemporalType.DATE)
	@Column(name="COA_DT_INICIO_VINCULO", insertable=false, updatable=false)
	private java.util.Date coaDtInicioVinculo;

	@Column(name="PMA_AN")
	private long pmaAn;

	@Column(name="PMA_ME")
	private long pmaMe;

	public ParametroMetaAtendentePK() {
	}
	public String getAtrregistroColaborador() {
		return this.atrregistroColaborador;
	}
	public void setAtrregistroColaborador(String atrregistroColaborador) {
		this.atrregistroColaborador = atrregistroColaborador;
	}
	public String getMcmcuAgencia() {
		return this.mcmcuAgencia;
	}
	public void setMcmcuAgencia(String mcmcuAgencia) {
		this.mcmcuAgencia = mcmcuAgencia;
	}
	public java.util.Date getCoaDtInicioVinculo() {
		return this.coaDtInicioVinculo;
	}
	public void setCoaDtInicioVinculo(java.util.Date coaDtInicioVinculo) {
		this.coaDtInicioVinculo = coaDtInicioVinculo;
	}
	public long getPmaAn() {
		return this.pmaAn;
	}
	public void setPmaAn(long pmaAn) {
		this.pmaAn = pmaAn;
	}
	public long getPmaMe() {
		return this.pmaMe;
	}
	public void setPmaMe(long pmaMe) {
		this.pmaMe = pmaMe;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ParametroMetaAtendentePK)) {
			return false;
		}
		ParametroMetaAtendentePK castOther = (ParametroMetaAtendentePK)other;
		return 
			this.atrregistroColaborador.equals(castOther.atrregistroColaborador)
			&& this.mcmcuAgencia.equals(castOther.mcmcuAgencia)
			&& this.coaDtInicioVinculo.equals(castOther.coaDtInicioVinculo)
			&& (this.pmaAn == castOther.pmaAn)
			&& (this.pmaMe == castOther.pmaMe);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.atrregistroColaborador.hashCode();
		hash = hash * prime + this.mcmcuAgencia.hashCode();
		hash = hash * prime + this.coaDtInicioVinculo.hashCode();
		hash = hash * prime + ((int) (this.pmaAn ^ (this.pmaAn >>> 32)));
		hash = hash * prime + ((int) (this.pmaMe ^ (this.pmaMe >>> 32)));
		
		return hash;
	}
}
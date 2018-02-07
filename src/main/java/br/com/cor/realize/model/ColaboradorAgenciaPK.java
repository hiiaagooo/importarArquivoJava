package br.com.correios.realize.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COLABORADOR_AGENCIA database table.
 * 
 */
@Embeddable
public class ColaboradorAgenciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ATRREGISTRO_COLABORADOR")
	private String atrregistroColaborador;

	@Column(name="MCMCU_AGENCIA")
	private String mcmcuAgencia;

	@Temporal(TemporalType.DATE)
	@Column(name="COA_DT_INICIO_VINCULO")
	private java.util.Date coaDtInicioVinculo;

	public ColaboradorAgenciaPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ColaboradorAgenciaPK)) {
			return false;
		}
		ColaboradorAgenciaPK castOther = (ColaboradorAgenciaPK)other;
		return 
			this.atrregistroColaborador.equals(castOther.atrregistroColaborador)
			&& this.mcmcuAgencia.equals(castOther.mcmcuAgencia)
			&& this.coaDtInicioVinculo.equals(castOther.coaDtInicioVinculo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.atrregistroColaborador.hashCode();
		hash = hash * prime + this.mcmcuAgencia.hashCode();
		hash = hash * prime + this.coaDtInicioVinculo.hashCode();
		
		return hash;
	}
}
package br.com.correios.realize.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AFASTAMENTO_ATENDENTE database table.
 * 
 */
@Embeddable
public class AfastamentoAtendentePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ATRREGISTRO_COLABORADOR", insertable=false, updatable=false)
	private String atrregistroColaborador;

	@Column(name="MCMCU_AGENCIA", insertable=false, updatable=false)
	private String mcmcuAgencia;

	@Temporal(TemporalType.DATE)
	@Column(name="COA_DT_INICIO_VINCULO", insertable=false, updatable=false)
	private java.util.Date coaDtInicioVinculo;

	@Temporal(TemporalType.DATE)
	@Column(name="AFA_DT_INICIO_AFASTAMENTO")
	private java.util.Date afaDtInicioAfastamento;

	public AfastamentoAtendentePK() {
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
	public java.util.Date getAfaDtInicioAfastamento() {
		return this.afaDtInicioAfastamento;
	}
	public void setAfaDtInicioAfastamento(java.util.Date afaDtInicioAfastamento) {
		this.afaDtInicioAfastamento = afaDtInicioAfastamento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AfastamentoAtendentePK)) {
			return false;
		}
		AfastamentoAtendentePK castOther = (AfastamentoAtendentePK)other;
		return 
			this.atrregistroColaborador.equals(castOther.atrregistroColaborador)
			&& this.mcmcuAgencia.equals(castOther.mcmcuAgencia)
			&& this.coaDtInicioVinculo.equals(castOther.coaDtInicioVinculo)
			&& this.afaDtInicioAfastamento.equals(castOther.afaDtInicioAfastamento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.atrregistroColaborador.hashCode();
		hash = hash * prime + this.mcmcuAgencia.hashCode();
		hash = hash * prime + this.coaDtInicioVinculo.hashCode();
		hash = hash * prime + this.afaDtInicioAfastamento.hashCode();
		
		return hash;
	}
}
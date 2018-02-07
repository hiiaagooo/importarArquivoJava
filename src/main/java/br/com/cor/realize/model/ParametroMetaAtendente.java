package br.com.correios.realize.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PARAMETRO_META_ATENDENTE database table.
 * 
 */
@Entity
@Table(name="PARAMETRO_META_ATENDENTE")
@NamedQuery(name="ParametroMetaAtendente.findAll", query="SELECT p FROM ParametroMetaAtendente p")
public class ParametroMetaAtendente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParametroMetaAtendentePK id;

	@Column(name="PMA_HR_ATENDIMENTO")
	private BigDecimal pmaHrAtendimento;

	@Column(name="PMA_IN_EXCLUIDO")
	private String pmaInExcluido;

	@Column(name="PMA_IN_REALIZA_CONSORCIO")
	private String pmaInRealizaConsorcio;

	@Column(name="PMA_IN_REALIZA_CREDITO")
	private String pmaInRealizaCredito;

	@Column(name="PMA_IN_TRABALHO_SABADO")
	private String pmaInTrabalhoSabado;

	//bi-directional many-to-one association to ColaboradorAgencia
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ATRREGISTRO_COLABORADOR", referencedColumnName="ATRREGISTRO_COLABORADOR"),
		@JoinColumn(name="COA_DT_INICIO_VINCULO", referencedColumnName="COA_DT_INICIO_VINCULO"),
		@JoinColumn(name="MCMCU_AGENCIA", referencedColumnName="MCMCU_AGENCIA")
		})
	private ColaboradorAgencia colaboradorAgencia;

	public ParametroMetaAtendente() {
	}

	public ParametroMetaAtendentePK getId() {
		return this.id;
	}

	public void setId(ParametroMetaAtendentePK id) {
		this.id = id;
	}

	public BigDecimal getPmaHrAtendimento() {
		return this.pmaHrAtendimento;
	}

	public void setPmaHrAtendimento(BigDecimal pmaHrAtendimento) {
		this.pmaHrAtendimento = pmaHrAtendimento;
	}

	public String getPmaInExcluido() {
		return this.pmaInExcluido;
	}

	public void setPmaInExcluido(String pmaInExcluido) {
		this.pmaInExcluido = pmaInExcluido;
	}

	public String getPmaInRealizaConsorcio() {
		return this.pmaInRealizaConsorcio;
	}

	public void setPmaInRealizaConsorcio(String pmaInRealizaConsorcio) {
		this.pmaInRealizaConsorcio = pmaInRealizaConsorcio;
	}

	public String getPmaInRealizaCredito() {
		return this.pmaInRealizaCredito;
	}

	public void setPmaInRealizaCredito(String pmaInRealizaCredito) {
		this.pmaInRealizaCredito = pmaInRealizaCredito;
	}

	public String getPmaInTrabalhoSabado() {
		return this.pmaInTrabalhoSabado;
	}

	public void setPmaInTrabalhoSabado(String pmaInTrabalhoSabado) {
		this.pmaInTrabalhoSabado = pmaInTrabalhoSabado;
	}

	public ColaboradorAgencia getColaboradorAgencia() {
		return this.colaboradorAgencia;
	}

	public void setColaboradorAgencia(ColaboradorAgencia colaboradorAgencia) {
		this.colaboradorAgencia = colaboradorAgencia;
	}

}
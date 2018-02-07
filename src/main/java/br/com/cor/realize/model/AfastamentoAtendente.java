package br.com.correios.realize.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the AFASTAMENTO_ATENDENTE database table.
 * 
 */
@Entity
@Table(name="AFASTAMENTO_ATENDENTE")
@NamedQuery(name="AfastamentoAtendente.findAll", query="SELECT a FROM AfastamentoAtendente a")
public class AfastamentoAtendente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AfastamentoAtendentePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="AFA_DT_FIM_AFASTAMENTO")
	private Date afaDtFimAfastamento;

	@Column(name="AFA_IN_EXCLUIDO")
	private String afaInExcluido;

	//bi-directional many-to-one association to ColaboradorAgencia
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ATRREGISTRO_COLABORADOR", referencedColumnName="ATRREGISTRO_COLABORADOR"),
		@JoinColumn(name="COA_DT_INICIO_VINCULO", referencedColumnName="COA_DT_INICIO_VINCULO"),
		@JoinColumn(name="MCMCU_AGENCIA", referencedColumnName="MCMCU_AGENCIA")
		})
	private ColaboradorAgencia colaboradorAgencia;

	//bi-directional many-to-one association to MotivoAfastamento
	@ManyToOne
	@JoinColumn(name="MAF_NU")
	private MotivoAfastamento motivoAfastamento;

	public AfastamentoAtendente() {
	}

	public AfastamentoAtendentePK getId() {
		return this.id;
	}

	public void setId(AfastamentoAtendentePK id) {
		this.id = id;
	}

	public Date getAfaDtFimAfastamento() {
		return this.afaDtFimAfastamento;
	}

	public void setAfaDtFimAfastamento(Date afaDtFimAfastamento) {
		this.afaDtFimAfastamento = afaDtFimAfastamento;
	}

	public String getAfaInExcluido() {
		return this.afaInExcluido;
	}

	public void setAfaInExcluido(String afaInExcluido) {
		this.afaInExcluido = afaInExcluido;
	}

	public ColaboradorAgencia getColaboradorAgencia() {
		return this.colaboradorAgencia;
	}

	public void setColaboradorAgencia(ColaboradorAgencia colaboradorAgencia) {
		this.colaboradorAgencia = colaboradorAgencia;
	}

	public MotivoAfastamento getMotivoAfastamento() {
		return this.motivoAfastamento;
	}

	public void setMotivoAfastamento(MotivoAfastamento motivoAfastamento) {
		this.motivoAfastamento = motivoAfastamento;
	}

}
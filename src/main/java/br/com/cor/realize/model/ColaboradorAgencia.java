package br.com.correios.realize.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COLABORADOR_AGENCIA database table.
 * 
 */
@Entity
@Table(name="COLABORADOR_AGENCIA")
@NamedQuery(name="ColaboradorAgencia.findAll", query="SELECT c FROM ColaboradorAgencia c")
public class ColaboradorAgencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ColaboradorAgenciaPK id;

	@Column(name="ATRREGISTRO_VINCULADOR")
	private String atrregistroVinculador;

	@Temporal(TemporalType.DATE)
	@Column(name="COA_DT_FIM_VINCULO")
	private Date coaDtFimVinculo;

	@Column(name="COA_IN_TIPO_COLABORADOR")
	private String coaInTipoColaborador;

	@Column(name="COA_IN_TIPO_GERENCIA")
	private String coaInTipoGerencia;

	//bi-directional many-to-one association to AfastamentoAtendente
	@OneToMany(mappedBy="colaboradorAgencia")
	private List<AfastamentoAtendente> afastamentoAtendentes;

	//bi-directional many-to-one association to ParametroMetaAtendente
	@OneToMany(mappedBy="colaboradorAgencia")
	private List<ParametroMetaAtendente> parametroMetaAtendentes;

	public ColaboradorAgencia() {
	}

	public ColaboradorAgenciaPK getId() {
		return this.id;
	}

	public void setId(ColaboradorAgenciaPK id) {
		this.id = id;
	}

	public String getAtrregistroVinculador() {
		return this.atrregistroVinculador;
	}

	public void setAtrregistroVinculador(String atrregistroVinculador) {
		this.atrregistroVinculador = atrregistroVinculador;
	}

	public Date getCoaDtFimVinculo() {
		return this.coaDtFimVinculo;
	}

	public void setCoaDtFimVinculo(Date coaDtFimVinculo) {
		this.coaDtFimVinculo = coaDtFimVinculo;
	}

	public String getCoaInTipoColaborador() {
		return this.coaInTipoColaborador;
	}

	public void setCoaInTipoColaborador(String coaInTipoColaborador) {
		this.coaInTipoColaborador = coaInTipoColaborador;
	}

	public String getCoaInTipoGerencia() {
		return this.coaInTipoGerencia;
	}

	public void setCoaInTipoGerencia(String coaInTipoGerencia) {
		this.coaInTipoGerencia = coaInTipoGerencia;
	}

	public List<AfastamentoAtendente> getAfastamentoAtendentes() {
		return this.afastamentoAtendentes;
	}

	public void setAfastamentoAtendentes(List<AfastamentoAtendente> afastamentoAtendentes) {
		this.afastamentoAtendentes = afastamentoAtendentes;
	}

	public AfastamentoAtendente addAfastamentoAtendente(AfastamentoAtendente afastamentoAtendente) {
		getAfastamentoAtendentes().add(afastamentoAtendente);
		afastamentoAtendente.setColaboradorAgencia(this);

		return afastamentoAtendente;
	}

	public AfastamentoAtendente removeAfastamentoAtendente(AfastamentoAtendente afastamentoAtendente) {
		getAfastamentoAtendentes().remove(afastamentoAtendente);
		afastamentoAtendente.setColaboradorAgencia(null);

		return afastamentoAtendente;
	}

	public List<ParametroMetaAtendente> getParametroMetaAtendentes() {
		return this.parametroMetaAtendentes;
	}

	public void setParametroMetaAtendentes(List<ParametroMetaAtendente> parametroMetaAtendentes) {
		this.parametroMetaAtendentes = parametroMetaAtendentes;
	}

	public ParametroMetaAtendente addParametroMetaAtendente(ParametroMetaAtendente parametroMetaAtendente) {
		getParametroMetaAtendentes().add(parametroMetaAtendente);
		parametroMetaAtendente.setColaboradorAgencia(this);

		return parametroMetaAtendente;
	}

	public ParametroMetaAtendente removeParametroMetaAtendente(ParametroMetaAtendente parametroMetaAtendente) {
		getParametroMetaAtendentes().remove(parametroMetaAtendente);
		parametroMetaAtendente.setColaboradorAgencia(null);

		return parametroMetaAtendente;
	}

}
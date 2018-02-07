package br.com.correios.realize.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MOTIVO_AFASTAMENTO database table.
 * 
 */
@Entity
@Table(name="MOTIVO_AFASTAMENTO")
@NamedQuery(name="MotivoAfastamento.findAll", query="SELECT m FROM MotivoAfastamento m")
public class MotivoAfastamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAF_NU")
	private long mafNu;

	@Column(name="MAF_IN_EXCLUIDO")
	private String mafInExcluido;

	@Column(name="MAF_IN_RECEITA_CONTAB_AGENCIA")
	private String mafInReceitaContabAgencia;

	@Column(name="MAF_IN_RECEITA_CONTAB_COLABORA")
	private String mafInReceitaContabColabora;

	@Column(name="MAF_NO")
	private String mafNo;

	//bi-directional many-to-one association to AfastamentoAtendente
	@OneToMany(mappedBy="motivoAfastamento")
	private List<AfastamentoAtendente> afastamentoAtendentes;

	public MotivoAfastamento() {
	}

	public long getMafNu() {
		return this.mafNu;
	}

	public void setMafNu(long mafNu) {
		this.mafNu = mafNu;
	}

	public String getMafInExcluido() {
		return this.mafInExcluido;
	}

	public void setMafInExcluido(String mafInExcluido) {
		this.mafInExcluido = mafInExcluido;
	}

	public String getMafInReceitaContabAgencia() {
		return this.mafInReceitaContabAgencia;
	}

	public void setMafInReceitaContabAgencia(String mafInReceitaContabAgencia) {
		this.mafInReceitaContabAgencia = mafInReceitaContabAgencia;
	}

	public String getMafInReceitaContabColabora() {
		return this.mafInReceitaContabColabora;
	}

	public void setMafInReceitaContabColabora(String mafInReceitaContabColabora) {
		this.mafInReceitaContabColabora = mafInReceitaContabColabora;
	}

	public String getMafNo() {
		return this.mafNo;
	}

	public void setMafNo(String mafNo) {
		this.mafNo = mafNo;
	}

	public List<AfastamentoAtendente> getAfastamentoAtendentes() {
		return this.afastamentoAtendentes;
	}

	public void setAfastamentoAtendentes(List<AfastamentoAtendente> afastamentoAtendentes) {
		this.afastamentoAtendentes = afastamentoAtendentes;
	}

	public AfastamentoAtendente addAfastamentoAtendente(AfastamentoAtendente afastamentoAtendente) {
		getAfastamentoAtendentes().add(afastamentoAtendente);
		afastamentoAtendente.setMotivoAfastamento(this);

		return afastamentoAtendente;
	}

	public AfastamentoAtendente removeAfastamentoAtendente(AfastamentoAtendente afastamentoAtendente) {
		getAfastamentoAtendentes().remove(afastamentoAtendente);
		afastamentoAtendente.setMotivoAfastamento(null);

		return afastamentoAtendente;
	}

}
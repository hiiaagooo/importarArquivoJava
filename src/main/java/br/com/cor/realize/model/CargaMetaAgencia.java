package br.com.correios.realize.model;

import br.com.correios.realize.model.enums.TipoMetaEnum;
import br.com.correios.realize.model.enums.TipoSituacaoImportacaoMetaEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the CARGA_META_AGENCIA database table.
 * 
 */
@Entity
@Table(name="CARGA_META_AGENCIA")
public class CargaMetaAgencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CMA_NU")
	@GeneratedValue(generator="sqCmaNu",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="sqCmaNu",sequenceName="SQ_CMA_NU", allocationSize=1)
	private Long cmaNu;

	@Column(name="CMA_DT")
	private LocalDateTime cmaDt;

	@Enumerated(EnumType.STRING)
	@Column(name="CMA_IN_SITUACAO")
	private TipoSituacaoImportacaoMetaEnum tipoSituacaoImportacaoMetaEnum;

	@Enumerated(EnumType.STRING)
	@Column(name="CMA_IN_TIPO_META")
	private TipoMetaEnum tipoMetaEnum;

	@Column(name="CMA_TX_MOTIVO_FALHA")
	private String cmaTxMotivoFalha;

	@Column(name="CMA_TX_ARQUIVO_CARGA")
	private String cmaTxOrigemCarga;

	@Column(name="CMA_AN_REFERENCIA")
	private Long anoReferencia;

	@Column(name="USU_NU")
	private Long usuNu;

	//bi-directional many-to-one association to MetaAgencia
	@OneToMany(mappedBy="cargaMetaAgencia")
	private List<MetaAgencia> metasAgencias;

	public CargaMetaAgencia() {
	}

	public Long getCmaNu() {
		return this.cmaNu;
	}

	public void setCmaNu(Long cmaNu) {
		this.cmaNu = cmaNu;
	}

	public LocalDateTime getCmaDt() {
		return this.cmaDt;
	}

	public void setCmaDt(LocalDateTime cmaDt) {
		this.cmaDt = cmaDt;
	}

	public TipoMetaEnum getTipoMetaEnum() {
		return tipoMetaEnum;
	}

	public void setTipoMetaEnum(TipoMetaEnum cmaTipoMetaEnum) {
		this.tipoMetaEnum = cmaTipoMetaEnum;
	}

	public TipoSituacaoImportacaoMetaEnum getTipoSituacaoImportacaoMetaEnum() {
		return tipoSituacaoImportacaoMetaEnum;
	}

	public void setTipoSituacaoImportacaoMetaEnum(TipoSituacaoImportacaoMetaEnum tipoSituacaoImportacaoMetaEnum) {
		this.tipoSituacaoImportacaoMetaEnum = tipoSituacaoImportacaoMetaEnum;
	}

	public String getCmaTxMotivoFalha() {
		return this.cmaTxMotivoFalha;
	}

	public void setCmaTxMotivoFalha(String cmaTxMotivoFalha) {
		this.cmaTxMotivoFalha = cmaTxMotivoFalha;
	}

	public String getCmaTxOrigemCarga() {
		return this.cmaTxOrigemCarga;
	}

	public Long getAnoReferencia() {
		return anoReferencia;
	}

	public void setAnoReferencia(Long anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	public void setCmaTxOrigemCarga(String cmaTxOrigemCarga) {
		this.cmaTxOrigemCarga = cmaTxOrigemCarga;
	}

	public Long getUsuNu() {
		return this.usuNu;
	}

	public void setUsuNu(Long usuNu) {
		this.usuNu = usuNu;
	}

	public List<MetaAgencia> getMetasAgencias() {
		return this.metasAgencias;
	}

	public void setMetasAgencias(List<MetaAgencia> metaAgencias) {
		this.metasAgencias = metaAgencias;
	}

	public MetaAgencia addMetaAgencia(MetaAgencia metaAgencia) {
		getMetasAgencias().add(metaAgencia);
		metaAgencia.setCargaMetaAgencia(this);

		return metaAgencia;
	}

	public MetaAgencia removeMetaAgencia(MetaAgencia metaAgencia) {
		getMetasAgencias().remove(metaAgencia);
		metaAgencia.setCargaMetaAgencia(null);

		return metaAgencia;
	}

}
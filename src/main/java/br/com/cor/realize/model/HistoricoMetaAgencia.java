package br.com.correios.realize.model;

import br.com.correios.realize.model.enums.TipoMetaEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * The persistent class for the HISTORICO_META_AGENCIA database table.
 * 
 */
@Entity
@Table(name="HISTORICO_META_AGENCIA")
public class HistoricoMetaAgencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="HMA_NU")
	@GeneratedValue(generator="sqHmaNu",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="sqHmaNu",sequenceName="SQ_HMA_NU", allocationSize=1)
	private Long hmaNu;

	@Column(name="HMA_DT_ALTERACAO")
	private LocalDateTime hmaDtAlteracao;

	@Column(name="HMA_NU_CARGA")
	private Long hmaNuCarga;

	@Column(name="HMA_VR")
	private BigDecimal hmaVr;

	@Column(name="HMA_NU_MCMCU_AGENCIA")
	private String mcmcuAgencia;

	@Enumerated(EnumType.STRING)
	@Column(name="HMA_IN_TIPO_META")
	private TipoMetaEnum hmaInTipoMeta;

	@Column(name="HMA_CO_DRKY_SEGMENTO_NEGOCIO")
	private String drkySegmentoNegocio;

	@Column(name="HMA_NU_JSITM_PRODUTO")
	private Long jsitmProduto;

	@Column(name="HMA_AN")
	private Long hmaAn;

	@Column(name="HMA_ME")
	private Long hmaMe;

	//bi-directional many-to-one association to MetaAgencia
	@ManyToOne
	@JoinColumn(name="MAG_NU")
	private MetaAgencia metaAgencia;

	public HistoricoMetaAgencia() {
	}

	public HistoricoMetaAgencia(MetaAgencia metaAgencia) {
		this.metaAgencia = metaAgencia;
		this.hmaVr = metaAgencia.getMagVr();
		this.hmaDtAlteracao = LocalDateTime.now();
		this.hmaNuCarga = metaAgencia.getCargaMetaAgencia().getCmaNu();
	}

	public Long getHmaNu() {
		return this.hmaNu;
	}

	public void setHmaNu(Long hmaNu) {
		this.hmaNu = hmaNu;
	}

	public LocalDateTime getHmaDtAlteracao() {
		return this.hmaDtAlteracao;
	}

	public void setHmaDtAlteracao(LocalDateTime hmaDtAlteracao) {
		this.hmaDtAlteracao = hmaDtAlteracao;
	}

	public Long getHmaNuCarga() {
		return this.hmaNuCarga;
	}

	public void setHmaNuCarga(Long hmaNuCarga) {
		this.hmaNuCarga = hmaNuCarga;
	}

	public BigDecimal getHmaVr() {
		return this.hmaVr;
	}

	public void setHmaVr(BigDecimal hmaVr) {
		this.hmaVr = hmaVr;
	}

	public MetaAgencia getMetaAgencia() {
		return this.metaAgencia;
	}

	public void setMetaAgencia(MetaAgencia metaAgencia) {
		this.metaAgencia = metaAgencia;
	}

	public String getMcmcuAgencia() {
		return mcmcuAgencia;
	}

	public void setMcmcuAgencia(String mcmcuAgencia) {
		this.mcmcuAgencia = mcmcuAgencia;
	}

	public TipoMetaEnum getHmaInTipoMeta() {
		return hmaInTipoMeta;
	}

	public void setHmaInTipoMeta(TipoMetaEnum hmaInTipoMeta) {
		this.hmaInTipoMeta = hmaInTipoMeta;
	}

	public String getDrkySegmentoNegocio() {
		return drkySegmentoNegocio;
	}

	public void setDrkySegmentoNegocio(String drkySegmentoNegocio) {
		this.drkySegmentoNegocio = drkySegmentoNegocio;
	}

	public Long getJsitmProduto() {
		return jsitmProduto;
	}

	public void setJsitmProduto(Long jsitmProduto) {
		this.jsitmProduto = jsitmProduto;
	}

	public Long getHmaAn() {
		return hmaAn;
	}

	public void setHmaAn(Long hmaAn) {
		this.hmaAn = hmaAn;
	}

	public Long getHmaMe() {
		return hmaMe;
	}

	public void setHmaMe(Long hmaMe) {
		this.hmaMe = hmaMe;
	}
}
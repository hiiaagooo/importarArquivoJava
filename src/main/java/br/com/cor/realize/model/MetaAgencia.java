package br.com.correios.realize.model;

import br.com.correios.realize.model.enums.TipoMetaEnum;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the META_AGENCIA database table.
 * 
 */
@Entity
@Table(name="META_AGENCIA")
public class MetaAgencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="sqMagNu",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="sqMagNu",sequenceName="SQ_MAG_NU", allocationSize=1)
	@Column(name="MAG_NU")
	private Long magNu;

	@Column(name="MCMCU_AGENCIA")
	private String mcmcuAgencia;

	@Enumerated(EnumType.STRING)
	@Column(name="MAG_IN_TIPO_META")
	private TipoMetaEnum tipoMetaEnum;

	@Column(name="DRKY_SEGMENTO_NEGOCIO")
	private String drkySegmentoNegocio;

	@Column(name="JSITM_PRODUTO")
	private Long jsitmProduto;

	@Column(name="MAG_AN")
	private Long magAn;

	@Column(name="MAG_ME")
	private Long magMe;

	@Column(name="MAG_VR")
	private BigDecimal magVr;

	//bi-directional many-to-one association to HistoricoMetaAgencia
	@OneToMany(mappedBy="metaAgencia",cascade = CascadeType.ALL)
	private List<HistoricoMetaAgencia> historicoMetasAgencias;

	//bi-directional many-to-one association to CargaMetaAgencia
	@ManyToOne
	@JoinColumn(name="CMA_NU")
	private CargaMetaAgencia cargaMetaAgencia;

	public MetaAgencia(){

	}

	public MetaAgencia(CargaMetaAgencia cargaMetaAgencia, String mcmcuAgencia, String drkySegmentoNegocio, Long jsitmProduto, Long mes, BigDecimal valor) {
		this.cargaMetaAgencia = cargaMetaAgencia;
		this.mcmcuAgencia = mcmcuAgencia;
		this.tipoMetaEnum = cargaMetaAgencia.getTipoMetaEnum();
		this.drkySegmentoNegocio = drkySegmentoNegocio;
		this.jsitmProduto = jsitmProduto;
		this.magAn = cargaMetaAgencia.getAnoReferencia();
		this.magMe = mes;
		this.magVr = valor;
	}

    public MetaAgencia(CargaMetaAgencia cargaMetaAgencia, String mcmcuAgencia, Long mes, BigDecimal valor) {
		this.cargaMetaAgencia = cargaMetaAgencia;
		this.mcmcuAgencia = mcmcuAgencia;
		this.tipoMetaEnum = cargaMetaAgencia.getTipoMetaEnum();
		this.magAn = cargaMetaAgencia.getAnoReferencia();
		this.magMe = mes;
		this.magVr = valor;
    }

	public Long getMagNu() {
		return magNu;
	}

	public void setMagNu(Long magNu) {
		this.magNu = magNu;
	}

	public BigDecimal getMagVr() {
		return this.magVr;
	}

	public void setMagVr(BigDecimal magVr) {
		this.magVr = magVr;
	}

	public List<HistoricoMetaAgencia> getHistoricoMetasAgencias() {
		return this.historicoMetasAgencias;
	}

	public void setHistoricoMetasAgencias(List<HistoricoMetaAgencia> historicoMetaAgencias) {
		this.historicoMetasAgencias = historicoMetaAgencias;
	}

	public HistoricoMetaAgencia addHistoricoMetaAgencia(HistoricoMetaAgencia historicoMetaAgencia) {
		getHistoricoMetasAgencias().add(historicoMetaAgencia);
		historicoMetaAgencia.setMetaAgencia(this);

		return historicoMetaAgencia;
	}

	public HistoricoMetaAgencia removeHistoricoMetaAgencia(HistoricoMetaAgencia historicoMetaAgencia) {
		getHistoricoMetasAgencias().remove(historicoMetaAgencia);
		historicoMetaAgencia.setMetaAgencia(null);

		return historicoMetaAgencia;
	}

	public CargaMetaAgencia getCargaMetaAgencia() {
		return this.cargaMetaAgencia;
	}

	public void setCargaMetaAgencia(CargaMetaAgencia cargaMetaAgencia) {
		this.cargaMetaAgencia = cargaMetaAgencia;
	}

	public String getMcmcuAgencia() {
		return mcmcuAgencia;
	}

	public void setMcmcuAgencia(String mcmcuAgencia) {
		this.mcmcuAgencia = mcmcuAgencia;
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

	public Long getMagAn() {
		return magAn;
	}

	public void setMagAn(Long magAn) {
		this.magAn = magAn;
	}

	public Long getMagMe() {
		return magMe;
	}

	public void setMagMe(Long magMe) {
		this.magMe = magMe;
	}

	public TipoMetaEnum getTipoMetaEnum() {
		return tipoMetaEnum;
	}

	public void setTipoMetaEnum(TipoMetaEnum tipoMetaEnum) {
		this.tipoMetaEnum = tipoMetaEnum;
	}
}
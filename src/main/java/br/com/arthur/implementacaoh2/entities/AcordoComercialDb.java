package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.arthur.implementacaoh2.domain.AcordoComercial;
import br.com.arthur.implementacaoh2.domain.ConfiguracaoCanal;
import br.com.arthur.implementacaoh2.domain.ContaRepasse;

@Entity
@Table(name = "ACORDO_COMERCIAL")
public class AcordoComercialDb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AcordoComercialId acordoComercialId;
	
	@Column(name = "ID_PARCEIRO")
	private Integer idParceiro;
	
	@Column(name = "ID_PRODUTO")
	private Integer idProduto;
	
	@Column(name = "ID_SITUACAO")
	private SituacaoDbType idSituacao;
	
	@Column(name = "DATA_INICIO_VIGENCIA")
	private Date dataInicioVigencia;
	
	@Column(name = "VIGENCIA_INDETERMINADA")
	private Boolean vigenciaIndeterminada;
	
	@Column(name = "DATA_FIM_VIGENCIA")
	private Date dataFimVigencia;
	
	@OneToMany(mappedBy = "canalDisponivelId.acordoComercialDb",
			fetch = FetchType.LAZY,
	        cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<CanalDisponivelDb> canaisDisponiveis;
	
	@OneToMany(mappedBy = "contaRepasseId.acordoComercialDb",
			fetch = FetchType.LAZY,
	        cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<ContaRepasseDb> contasRepasse;
	
	public AcordoComercialDb() {
	}

	public AcordoComercialId getAcordoComercialId() {
		return acordoComercialId;
	}

	public void setAcordoComercialId(AcordoComercialId acordoComercialId) {
		this.acordoComercialId = acordoComercialId;
	}

	public SituacaoDbType getIdSituacao() {
		return idSituacao;
	}

	public void setIdSituacao(SituacaoDbType idSituacao) {
		this.idSituacao = idSituacao;
	}

	public List<CanalDisponivelDb> getCanaisDisponiveis() {
		return canaisDisponiveis;
	}

	public void setCanaisDisponiveis(List<CanalDisponivelDb> canaisDisponiveis) {
		this.canaisDisponiveis = canaisDisponiveis;
	}
	
	public List<ContaRepasseDb> getContasRepasse() {
		return contasRepasse;
	}

	public void setContasRepasse(List<ContaRepasseDb> contasRepasse) {
		this.contasRepasse = contasRepasse;
	}
	
	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public Boolean getVigenciaIndeterminada() {
		return vigenciaIndeterminada;
	}

	public void setVigenciaIndeterminada(Boolean vigenciaIndeterminada) {
		this.vigenciaIndeterminada = vigenciaIndeterminada;
	}

	public Date getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(Date dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}
	
	public Integer getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(Integer idParceiro) {
		this.idParceiro = idParceiro;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public static AcordoComercialDb converterParaDb(AcordoComercial acordoComercial) {
		AcordoComercialDb db = new AcordoComercialDb();
		AcordoComercialId acordoComercialId = new AcordoComercialId(acordoComercial.getIdAcordoComercial(), 
						acordoComercial.getIdVersaoAcordoComercial());
		db.setAcordoComercialId(acordoComercialId);
		db.setDataInicioVigencia(acordoComercial.getDataInicioVigencia());
		db.setDataFimVigencia(acordoComercial.getDataFimVigencia());
		db.setVigenciaIndeterminada(acordoComercial.getVigenciaIndeterminada());
		db.setIdSituacao(acordoComercial.getSituacao());
		db.setIdParceiro(acordoComercial.getIdParceiro());
		db.setIdProduto(acordoComercial.getIdProduto());
		db.setVigenciaIndeterminada(acordoComercial.getVigenciaIndeterminada());
		
		db.setCanaisDisponiveis(new ArrayList<>());
		for (ConfiguracaoCanal configuracaoCanal : acordoComercial.getConfiguracoesCanal()) {
			CanalDisponivelDb canalDisponivel = new CanalDisponivelDb();
			canalDisponivel.setCanalDisponivelId(new CanalDisponivelId());
			canalDisponivel.getCanalDisponivelId().setAcordoComercialDb(db);
			canalDisponivel.getCanalDisponivelId().setIdCanal(configuracaoCanal.getIdCanal());
			canalDisponivel.setIdSituacao(SituacaoDbType.ATIVO);
			db.getCanaisDisponiveis().add(canalDisponivel);
		}
		
		db.setContasRepasse(new ArrayList<ContaRepasseDb>());

		for (ContaRepasse contaRepasse : acordoComercial.getContasRepasse()) {
			ContaParceiroDb contaParceiroDb = new ContaParceiroDb();
			contaParceiroDb.setContaId(new ContaId(acordoComercial.getIdParceiro(), contaRepasse.getIdConta()));
			ContaRepasseId contaRepasseId = new ContaRepasseId(db, contaParceiroDb);
			ContaRepasseDb contaRepasseDb = new ContaRepasseDb(contaRepasseId, contaRepasse.getPercentualRateio(), contaRepasse.getCodigoFinalidadeSPB());
			db.getContasRepasse().add(contaRepasseDb);
		}
		return db;
	}
}

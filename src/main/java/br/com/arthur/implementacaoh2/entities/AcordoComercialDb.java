package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.arthur.implementacaoh2.domain.AcordoComercial;
import br.com.arthur.implementacaoh2.domain.ConfiguracaoCanal;

@Entity
@Table(name = "ACORDO_COMERCIAL")
public class AcordoComercialDb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AcordoComercialId acordoComercialId;
	
	private SituacaoType idSituacao;
	
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

	public SituacaoType getIdSituacao() {
		return idSituacao;
	}

	public void setIdSituacao(SituacaoType idSituacao) {
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
	
	public static AcordoComercialDb converterParaDb(AcordoComercial acordoComercial) {
		AcordoComercialDb db = new AcordoComercialDb();
		AcordoComercialId acordoComercialId = new AcordoComercialId(acordoComercial.getIdAcordoComercial(), 
						acordoComercial.getIdVersaoAcordoComercial());
		db.setAcordoComercialId(acordoComercialId);
		db.setCanaisDisponiveis(new ArrayList<>());
		for (ConfiguracaoCanal configuracaoCanal : acordoComercial.getConfiguracoesCanal()) {
			CanalDisponivelDb canalDisponivel = new CanalDisponivelDb();
			canalDisponivel.setCanalDisponivelId(new CanalDisponivelId());
			canalDisponivel.getCanalDisponivelId().setAcordoComercialDb(db);
			canalDisponivel.getCanalDisponivelId().setIdCanal(configuracaoCanal.getIdCanal());
			canalDisponivel.setIdSituacao(SituacaoType.ATIVO);
			db.getCanaisDisponiveis().add(canalDisponivel);
		}
		return db;
	}
}

package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
	
	@OneToMany
	@JoinColumns({
		@JoinColumn(name = "ID_ACORDO_COMERCIAL"),
		@JoinColumn(name = "ID_VERSAO_ACORDO_COMERCIAL")
	})
	private List<CanalDisponivelDb> canaisDisponiveis;
	
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
	
	public AcordoComercial convert() {
		AcordoComercial acordoComercial = new AcordoComercial();
		acordoComercial.setIdAcordoComercial(this.acordoComercialId.getIdAcordoComercial());
		acordoComercial.setIdVersaoAcordoComercial(this.acordoComercialId.getIdVersaoAcordoComercial());
		acordoComercial.setConfiguracoesCanal(new ArrayList<>());
		for (CanalDisponivelDb canalDisponivelDb : canaisDisponiveis) {
			ConfiguracaoCanal configuracaoCanal = new ConfiguracaoCanal();
			configuracaoCanal.setIdCanal(canalDisponivelDb.getCanalDisponivelId().getIdCanal());
			configuracaoCanal.setMeiosPagamento(new ArrayList<>());
			for (MeioPagamentoDb meioPagamentoDb : canalDisponivelDb.getMeiosPagamento()) {
				configuracaoCanal.getMeiosPagamento().add(meioPagamentoDb.getMeioPagamentoId().getIdMeioPagamento());
			}
			acordoComercial.getConfiguracoesCanal().add(configuracaoCanal);
		}
		return acordoComercial;
	}
}

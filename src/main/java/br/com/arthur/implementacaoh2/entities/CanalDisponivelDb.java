package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACORDO_COMERCIAL_CANAL_DISPONIVEL")
public class CanalDisponivelDb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CanalDisponivelId canalDisponivelId;
	
	private SituacaoType idSituacao;
	
	@OneToMany
	@JoinColumns({
		@JoinColumn(name = "ID_ACORDO_COMERCIAL"),
		@JoinColumn(name = "ID_VERSAO_ACORDO_COMERCIAL"),
		@JoinColumn(name = "ID_CANAL")
	})
	private List<MeioPagamentoDb> meiosPagamento;

	public CanalDisponivelDb() {
	}
	
	public CanalDisponivelId getCanalDisponivelId() {
		return canalDisponivelId;
	}

	public void setCanalDisponivelId(CanalDisponivelId canalDisponivelId) {
		this.canalDisponivelId = canalDisponivelId;
	}

	public SituacaoType getIdSituacao() {
		return idSituacao;
	}

	public void setIdSituacao(SituacaoType idSituacao) {
		this.idSituacao = idSituacao;
	}

	public List<MeioPagamentoDb> getMeiosPagamento() {
		return meiosPagamento;
	}

	public void setMeiosPagamento(List<MeioPagamentoDb> meiosPagamento) {
		this.meiosPagamento = meiosPagamento;
	}
	
}
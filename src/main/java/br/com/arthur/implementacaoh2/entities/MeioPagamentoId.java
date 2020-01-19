package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class MeioPagamentoId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "ID_ACORDO_COMERCIAL"),
		@JoinColumn(name = "ID_VERSAO_ACORDO_COMERCIAL"),
		@JoinColumn(name = "ID_CANAL"),
	})
	private CanalDisponivelDb canalDisponivelDb;
	
	@Column(name = "ID_MEIO_PAGAMENTO")
	private Integer idMeioPagamento;
	
	public MeioPagamentoId() {
	}

	public CanalDisponivelDb getCanalDisponivelDb() {
		return canalDisponivelDb;
	}

	public void setCanalDisponivelDb(CanalDisponivelDb canalDisponivelDb) {
		this.canalDisponivelDb = canalDisponivelDb;
	}

	public Integer getIdMeioPagamento() {
		return idMeioPagamento;
	}

	public void setIdMeioPagamento(Integer idMeioPagamento) {
		this.idMeioPagamento = idMeioPagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canalDisponivelDb == null) ? 0 : canalDisponivelDb.hashCode());
		result = prime * result + ((idMeioPagamento == null) ? 0 : idMeioPagamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeioPagamentoId other = (MeioPagamentoId) obj;
		if (canalDisponivelDb == null) {
			if (other.canalDisponivelDb != null)
				return false;
		} else if (!canalDisponivelDb.equals(other.canalDisponivelDb))
			return false;
		if (idMeioPagamento == null) {
			if (other.idMeioPagamento != null)
				return false;
		} else if (!idMeioPagamento.equals(other.idMeioPagamento))
			return false;
		return true;
	}

}
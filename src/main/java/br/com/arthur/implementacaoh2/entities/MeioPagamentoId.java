package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MeioPagamentoId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CanalDisponivelId canalDisponivelId;
	
	@Column(name = "ID_MEIO_PAGAMENTO")
	private Integer idMeioPagamento;
	
	public MeioPagamentoId() {
	}

	public CanalDisponivelId getCanalDisponivelId() {
		return canalDisponivelId;
	}

	public void setCanalDisponivelId(CanalDisponivelId canalDisponivelId) {
		this.canalDisponivelId = canalDisponivelId;
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
		result = prime * result + ((canalDisponivelId == null) ? 0 : canalDisponivelId.hashCode());
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
		if (canalDisponivelId == null) {
			if (other.canalDisponivelId != null)
				return false;
		} else if (!canalDisponivelId.equals(other.canalDisponivelId))
			return false;
		if (idMeioPagamento == null) {
			if (other.idMeioPagamento != null)
				return false;
		} else if (!idMeioPagamento.equals(other.idMeioPagamento))
			return false;
		return true;
	}
	
}
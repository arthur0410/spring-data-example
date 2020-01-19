package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ACORDO_COMERCIAL_MEIO_PAGAMENTO")
public class MeioPagamentoDb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MeioPagamentoId meioPagamentoId;
	
	private SituacaoDbType situacao;
	
	public MeioPagamentoDb() {
	}

	public MeioPagamentoId getMeioPagamentoId() {
		return meioPagamentoId;
	}

	public void setMeioPagamentoId(MeioPagamentoId meioPagamentoId) {
		this.meioPagamentoId = meioPagamentoId;
	}

	public SituacaoDbType getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoDbType situacao) {
		this.situacao = situacao;
	}
	
}

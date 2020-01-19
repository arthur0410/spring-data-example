package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "CONTA_PARCEIRO")
@Inheritance(strategy = InheritanceType.JOINED)
public class ContaParceiroDb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContaId contaId;
	
	@Column(name = "TIPO_CONTA")
	private ContaType tipoConta;

	public ContaParceiroDb() {
	}

	public ContaParceiroDb(ContaId contaId, ContaType tipoConta) {
		this.contaId = contaId;
		this.tipoConta = tipoConta;
	}

	public ContaParceiroDb(ContaId contaId) {
		this.contaId = contaId;
	}

	public ContaId getContaId() {
		return contaId;
	}

	public void setContaId(ContaId contaId) {
		this.contaId = contaId;
	}

	public ContaType getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(ContaType tipoConta) {
		this.tipoConta = tipoConta;
	}

}

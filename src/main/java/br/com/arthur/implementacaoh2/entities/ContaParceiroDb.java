package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
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
	
	@OneToMany
	@JoinColumns({
		@JoinColumn(name = "ID_PARCEIRO", referencedColumnName = "ID_PARCEIRO"),
		@JoinColumn(name = "ID_CONTA", referencedColumnName = "ID_CONTA")
	})
	List<ContaRepasseDb> contasRepasse;

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

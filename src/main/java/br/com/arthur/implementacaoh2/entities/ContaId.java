package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID_PARCEIRO")
	private Integer idParceiro;
	
	@Column(name = "ID_CONTA")
	private Integer idConta;
	
	public ContaId() {
	}
	
	public ContaId(Integer idParceiro, Integer idConta) {
		this.idParceiro = idParceiro;
		this.idConta = idConta;
	}

	public Integer getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(Integer idParceiro) {
		this.idParceiro = idParceiro;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
		result = prime * result + ((idParceiro == null) ? 0 : idParceiro.hashCode());
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
		ContaId other = (ContaId) obj;
		if (idConta == null) {
			if (other.idConta != null)
				return false;
		} else if (!idConta.equals(other.idConta))
			return false;
		if (idParceiro == null) {
			if (other.idParceiro != null)
				return false;
		} else if (!idParceiro.equals(other.idParceiro))
			return false;
		return true;
	}

}

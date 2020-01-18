package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class ContaRepasseId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AcordoComercialId acordoComercialId;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_CONTA", referencedColumnName = "ID_CONTA"),
		@JoinColumn(name = "ID_PARCEIRO", referencedColumnName= "ID_PARCEIRO")
	})
	private ContaParceiroDb contaParceiro;

	public AcordoComercialId getAcordoComercialId() {
		return acordoComercialId;
	}

	public void setAcordoComercialId(AcordoComercialId acordoComercialId) {
		this.acordoComercialId = acordoComercialId;
	}

	public ContaParceiroDb getContaParceiro() {
		return contaParceiro;
	}

	public void setContaParceiro(ContaParceiroDb contaParceiro) {
		this.contaParceiro = contaParceiro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acordoComercialId == null) ? 0 : acordoComercialId.hashCode());
		result = prime * result + ((contaParceiro == null) ? 0 : contaParceiro.hashCode());
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
		ContaRepasseId other = (ContaRepasseId) obj;
		if (acordoComercialId == null) {
			if (other.acordoComercialId != null)
				return false;
		} else if (!acordoComercialId.equals(other.acordoComercialId))
			return false;
		if (contaParceiro == null) {
			if (other.contaParceiro != null)
				return false;
		} else if (!contaParceiro.equals(other.contaParceiro))
			return false;
		return true;
	}

}

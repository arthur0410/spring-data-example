package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CanalDisponivelId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AcordoComercialId acordoComercialId;
	
	@Column(name = "ID_CANAL")
	private String idCanal;
	
	public CanalDisponivelId() {
	}

	public AcordoComercialId getAcordoComercialId() {
		return acordoComercialId;
	}

	public void setAcordoComercialId(AcordoComercialId acordoComercialId) {
		this.acordoComercialId = acordoComercialId;
	}

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acordoComercialId == null) ? 0 : acordoComercialId.hashCode());
		result = prime * result + ((idCanal == null) ? 0 : idCanal.hashCode());
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
		CanalDisponivelId other = (CanalDisponivelId) obj;
		if (acordoComercialId == null) {
			if (other.acordoComercialId != null)
				return false;
		} else if (!acordoComercialId.equals(other.acordoComercialId))
			return false;
		if (idCanal == null) {
			if (other.idCanal != null)
				return false;
		} else if (!idCanal.equals(other.idCanal))
			return false;
		return true;
	}
	
}
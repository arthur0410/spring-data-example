package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AcordoComercialId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_ACORDO_COMERCIAL")
	private Long idAcordoComercial;
	
	@Column(name = "ID_VERSAO_ACORDO_COMERCIAL")
	private Long idVersaoAcordoComercial;

	public AcordoComercialId() {
	}
	
	public AcordoComercialId(Long idAcordoComercial, Long idVersaoAcordoComercial) {
		this.idAcordoComercial = idAcordoComercial;
		this.idVersaoAcordoComercial = idVersaoAcordoComercial;
	}

	public Long getIdAcordoComercial() {
		return idAcordoComercial;
	}

	public void setIdAcordoComercial(Long idAcordoComercial) {
		this.idAcordoComercial = idAcordoComercial;
	}

	public Long getIdVersaoAcordoComercial() {
		return idVersaoAcordoComercial;
	}

	public void setIdVersaoAcordoComercial(Long idVersaoAcordoComercial) {
		this.idVersaoAcordoComercial = idVersaoAcordoComercial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAcordoComercial == null) ? 0 : idAcordoComercial.hashCode());
		result = prime * result + ((idVersaoAcordoComercial == null) ? 0 : idVersaoAcordoComercial.hashCode());
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
		AcordoComercialId other = (AcordoComercialId) obj;
		if (idAcordoComercial == null) {
			if (other.idAcordoComercial != null)
				return false;
		} else if (!idAcordoComercial.equals(other.idAcordoComercial))
			return false;
		if (idVersaoAcordoComercial == null) {
			if (other.idVersaoAcordoComercial != null)
				return false;
		} else if (!idVersaoAcordoComercial.equals(other.idVersaoAcordoComercial))
			return false;
		return true;
	}
	
	
}
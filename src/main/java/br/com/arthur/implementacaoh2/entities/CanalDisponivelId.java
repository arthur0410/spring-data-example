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
public class CanalDisponivelId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "ID_ACORDO_COMERCIAL"),
		@JoinColumn(name = "ID_VERSAO_ACORDO_COMERCIAL")
	})
	private AcordoComercialDb acordoComercialDb;
	
	@Column(name = "ID_CANAL")
	private String idCanal;
	
	public CanalDisponivelId() {
	}

	public AcordoComercialDb getAcordoComercialDb() {
		return acordoComercialDb;
	}

	public void setAcordoComercialDb(AcordoComercialDb acordoComercialDb) {
		this.acordoComercialDb = acordoComercialDb;
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
		result = prime * result + ((acordoComercialDb == null) ? 0 : acordoComercialDb.hashCode());
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
		if (acordoComercialDb == null) {
			if (other.acordoComercialDb != null)
				return false;
		} else if (!acordoComercialDb.equals(other.acordoComercialDb))
			return false;
		if (idCanal == null) {
			if (other.idCanal != null)
				return false;
		} else if (!idCanal.equals(other.idCanal))
			return false;
		return true;
	}
	
}
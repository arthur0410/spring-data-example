package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class ContaRepasseId implements Serializable {

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
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "ID_CONTA", referencedColumnName = "ID_CONTA"),
		@JoinColumn(name = "ID_PARCEIRO", referencedColumnName= "ID_PARCEIRO")
	})
	private ContaParceiroDb contaParceiro;
	
	public ContaRepasseId() {
	}

	public AcordoComercialDb getAcordoComercialDb() {
		return acordoComercialDb;
	}

	public void setAcordoComercialDb(AcordoComercialDb acordoComercialDb) {
		this.acordoComercialDb = acordoComercialDb;
	}

	public ContaParceiroDb getContaParceiro() {
		return contaParceiro;
	}

	public void setContaParceiro(ContaParceiroDb contaParceiro) {
		this.contaParceiro = contaParceiro;
	}

}

package br.com.arthur.implementacaoh2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CONTA_REPASSE")
public class ContaRepasseDb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContaRepasseId contaRepasseId;
	
	@Column(name = "PERCENTUAL_RATEIO")
	private Double percentualRateio;
	
	@Column(name = "CODIGO_FINALIDADE_SPB")
	private String codigoFinalidadeSPB;
	
	public ContaRepasseDb() {
	}

	public ContaRepasseDb(ContaRepasseId contaRepasseId) {
		this.contaRepasseId = contaRepasseId;
	}

	public ContaRepasseId getContaRepasseId() {
		return contaRepasseId;
	}

	public void setContaRepasseId(ContaRepasseId contaRepasseId) {
		this.contaRepasseId = contaRepasseId;
	}

	public Double getPercentualRateio() {
		return percentualRateio;
	}

	public void setPercentualRateio(Double percentualRateio) {
		this.percentualRateio = percentualRateio;
	}

	public String getCodigoFinalidadeSPB() {
		return codigoFinalidadeSPB;
	}

	public void setCodigoFinalidadeSPB(String codigoFinalidadeSPB) {
		this.codigoFinalidadeSPB = codigoFinalidadeSPB;
	}
	
}

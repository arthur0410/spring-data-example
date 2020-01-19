package br.com.arthur.implementacaoh2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContaRepasse {

	@JsonProperty("id_conta")
	private Integer idConta;
	
	@JsonProperty("codigo_finalidade_spb")
	private String codigoFinalidadeSPB;
	
	@JsonProperty("percentual_rateio")
	private Double percentualRateio;

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public String getCodigoFinalidadeSPB() {
		return codigoFinalidadeSPB;
	}

	public void setCodigoFinalidadeSPB(String codigoFinalidadeSPB) {
		this.codigoFinalidadeSPB = codigoFinalidadeSPB;
	}

	public Double getPercentualRateio() {
		return percentualRateio;
	}

	public void setPercentualRateio(Double percentualRateio) {
		this.percentualRateio = percentualRateio;
	}
	
	
}

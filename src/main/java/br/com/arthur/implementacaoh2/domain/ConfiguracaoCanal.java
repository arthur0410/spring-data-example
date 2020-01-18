package br.com.arthur.implementacaoh2.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfiguracaoCanal {

	@JsonProperty("id_canal")
	private String idCanal;
	
	@JsonProperty("meios_pagamento")
	private List<Integer> meiosPagamento;

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	public List<Integer> getMeiosPagamento() {
		return meiosPagamento;
	}

	public void setMeiosPagamento(List<Integer> meiosPagamento) {
		this.meiosPagamento = meiosPagamento;
	}
	

}

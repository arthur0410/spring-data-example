package br.com.arthur.implementacaoh2.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AcordoComercial {

	@JsonProperty("id_acordo_comercial")
	private Long idAcordoComercial;
	
	@JsonProperty("id_versao_acordo_comercial")
	private Long idVersaoAcordoComercial;
	
	@JsonProperty("configuracoes_canal")
	private List<ConfiguracaoCanal> configuracoesCanal;

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

	public List<ConfiguracaoCanal> getConfiguracoesCanal() {
		return configuracoesCanal;
	}

	public void setConfiguracoesCanal(List<ConfiguracaoCanal> configuracoesCanal) {
		this.configuracoesCanal = configuracoesCanal;
	}
	
}

package br.com.arthur.implementacaoh2.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.arthur.implementacaoh2.entities.SituacaoDbType;
import br.com.arthur.implementacaoh2.entrypoints.ValidaDatas;

@ValidaDatas
public class AcordoComercial {
	
	@JsonProperty("id_acordo_comercial")
	private Long idAcordoComercial;
	
	@JsonProperty("id_versao_acordo_comercial")
	private Long idVersaoAcordoComercial;
	
	@JsonProperty("id_parceiro")
	private Integer idParceiro;
	
	@JsonProperty("id_produto")
	private Integer idProduto;
	
	@JsonProperty("situacao")
	private SituacaoDbType situacao;
	
	@JsonProperty("data_inicio_vigencia")
	@FutureOrPresent
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataInicioVigencia;
	
	@JsonProperty("vigencia_indeterminada")
	@NotNull
	private Boolean vigenciaIndeterminada;
	
	@JsonProperty("data_fim_vigencia")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Future
	private Date dataFimVigencia;
	
	@JsonProperty("configuracoes_canal")
	private List<ConfiguracaoCanal> configuracoesCanal;
	
	@JsonProperty("contas_repasse")
	private List<ContaRepasse> contasRepasse;;

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

	public SituacaoDbType getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoDbType situacao) {
		this.situacao = situacao;
	}

	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public Date getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(Date dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

	public Boolean getVigenciaIndeterminada() {
		return vigenciaIndeterminada;
	}

	public void setVigenciaIndeterminada(Boolean vigenciaIndeterminada) {
		this.vigenciaIndeterminada = vigenciaIndeterminada;
	}

	public Integer getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(Integer idParceiro) {
		this.idParceiro = idParceiro;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public List<ContaRepasse> getContasRepasse() {
		return contasRepasse;
	}

	public void setContasRepasse(List<ContaRepasse> contasRepasse) {
		this.contasRepasse = contasRepasse;
	}
	
}

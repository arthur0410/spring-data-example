package br.com.arthur.implementacaoh2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SituacaoDbType {
	@JsonProperty("ativo")
    ATIVO("1"), 
    @JsonProperty("inativo")
    INATIVO("99");
	 
    private String code;
 
    private SituacaoDbType(String code) {
        this.code = code;
    }
 
    public String getCode() {
        return code;
    }
}

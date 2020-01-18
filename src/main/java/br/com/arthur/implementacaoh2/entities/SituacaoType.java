package br.com.arthur.implementacaoh2.entities;

public enum SituacaoType {
    ATIVO("1"), INATIVO("99");
	 
    private String code;
 
    private SituacaoType(String code) {
        this.code = code;
    }
 
    public String getCode() {
        return code;
    }
}

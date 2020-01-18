package br.com.arthur.implementacaoh2.entities;

public enum ContaType {
    INTERNA(1), EXTERNA(2);
	 
    private Integer code;
 
    private ContaType(Integer code) {
        this.code = code;
    }
 
    public Integer getCode() {
        return code;
    }
}

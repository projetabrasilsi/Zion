package model.enums;

public enum Enum_Aux_Tipo_Endereco {
	COMERCIAL("COMERCIAL"),  
    RESIDENCIAL("RESIDENCIAL"),  
    COBRANCA("COBRANCA");  
    private String descricao;  
    Enum_Aux_Tipo_Endereco(String descricao) {  
        this.descricao = descricao;  
    }
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}  
    
}

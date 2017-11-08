package model.enums;

public enum Enum_Aux_Tipo_Pessoa {
	FISICA("FISICA",Enum_Aux_Mascaras.CPF), 
	JURIDICA("JURIDICA",Enum_Aux_Mascaras.CNPJ);
	
	
		
    
	private String descricao;
	private Enum_Aux_Mascaras mascara;
	
			
	Enum_Aux_Tipo_Pessoa(String descricao, Enum_Aux_Mascaras mascara){
		this.descricao = descricao;
		this.mascara = mascara;		
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Enum_Aux_Mascaras getMascara() {
		return mascara;
	}


	public void setMascara(Enum_Aux_Mascaras mascara) {
		this.mascara = mascara;
	}
	
	
	
}

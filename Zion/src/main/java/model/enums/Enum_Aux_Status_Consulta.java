package model.enums;

public enum Enum_Aux_Status_Consulta {
	
	BAIXADO("BAIXADO","ETAPA DE DOWNLOAD"),
	ANALISADO("ANALISADO","ETAPA DE ANALISE"),
	INVALIDADO("INVALIDADO",""),	
	SALVO("SALVO","");
	String descricao;
	String descricao2;
	
	Enum_Aux_Status_Consulta(String descricao,String descricao2) {
		this.descricao = descricao;		
		this.descricao2 = descricao2;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao2() {
		return descricao2;
	}
	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}
	

}

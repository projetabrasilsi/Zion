package model.enums;

public enum Enum_Aux_Comparativos_Resultados {
	
	AUMENTOU("AUMENTOU"),
	DIMINIUIU("DIMINUIU"),
	MANTEVE("MANTEVE"),
	NAO_AVALIADO("NAO_AVALIADO"),
	TODOS("");
	
	private String descricao;
	
	Enum_Aux_Comparativos_Resultados(String descricao ){
		this.descricao = descricao;
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}

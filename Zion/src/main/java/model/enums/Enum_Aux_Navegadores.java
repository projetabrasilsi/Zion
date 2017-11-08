package model.enums;

public enum Enum_Aux_Navegadores {
	INICIO("INICIO"),
	FIM("FIM"),
	ANTERIOR("ANTERIOR"),
	PROXIMO("PROXIMO");
	
	String descricao;
	
	private Enum_Aux_Navegadores(String descricao) {
	  setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

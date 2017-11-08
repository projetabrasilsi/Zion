package model.enums;

public enum Enum_Aux_Tipo_de_Contato {
	
	FIXO("FIXO",Enum_Aux_Mascaras.TEL8DG),
	CELULAR("CELULAR",Enum_Aux_Mascaras.TEL9DG),
	EMAIL("EMAIL",Enum_Aux_Mascaras.SEMMASC);
	
	private String descricao;
	private Enum_Aux_Mascaras mascara;
	Enum_Aux_Tipo_de_Contato(String descricao, Enum_Aux_Mascaras mascara){
		
		this.descricao = descricao;
		this.mascara = mascara;
		
	}

	public String getDescricao() {
		return descricao;
	}

	public Enum_Aux_Mascaras getMascara() {
		return mascara;
	}

	public void setMascara(Enum_Aux_Mascaras mascara) {
		this.mascara = mascara;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

	
}

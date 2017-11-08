package model.enums;

public enum Enum_Aux_Cidades_Servicos {
	FLORIANOPOLIS_SC("FLORIANOPOLIS_SC"),
	SAO_JOSE_SC("SAO_JOSE_SC"),
	PALHOCA_SC("PALHOCA_SC"),
	BIGUAGU_SC("BIGUACU_SC"),
	SC_GERAL("SC_GERAL");
	
	String descricao;
	Enum_Aux_Cidades_Servicos(String descricao ){
		setDescricao(descricao);
		
	}
	protected String getDescricao() {
		return descricao;
	}
	protected void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

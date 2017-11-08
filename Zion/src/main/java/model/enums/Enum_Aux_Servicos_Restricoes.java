package model.enums;

public enum Enum_Aux_Servicos_Restricoes {
	FLORIANOPOLIS_SC("FLORIANOPOLIS_SC","FLORIANÓPOLIS SC",Enum_Aux_Estados.SC),
	SAO_JOSE_SC("SAO_JOSE_SC","SÃO JOSÉ SC",Enum_Aux_Estados.SC),
	PALHOCA_SC("PALHOCA_SC","PALHOÇA SC",Enum_Aux_Estados.SC),
	BIGUACU_SC("BIGUACU_SC","BIGUAÇU SC",Enum_Aux_Estados.SC),
	SANTA_CATARINA_SC("SANTA_CATARINA_SC","SANTA CATARINA SC",Enum_Aux_Estados.SC);
	private String descricao;
	private String titulo;
	private Enum_Aux_Estados enum_Aux_Estados;
	
	private Enum_Aux_Servicos_Restricoes(String descricao,String titulo,Enum_Aux_Estados enum_Aux_Estados) {
		this.descricao = descricao;
		this.titulo = titulo;
		this.enum_Aux_Estados = enum_Aux_Estados;

	}
	
	public static Enum_Aux_Servicos_Restricoes retornaEnum(String text) {
	    for (Enum_Aux_Servicos_Restricoes b : Enum_Aux_Servicos_Restricoes.values()) {
	      if (b.getDescricao().equalsIgnoreCase(text)) {
	        return b;
	      }
	    }
	    return null;
	  }
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Enum_Aux_Estados getEnum_Aux_Estados() {
		return enum_Aux_Estados;
	}
	public void setEnum_Aux_Estados(Enum_Aux_Estados enum_Aux_Estados) {
		this.enum_Aux_Estados = enum_Aux_Estados;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
}

package model.enums;

public enum Enum_Aux_Servicos_Sub_Classificacoes {
	COMPARATIVOS(1,"COMPARATIVOS",true),
	DAMS(2,"DAMS",false),
	CNDS(3,"CNDS",false),
	CONFERENCIA_DEBITOS(4,"CONFERENCIA_DEBITOS",false),
	TRANSFERENCIA_TITULARIDADE(5,"TRANSFERENCIA_TITULARIDADE",false);
	private int id;
	private String descricao;
	private boolean comparativo;
	Enum_Aux_Servicos_Sub_Classificacoes(int id,String descricao,boolean comparativo){
		this.descricao = descricao;
		this.id = id;
		this.comparativo = comparativo;
	}
	public static Enum_Aux_Servicos_Sub_Classificacoes retornaEnum(String text) {
	    for (Enum_Aux_Servicos_Sub_Classificacoes b : Enum_Aux_Servicos_Sub_Classificacoes.values()) {
	      if (b.getDescricao().equalsIgnoreCase(text)) {
	        return b;
	      }
	    }
	    return null;
	  }
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public boolean isComparativo() {
		return comparativo;
	}



	public void setComparativo(boolean comparativo) {
		this.comparativo = comparativo;
	}

	
}

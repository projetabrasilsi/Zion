package model.enums;

public enum Enum_Aux_Servicos_Sub_Classificacoes {
	COMPARATIVOS(1,"COMPARATIVOS","COMPARATIVOS",true,false,4),
	DAMS(2,"DAMS","DAMS",false,false,5),
	CNDS(3,"CNDS","CNDS",false,true,5),
	CONFERENCIA_DEBITOS(4,"CONFERENCIA_DEBITOS","CONFERÊNCIA DE DÉBITOS",false,true,5),
	TRANSFERENCIA_TITULARIDADE(5,"TRANSFERENCIA_TITULARIDADE","TRANSFERÊNCIA DE TITULARIDADE",false,true,5);
	private int id;
	private String descricao;
	private String descricao2;
	private boolean comparativo;
	private boolean exigecpfcnpj;
	private int nSeq;
	Enum_Aux_Servicos_Sub_Classificacoes(int id,String descricao,String descricao2,boolean comparativo,boolean exigecpfcnpj,int nSeq){
		this.descricao = descricao;
		this.id = id;
		this.comparativo = comparativo;
		this.descricao2 = descricao2;
		this.exigecpfcnpj = exigecpfcnpj;
		this.nSeq = nSeq;
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
	public String getDescricao2() {
		return descricao2;
	}
	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}
	public boolean isExigecpfcnpj() {
		return exigecpfcnpj;
	}
	public void setExigecpfcnpj(boolean exigecpfcnpj) {
		this.exigecpfcnpj = exigecpfcnpj;
	}
	public int getnSeq() {
		return nSeq;
	}
	public void setnSeq(int nSeq) {
		this.nSeq = nSeq;
	}

	
}

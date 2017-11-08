package model.enums;

public enum Enum_Aux_Servicos_Classificacoes {
	IPTU(1,"IPTU","ADMINISTRAÇÃO DE IPTU"),
	AGUA(2,"AGUA","ADMINISTRAÇÃO DE ÁGUA"),
	ENERGIA(3,"ENERGIA","ADMINISTRAÇÃO DE ENERGIA"),	
	CONDOMINIO(4,"CONOMINIO","ADMINISTRAÇÃO DE CONDOMINIOS");

	private int id;
	private String descricao;
	private String titulo;
	

	Enum_Aux_Servicos_Classificacoes(int id,String descricao,String titulo){
		this.descricao = descricao;
		this.id = id;
		this.titulo = titulo;
	}
	
	public static Enum_Aux_Servicos_Classificacoes retornaEnum(String text) {
	    for (Enum_Aux_Servicos_Classificacoes b : Enum_Aux_Servicos_Classificacoes.values()) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

}



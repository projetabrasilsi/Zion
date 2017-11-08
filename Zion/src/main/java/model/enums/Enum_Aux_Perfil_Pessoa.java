package model.enums;

public enum Enum_Aux_Perfil_Pessoa {
	NENHUM("Nenhum", false,false,Enum_Aux_Tipo_Pessoa.FISICA ),
	CONTRATADOS("Contratados",false,true,Enum_Aux_Tipo_Pessoa.JURIDICA),
	CONTRATANTES("Contratantes",false,true,Enum_Aux_Tipo_Pessoa.JURIDICA),
	ADMINISTRADORES_GERAL("Administradores Geral",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	ADMINISTRADORES_IPTU("Administradores IPTU",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	ADMINISTRADORES_AGUA("Administradores AGUA",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	ADMINISTRADORES_ENERGIA("Administradores ENERGIA",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	ADMINISTRADORES_CONDOMINIOS("Administradores CONDOMÍNIOS",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	DIRETORES("Diretores",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	GERENTES("Gerentes",true,true,Enum_Aux_Tipo_Pessoa.FISICA),	
	FUNCIONARIOS("Funcionarios",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	ADM_IPTU("Administradores de IPTU",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	ADM_ENERGIA("Administradores de ENERGIA",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	ADM_AGUA("Administradores de AGUA",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	ADM_CONDOMINIO("Administradores de CONDOMINIO",true,true,Enum_Aux_Tipo_Pessoa.FISICA),
	
	CLIENTES("Clientes",true,false,Enum_Aux_Tipo_Pessoa.FISICA);
	
	private String descricao;
	private boolean possuiVinculo;
	private boolean requerSenha;
	private Enum_Aux_Tipo_Pessoa enum_Aux_Tipo_Pessoa; 
	
	
	
	Enum_Aux_Perfil_Pessoa(String descricao, boolean possuiVinculo, boolean requerSenha, Enum_Aux_Tipo_Pessoa enum_Aux_Tipo_Pessoa){		
		setDescricao(descricao);		
		setPossuiVinculo(possuiVinculo);	
		setRequerSenha(requerSenha);
		setEnum_Aux_Tipo_Pessoa(enum_Aux_Tipo_Pessoa);
	}
	
	public String getDescricao() {
		return descricao;
	}

	public boolean isPossuiVinculo() {
		return possuiVinculo;
	}

	public void setPossuiVinculo(boolean possuiVinculo) {
		this.possuiVinculo = possuiVinculo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isRequerSenha() {
		return requerSenha;
	}

	public void setRequerSenha(boolean requerSenha) {
		this.requerSenha = requerSenha;
	}

	public Enum_Aux_Tipo_Pessoa getEnum_Aux_Tipo_Pessoa() {
		return enum_Aux_Tipo_Pessoa;
	}

	public void setEnum_Aux_Tipo_Pessoa(Enum_Aux_Tipo_Pessoa enum_Aux_Tipo_Pessoa) {
		this.enum_Aux_Tipo_Pessoa = enum_Aux_Tipo_Pessoa;
	}
			
}

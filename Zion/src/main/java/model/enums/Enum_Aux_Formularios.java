package model.enums;

public enum Enum_Aux_Formularios {	
	CAD_CONTRATADOS("Cadastro de Contratados", Enum_Aux_Perfil_Pessoa.CONTRATADOS,Enum_Aux_Perfil_Pessoa.CONTRATADOS.isPossuiVinculo()),
	CAD_CONTRATANTES("Cadastro de Contratantes", Enum_Aux_Perfil_Pessoa.CONTRATANTES,Enum_Aux_Perfil_Pessoa.CONTRATANTES.isPossuiVinculo()),
	CAD_ADMINISTRADORES_GERAL("Cadastro de Administradores Geral", Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_GERAL,Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_GERAL.isPossuiVinculo()),
	CAD_ADMINISTRADORES_IPTU("Cadastro de Administradores IPTU", Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_IPTU,Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_IPTU.isPossuiVinculo()),
	CAD_ADMINISTRADORES_ENERGIA("Cadastro de Administradores ENERGIA", Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_ENERGIA,Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_ENERGIA.isPossuiVinculo()),
	CAD_ADMINISTRADORES_AGUA("Cadastro de Administradores AGUA", Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_AGUA,Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_AGUA.isPossuiVinculo()),
	CAD_ADMINISTRADORES_CONDOMINIOS("Cadastro de Administradores CONDOMÍNIOS", Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_CONDOMINIOS,Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_CONDOMINIOS.isPossuiVinculo()),
	CAD_DIRETORES("Cadastro de Diretores", Enum_Aux_Perfil_Pessoa.DIRETORES,Enum_Aux_Perfil_Pessoa.DIRETORES.isPossuiVinculo()),
	CAD_GERENTES("Cadastro de Gerentes", Enum_Aux_Perfil_Pessoa.GERENTES,Enum_Aux_Perfil_Pessoa.GERENTES.isPossuiVinculo()),	
	CAD_FUNCIONARIOS("Cadastro de Funcionarios", Enum_Aux_Perfil_Pessoa.FUNCIONARIOS,Enum_Aux_Perfil_Pessoa.FUNCIONARIOS.isPossuiVinculo()),
	CAD_CLIENTES("Cadastro de Clientes", Enum_Aux_Perfil_Pessoa.CLIENTES,Enum_Aux_Perfil_Pessoa.CLIENTES.isPossuiVinculo()), 
	CAD_INSCRICOES_IPTU("Cadastro de Inscricoes do IPTU", null,true),
	CAD_INSCRICOES_AGUA("Cadastro de Inscricoes de AGUA", null,true),
	CAD_INSCRICOES_ENERGIA("Cadastro de Inscricoes de ENERGIA", null,true),
	CAD_INSCRICOES_CONDOMINIOS("Cadastro de Inscricoes de CONDOMINIOS", null,true),
	MENU_PRINCIPAL("Menu Principal", null,false),
	CAD_SERVICOS("Cadastro de Serviços", null,true),
	PROTOCOLOS_DE_SERVICOS("Protocolos de serviços",null,true),
	FORM_IPTU("Formulário de Serviços de IPTU",null,true),
	FORM_ENERGIA("Formulário de Serviços de ENERGIA",null,true),
	FORM_AGUA("Formulário de Serviços de ÁGUA",null,true),
	FORM_CONDOMINIOS("Formulário de Serviços de CONDOMÍNIOS",null,true),
	FORM_LOGIN("Login", null,false);
	
	
	private String descricao;
	private Enum_Aux_Perfil_Pessoa perfil_Pessoa;
	private boolean possui_Vinculos;
	
	
	
	Enum_Aux_Formularios(String descricao, Enum_Aux_Perfil_Pessoa perfil_Pessoa, boolean possui_Vinculos){
		setDescricao(descricao);
		setPerfil_Pessoa(perfil_Pessoa);				
		setPossui_Vinculos(possui_Vinculos);
	}


	public Enum_Aux_Perfil_Pessoa getPerfil_Pessoa() {
		return perfil_Pessoa;
	}


	public void setPerfil_Pessoa(Enum_Aux_Perfil_Pessoa perfil_Pessoa) {
		this.perfil_Pessoa = perfil_Pessoa;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public boolean isPossui_Vinculos() {
		return possui_Vinculos;
	}


	public void setPossui_Vinculos(boolean possui_Vinculos) {
		this.possui_Vinculos = possui_Vinculos;
	}


	
	
	
}

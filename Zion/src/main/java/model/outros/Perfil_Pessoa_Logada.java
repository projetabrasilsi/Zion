package model.outros;

import java.util.ArrayList;
import java.util.List;

import model.entities.Acessos;
import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.enums.Enum_Aux_Formularios;
import model.enums.Enum_Aux_Perfil_Pessoa;
import model.enums.Enum_Aux_Servicos_Classificacoes;

public class Perfil_Pessoa_Logada {
	
	private Pessoa Pessoa_Logada;
	private Pessoa Empresa_Logada;
	private Enum_Aux_Perfil_Pessoa perfil_Logado;
	private Enum_Aux_Formularios formulario_Atual;
	private List<Pessoa_Perfil_e_Vinculo> perfis_da_Pessoa_Logada;
	private boolean empresaPossuiAlguemVinculado = false;
	private boolean existemPessoasCadatradas = false;
	private Acessos acessos;
	private boolean vinculoproprio = true;
	private Enum_Aux_Servicos_Classificacoes servicosClassificacoes;
	
	public Enum_Aux_Servicos_Classificacoes getServicosClassificacoes() {
		return servicosClassificacoes;
	}

	public void setServicosClassificacoes(Enum_Aux_Servicos_Classificacoes servicosClassificacoes) {
		this.servicosClassificacoes = servicosClassificacoes;
	}

	public Perfil_Pessoa_Logada() {
		super();
		setPessoa_Logada(new Pessoa());
		setEmpresa_Logada(new Pessoa());		
		setFormulario_Atual(Enum_Aux_Formularios.MENU_PRINCIPAL);
		setPerfis_da_Pessoa_Logada(new ArrayList<>());
		setPerfil_Logado(Enum_Aux_Perfil_Pessoa.NENHUM);
	}
	
	public Perfil_Pessoa_Logada(Pessoa pessoa_Logada, Pessoa empresa_Logada,	Enum_Aux_Perfil_Pessoa perfil_Logado,
	Enum_Aux_Formularios formulario_Atual,
	List<Pessoa_Perfil_e_Vinculo> perfis_da_Pessoa_Logada) {		
		setPessoa_Logada(pessoa_Logada);
		setEmpresa_Logada(empresa_Logada);		
		setFormulario_Atual(formulario_Atual);
		setPerfis_da_Pessoa_Logada(perfis_da_Pessoa_Logada);
	}
	
	public Pessoa getPessoa_Logada() {
		return Pessoa_Logada;
	}
	public void setPessoa_Logada(Pessoa pessoa_Logada) {
		Pessoa_Logada = pessoa_Logada;
	}
	public Pessoa getEmpresa_Logada() {
		return Empresa_Logada;
	}
	public void setEmpresa_Logada(Pessoa empresa_Logada) {
		Empresa_Logada = empresa_Logada;
	}
	public Enum_Aux_Perfil_Pessoa getPerfil_Logado() {
		return perfil_Logado;
	}
	public void setPerfil_Logado(Enum_Aux_Perfil_Pessoa perfil_Logado) {
		this.perfil_Logado = perfil_Logado;
	}
	public Enum_Aux_Formularios getFormulario_Atual() {
		return formulario_Atual;
	}
	public void setFormulario_Atual(Enum_Aux_Formularios formulario_Atual) {
		this.formulario_Atual = formulario_Atual;
	}

	public List<Pessoa_Perfil_e_Vinculo> getPerfis_da_Pessoa_Logada() {
		return perfis_da_Pessoa_Logada;
	}

	public void setPerfis_da_Pessoa_Logada(List<Pessoa_Perfil_e_Vinculo> perfis_da_Pessoa_Logada) {
		this.perfis_da_Pessoa_Logada = perfis_da_Pessoa_Logada;
	}

	@Override
	public String toString() {
		return "Perfil_Pessoa_Logada [Pessoa_Logada=" + Pessoa_Logada + ", Empresa_Logada=" + Empresa_Logada
				+ ", perfil_Logado=" + perfil_Logado + ", formulario_Atual=" + formulario_Atual
				+ ", perfis_da_Pessoa_Logada=" + perfis_da_Pessoa_Logada + "]";
	}


	public boolean isExistemPessoasCadatradas() {
		return existemPessoasCadatradas;
	}

	public void setExistemPessoasCadatradas(boolean existemPessoasCadatradas) {
		this.existemPessoasCadatradas = existemPessoasCadatradas;
	}

	public boolean isEmpresaPossuiAlguemVinculado() {
		return empresaPossuiAlguemVinculado;
	}

	public void setEmpresaPossuiAlguemVinculado(boolean empresaPossuiAlguemVinculado) {
		this.empresaPossuiAlguemVinculado = empresaPossuiAlguemVinculado;
	}

	public Acessos getAcessos() {
		return acessos;
	}

	public void setAcessos(Acessos acessos) {
		this.acessos = acessos;
	}

	public boolean isVinculoproprio() {
		return vinculoproprio;
	}

	public void setVinculoproprio(boolean vinculoproprio) {
		this.vinculoproprio = vinculoproprio;
	}

	
	
	

}

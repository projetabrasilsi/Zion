package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.enums.Enum_Aux_Formularios;
import model.enums.Enum_Aux_Perfil_Pessoa;

public class Acessos {
	private Enum_Aux_Perfil_Pessoa perfil;
	private List<Enum_Aux_Formularios> formularios = new ArrayList<>();
	
	

	public Acessos(Enum_Aux_Perfil_Pessoa perfil) {
		this.perfil = perfil;
		switch (perfil) {
		case ADMINISTRADORES_GERAL:
			configuraADM_GERAL();
			break;
		case ADMINISTRADORES_AGUA:
			configuraADM_AGUA();
			break;
		case ADMINISTRADORES_CONDOMINIOS:
			configuraADM_CONDOMINIOS();
			break;
		case ADMINISTRADORES_ENERGIA:
			configuraADM_ENERGIA();
			break;
		case ADMINISTRADORES_IPTU:
			configuraADM_IPTU();
			break;
		case CONTRATADOS:
			configuraContratados();
			break;
		case CONTRATANTES:
			configuraContrantes();
			break;
		case DIRETORES:
			configuraDiretores();
			break;
		case FUNCIONARIOS:
			configuraFuncionarios();
			break;
		case GERENTES:
			configuraGerentes();
			break;
		case CLIENTES:
			configuraClientes();
			break;
		case ADM_AGUA:
			configuraADM_AGUA();
			break;
		case ADM_CONDOMINIO:
			configuraADM_CONDOMINIOS();
			break;
		case ADM_ENERGIA:
			configuraADM_ENERGIA();
			break;
		case ADM_IPTU:
			configuraADM_IPTU();
			break;
		case NENHUM:
			configuracaoVazia();
			break;
		default:
			configuraClientes();

		}

	}

	private void configuraADM_GERAL() {
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_GERAL);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_AGUA);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_IPTU);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_ENERGIA);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_CONDOMINIOS);
		formularios.add(Enum_Aux_Formularios.CAD_CLIENTES);
		formularios.add(Enum_Aux_Formularios.CAD_CONTRATANTES);
		formularios.add(Enum_Aux_Formularios.CAD_CONTRATADOS);
		formularios.add(Enum_Aux_Formularios.CAD_DIRETORES);
		formularios.add(Enum_Aux_Formularios.CAD_FUNCIONARIOS);
		
		
		
		formularios.add(Enum_Aux_Formularios.FORM_IPTU);
		formularios.add(Enum_Aux_Formularios.FORM_ENERGIA);
		formularios.add(Enum_Aux_Formularios.FORM_AGUA);
		formularios.add(Enum_Aux_Formularios.FORM_CONDOMINIOS);
		formularios.add(Enum_Aux_Formularios.CAD_INSCRICOES_IPTU);
		formularios.add(Enum_Aux_Formularios.CAD_INSCRICOES_ENERGIA);
		formularios.add(Enum_Aux_Formularios.CAD_INSCRICOES_AGUA);
		formularios.add(Enum_Aux_Formularios.CAD_INSCRICOES_CONDOMINIOS);
		
		
		
	}

	private void configuraClientes() {

	}
	
	private void configuracaoVazia() {
		formularios.add(Enum_Aux_Formularios.CAD_CONTRATADOS);
	}

	private void configuraADM_IPTU() {		
		formularios.add(Enum_Aux_Formularios.FORM_IPTU);	
		formularios.add(Enum_Aux_Formularios.CAD_INSCRICOES_IPTU);
	}
	
	private void configuraADM_ENERGIA() {
		formularios.add(Enum_Aux_Formularios.FORM_ENERGIA);
		formularios.add(Enum_Aux_Formularios.CAD_INSCRICOES_ENERGIA);
	}
	
	private void configuraADM_AGUA() {
		formularios.add(Enum_Aux_Formularios.FORM_AGUA);
		formularios.add(Enum_Aux_Formularios.CAD_INSCRICOES_AGUA);
	}
	
	private void configuraADM_CONDOMINIOS() {
		
		formularios.add(Enum_Aux_Formularios.FORM_CONDOMINIOS);
		formularios.add(Enum_Aux_Formularios.CAD_INSCRICOES_CONDOMINIOS);

	}

	private void configuraContrantes() {
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_GERAL);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_AGUA);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_CONDOMINIOS);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_ENERGIA);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_IPTU);
		
		formularios.add(Enum_Aux_Formularios.FORM_IPTU);
		formularios.add(Enum_Aux_Formularios.FORM_ENERGIA);
		formularios.add(Enum_Aux_Formularios.FORM_AGUA);
		formularios.add(Enum_Aux_Formularios.FORM_CONDOMINIOS);
		
		
	}

	private void configuraContratados() {
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_GERAL);
		formularios.add(Enum_Aux_Formularios.CAD_CLIENTES);
		formularios.add(Enum_Aux_Formularios.CAD_CONTRATANTES);
		formularios.add(Enum_Aux_Formularios.CAD_CONTRATADOS);
		formularios.add(Enum_Aux_Formularios.CAD_DIRETORES);
		formularios.add(Enum_Aux_Formularios.CAD_FUNCIONARIOS);
		formularios.add(Enum_Aux_Formularios.CAD_GERENTES);
		
		formularios.add(Enum_Aux_Formularios.CAD_SERVICOS);
		
		formularios.add(Enum_Aux_Formularios.FORM_IPTU);
		formularios.add(Enum_Aux_Formularios.FORM_ENERGIA);
		formularios.add(Enum_Aux_Formularios.FORM_AGUA);
		formularios.add(Enum_Aux_Formularios.FORM_CONDOMINIOS);
	}

	private void configuraDiretores() {
		formularios.add(Enum_Aux_Formularios.CAD_CLIENTES);
		formularios.add(Enum_Aux_Formularios.CAD_DIRETORES);
		formularios.add(Enum_Aux_Formularios.CAD_FUNCIONARIOS);
		formularios.add(Enum_Aux_Formularios.CAD_GERENTES);
		
		
		
		formularios.add(Enum_Aux_Formularios.FORM_IPTU);
		formularios.add(Enum_Aux_Formularios.FORM_ENERGIA);
		formularios.add(Enum_Aux_Formularios.FORM_AGUA);
		formularios.add(Enum_Aux_Formularios.FORM_CONDOMINIOS);
		
	}

	private void configuraFuncionarios() {
		
		
	}

	private void configuraGerentes() {		
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_GERAL);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_AGUA);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_CONDOMINIOS);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_ENERGIA);
		formularios.add(Enum_Aux_Formularios.CAD_ADMINISTRADORES_IPTU);
		
		formularios.add(Enum_Aux_Formularios.CAD_CLIENTES);
		
		formularios.add(Enum_Aux_Formularios.FORM_IPTU);
		formularios.add(Enum_Aux_Formularios.FORM_ENERGIA);
		formularios.add(Enum_Aux_Formularios.FORM_AGUA);
		formularios.add(Enum_Aux_Formularios.FORM_CONDOMINIOS);
		
	}

	public void setPerfil(Enum_Aux_Perfil_Pessoa perfil) {
		this.perfil = perfil;
	}

	public List<Enum_Aux_Formularios> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<Enum_Aux_Formularios> formularios) {
		this.formularios = formularios;
	}

	public Enum_Aux_Perfil_Pessoa getPerfil() {
		return perfil;
	}

	

}

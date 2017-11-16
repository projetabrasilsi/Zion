package controller.login;

import model.dao.PessoaDAO;
import model.dao.Pessoa_Perfil_e_VinculoDAO;
import model.dao.UsuarioDAO;
import model.entities.Acessos;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.entities.Usuario;
import model.enums.Enum_Aux_Perfil_Pessoa;
import model.outros.Perfil_Pessoa_Logada;
import util.Utilidades;

public class LoginController_Metodos_A extends LoginController_Metodos_B {
	protected boolean existemPessoasCadastradas() {
		Utilidades.setpPL(new Perfil_Pessoa_Logada());
		Utilidades.getpPL().setPerfil_Logado(null);
		Utilidades.getpPL().setPessoa_Logada(null);
		Utilidades.getpPL().setEmpresa_Logada(null);
		Utilidades.getpPL().setFormulario_Atual(null);
		PessoaDAO pdao = new PessoaDAO();
		Utilidades.getpPL().setExistemPessoasCadatradas(pdao.existemsPessoasCadatradas());
		if (!Utilidades.getpPL().isExistemPessoasCadatradas()) {
			Utilidades.getpPL().setPerfil_Logado(Enum_Aux_Perfil_Pessoa.NENHUM);
			Utilidades.getpPL().setAcessos(new Acessos(Utilidades.getpPL().getPerfil_Logado()));
			Utilidades.setpPL(Utilidades.getpPL());
			return false;
		}
		
		return true;
	}

	protected boolean validacpf_cnpj(String cpf_Cnpj_Empresa, String cpf_Cnpj_Usuario) {
		if (cpf_Cnpj_Empresa == null || cpf_Cnpj_Empresa.length() <= 0
				|| (cpf_Cnpj_Empresa.length() != 14 && cpf_Cnpj_Empresa.length() != 11)) {
			Utilidades.enviaAlertError("CNPJ", "VALIDAÇÃO", "CPF/Cnpj da Empresa é Inválido");
			getcB_Empresa().requestFocus();
			return false;
		}
		if (cpf_Cnpj_Usuario == null || cpf_Cnpj_Usuario.length() <= 0) {
			return false;

		} else if ((cpf_Cnpj_Usuario.length() != 14 && cpf_Cnpj_Usuario.length() != 11)) {
			Utilidades.enviaAlertError("CPF", "VALIDAÇÃO", "CPF/Cnpj do Usuário é Inválido");
			getcB_Usuario().requestFocus();
			return false;
		}
		boolean cpfCnpjOk = false;
		if (cpf_Cnpj_Empresa.length() == 14) {
			cpfCnpjOk = Utilidades.isValidCNPJ(cpf_Cnpj_Empresa);
			if (!cpfCnpjOk) {
				Utilidades.enviaAlertError("CNPJ", "VALIDAÇÃO", "Cnpj da Empresa é Inválido");
				getcB_Empresa().requestFocus();
				return false;
			}
		} else {
			cpfCnpjOk = Utilidades.isValidCPF(cpf_Cnpj_Empresa);
			if (!cpfCnpjOk) {
				Utilidades.enviaAlertError("CPF", "VALIDAÇÃO", "CPF da Empresa é Inválido");
				getcB_Empresa().requestFocus();
				return false;
			}
		}

		if (cpf_Cnpj_Usuario.length() == 14) {
			cpfCnpjOk = Utilidades.isValidCNPJ(cpf_Cnpj_Usuario);
			if (!cpfCnpjOk) {
				Utilidades.enviaAlertError("CNPJ", "VALIDAÇÃO", "Cnpj do Usuário é Inválido");
				getcB_Usuario().requestFocus();
				return false;
			}
		} else {
			cpfCnpjOk = Utilidades.isValidCPF(cpf_Cnpj_Usuario);
			if (!cpfCnpjOk) {
				Utilidades.enviaAlertError("CPF", "VALIDAÇÃO", "CPF do Usuário é Inválido");
				getcB_Usuario().requestFocus();
				return false;
			}
		}
		return true;
	}

	protected boolean loginEmpresa() {
		PessoaDAO pdao = new PessoaDAO();
		Utilidades.getpPL().setEmpresa_Logada(pdao.retornaPessoaPelocpf_Cnpj(cB_Empresa.getValue()));
		if (Utilidades.getpPL().getEmpresa_Logada() == null) {
			Utilidades.enviaAlertError("LOGIN", "EMPRESA", "CPF ou CNPJ, não existe no cadastro");
			return false;
		}
		return true;
	}

	protected boolean usuarioEstaCorreto() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario us = dao.autenticar(cB_Usuario.getValue(), psf_Senha.getText());
		if ((us == null || us.getId_Pessoa() == null)) {
			Utilidades.getpPL().setPessoa_Logada(null);
			return false;
		} else
			Utilidades.getpPL().setPessoa_Logada(us.getId_Pessoa());
		return true;
	}

	protected boolean usuarioEstaVinculoadoAempresa() {
		Pessoa_Perfil_e_Vinculo ppv = new Pessoa_Perfil_e_Vinculo();
		ppv.setId_Pessoa_D(Utilidades.getpPL().getPessoa_Logada());
		ppv.setId_Pessoa_M(Utilidades.getpPL().getEmpresa_Logada());
		Pessoa_Perfil_e_VinculoDAO ppvDAO = new Pessoa_Perfil_e_VinculoDAO();
		ppv = ppvDAO.Pessoa_Perfil_e_VinculoExiste(ppv, true, false);
		if (ppv == null) {
			Utilidades.enviaAlertError("LOGIN", "USUÁRIO", "Senha de Usuário e Usuário NÃO CONFEREM");
			Utilidades.getpPL().setPpv(null);
			return false;
		}
		Utilidades.getpPL().setPpv(ppv);
		Utilidades.getpPL().setPerfil_Logado(ppv.getEnum_Aux_Perfil_Pessoa());
		return true;
	}

}

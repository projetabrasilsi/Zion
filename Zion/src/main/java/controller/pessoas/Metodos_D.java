package controller.pessoas;

import java.util.List;

import model.entities.Contato;
import model.entities.Endereco;
import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.entities.Usuario;
import model.enums.Enum_Aux_Sexo;
import model.enums.Enum_Aux_Tipo_Pessoa;
import model.outros.Perfil_Pessoa_Logada;
import util.Utilidades;

public class Metodos_D extends Metodos_E {

	public boolean validarAntesdoMerge(Pessoa pessoa, Endereco endereco, Usuario usuario, Contato contato,
			List<Contato> contatos, Pessoa_Perfil_e_Vinculo pPV, List<Pessoa_Perfil_e_Vinculo> pPVs,
			Perfil_Pessoa_Logada pPL) {
		// Validação de Dados Pessoais
		if (pessoa.getDescricao() == null || pessoa.getDescricao().length() <= 0) {
			if (pessoa.getEnum_Aux_Tipo_Pessoa() == Enum_Aux_Tipo_Pessoa.FISICA)
				Utilidades.enviaAlertError("VALIDAÇÃO", "DADOS PESSOAISs", "Informe o nome");
			else
				Utilidades.enviaAlertError("VALIDAÇÃO", "DADOS PESSOAIS", "Informe razão social");
			return false;
		}
		if (pessoa.getEnum_Aux_Tipo_Pessoa() == Enum_Aux_Tipo_Pessoa.JURIDICA) {
			if (pessoa.getFantasia_Apelido() == null || pessoa.getFantasia_Apelido().length() <= 0) {
				Utilidades.enviaAlertError("VALIDAÇÃO", "DADOS PESSOAIS", "Informe nome fantasia");
				return false;
			}
		} else {
			if (pessoa.getSexo() != Enum_Aux_Sexo.FEMININO && pessoa.getSexo() != Enum_Aux_Sexo.MASCULINO) {
				Utilidades.enviaAlertError("VALIDAÇÃO", "DADOS PESSOAIS", "informe o sexo");
				return false;
			}
		}

		// Validação de Usuário
		if (pPL.getFormulario_Atual().getPerfil_Pessoa().isRequerSenha()) {
			if (usuario == null || usuario.getSenha() == null || usuario.getSenha().length() <= 0) {
				Utilidades.enviaAlertError("VALIDAÇÃO", "SENHA", "Informe uma Senha");
				return false;
			}
			if (usuario.getSenha().length() != 8) {
				Utilidades.enviaAlertError("VALIDAÇÃO", "SENHA",
						"Senha deve conter no mínimo e no máximo 8 caracteres");
				return false;
			}
			if (usuario.getConfSenha() == null || usuario.getConfSenha().length() <= 0) {
				Utilidades.enviaAlertError("VALIDAÇÃO", "CONFIRMAÇÃO DE SENHA", "Informe a confirmação da Senha");
				return false;
			}
			if (usuario.getConfSenha().length() != 8) {
				Utilidades.enviaAlertError("VALIDAÇÃO", "CONFIRMAÇÃO DE SENHA",
						"Confirmação de senha deve conter no mínimo e no máximo 8 caracteres");
				return false;
			}

			if (usuario.getConfSenha() == null || usuario.getConfSenha().length() <= 0) {
				Utilidades.enviaAlertError("VALIDAÇÃO", "CONFIRMAÇÃO DE SENHA", "Informe a confirmação da Senha");
				return false;
			}

			if (!usuario.getSenha().equals(usuario.getConfSenha())) {
				Utilidades.enviaAlertError("VALIDAÇÃO", "CONFIRMAÇÃO DE SENHA",
						"Confirmação de Senha e senha não são as mesmas");
				return false;
			}

		}
		// Validação de Perfis
		// nÃO HÁ VALIDAÇÃO

		

		return true;
	}

}

package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import model.dao.PessoaDAO;
import model.dao.Pessoa_Perfil_e_VinculoDAO;
import model.dao.UsuarioDAO;
import model.entities.Acessos;
import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.entities.Usuario;
import model.enums.Enum_Aux_Formularios;
import model.enums.Enum_Aux_Perfil_Pessoa;
import model.outros.Perfil_Pessoa_Logada;
import util.Utilidades;

public class Login extends LoginControles implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		trocaTabPorEnter();
		carregaEmpresaEUsuarios();
		bt_Cancelar.setOnAction((e) -> {
			Stage stage = (Stage) bt_Cancelar.getScene().getWindow(); // Obtendo a janela atual
			stage.close(); // Fechando o Stage
		});

		bt_Confirmar.setOnAction((e) -> {
			setConfirmado(logar());
			if (isConfirmado()) {
				Stage stage = (Stage) bt_Confirmar.getScene().getWindow(); // Obtendo a janela atual
				stage.close();
			}
		});
		cB_Empresa.setEditable(true);
		cB_Usuario.setEditable(true);

	}

	@SuppressWarnings("unchecked")
	public void trocaTabPorEnter() {
		cB_Empresa = (ComboBox<String>) Utilidades.trocaTabPorEnter(cB_Empresa);
		cB_Usuario = (ComboBox<String>) Utilidades.trocaTabPorEnter(cB_Usuario);
		psf_Senha = (PasswordField) Utilidades.trocaTabPorEnter(psf_Senha);
		bt_Confirmar = (Button) Utilidades.trocaTabPorEnter(bt_Confirmar);
		bt_Cancelar = (Button) Utilidades.trocaTabPorEnter(bt_Cancelar);
		Utilidades.addTextLimiter(psf_Senha, 8);
		cB_Empresa.requestFocus();
	}

	public void carregaEmpresaEUsuarios() {

	}

	public void salvaEmpresaEUsuario() {

	}

	public boolean logar() {
		String cpf_Cnpj_Empresa = Utilidades.retornaSomenteNumeros(getcB_Empresa().getValue());
		String cpf_Cnpj_Usuario = Utilidades.retornaSomenteNumeros(getcB_Usuario().getValue());
		if (cpf_Cnpj_Empresa == null || cpf_Cnpj_Empresa.length() <= 0
				|| (cpf_Cnpj_Empresa.length() != 14 && cpf_Cnpj_Empresa.length() != 11)) {
			Utilidades.enviaAlertError("CNPJ", "VALIDAÇÃO", "CPF/Cnpj da Empresa é Inválido");
			getcB_Empresa().requestFocus();
			return false;
		}

		if (cpf_Cnpj_Usuario == null || cpf_Cnpj_Usuario.length() <= 0
				|| (cpf_Cnpj_Usuario.length() != 14 && cpf_Cnpj_Usuario.length() != 11)) {
			Utilidades.enviaAlertError("CPF", "VALIDAÇÃO", "CPF/Cnpj do Usuário é Inválido");
			getcB_Empresa().requestFocus();
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
		Perfil_Pessoa_Logada ppl = new Perfil_Pessoa_Logada();
		ppl.setPerfil_Logado(null);
		ppl.setPessoa_Logada(null);
		ppl.setEmpresa_Logada(null);
		ppl.setFormulario_Atual(null);

		PessoaDAO pdao = new PessoaDAO();
		ppl.setExistemPessoasCadatradas(pdao.existemsPessoasCadatradas());

		if (!ppl.isExistemPessoasCadatradas()) {
			ppl.setPerfil_Logado(Enum_Aux_Perfil_Pessoa.NENHUM);
			
			ppl.setAcessos(new Acessos(ppl.getPerfil_Logado()));
			Utilidades.setpPL(ppl);
			return true;
		}

		Pessoa m = pdao.retornaPessoaPelocpf_Cnpj(cB_Empresa.getValue());
		if (m == null) {
			Utilidades.enviaAlertError("LOGIN", "EMPRESA", "CPF ou CNPJ, não existe no cadastro");
			return false;
		}
		Pessoa_Perfil_e_VinculoDAO ppvDAO = new Pessoa_Perfil_e_VinculoDAO();
		ppl.setEmpresa_Logada(m);
		ppl.setEmpresaPossuiAlguemVinculado(ppvDAO.existeAlguemPerfilVinculadoAoMestre(m));

		UsuarioDAO dao = new UsuarioDAO();
		Usuario us = dao.autenticar(cB_Usuario.getValue(), psf_Senha.getText());

		Pessoa pessoa = pdao.retornaPessoaPelocpf_Cnpj(cB_Usuario.getValue());

		if ((us == null || us.getId_Pessoa() == null || pessoa == null || !pessoa.equals(us.getId_Pessoa()))
				&& ppl.isEmpresaPossuiAlguemVinculado()) {
			Pessoa_Perfil_e_Vinculo ppv = new Pessoa_Perfil_e_Vinculo();
			ppv.setId_Pessoa_M(m);
			ppv.setId_Pessoa_D(pessoa);
			ppv = loginContratanteOuContratado(ppv);
			if (ppv == null) {
				Utilidades.enviaAlertError("LOGIN", "USUÁRIO", "Senha de Usuário e Usuário NÃO CONFEREM");
				return false;
			}else {
				
				ppl.setVinculoproprio(false);
			}
		}
		if (us != null && us.getId_Pessoa() != null && us.getId_Pessoa().getId() != null
				&& us.getId_Pessoa().getId() > 0)
			ppl.setPessoa_Logada(us.getId_Pessoa());
		else
			ppl.setPessoa_Logada(null);

		Pessoa_Perfil_e_Vinculo ppv = new Pessoa_Perfil_e_Vinculo();
		Pessoa_Perfil_e_Vinculo ppv1 = new Pessoa_Perfil_e_Vinculo();
		if (ppl.isEmpresaPossuiAlguemVinculado()) {
			if (ppl.getPessoa_Logada() != null)
				ppv.setId_Pessoa_D(ppl.getPessoa_Logada());
			else
				ppv.setId_Pessoa_D(null);
			if (ppl.getEmpresa_Logada() != null)
				ppv.setId_Pessoa_M(ppl.getEmpresa_Logada());
			else
				ppv.setId_Pessoa_M(null);
			ppv.setEnum_Aux_Perfil_Pessoa(null);
			ppv1 = ppv;
			ppv = ppvDAO.Pessoa_Perfil_e_VinculoExiste(ppv, true, true);
			if (ppv == null) {
				ppv1 = loginContratanteOuContratado(ppv1);
				if (ppv1 == null) {
					Utilidades.enviaAlertError("LOGIN", "VINCULO",
							"Você não está vinculoado à: " + m.getFantasia_Apelido());
					return false;
				}else {
					ppl.setPerfil_Logado(ppv1.getEnum_Aux_Perfil_Pessoa());
					ppl.setVinculoproprio(false);
				}
			} else {
				ppl.setPerfil_Logado(ppv.getEnum_Aux_Perfil_Pessoa());
				ppl.setVinculoproprio(true);
			}
		} else {
			// se a empresa logada não possui nenhum vinculo
			// preciso checar se o perfil logado é de um CONTRATADO ou da PRÓPRIA EMPRESA MESMO(CONTRATANTE)
			ppv = new Pessoa_Perfil_e_Vinculo();
			
			
			if (ppl.getPessoa_Logada() != null)
				ppv.setId_Pessoa_D(ppl.getPessoa_Logada());
			else
				ppv.setId_Pessoa_D(null);			
			ppv.setId_Pessoa_M(null);
			ppv.setEnum_Aux_Perfil_Pessoa(null);
			ppv1 = ppv;
			ppv1 = loginContratanteOuContratado(ppv1);
			if (ppv1 == null) {
				ppl.setVinculoproprio(true);
				Utilidades.enviaAlertError("LOGIN", "VINCULO",
						"Você não está vinculoado à: " + m.getFantasia_Apelido());
				
				return false;
			}else {
				ppl.setPerfil_Logado(ppv1.getEnum_Aux_Perfil_Pessoa());
				ppl.setVinculoproprio(false);
			}
			
			
			
			
			
			
		}
		if (ppl.getPerfil_Logado() != null) {
			ppl.setAcessos(new Acessos(ppl.getPerfil_Logado()));
		} else
			
			ppl.setAcessos(null);

		ppl.setFormulario_Atual(Enum_Aux_Formularios.FORM_LOGIN);

		Utilidades.setpPL(ppl);

		return true;
	}

	public Pessoa_Perfil_e_Vinculo  loginContratanteOuContratado(Pessoa_Perfil_e_Vinculo ppv) {
		// mesmo se o login não possuir vinculo, MAS MAS MAS
		// se o login for de um contratado ou de um contratante mas onde o mesmo login D
		// seja o mesma Pessoa M ==> está tudo certo
		Pessoa_Perfil_e_Vinculo ppv1 = new Pessoa_Perfil_e_Vinculo();
		ppv1 = ppv;
		Pessoa m = ppv.getId_Pessoa_M();

		ppv1.setEnum_Aux_Perfil_Pessoa(Enum_Aux_Perfil_Pessoa.CONTRATADOS);
		ppv1.setId_Pessoa_M(null);
		Pessoa_Perfil_e_VinculoDAO ppvDAO = new Pessoa_Perfil_e_VinculoDAO();
		ppv1 = ppvDAO.Pessoa_Perfil_e_VinculoExiste(ppv1, true, true);
		if (ppv1 == null) {

			ppv1 = ppv;
			ppv1.setEnum_Aux_Perfil_Pessoa(Enum_Aux_Perfil_Pessoa.CONTRATANTES);
			ppv1.setId_Pessoa_M(null);

			ppv1 = ppvDAO.Pessoa_Perfil_e_VinculoExiste(ppv1, true, true);
			if (ppv1 != null ) {
				if(!ppv1.getId_Pessoa_D().equals(m))
					ppv = null;
				else
					ppv = ppv1;
			}
				

		}else {
			ppv.setEnum_Aux_Perfil_Pessoa(Enum_Aux_Perfil_Pessoa.CONTRATADOS);
		}
		ppv = ppv1;

		return ppv;
	}

}

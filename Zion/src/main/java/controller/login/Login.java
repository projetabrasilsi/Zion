package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.entities.Acessos;
import model.enums.Enum_Aux_Formularios;
import util.Utilidades;

public class Login extends LoginController_Metodos_A implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		trocaTabPorEnter();
		carregaEmpresaEUsuarios();
		inicializaControles();
	}

	protected void inicializaControles() {
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

	public boolean logar() {
		String cpf_Cnpj_Empresa = Utilidades.retornaSomenteNumeros(getcB_Empresa().getValue());
		String cpf_Cnpj_Usuario = Utilidades.retornaSomenteNumeros(getcB_Usuario().getValue());

		if (!validacpf_cnpj(cpf_Cnpj_Empresa, cpf_Cnpj_Usuario))
			return false;
		// Se não existe pessoa cadastrada ele retorna true para cadastrar a primeira
		// vez
		// MAS se existe ele irá fazer outras avaliações importantes
		if (existemPessoasCadastradas()) {	
			Utilidades.getpPL().setExistemPessoasCadatradas(true);
			if (!loginEmpresa())
				return false;
			if (!usuarioEstaCorreto())
				return false;

			// se não existe alguém vinculo -- abre para vincular;
			// MAS se existe deverá fazer outras aavaliações
			if (empresapossuiAlguemVinculado()) {				
				if (!usuarioEstaVinculoadoAempresa()) {
					// se o usuário não estiver vinculado a empresa
					// pode ser que este usuário tenha o perfil de contrante ou contratado
					Utilidades.getpPL().setPpv(loginContratanteOuContratado());
					if(Utilidades.getpPL().getPpv() == null)
					return false;
				}
				Utilidades.getpPL().setPerfil_Logado(Utilidades.getpPL().getPpv().getEnum_Aux_Perfil_Pessoa());
			}else {
				Utilidades.getpPL().setPpv(loginContratanteOuContratado());
				if(Utilidades.getpPL().getPpv() == null)
					return false;
				
				Utilidades.getpPL().setPerfil_Logado(Utilidades.getpPL().getPpv().getEnum_Aux_Perfil_Pessoa());
			}
		}

		Utilidades.getpPL().setFormulario_Atual(Enum_Aux_Formularios.FORM_LOGIN);
		if(Utilidades.getpPL().getPpv() != null && Utilidades.getpPL().getPpv().getEnum_Aux_Perfil_Pessoa() != null)
		Utilidades.getpPL().setVinculoproprio(Utilidades.getpPL().getPpv().getEnum_Aux_Perfil_Pessoa().isPossuiVinculo());
		else
			Utilidades.getpPL().setVinculoproprio(true);
			
		if (Utilidades.getpPL().getPerfil_Logado() != null) {
			Utilidades.getpPL().setAcessos(new Acessos(Utilidades.getpPL().getPerfil_Logado()));
		} else
			Utilidades.getpPL().setAcessos(null);
		return true;
	}

}

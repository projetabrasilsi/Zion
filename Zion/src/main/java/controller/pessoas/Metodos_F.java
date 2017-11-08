package controller.pessoas;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.dao.PessoaDAO;
import model.entities.Pessoa;
import model.enums.Enum_Aux_Sexo;
import model.enums.Enum_Aux_Tipo_Pessoa;
import util.Utilidades;

public class Metodos_F extends Metodos_G {
	public Pessoa chamaTelaConsultaCPFCNPJ(Pessoa p) {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("cpfcnpjconsulta.fxml"));
		AnchorPane page = null;
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// Criando um Estágio de Diálogo (Stage Dialog)
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Cadastro de Clientes");
		Scene scene = new Scene(page);

		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);

		// Setando o cliente no Controller.
		Cpf_Cnpj_Consulta controller = loader.getController();
		controller.setTipo_Pessoa(Utilidades.getpPL().getFormulario_Atual().getPerfil_Pessoa().getEnum_Aux_Tipo_Pessoa());
		controller.cB_Tipo_Pessoa.setValue(Utilidades.getpPL().getFormulario_Atual().getPerfil_Pessoa().getEnum_Aux_Tipo_Pessoa());

		controller.setDialogStage(dialogStage);

		// Mostra o Dialog e espera até que o usuário o feche
		dialogStage.showAndWait();
		setConfirmado(false);

		if (controller.isButtonConfirmarClicked()) {
			String cpf_Cnpj = Utilidades.retornaSomenteNumeros(controller.getCpf_Cnpj_Numeros());
			Enum_Aux_Tipo_Pessoa tipoPessoa = controller.getTipo_Pessoa();
			boolean cpfCnpjOk = false;
			if (tipoPessoa == Enum_Aux_Tipo_Pessoa.FISICA) {
				cpfCnpjOk = Utilidades.isValidCPF(cpf_Cnpj);
				if (!cpfCnpjOk) {
					Utilidades.enviaAlertError("CPF", "VALIDAÇÃO", "Cpf é Inválido");
					return p;
				}

			} else {
				cpfCnpjOk = Utilidades.isValidCNPJ(cpf_Cnpj);
				if (!cpfCnpjOk) {
					Utilidades.enviaAlertError("CNPJ", "VALIDAÇÃO", "Cnpj é Inválido");
					return p;
				}
			}

			PessoaDAO dao = new PessoaDAO();
			p = dao.retornaPessoaPelocpf_Cnpj(cpf_Cnpj);
			

			if (p != null) {
				// checar se já tem perfil para esta empresa -- se tem
				// setConfirmado(true); --- pode ser true ou false

			} else {
				p = new Pessoa();
				p.setEnum_Aux_Tipo_Pessoa(tipoPessoa);
				if(tipoPessoa == Enum_Aux_Tipo_Pessoa.FISICA)
				p.setSexo(Enum_Aux_Sexo.MASCULINO);
				else
					p.setSexo(Enum_Aux_Sexo.OUTROS);
				p.setCpf_Cnpj(cpf_Cnpj);
			}
			setConfirmado(true);

			return p;
		} else
			setConfirmado(false);
		return p;

	}

	


}

package controller.pessoas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.enums.Enum_Aux_Tipo_Pessoa;
import util.Utilidades;

public class Cpf_Cnpj_Consulta extends Cpf_Cnpj_Consulta_A implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		trocaTabPorEnter();

		cB_Tipo_Pessoa.valueProperty().addListener(new ChangeListener<Enum_Aux_Tipo_Pessoa>() {
			@Override
			public void changed(ObservableValue<? extends Enum_Aux_Tipo_Pessoa> observable,
					Enum_Aux_Tipo_Pessoa oldValue, Enum_Aux_Tipo_Pessoa newValue) {

			}
		});
		cB_Tipo_Pessoa.requestFocus();
		cB_Tipo_Pessoa.getItems().setAll(Enum_Aux_Tipo_Pessoa.values());
		cB_Tipo_Pessoa.getSelectionModel().select(Enum_Aux_Tipo_Pessoa.FISICA);
		setTipo_Pessoa(Enum_Aux_Tipo_Pessoa.FISICA);
		cB_Tipo_Pessoa.valueProperty().addListener(new ChangeListener<Enum_Aux_Tipo_Pessoa>() {
			@Override
			public void changed(ObservableValue<? extends Enum_Aux_Tipo_Pessoa> observable,
					Enum_Aux_Tipo_Pessoa oldValue, Enum_Aux_Tipo_Pessoa newValue) {

				setTipo_Pessoa(newValue);
				configura_tela();
			}
		});

		bt_Cancelar.setOnAction((e) -> {
			Stage stage = (Stage) bt_Cancelar.getScene().getWindow(); // Obtendo a janela atual
			stage.close(); // Fechando o Stage
		});

		bt_Confirmar.setOnAction((e) -> {

			if (cB_Tipo_Pessoa.getValue() != null) {
				if (validaCPF_CNPJ()) {
					Stage stage = (Stage) bt_Confirmar.getScene().getWindow();
					setButtonConfirmarClicked(true);
					stage.close();
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERRO");
				alert.setHeaderText("Escolha do Tipo de Pessoa");
				alert.setContentText("Não foi Informado");
				alert.showAndWait();
			}
		});

		configura_tela();

	}

	public boolean validaCPF_CNPJ() {
		setCpf_Cnpj_Numeros(Utilidades.retornaSomenteNumeros(tF_Cpf_Cnpj.getText()));
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERRO");
		alert.setHeaderText("Tentativa de Validação CPF/CNPJ");

		if (cB_Tipo_Pessoa.getValue() == Enum_Aux_Tipo_Pessoa.JURIDICA) {
			setCpf_Cnpj_Valido(Utilidades.isValidCNPJ(getCpf_Cnpj_Numeros()));
			if (!isCpf_Cnpj_Valido()) {
				setCpf_Cnpj_Numeros("");
				alert.setContentText("CNPJ não é válido");
				alert.showAndWait();
				return false;
			}
			 

		} else {
			setCpf_Cnpj_Valido(Utilidades.isValidCPF(getCpf_Cnpj_Numeros()));

			if (!isCpf_Cnpj_Valido()) {
				setCpf_Cnpj_Numeros("");
				alert.setContentText("CPF não é válido");
				alert.showAndWait();
				return false;
			}
		}
		return true;

	}

	

}

package controller.protocolos.passob;

import java.io.IOException;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProtocolosNovosControles_Metodos_A extends ProtocolosNovosControles_Metodos_B {
	public void chamaTelaThreadPassoC(String titulo) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("protocolos_passoc.fxml"));
		AnchorPane page = null;
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage dialogStage = new Stage();
		dialogStage.setTitle(titulo);
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);
		dialogStage.showAndWait();
	}

	public void inicializaControles() {
		inicializaEventos();
		liberaControlesOuNao();
		bt_Confirmar.setOnAction((e) -> {
			if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao()
					.isComparativo()) {
				ProtocoloController_ControlesGerais_A.setAnoAnt(cB_Comp_1.getValue());
				ProtocoloController_ControlesGerais_A.setAnoAtual(cB_Comp_2.getValue());
				ProtocoloController_ControlesGerais_A.setMesAnt(0);
				ProtocoloController_ControlesGerais_A.setMesAtual(0);
				if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().isAnoEMes()) {
					// mudar valores;
					ProtocoloController_ControlesGerais_A.setMesAnt(0);
					ProtocoloController_ControlesGerais_A.setMesAtual(0);
				} else {
					ProtocoloController_ControlesGerais_A.setMesAnt(0);
					ProtocoloController_ControlesGerais_A.setMesAtual(0);
				}
			} else {
				ProtocoloController_ControlesGerais_A.setAnoAnt(0);
				ProtocoloController_ControlesGerais_A.setAnoAtual(0);
				ProtocoloController_ControlesGerais_A.setMesAnt(0);
				ProtocoloController_ControlesGerais_A.setMesAtual(0);
			}
			Stage stage = (Stage) bt_Confirmar.getScene().getWindow();
			ProtocoloController_ControlesGerais_A.setOk(true);
			stage.close();
		});

		bt_Cancelar.setOnAction((e) -> {
			Stage stage = (Stage) bt_Cancelar.getScene().getWindow();
			ProtocoloController_ControlesGerais_A.setOk(false);
			stage.close();
		});
	}

	public void liberaControlesOuNao() {
		if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao()
				.isComparativo()) {
			if (anualAtualEMaior()) {
				if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes() != null)
					bt_Escolher_Arquivo_1.setDisable(false);
				else
					bt_Escolher_Arquivo_1.setDisable(true);
				bt_Escolher_Arquivo_2.setDisable(true);
				bt_Confirmar.setDisable(true);
			} else {
				bt_Escolher_Arquivo_1.setDisable(true);
				bt_Escolher_Arquivo_2.setDisable(true);
			}
		} else {
			bt_Escolher_Arquivo_1.setDisable(false);
			bt_Escolher_Arquivo_2.setDisable(true);
			bt_Escolher_Arquivo_2.setVisible(false);
		}
	}

	public boolean anualAtualEMaior() {
		if (ProtocoloController_ControlesGerais_A.getAnoAtual() > ProtocoloController_ControlesGerais_A.getAnoAnt())
			return true;
		else
			return false;
	}

	public void inicializaEventos() {
		cB_Comp_1.valueProperty().addListener(new ChangeListener<Integer>() {
			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				if (cB_Comp_1.getValue() != null)
					ProtocoloController_ControlesGerais_A.setAnoAnt(cB_Comp_1.getValue());
				else
					ProtocoloController_ControlesGerais_A.setAnoAnt(0);
				liberaControlesOuNao();
			}
		});

		cB_Comp_2.valueProperty().addListener(new ChangeListener<Integer>() {
			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				if (cB_Comp_2.getValue() != null)
					ProtocoloController_ControlesGerais_A.setAnoAtual(cB_Comp_2.getValue());
				else
					ProtocoloController_ControlesGerais_A.setAnoAtual(0);
				liberaControlesOuNao();
			}
		});
	}

}

package controller.protocolos.passoa;

import java.io.IOException;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProtocoloController_Controles_Metodos_G extends ProtocoloController_Controles_A {
	public boolean chamateladePassoC() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("protocolos_passoc.fxml"));
		AnchorPane page = null;
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Passo C - Verificando Existência e Gravando Número de Inscrições");
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);
		dialogStage.showAndWait();
		dialogStage.close();
		return ProtocoloController_ControlesGerais_A.isOk();
	}
	
	public boolean chamateladePassoD() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("protocolos_passod.fxml"));
		AnchorPane page = null;
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Passo D - GRAVANDO REGISTROS");
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);
		dialogStage.showAndWait();
		dialogStage.close();
		return ProtocoloController_ControlesGerais_A.isOk();
	}
	
	public boolean chamateladePassoE() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("protocolos_passoeservicosiptucomparativos.fxml"));
		AnchorPane page = null;
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Passo E - Realizando Comparações");
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);
		dialogStage.showAndWait();
		dialogStage.close();
		return ProtocoloController_ControlesGerais_A.isOk();
	}

	
}

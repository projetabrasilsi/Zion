package controller.protocolos.passob;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Utilidades;

public class ProtocolosNovosController extends ProtocolosNovosControles_Metodos_A implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bt_Confirmar.setDisable(true);
		ProtocoloController_ControlesGerais_A.setOk(false);
		inicializaControles();
		CarregaCombosComparativas();
		bt_Escolher_Arquivo_1.setOnAction((e) -> {
			ProtocoloController_ControlesGerais_A.setEscolhido(false);
			ProtocoloController_ControlesGerais_A.anexarArquivo();

			if (!ProtocoloController_ControlesGerais_A.isEscolhido()) {
				Utilidades.enviaAlertError("ERRO", "Escolha de Arquivo", "Escolha um Arquivo Válido");
				return;
			}
			ProtocoloController_ControlesGerais_A.setnLista(1);			
			ProtocoloController_ControlesGerais_A.setComparativos_1(new ArrayList<>());
			ProtocoloController_ControlesGerais_A.setAno(cB_Comp_1.getValue());
			chamaTelaThreadPassoC("PRIMEIRA LISTA");
			// chama ProtocolosThreadController

			if (ProtocoloController_ControlesGerais_A.isOk() && ProtocoloController_ControlesGerais_A.isFinalizado()) {
				bt_Escolher_Arquivo_1.setDisable(true);
				bt_Escolher_Arquivo_2.setDisable(false);
				bt_Confirmar.setDisable(true);
			} else {
				bt_Escolher_Arquivo_1.setDisable(false);
				bt_Escolher_Arquivo_2.setDisable(true);
				bt_Confirmar.setDisable(true);
			}

		});

		bt_Escolher_Arquivo_2.setOnAction((e) -> {
			ProtocoloController_ControlesGerais_A.setEscolhido(false);
			ProtocoloController_ControlesGerais_A.anexarArquivo();

			if (!ProtocoloController_ControlesGerais_A.isEscolhido()) {
				Utilidades.enviaAlertError("ERRO", "Escolha de Arquivo", "Escolha um Arquivo Válido");
				return;
			}
			ProtocoloController_ControlesGerais_A.setnLista(2);			
			ProtocoloController_ControlesGerais_A.setComparativos_2(new ArrayList<>());
			ProtocoloController_ControlesGerais_A.setAno(cB_Comp_2.getValue());
			chamaTelaThreadPassoC("SEGUNDA LISTA");
			if (ProtocoloController_ControlesGerais_A.isOk() && ProtocoloController_ControlesGerais_A.isFinalizado()) {
				bt_Escolher_Arquivo_2.setDisable(true);
				bt_Confirmar.setDisable(false);
			} else {
				bt_Escolher_Arquivo_2.setDisable(false);
				bt_Confirmar.setDisable(true);
			}

		});
		

	}

	public void CarregaCombosComparativas() {
		List<Integer> lista = new ArrayList<>();
		lista.add(2016);
		lista.add(2017);
		lista.add(2018);
		lista.add(2019);
		lista.add(2020);
		Calendar c = Calendar.getInstance();
		int ano = c.get(Calendar.YEAR);

		cB_Comp_1.getItems().setAll(lista);
		cB_Comp_2.getItems().setAll(lista);

		// obrigatório setar os valores iniciais -- para não ocorrer comparações com
		// números vários
		ProtocoloController_ControlesGerais_A.setAnoAnt(ano - 1);
		ProtocoloController_ControlesGerais_A.setAnoAtual(ano);
		cB_Comp_1.setValue(ano - 1);
		cB_Comp_2.setValue(ano);
	}

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

}
package controller.protocolos.passoa;

import java.io.IOException;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.ProtocolosdeServicos_Detalhe;

public class ProtocoloController_Controles_Metodos_I extends ProtocoloController_Controles_Metodos_J {
	private int i = 0;
	ObservableList<ProtocolosdeServicos_Detalhe> ff = FXCollections.observableArrayList();

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
	public void inicializaRolagem() {
		sB.setMax(tV_ProtServicos_Detalhe.getItems().size() - 1);
		sB.setMin(0);

		sB.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldV, Number newV) {
				tV_ProtServicos_Detalhe.scrollTo(newV.intValue());
				tV_ProtServicos_Detalhe.getSelectionModel().select(newV.intValue());
				tV_ProtServicos_Detalhe.requestFocus();
			}
		});
	}

	public void rolar() {
		i = 0;

		ff = tV_ProtServicos_Detalhe.getItems();
		Task<Void> task = new Task<Void>() {
			@SuppressWarnings("unused")
			@Override
			public Void call() throws Exception {
				updateMessage("iniciando");

				for (ProtocolosdeServicos_Detalhe pd : ff) {
					updateMessage("" + i + "/" + ff.size());
					i++;
				}
				return null;
			}
		};

		task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
			}
		});
		task.messageProperty().addListener((obs, oldMessage, newMessage) -> {
			sB.setValue(i);
			lb_Rolagem.setText(newMessage);
		});
		task.setOnFailed(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
			}
		});
		ProtocoloController_ControlesGerais_A.setSync(new Thread(task));
		ProtocoloController_ControlesGerais_A.getSync().start();
	}
}

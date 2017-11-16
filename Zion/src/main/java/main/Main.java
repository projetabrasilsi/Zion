package main;

import java.io.IOException;

import controller.login.Login;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		if (chamaLogin()) {
			try {
				Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
				Scene scene = new Scene(root, 1003, 566);
				scene.getStylesheets().add("jmetro/JMetroDarkTheme.css");
				stage.setTitle("Menu Principal");
				stage.setMaximized(true);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent arg0) {
					Platform.exit();
					System.exit(0);
				}
			});
		}
	}

	public boolean chamaLogin() {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("login.fxml"));
		AnchorPane page = null;
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// Criando um Estágio de Diálogo (Stage Dialog)
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Tela de Login");
		Scene scene = new Scene(page);

		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);

		Login controller = loader.getController();
		controller.setDialogStage(dialogStage);

		controller.setConfirmado(false);
		dialogStage.showAndWait();
		return controller.isConfirmado();

	}

	public static void main(String[] args) {
		launch(args);

	}

}

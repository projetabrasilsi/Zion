package controller.protocolos.passoc;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;

public class ProtocolosThreadImportacaoController_Metodos_C {
	@FXML
	protected int ano = 0;
	@FXML
	protected Label lb_Titulo = new Label();
	@FXML
	protected AnchorPane aP_Protocolo_Novo = new AnchorPane();
	@FXML
	protected ProgressBar pBar = new ProgressBar(0.1);
	@FXML
	protected ProgressIndicator pBI = new ProgressIndicator(0.1);
	@FXML
	protected Button bt_Fechar = new Button();
	public void falha() {
		bt_Fechar.setVisible(true);
		bt_Fechar.setDisable(false);
		pBar = new ProgressBar(0);
		pBI = new ProgressIndicator(0);
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
		lb_Titulo.setText(ProtocoloController_ControlesGerais_A.getTextoResposta());
	}
	
	
}

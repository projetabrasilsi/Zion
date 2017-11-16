package controller.protocolos.passob;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ProtocolosNovosControles_A  {
	@FXML
	protected AnchorPane aP_Protocolo_Novo = new AnchorPane();
	@FXML
	protected Button bt_Confirmar = new Button();
	@FXML
	protected Button bt_Cancelar = new Button();
	@FXML
	protected Button bt_Escolher_Arquivo_1 = new Button();
	@FXML
	protected Button bt_Escolher_Arquivo_2 = new Button();
	@FXML
	protected Label lb_Comp_1 = new Label();
	@FXML
	protected Label lb_Comp_2 = new Label();
	@FXML
	protected Label lb_Inscricoes = new Label();
	@FXML
	protected Label lb_Etapas = new Label();
	@FXML
	protected ComboBox<Integer> cB_Comp_1 = new ComboBox<>();
	@FXML
	protected ComboBox<Integer> cB_Comp_2 = new ComboBox<>();
}

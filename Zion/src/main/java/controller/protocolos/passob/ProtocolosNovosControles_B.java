package controller.protocolos.passob;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.enums.Enum_Aux_Servicos_Restricoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;

public class ProtocolosNovosControles_B {
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
	protected Label lb_Tipo_Servico = new Label();
	@FXML
	protected Label lb_Comp_1 = new Label();
	@FXML
	protected Label lb_Comp_2 = new Label();

	@FXML
	protected Label lb_Escolha_Restricao = new Label();

	@FXML
	protected Label lb_Inscricoes = new Label();

	@FXML
	public ComboBox<Enum_Aux_Servicos_Restricoes> cB_Escolha_Restricao = new ComboBox<Enum_Aux_Servicos_Restricoes>();
	@FXML
	public ComboBox<Enum_Aux_Servicos_Sub_Classificacoes> cB_Sub_Classificacao = new ComboBox<Enum_Aux_Servicos_Sub_Classificacoes>();
	@FXML
	protected ComboBox<Integer> cB_Comp_1 = new ComboBox<>();
	@FXML
	protected ComboBox<Integer> cB_Comp_2 = new ComboBox<>();
	
	
		

}

package controller.protocolos.passod;

import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.entities.Inscricao;
import model.entities.Pessoa;
import model.entities.ProtocolosdeServicos_Detalhe;

public class ProtocolosThreadMergeController_Controles_A  {
	
	@FXML protected AnchorPane aPane = new AnchorPane();
	@FXML protected TableView<ProtocolosdeServicos_Detalhe> tV_ProtServicos_Detalhe = new TableView<ProtocolosdeServicos_Detalhe>();
	@FXML protected TableColumn<ProtocolosdeServicos_Detalhe, Integer> tC_Contador = new TableColumn<>("Contagem");
	@FXML protected TableColumn<ProtocolosdeServicos_Detalhe, Inscricao> tC_Inscricao = new TableColumn<>("Inscricao");
	@FXML protected TableColumn<ProtocolosdeServicos_Detalhe, Double> tC_Valor_Atual = new TableColumn<>("Valor Atual");
	@FXML protected TableColumn<ProtocolosdeServicos_Detalhe, Double> tC_Valor_Anterior = new TableColumn<>("Valor Anterior");
	@FXML protected TableColumn<ProtocolosdeServicos_Detalhe, Double> tC_Diferenca = new TableColumn<>("Diferença");
	@FXML protected TableColumn<ProtocolosdeServicos_Detalhe, Double> tC_Percentual = new TableColumn<>("Percentual");
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Calendar> tC_Data_Hora = new TableColumn<>(
			"Última Atualização");
	@FXML protected TableColumn<ProtocolosdeServicos_Detalhe, Pessoa> tC_Responsavel = new TableColumn<>("Responsável");
	@FXML protected ObservableList<ProtocolosdeServicos_Detalhe> ProtocolosdeServicos_DetalheObsList = FXCollections
			.observableArrayList();
	
	
	@FXML
	protected Label lb_Titulo_Merge = new Label();
	@FXML
	protected Label lb_Titulo_Tela = new Label();
	@FXML
	protected Label lb_Etapas = new Label();
	
	
	@FXML
	protected AnchorPane aP_Protocolo_Novo = new AnchorPane();
	@FXML
	protected ProgressBar pBar = new ProgressBar(0.1);
	@FXML
	protected ProgressIndicator pBI = new ProgressIndicator(0.1);
	@FXML
	protected Button bt_Fechar = new Button();
	
	

}

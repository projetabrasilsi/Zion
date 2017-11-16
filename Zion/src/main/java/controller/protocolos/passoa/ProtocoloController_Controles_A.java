package controller.protocolos.passoa;

import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.entities.Inscricao;
import model.entities.Pessoa;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Comparativos_Resultados;
import model.enums.Enum_Aux_Status_Consulta;
import model.enums.Enum_Aux_Tipo_Conferencia;

public class ProtocoloController_Controles_A extends ProtocoloController_Controles_B {
	@FXML
	protected AnchorPane aPane = new AnchorPane();
	@FXML
	protected Group group_Table = new Group();
	
	
	@FXML
	protected Group group_Pessoas = new Group();
	@FXML
	protected TableView<ProtocolosdeServicos_Detalhe> tV_ProtServicos_Detalhe = new TableView<ProtocolosdeServicos_Detalhe>();
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Integer> tC_Contador = new TableColumn<>("Contagem");
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Inscricao> tC_Inscricao = new TableColumn<>("Inscricao");
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Calendar> tC_Data_Hora = new TableColumn<>(
			"Última Atualização");
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Pessoa> tC_Responsavel = new TableColumn<>("Responsável");
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Double> tC_Valor_Atual = new TableColumn<>("Valor Atual");
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Double> tC_Valor_Anterior = new TableColumn<>("Valor Anterior");
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Double> tC_Diferenca = new TableColumn<>("Diferença");
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Double> tC_Percentual = new TableColumn<>("Percentual");
	@FXML
	protected TableColumn<ProtocolosdeServicos_Detalhe, Enum_Aux_Comparativos_Resultados> tC_Resultado = new TableColumn<>(
			"Resultado");
	protected TableColumn<ProtocolosdeServicos_Detalhe, Enum_Aux_Status_Consulta> tC_StatusConsulta = new TableColumn<>(
			"Resultado");
	
	protected TableColumn<ProtocolosdeServicos_Detalhe, Enum_Aux_Tipo_Conferencia> tC_TipoConferencia = new TableColumn<>(
			"Conferencia");
	
	@FXML
	protected TableColumn<String, String> tC_Ordem = new TableColumn<>(
			"Resultado");
	
	
	@FXML
	protected ComboBox<Enum_Aux_Comparativos_Resultados> cB_FilterField = new ComboBox<Enum_Aux_Comparativos_Resultados>();
	@FXML
	protected ObservableList<ProtocolosdeServicos_Detalhe> filteredData = FXCollections.observableArrayList();
	@FXML
	protected ScrollBar sB = new ScrollBar();
	@FXML
	protected ObservableList<ProtocolosdeServicos_Detalhe> ProtocolosdeServicos_DetalheObsList = FXCollections
			.observableArrayList();
	@FXML
	protected Button bt_Rolagem = new Button();
	@FXML
	protected Button bt_Anterior = new Button();
	@FXML
	protected Button bt_AtvDatv = new Button();
	@FXML
	protected Button bt_Fim = new Button();
	@FXML
	protected Button bt_Inicio = new Button();
	@FXML
	protected Button bt_Novo = new Button();
	@FXML
	protected Button bt_Proximo = new Button();
	@FXML
	protected Button bt_Relatorio_Analitico = new Button();
	@FXML
	protected Button bt_Relatorio_Sintetico = new Button();
	@FXML
	protected Group group_Buttons = new Group();
	@FXML
	protected Label lb_Total_Invalidado = new Label();
	@FXML
	protected Label lb_Resp_Registro = new Label();
	@FXML
	protected Label lb_Id = new Label();
	@FXML
	protected Label lb_Escolha_Restricao = new Label();
	@FXML
	protected Label lb_Tipo_Servico = new Label();
	@FXML
	protected Label lb_Ultima_Alteracao = new Label();
	@FXML
	protected Label lb_Total_Inscricoes = new Label();
	@FXML
	protected Label lb_Total_Valido = new Label();
	@FXML
	protected Label lb_Status = new Label();
	@FXML
	protected Label lb_Status_Value = new Label();
	@FXML
	protected Label lb_Resp_Registro_Value = new Label();
	@FXML
	protected Label lb_Ultima_Alteracao_Value = new Label();
	@FXML
	protected Label lb_Id_Value = new Label();
	@FXML
	protected Label lb_Total_Inscricoes_Value = new Label();
	@FXML
	protected Label lb_Total_Valido_Value = new Label();
	@FXML
	protected Label lb_Total_Validado_Value = new Label();
	@FXML
	protected Label lb_Total_Invalidado_Value = new Label();
	@FXML
	protected Label lb_Classificacoes = new Label();
	@FXML
	protected Label lb_Sub_Classificacoes = new Label();
	
}

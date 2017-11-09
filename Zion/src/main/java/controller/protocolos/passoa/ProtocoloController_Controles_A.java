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

public class ProtocoloController_Controles_A extends ProtocoloController_Controles_B {

	// controles gerais
	@FXML
	protected AnchorPane aPane = new AnchorPane();
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
	protected TableColumn<ProtocolosdeServicos_Detalhe, Enum_Aux_Comparativos_Resultados> tC_Resultado = new TableColumn<>("Resultado");
	@FXML
    protected ComboBox<Enum_Aux_Comparativos_Resultados> cB_FilterField = new ComboBox<Enum_Aux_Comparativos_Resultados>();
    @FXML
    protected ObservableList<ProtocolosdeServicos_Detalhe> filteredData = FXCollections.observableArrayList();
    @FXML
    protected ScrollBar sB =  new ScrollBar();
    
    
    
    
    
    
	
    
	
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
	protected Label lb_Titulo = new Label();
	@FXML
	protected Label lb_Escolha_Restricao_Value = new Label();
	@FXML
	protected Label lb_Tipo_Servico_Value = new Label();
	@FXML
	protected Label lb_Classificacao = new Label();
	@FXML
	protected Label lb_Classificacao_Value = new Label();
	@FXML
	protected Label lb_Progresso = new Label();
	@FXML
	protected Label lb_Duracao = new Label();
	@FXML
	protected Label lb_Duracao_Value = new Label();
	@FXML
	protected Label lb_nTotalReg_Value = new Label();
	@FXML
	protected Label lb_nRegAnt_Value = new Label();
	@FXML
	protected Label lb_nRegAtual_Value = new Label();
	@FXML
	protected Label lb_vlTot_Value = new Label();
	@FXML
	protected Label lb_vlTotAnt_Value = new Label();
	@FXML
	protected Label lb_vlTotAtual_Value = new Label();
	@FXML
	protected Label lb_nRegSomenteAnt_Value = new Label();
	@FXML
	protected Label lb_nRegSomenteAtual_Value = new Label();
	@FXML
	protected Label lb_nRegPermanentes_Value = new Label();
	@FXML
	protected Label lb_vlTotSomenteAnt_Value = new Label();
	@FXML
	protected Label lb_vlTotSomenteAtual_Value = new Label();
	@FXML
	protected Label lb_vlTotPermanentes_Value = new Label();
	@FXML
	protected Label lb_nRegAumentouValor_Value = new Label();
	@FXML
	protected Label lb_nRegDiminuiValor_Value = new Label();
	@FXML
	protected Label lb_nRegPermaneceuValor_Value = new Label();
	@FXML
	protected Label lb_nRegAnt1111 = new Label();
	@FXML
	protected Label lb_nRegAtual_Value11 = new Label();
	@FXML
	protected Label lb_nRegAnt_Value11 = new Label();
	@FXML
	protected Label lb_nTotalReg_Value11 = new Label();
	@FXML
	protected Label lb_nRegSomenteAntPerc_Value = new Label();
	@FXML
	protected Label lb_PermanenciaPerc_Value = new Label();
	@FXML
	protected Label lb_PermanenciaFinalPerc_Value = new Label();
	
	@FXML
	protected Label lb_Rolagem = new Label();
	
	

	@FXML
	protected Label lb_nRegAntPerc_Value = new Label();
	@FXML
	protected Label lb_nTotalRegPerc_Value = new Label();
	@FXML
	protected Label lb_nRegSomenteAtualPerc_Value = new Label();
	@FXML
	protected Label lb_nRegAtualPerc_Value = new Label();
	@FXML
	protected Label lb_Permanencia_Value = new Label();
	@FXML
	protected Label lb_Crescimento_Value = new Label();
	@FXML
	protected Label lb_nRetencao_Value = new Label();
	@FXML
	protected Label lb_CrescimentoPerc_Value = new Label();
	@FXML
	protected Label lb_nRetencaoPerc_Value = new Label();
	@FXML
	protected Label lb_nRegAnt = new Label();
	@FXML
	protected Label lb_nRegAtualExistentenoAnt = new Label();
	@FXML
	protected Label lb_nRegAtual = new Label();
	@FXML
	protected Label lb_nRegAumentouValor = new Label();
	@FXML
	protected Label lb_nRegSomenteAnterior = new Label();
	@FXML
	protected Label lb_nRegSomenteAtual = new Label();
	@FXML
	protected Label lb_nRegDiminuiValor = new Label();
	@FXML
	protected Label lb_nRegPermaneceuValor = new Label();
	@FXML
	protected Label lb_nTotalReg = new Label();

	@FXML
	protected Label lb_nRegAnt11 = new Label();
	@FXML
	protected Label lb_nRegAnt111 = new Label();
	@FXML
	protected Label lb_nRegAnt1 = new Label();
	@FXML
	protected Label lb_VlTotAnt_Value = new Label();
	@FXML
	protected Label lb_VlTotSomenteAtual_Value = new Label();
	@FXML
	protected Label lb_VlTotSomenteAnt_Value = new Label();
	@FXML
	protected Label lb_VlTotPermaneceu_Value = new Label();
	
	@FXML
	protected Label lb_VlTotAumentouValor_Value = new Label();
	
	@FXML
	protected Label lb_VlTotDiminuiValor_Value = new Label();
	@FXML
	protected Label lb_VlTotPermaneceuValor_Value = new Label();
	@FXML
	protected Label lb_DifInflacao_Value = new Label();
	@FXML
	protected Label lb_DifDeflanflacao_Value = new Label();

	@FXML
	protected Label lb_CarteiraDiferencaInflacao = new Label();
	@FXML
	protected Label lb_CarteiraDiferencaDeflacao = new Label();
	@FXML
	protected Label lb_CarteiraClientesNovos = new Label();
	@FXML
	protected Label lb_CarteiraClientesBaixados = new Label();
	@FXML
	protected Label lb_CarteiraResultadoA = new Label();
	@FXML
	protected Label lb_CarteiraResultadoB = new Label();
	@FXML
	protected Label lb_CarteiraResultadoFinal = new Label();
	@FXML
	protected Label lb_CarteiraResultadoPercentualFinal = new Label();
	@FXML
	
	protected Label lb_nRegDiminuiValorPerc_Value = new Label();
	
	@FXML
	protected Label lb_nRegAumentouValorPerc_Value = new Label();
	@FXML
	protected Label lb_nRegDiminuiuValorPerc_Value = new Label();
					 
	
	protected Label lb_nRegPermaneceuValorPerc_Value = new Label();

}

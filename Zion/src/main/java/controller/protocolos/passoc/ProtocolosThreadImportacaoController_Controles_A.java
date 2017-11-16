package controller.protocolos.passoc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Servicos_Restricoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;

public class ProtocolosThreadImportacaoController_Controles_A {
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
	@FXML
	protected Label lb_Etapas = new Label();
	protected String texto = "";
	protected String nInsc = "";
	protected String cpf_Cnpj = "";
	protected double valor = 0;
	protected String stringClassif = "";
	protected String stringSub = "";
	protected String stringRestr = "";
	protected Enum_Aux_Servicos_Classificacoes classif;
	protected Enum_Aux_Servicos_Sub_Classificacoes sub;
	protected Enum_Aux_Servicos_Restricoes restr;	
	protected int ano1 = 0;
	protected int i = 1;
	protected int celula = 0;
	protected int celulaAviso = 0;
		
}

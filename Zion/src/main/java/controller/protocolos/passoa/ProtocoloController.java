package controller.protocolos.passoa;

import java.net.URL;
import java.util.ResourceBundle;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.fxml.Initializable;
import model.enums.Enum_Aux_Comparativos_Resultados;
import util.Utilidades;

public class ProtocoloController extends ProtocoloController_Controles_Metodos_A implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
        
		configuraPainelPrincipal();
		ProtocoloController_ControlesGerais_A.setEnum_Aux_Servicos_Composicoes(Utilidades.getpPL().getEnum_Aux_Servicos_Composicoes());
		buscaTitulo();
		inicializarObservadores();
		preencheComboFiltragem();
		inicializa_Eventos();
	}
	
	public void preencheComboFiltragem() {
		cB_FilterField.getItems().clear();
		cB_FilterField.getItems().setAll(Enum_Aux_Comparativos_Resultados.values());
	}
	
	public void buscaTitulo() {		
		ProtocoloController_ControlesGerais_A.setServicosClassificacoes(Utilidades.getpPL().getEnum_Aux_Servicos_Composicoes().getClassificacao());        
        lb_Classificacoes.setText(Utilidades.getpPL().getEnum_Aux_Servicos_Composicoes().getClassificacao().getTitulo()+" - "+ Utilidades.getpPL().getEnum_Aux_Servicos_Composicoes().getSub_Classificacao().getDescricao2());        
        lb_Sub_Classificacoes.setText("");
        lb_Restricoes.setText(Utilidades.getpPL().getEnum_Aux_Servicos_Composicoes().getRestricao().getTitulo());
	}
	

}

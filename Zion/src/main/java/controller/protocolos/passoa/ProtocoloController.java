package controller.protocolos.passoa;

import java.net.URL;
import java.util.ResourceBundle;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.fxml.Initializable;
import model.enums.Enum_Aux_Comparativos_Resultados;
import model.enums.Enum_Aux_Servicos_Composicoes;
import util.Utilidades;

public class ProtocoloController extends ProtocoloController_Controles_Metodos_A implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ProtocoloController_ControlesGerais_A.setComposicaoServicosNavega(Enum_Aux_Servicos_Composicoes.IPTU_COMPARATIVOS_FLORIANOPOLIS_SC);
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
		ProtocoloController_ControlesGerais_A.setServicosClassificacoes(Utilidades.getpPL().getServicosClassificacoes());        
        lb_Titulo.setText(Utilidades.getpPL().getServicosClassificacoes().getTitulo());        
	}
	

}

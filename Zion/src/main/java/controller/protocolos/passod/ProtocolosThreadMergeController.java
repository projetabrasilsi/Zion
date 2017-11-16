package controller.protocolos.passod;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.fxml.Initializable;

public class ProtocolosThreadMergeController extends ProtocolosThreadMergeController_Metodos_A
		implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ProtocoloController_ControlesGerais_A.evoluisequencia();
		lb_Etapas.setText(ProtocoloController_ControlesGerais_A.getSequencia());		
		bt_Fechar.setVisible(false);
		bt_Fechar.setDisable(true);
		lb_Titulo_Merge.setPrefWidth(tV_ProtServicos_Detalhe.getPrefWidth());
		lb_Titulo_Tela.setPrefWidth(tV_ProtServicos_Detalhe.getPrefWidth());
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
		inicializaEventos();	
		ProtocoloController_ControlesGerais_A.zeraContagemRegistros();
		if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao().isComparativo()) {
				ProtocoloController_ControlesGerais_A.setnRegAnt(ProtocoloController_ControlesGerais_A.getComparativos_1().size());
				ProtocoloController_ControlesGerais_A.setnRegAtual(ProtocoloController_ControlesGerais_A.getComparativos_2().size());
				ProtocoloController_ControlesGerais_A.setnTotalReg(ProtocoloController_ControlesGerais_A.getComparativos_1().size()+ProtocoloController_ControlesGerais_A.getComparativos_2().size());
		} else {
			ProtocoloController_ControlesGerais_A.setnRegAnt(ProtocoloController_ControlesGerais_A.getComparativos_1().size());
			ProtocoloController_ControlesGerais_A.setnTotalReg(ProtocoloController_ControlesGerais_A.getnRegAnt());

		}				
		salvandoListaImportada();
	}
	
	public void inicializaEventos() {
		bt_Fechar.setOnAction((e) -> {
			fechatela();
		});
	}

}

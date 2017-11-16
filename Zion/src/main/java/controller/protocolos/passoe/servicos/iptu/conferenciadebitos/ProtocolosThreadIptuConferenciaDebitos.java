package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.net.URL;
import java.util.ResourceBundle;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.fxml.Initializable;

public class ProtocolosThreadIptuConferenciaDebitos extends ProtocolosThreadIptuConferenciaDebitos_Metodos_A
		implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ProtocoloController_ControlesGerais_A.evoluisequencia();
		lb_Etapas.setText(ProtocoloController_ControlesGerais_A.getSequencia());
		bt_Fechar.setVisible(false);
		bt_Fechar.setDisable(true);		
		downloadDebitos();
				
			
	}

	

}

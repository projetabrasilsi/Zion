package controller.protocolos.passod;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.scene.paint.Color;

public class ProtocolosThreadMergeController_Metodos_F extends ProtocolosThreadMergeController_Metodos_G {
	public void setaLabelsEValoresIniciais() {
		tV_ProtServicos_Detalhe.requestFocus();
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);	
		lb_Titulo_Tela.setText("SALVANDO LISTAGEM DE INSCRIÇÕES");
	}
	public void sucesso() {
		lb_Titulo_Merge.setTextFill(Color.web("#0a7cdf"));		
		

		if (ProtocoloController_ControlesGerais_A.isOk() && ProtocoloController_ControlesGerais_A.isFinalizado())			
		lb_Titulo_Tela.setText("REALIZAÇÃO DA GRAVAÇÃO DA LISTAGEM DE INSCRIÇÕES: Finalizada com Sucesso!!!");			
		 else {
			lb_Titulo_Tela.setTextFill(Color.web("#ff0000"));	
		    lb_Titulo_Tela.setText("REALIZAÇÃO DA LISTA COMPARAÇÕES: NÃO FOI REALIZADA. ERRO!");
		
		}
	}
}

package controller.protocolos.passoa;

import java.io.IOException;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProtocoloController_Controles_Metodos_H extends ProtocoloController_Controles_Metodos_I {

	public void setarResumoVazio() {
		lb_PermanenciaFinalPerc_Value.setText("");
		lb_nTotalRegPerc_Value.setText("");
		lb_PermanenciaPerc_Value.setText("");
		lb_nTotalReg_Value.setText("");
		lb_nRegAnt_Value.setText("");
		lb_nRegAtual_Value.setText("");
		lb_nRegAumentouValor_Value.setText("");
		lb_nRegDiminuiValor_Value.setText("");
		lb_nRegPermaneceuValor.setText("");
		lb_nRegPermaneceuValor_Value.setPrefWidth(lb_nRegPermaneceuValor.getPrefWidth());
		lb_nRegAnt1111.setPrefWidth(lb_nRegPermaneceuValor.getPrefWidth());
		lb_nRegPermaneceuValor_Value.setText("");
		lb_nRegSomenteAnt_Value.setText("");
		lb_nRegSomenteAtual_Value.setText("");
		lb_nRegPermanentes_Value.setText("");
		lb_nRegAnt.setText("");
		lb_nRegAnt_Value.setPrefWidth(lb_nRegAnt.getPrefWidth());
		lb_nRegAntPerc_Value.setPrefWidth(lb_nRegAnt.getPrefWidth());
		lb_nRegAtual.setText("");
		lb_nRegAtual_Value.setPrefWidth(lb_nRegAtual.getPrefWidth());
		lb_nRegAtualPerc_Value.setPrefWidth(lb_nRegAtual.getPrefWidth());
		lb_nRegSomenteAtual.setText("Aquisições : ");
		lb_nRegSomenteAnterior.setText("Perdas : ");
		lb_nRegAtualExistentenoAnt.setText("Em: ");
		lb_nRegSomenteAntPerc_Value.setText("");
		lb_nRegSomenteAtualPerc_Value.setText("");
		lb_CrescimentoPerc_Value.setText("");
		lb_PermanenciaPerc_Value.setText("");
		lb_Permanencia_Value.setText("");
		lb_Crescimento_Value.setText("");
		lb_nRegAtualPerc_Value.setText("");
		lb_nRegAntPerc_Value.setText("");
		lb_PermanenciaFinalPerc_Value.setText("");
		lb_VlTotAnt_Value.setText("");
		lb_VlTotSomenteAtual_Value.setText("");
		lb_VlTotSomenteAnt_Value.setText("");
		lb_VlTotPermaneceu_Value.setText("");
		lb_nRegAumentouValorPerc_Value.setText("");
		lb_VlTotAumentouValor_Value.setText("");
		lb_nRegDiminuiValorPerc_Value.setText("");
		lb_VlTotDiminuiValor_Value.setText("");
		lb_nRegPermaneceuValor_Value.setText("");
		lb_VlTotPermaneceuValor_Value.setText("");
		lb_CarteiraDiferencaInflacao.setText("");
		lb_CarteiraDiferencaDeflacao.setText("");
		lb_CarteiraClientesNovos.setText("");
		lb_CarteiraClientesBaixados.setText("");
		lb_CarteiraResultadoA.setText("");
		lb_CarteiraResultadoB.setText("");
		lb_CarteiraResultadoFinal.setText("");
		lb_CarteiraResultadoPercentualFinal.setText("");
	}

	

	public void rolarIndicando(int i) {
		sB.setValue(i);
	}

	public boolean chamateladePassoE() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader()
				.getResource(ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getFormulario()));
		AnchorPane page = null;
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage dialogStage = new Stage();
		dialogStage.setTitle(ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getTitulo());
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);
		dialogStage.showAndWait();
		
		
		dialogStage.close();
		
		return ProtocoloController_ControlesGerais_A.isOk();
	}
}

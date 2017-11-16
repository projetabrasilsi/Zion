package controller.protocolos.passoa;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.entities.ProtocolosdeServicos;

public class ProtocoloController_Controles_Metodos_G extends ProtocoloController_Controles_Metodos_H {
	public void setarResumo(ProtocolosdeServicos pS) {
		if (pS != null) {
			lb_nTotalRegPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(1.0, true));
			lb_PermanenciaPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getPermaneceuPercentual(), true));
			lb_nTotalReg_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnTotalReg()));
			lb_nRegAnt_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegAnt()));
			lb_nRegAtual_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegAtual()));
			lb_nRegDiminuiValor_Value
					.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegDiminuiValor()));
			lb_nRegPermaneceuValor.setText("Permaneceram: " + pS.getAnoAnt() + "/" + pS.getAnoAtual());
			lb_nRegPermaneceuValor_Value.setPrefWidth(lb_nRegPermaneceuValor.getPrefWidth());
			lb_nRegAnt1111.setPrefWidth(lb_nRegPermaneceuValor.getPrefWidth());
			lb_nRegPermaneceuValor_Value
					.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegPermaneceuValor()));
			lb_nRegSomenteAnt_Value
					.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegSomenteAnt()));
			lb_nRegSomenteAtual_Value
					.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegSomenteAtual()));
			lb_nRegPermanentes_Value
					.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegPermanentes()));
			lb_nRegAnt.setText("" + pS.getAnoAnt());
			lb_nRegAnt_Value.setPrefWidth(lb_nRegAnt.getPrefWidth());
			lb_nRegAntPerc_Value.setPrefWidth(lb_nRegAnt.getPrefWidth());
			lb_nRegAtual.setText("" + pS.getAnoAtual());
			lb_nRegAtual_Value.setPrefWidth(lb_nRegAtual.getPrefWidth());
			lb_nRegAtualPerc_Value.setPrefWidth(lb_nRegAtual.getPrefWidth());
			lb_nRegSomenteAtual.setText("Aquisições : " + pS.getAnoAtual());
			lb_nRegSomenteAnterior.setText("Perdas : " + pS.getAnoAnt());
			lb_nRegAtualExistentenoAnt.setText("Em: " + pS.getAnoAnt() + "/" + pS.getAnoAtual());
			lb_nRegSomenteAntPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getPerdaPercentual(), true));
			lb_nRegSomenteAtualPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getNovosPercentual(), true));
			lb_CrescimentoPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getCrescimentoPercentual(), true));
			lb_PermanenciaFinalPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getPermaneceuPercentual(), true));
			lb_Permanencia_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegPermanentes()));
			lb_Crescimento_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getCrescimento()));
			lb_nRegAumentouValor_Value
					.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegAumentouValor()));
			lb_nRegAtualPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegAtualPerc(), true));
			lb_nRegAntPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegAntPerc(), true));
			lb_VlTotAnt_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotAnt(), false));
			lb_vlTotAtual_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotAtual(), false));
			lb_VlTotSomenteAtual_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotSomenteAtual(), false));
			lb_VlTotSomenteAnt_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotSomenteAnt(), false));
			lb_VlTotPermaneceu_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotPermaneceu(), false));
			lb_VlTotAumentouValor_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotAumentou(), false));
			lb_VlTotDiminuiValor_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotDiminuiu(), false));
			lb_VlTotPermaneceuValor_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotPermaneceuValor(), false));
			lb_DifInflacao_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotDifInflacao(), false));
			lb_DifDeflanflacao_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotDifDeflacao(), false));
			lb_CarteiraDiferencaInflacao.setText(lb_DifInflacao_Value.getText());
			lb_CarteiraDiferencaDeflacao.setText(lb_DifDeflanflacao_Value.getText());
			lb_CarteiraClientesNovos.setText(lb_VlTotSomenteAtual_Value.getText());
			lb_CarteiraDiferencaInflacao.setText(lb_DifInflacao_Value.getText());
			lb_CarteiraDiferencaDeflacao.setText(lb_DifDeflanflacao_Value.getText());
			lb_CarteiraClientesBaixados.setText(lb_VlTotSomenteAnt_Value.getText());
			lb_CarteiraResultadoA
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getCarteiraResultadoA(), false));
			lb_CarteiraResultadoB
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getCarteiraResultadoB(), false));
			lb_CarteiraResultadoFinal.setText(
					ProtocoloController_ControlesGerais_A.retornaFormato(pS.getCarteiraResultadoFinal(), false));
			lb_CarteiraResultadoPercentualFinal.setText(ProtocoloController_ControlesGerais_A
					.retornaFormato(pS.getCarteiraResultadoPercentualFinal(), true));
			lb_nRegAumentouValorPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegAumentouValorPerc(), true));
			lb_nRegDiminuiValorPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegDiminuiValorPerc(), true));
			lb_nRegPermaneceuValorPerc_Value
					.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegAumentouValorPerc(), true));
		} else {
			setarResumoVazio();
		}

	}

}

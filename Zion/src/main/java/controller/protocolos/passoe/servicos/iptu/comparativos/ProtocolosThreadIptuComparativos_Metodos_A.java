package controller.protocolos.passoe.servicos.iptu.comparativos;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.dao.ProtocolosdeServicosDAO;

public class ProtocolosThreadIptuComparativos_Metodos_A extends ProtocolosThreadIptuComparativos_Metodos_B {
	public boolean gravadados() {
		boolean ok = false;
		double percentuais = 0;
		ProtocoloController_ControlesGerais_A.contabilizaResultados();
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnTotalReg(ProtocoloController_ControlesGerais_A.getnTotalReg());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegAnt(ProtocoloController_ControlesGerais_A.getnRegAnt());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotAnt(ProtocoloController_ControlesGerais_A.getVlTotAnt());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegAtual(ProtocoloController_ControlesGerais_A.getnRegAtual());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotAtual(ProtocoloController_ControlesGerais_A.getVlTotAtual());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegSomenteAnt(ProtocoloController_ControlesGerais_A.getnRegSomenteAnt());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotSomenteAnt(ProtocoloController_ControlesGerais_A.getVlTotSomenteAnt());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegSomenteAtual(ProtocoloController_ControlesGerais_A.getnRegSomenteAtual());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotSomenteAtual(ProtocoloController_ControlesGerais_A.getVlTotSomenteAtual());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegPermanentes(ProtocoloController_ControlesGerais_A.getnRegPermanentes());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotPermaneceu(ProtocoloController_ControlesGerais_A.getVlTotPermaneceu());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegAumentouValor(ProtocoloController_ControlesGerais_A.getnRegAumentouValor());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegDiminuiValor(ProtocoloController_ControlesGerais_A.getnRegDiminuiValor());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegPermaneceuValor(ProtocoloController_ControlesGerais_A.getnRegPermaneceuValor());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setCrescimento(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegSomenteAtual()
						- ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegSomenteAnt());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotAnt(ProtocoloController_ControlesGerais_A.getVlTotAnt());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotAtual(ProtocoloController_ControlesGerais_A.getVlTotAtual());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotAumentou(ProtocoloController_ControlesGerais_A.getVlTotAumentou());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotDiminuiu(ProtocoloController_ControlesGerais_A.getVlTotDiminuiu());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotPermaneceu(ProtocoloController_ControlesGerais_A.getVlTotPermaneceuValor());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotPermaneceu(ProtocoloController_ControlesGerais_A.getVlTotPermaneceu());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotSomenteAnt(ProtocoloController_ControlesGerais_A.getVlTotSomenteAnt());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotSomenteAtual(ProtocoloController_ControlesGerais_A.getVlTotSomenteAtual());
		if (ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnTotalReg() > 0) {
			percentuais = ((double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegAtual()
					/ (double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnTotalReg());
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setnRegAtualPerc(percentuais);
			percentuais = ((double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegAnt()
					/ (double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnTotalReg());
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setnRegAntPerc(percentuais);
		} else {
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setnRegAtualPerc(0);
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setnRegAntPerc(0);
		}
		if (ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegAnt() > 0) {

			percentuais = ((double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getCrescimento()
					/ (double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegAnt());
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setCrescimentoPercentual(percentuais);
			percentuais = ((double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegSomenteAnt()
					/ (double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegAnt());
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setPerdaPercentual(percentuais);

			percentuais = ((double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
					.getnRegSomenteAtual()
					/ (double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegAnt());
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setNovosPercentual(percentuais);
			percentuais = ((double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegPermanentes()
					/ (double) ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getnRegAnt());
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setPermaneceuPercentual(percentuais);
		} else {
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setCrescimentoPercentual(0);
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setPerdaPercentual(0);
		}
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotPermaneceuValor(ProtocoloController_ControlesGerais_A.getVlTotPermaneceuValor());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotDifDeflacao(ProtocoloController_ControlesGerais_A.getVlTotDifDeflacao());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setVlTotDifInflacao(ProtocoloController_ControlesGerais_A.getVlTotDifInflacao());

		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setCarteiraResultadoA(ProtocoloController_ControlesGerais_A.getCarteiraResultadoA());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setCarteiraResultadoB(ProtocoloController_ControlesGerais_A.getCarteiraResultadoB());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setCarteiraResultadoFinal(ProtocoloController_ControlesGerais_A.getCarteiraResultadoFinal());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setCarteiraResultadoPercentualFinal(
				ProtocoloController_ControlesGerais_A.getCarteiraResultadoPercentualFinal());

		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegAumentouValorPerc(ProtocoloController_ControlesGerais_A.getnRegAumentouValorPerc());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegDiminuiValorPerc(ProtocoloController_ControlesGerais_A.getnRegDiminuiValorPerc());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setnRegPermaneceuValorPerc(ProtocoloController_ControlesGerais_A.getnRegPermaneceuValorPerc());
		ProtocolosdeServicosDAO pdao = new ProtocolosdeServicosDAO();
		ProtocoloController_ControlesGerais_A
				.setProtocolosdeServicos(pdao.merge(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()));
		ok = true;
		return ok;
	}

}

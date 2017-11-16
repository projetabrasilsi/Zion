package controller.protocolos.controlesgerais;

import java.util.ArrayList;
import java.util.List;
import model.dao.ProtocolosdeServicos_DetalheDAO;
import model.entities.ProtocolosdeServicos_Detalhe;

public class ProtocoloController_ControlesGerais_A extends ProtocoloController_ControlesGerais_B {
	public static void contabilizaResultados() {
		zeraContagemRegistros();
		ProtocolosdeServicos_DetalheDAO dao = new ProtocolosdeServicos_DetalheDAO();
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setnTotalReg(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), true,
						false, false, false, false, false, false, false, false));
		ProtocoloController_ControlesGerais_A.setnRegAnt(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						true, false, false, false, false, false, false, false));
		ProtocoloController_ControlesGerais_A.setVlTotAnt(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, true, false, false, false, false, false, false, false, true, false, false));
		ProtocoloController_ControlesGerais_A.setnRegAtual(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, true, false, false, false, false, false, false));
		ProtocoloController_ControlesGerais_A.setVlTotAtual(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, true, false, false, false, false, false, false, true, false, false));
		ProtocoloController_ControlesGerais_A.setnRegSomenteAnt(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, true, false, false, false, false, false));
		ProtocoloController_ControlesGerais_A.setVlTotSomenteAnt(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, true, false, false, false, false, false, true, false, false));
		ProtocoloController_ControlesGerais_A.setnRegSomenteAtual(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, true, false, false, false, false));
		ProtocoloController_ControlesGerais_A.setVlTotSomenteAtual(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, true, false, false, false, false, true, false, false));
		ProtocoloController_ControlesGerais_A.setnRegPermanentes(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, false, true, false, false, false));
		ProtocoloController_ControlesGerais_A.setVlTotPermaneceu(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, false, true, false, false, false, true, false, false));
		ProtocoloController_ControlesGerais_A.setnRegAumentouValor(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, false, false, true, false, false));
		ProtocoloController_ControlesGerais_A.setVlTotAumentou(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, false, false, true, false, false, true, false, false));
		ProtocoloController_ControlesGerais_A.setnRegDiminuiValor(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, false, false, false, true, false));
		ProtocoloController_ControlesGerais_A.setVlTotDiminuiu(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, false, false, false, true, false, true, false, false));
		ProtocoloController_ControlesGerais_A.setnRegPermaneceuValor(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, false, false, false, false, true));
		ProtocoloController_ControlesGerais_A.setVlTotPermaneceuValor(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, false, false, false, false, true, true, false, false));
		ProtocoloController_ControlesGerais_A.setVlTotDifInflacao(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, false, false, false, false, false, true, true, false));
		ProtocoloController_ControlesGerais_A.setVlTotDifDeflacao(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, false, false, false, false, false, true, false, true));
		ProtocoloController_ControlesGerais_A
				.setCarteiraResultadoA(ProtocoloController_ControlesGerais_A.getVlTotSomenteAtual()
						+ ProtocoloController_ControlesGerais_A.vlTotDifInflacao);
		ProtocoloController_ControlesGerais_A
				.setCarteiraResultadoB(ProtocoloController_ControlesGerais_A.getVlTotSomenteAnt()
						+ ProtocoloController_ControlesGerais_A.getVlTotDifDeflacao());
		ProtocoloController_ControlesGerais_A
				.setCarteiraResultadoFinal(ProtocoloController_ControlesGerais_A.getCarteiraResultadoA()
						- ProtocoloController_ControlesGerais_A.getCarteiraResultadoB());
		if (ProtocoloController_ControlesGerais_A.getVlTotAnt() > 0)
			ProtocoloController_ControlesGerais_A.setCarteiraResultadoPercentualFinal(
					ProtocoloController_ControlesGerais_A.getCarteiraResultadoFinal()
							/ ProtocoloController_ControlesGerais_A.getVlTotAnt());
		else
			ProtocoloController_ControlesGerais_A.setCarteiraResultadoPercentualFinal(0);

		if (ProtocoloController_ControlesGerais_A.getnRegPermanentes() > 0) {

			ProtocoloController_ControlesGerais_A
					.setnRegAumentouValorPerc((double) ProtocoloController_ControlesGerais_A.getnRegAumentouValor()
							/ (double) ProtocoloController_ControlesGerais_A.getnRegPermanentes());
			ProtocoloController_ControlesGerais_A
					.setnRegDiminuiValorPerc((double) ProtocoloController_ControlesGerais_A.getnRegDiminuiValor()
							/ (double) ProtocoloController_ControlesGerais_A.getnRegPermanentes());
			ProtocoloController_ControlesGerais_A
					.setnRegPermaneceuValorPerc((double) ProtocoloController_ControlesGerais_A.getnRegPermaneceuValor()
							/ (double) ProtocoloController_ControlesGerais_A.getnRegPermanentes());
		} else {
			nRegAumentouValorPerc = 0;
			nRegDiminuiValorPerc = 0;
			nRegPermaneceuValorPerc = 0;
		}
	}

	public static List<ProtocolosdeServicos_Detalhe> buscaprotocoloservicosDetalhes() {
		List<ProtocolosdeServicos_Detalhe> lista = new ArrayList<>();
		ProtocolosdeServicos_DetalheDAO dao = new ProtocolosdeServicos_DetalheDAO();
		lista = dao.retornadetalhe(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos());
		// deixei de retornar protocolosdeServicos_detalheLista pois quando algum outro
		// objeto recebe de protocolosdeservicos_detalheLista e
		// eu preciso de zerar este protocolosdeservicos_detalheLista esse objeto também
		// zera pois faz a mesma referencia na memória
		// por isso criei a lista;
		// return getProtocolosdeServicos_DetalheLista();
		return lista;
	}

}

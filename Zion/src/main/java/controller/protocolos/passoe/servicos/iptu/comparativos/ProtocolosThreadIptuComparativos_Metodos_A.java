package controller.protocolos.passoe.servicos.iptu.comparativos;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.dao.Inscricao_HistoricoDAO;
import model.dao.ProtocolosdeServicosDAO;
import model.entities.Inscricao_Historico;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Comparativos_Resultados;

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

		/*
		 * ControlesEstaticos.getVlTot(); ControlesEstaticos.getVlTot();
		 * ControlesEstaticos.getVlTotAtual();
		 */

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

		/*
		 * ControlesEstaticos.getVlTotSomenteAnt();
		 * ControlesEstaticos.getVlTotSomenteAtual();
		 * ControlesEstaticos.getVlTotPermanentes();
		 */

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

	public ProtocolosdeServicos_Detalhe geraComparativos(ProtocolosdeServicos_Detalhe pd) {
		Inscricao_Historico iH1 = new Inscricao_Historico();
		Inscricao_Historico iH2 = new Inscricao_Historico();

		iH1.setEnum_Aux_Servicos_Sub_Classificacoes(
				ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao());
		iH1.setId_Inscricao(pd.getId_Inscricao());
		iH1.setAno_Ref(ProtocoloController_ControlesGerais_A.getAnoAnt());

		iH2.setEnum_Aux_Servicos_Sub_Classificacoes(
				ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao());
		iH2.setId_Inscricao(pd.getId_Inscricao());
		iH2.setAno_Ref(ProtocoloController_ControlesGerais_A.getAnoAtual());

		iH1 = verificaSeInscHisotircoExiste(iH1);
		iH2 = verificaSeInscHisotircoExiste(iH2);

		pd.setAnoAtual(ProtocoloController_ControlesGerais_A.getAnoAtual());
		pd.setMesAtual(0);
		pd.setAnoAnt(ProtocoloController_ControlesGerais_A.getAnoAnt());
		pd.setMesAnt(0);

		if (iH1 == null)
			pd.setValorAnt(0);
		else
			pd.setValorAnt(iH1.getValor());
		if (iH2 == null)
			pd.setValorAtual(0);
		else
			pd.setValorAtual(iH2.getValor());

		if (pd.getValorAnt() > 0 && pd.getValorAtual() > 0) {
			if (pd.getValorAnt() > pd.getValorAtual()) {
				pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.DIMINIUIU);
				pd.setDiferenca(pd.getValorAnt() - pd.getValorAtual());
			} else 
				if (pd.getValorAnt() < pd.getValorAtual()){
				pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.AUMENTOU);
				pd.setDiferenca(pd.getValorAtual() - pd.getValorAnt());
			}else {
				pd.setDiferenca(0);
				pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.MANTEVE);
				
			}
		} else {
			pd.setDiferenca(0);
			pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.NAO_AVALIADO);
		}

		if (pd.getValorAnt() > 0)
			pd.setPercentual((pd.getDiferenca() / pd.getValorAnt()));
		else
			pd.setPercentual(0);

		return pd;
	}

	public Inscricao_Historico verificaSeInscHisotircoExiste(Inscricao_Historico iH) {
		Inscricao_HistoricoDAO iDAO = new Inscricao_HistoricoDAO();
		iH = iDAO.verificaSeExiste(iH);
		return iH;
	}

}

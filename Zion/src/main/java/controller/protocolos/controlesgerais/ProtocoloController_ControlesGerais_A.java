package controller.protocolos.controlesgerais;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javafx.stage.FileChooser;
import model.dao.ProtocolosdeServicos_DetalheDAO;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Comparativos_Resultados;

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
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setnRegAnt(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						true, false, false, false, false, false, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setVlTotAnt(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, true, false, false, false, false, false, false, false, true, false, false));

		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setnRegAtual(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, true, false, false, false, false, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setVlTotAtual(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, true, false, false, false, false, false, false, true, false, false));

		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setnRegSomenteAnt(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, true, false, false, false, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setVlTotSomenteAnt(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, true, false, false, false, false, false, true, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setnRegSomenteAtual(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, true, false, false, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setVlTotSomenteAtual(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, true, false, false, false, false, true, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */

		ProtocoloController_ControlesGerais_A.setnRegPermanentes(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, false, true, false, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */

		ProtocoloController_ControlesGerais_A.setVlTotPermaneceu(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, false, true, false, false, false, true, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setnRegAumentouValor(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, false, false, true, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setVlTotAumentou(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, false, false, true, false, false, true, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */

		ProtocoloController_ControlesGerais_A.setnRegDiminuiValor(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, false, false, false, true, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
		ProtocoloController_ControlesGerais_A.setVlTotDiminuiu(
				dao.retornadetalheTotalRegistrosEmValor(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(),
						false, false, false, false, false, false, false, true, false, true, false, false));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */

		ProtocoloController_ControlesGerais_A.setnRegPermaneceuValor(
				dao.retornadetalheTotalRegistros(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos(), false,
						false, false, false, false, false, false, false, true));
		/*
		 * retornadetalheTotalRegistros(ProtocolosdeServicos
		 * id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,
		 * boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean
		 * aumentou,boolean diminuiu, boolean permaneceu)
		 */
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

		/*
		 * crescimento = 0; perdaPercentual = 0; aquisicaoPercentual = 0;
		 * crescimentoPercentual = 0; novosPercentual = 0; permaneceuPercentual = 0;
		 * nRegAtualPerc = 0; nRegAntPerc = 0; nRegAumentouValorPerc = 0;
		 * nRegDiminuiValorPerc = 0; nRegPermaneceuValorPerc = 0;
		 */

	}

	public static void zeraContagemRegistros() {
		anoAnt = 0;
		anoAtual = 0;
		MesAnt = 0;
		MesAtual = 0;
		nTotalReg = 0;
		nRegAnt = 0;
		nRegAtual = 0;
		vlTot = 0;
		vlTotAnt = 0;
		vlTotAtual = 0;
		vlTotAumentou = 0;
		vlTotDifInflacao = 0;
		vlTotDifDeflacao = 0;
		vlTotPermaneceu = 0;
		vlTotDiminuiu = 0;
		crescimento = 0;
		perdaPercentual = 0;
		aquisicaoPercentual = 0;
		crescimentoPercentual = 0;
		novosPercentual = 0;
		permaneceuPercentual = 0;
		nRegAtualPerc = 0;
		nRegAntPerc = 0;
		nRegAumentouValorPerc = 0;
		nRegDiminuiValorPerc = 0;
		nRegPermaneceuValorPerc = 0;

		nRegSomenteAnt = 0;
		nRegSomenteAtual = 0;
		nRegPermanentes = 0;
		vlTotSomenteAnt = 0;
		vlTotSomenteAtual = 0;
		vlTotPermaneceuValor = 0;
		nRegAumentouValor = 0;
		nRegDiminuiValor = 0;
		nRegPermaneceuValor = 0;

		CarteiraDiferencaInflacao = 0;
		CarteiraDiferencaDeflacao = 0;
		CarteiraClientesNovos = 0;
		CarteiraClientesBaixados = 0;
		CarteiraResultadoA = 0;
		CarteiraResultadoB = 0;
		CarteiraResultadoFinal = 0;
		CarteiraResultadoPercentualFinal = 0;
	}

	public static String formataNumeros(int par) {
		NumberFormat formatter = new DecimalFormat("0000");
		return formatter.format(par);
	}

	public static String retornaCor(Enum_Aux_Comparativos_Resultados enum_Aux_Comparativos_Resultados) {
		if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.DIMINIUIU))
			return "black";
		else if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.MANTEVE))
			return "black";
		else if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.AUMENTOU))
			return "white";
		else
			return "white";

	}

	public static String retornaCorPreenchimento(Enum_Aux_Comparativos_Resultados enum_Aux_Comparativos_Resultados) {

		if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.DIMINIUIU))
			return "lightskyblue";
		else if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.MANTEVE))
			return "yellow";
		else if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.AUMENTOU))
			return "red";
		else
			return "black";

	}

	public static String retornaFormato(double valor, boolean percentual) {

		Locale locale = new Locale("pt", "BR");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		if (!percentual)
			return currencyFormatter.format(valor);
		else {
			NumberFormat formatador = NumberFormat.getPercentInstance();
			formatador.setMinimumFractionDigits(2);
			formatador.setMaximumFractionDigits(4);
			formatador.setGroupingUsed(true);

			return formatador.format(valor);
		}

	}

	public static boolean anexarArquivo() {
		setTextoResposta("");
		fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
		fileChooser.getExtensionFilters().add(extFilter);
		selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null) {
			setEscolhido(true);
			setTextoResposta(selectedFile.getName());
			return true;
		} else {
			setTextoResposta("Arquivo não escolhido");
			setEscolhido(true);
			return false;
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

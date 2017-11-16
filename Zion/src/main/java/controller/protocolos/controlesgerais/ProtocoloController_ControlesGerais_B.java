package controller.protocolos.controlesgerais;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javafx.stage.FileChooser;
import model.enums.Enum_Aux_Comparativos_Resultados;

public class ProtocoloController_ControlesGerais_B extends ProtocoloController_ControlesGerais_C {
	public static void zeraContagemRegistros() {
		anoAnt = 0;
		anoAtual = 0;
		mesAnt = 0;
		mesAtual = 0;
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

	public static String retornaCor(Enum_Aux_Comparativos_Resultados enum_Aux_Comparativos_Resultados) {
		if (enum_Aux_Comparativos_Resultados != null) {
			if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.DIMINIUIU))
				return "black";
			else if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.MANTEVE))
				return "black";
			else if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.AUMENTOU))
				return "white";
			else
				return "white";
		} else {
			return "white";
		}
	}

	public static String retornaCorPreenchimento(Enum_Aux_Comparativos_Resultados enum_Aux_Comparativos_Resultados) {
		if (enum_Aux_Comparativos_Resultados != null) {
			if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.DIMINIUIU))
				return "lightskyblue";
			else if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.MANTEVE))
				return "yellow";
			else if (enum_Aux_Comparativos_Resultados.equals(Enum_Aux_Comparativos_Resultados.AUMENTOU))
				return "red";
			else
				return "black";
		} else {
			return "black";
		}
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

	public static String formataNumeros(int par) {
		NumberFormat formatter = new DecimalFormat("0000");
		return formatter.format(par);
	}

}

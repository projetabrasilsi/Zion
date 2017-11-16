package controller.protocolos.controlesgerais;

import java.util.HashMap;
import java.util.Map;

public class ProtocoloController_ControlesGerais_K {
	protected static Map<String, Integer[]> cDebitos_DFlorianopolis = new HashMap<>();
	protected static Map<String, Integer[]> cDebitos_GFlorianopolis = new HashMap<>();
	protected static Map<String, Integer[]> cDebitos_JFlorianopolis = new HashMap<>();
	protected static Map<String, Integer[]> cDebitos_J1Florianopolis = new HashMap<>();
	protected static Map<String, Integer[]> cDebitos_LFlorianopolis = new HashMap<>();
	
	
	

	public ProtocoloController_ControlesGerais_K() {
		adicionaMap2();
	}

	public static void adicionaMap2() {
		// No DAM FITI DATA VENC CARTORIO VALOR MULTA JUROS TOTAL
				cDebitos_DFlorianopolis.put("seq", new Integer[] { 1, 5 });
				cDebitos_DFlorianopolis.put("dam", new Integer[] { 6, 18 });
				cDebitos_DFlorianopolis.put("fiti", new Integer[] { 19, 26 });
				cDebitos_DFlorianopolis.put("data_Venc", new Integer[] { 27, 38 });
				cDebitos_DFlorianopolis.put("cartorio", new Integer[] { 39, 76 });
				cDebitos_DFlorianopolis.put("valor", new Integer[] { 77, 90 });
				cDebitos_DFlorianopolis.put("multa", new Integer[] { 91, 104 });
				cDebitos_DFlorianopolis.put("juros", new Integer[] { 105, 118 });
				cDebitos_DFlorianopolis.put("total", new Integer[] { 119, 132 });

				cDebitos_GFlorianopolis.put("seq", new Integer[] { 1, 5 });			
				cDebitos_GFlorianopolis.put("dam", new Integer[] { 6, 20 });
				cDebitos_GFlorianopolis.put("processo", new Integer[] { 21, 34 });
				cDebitos_GFlorianopolis.put("data_Venc", new Integer[] { 35, 46 });
				cDebitos_GFlorianopolis.put("tributos", new Integer[] { 47, 60 });
				cDebitos_GFlorianopolis.put("historico", new Integer[] { 61, 78 });
				cDebitos_GFlorianopolis.put("valor", new Integer[] { 79, 90 });
				cDebitos_GFlorianopolis.put("multa", new Integer[] { 91, 104 });
				cDebitos_GFlorianopolis.put("juros", new Integer[] { 105, 118 });
				cDebitos_GFlorianopolis.put("total", new Integer[] { 119, 132 });				
				


		

		// No DAM ANO DATA VENC No. PROCESSO
		// No. PARCELAMENTO VALOR JUROS TOTAL
		cDebitos_JFlorianopolis.put("seq", new Integer[] { 1, 5 });
		cDebitos_JFlorianopolis.put("dam", new Integer[] { 6, 20 });
		cDebitos_JFlorianopolis.put("ano", new Integer[] { 21, 26 });
		cDebitos_JFlorianopolis.put("data_Venc", new Integer[] { 27, 38 });
		cDebitos_JFlorianopolis.put("processo", new Integer[] { 39, 55 });
		cDebitos_JFlorianopolis.put("nParcelamento", new Integer[] { 55, 76 });
		cDebitos_JFlorianopolis.put("valor", new Integer[] { 77, 104 });
		cDebitos_JFlorianopolis.put("juros", new Integer[] { 105, 118 });
		cDebitos_JFlorianopolis.put("total", new Integer[] { 119, 132 });

		// DAM LIV/FOLHA/CERT. DATA INSC HISTORICO
		// INSCRICAO VALOR

		cDebitos_J1Florianopolis.put("dam", new Integer[] { 1, 13 });
		cDebitos_J1Florianopolis.put("liv_Folha_Cert", new Integer[] { 14, 34 });
		cDebitos_J1Florianopolis.put("data_Insc", new Integer[] { 35, 46 });
		cDebitos_J1Florianopolis.put("historico", new Integer[] { 47, 92 });
		cDebitos_J1Florianopolis.put("inscricao", new Integer[] { 93, 119 });
		cDebitos_J1Florianopolis.put("valor", new Integer[] { 120, 132 });
		
		
		// No DAM ANO DATA VENC HISTORICO PROCESSO VALOR JUROS TOTAL
		cDebitos_LFlorianopolis.put("seq", new Integer[] { 1, 5 });
		cDebitos_LFlorianopolis.put("dam", new Integer[] { 6, 20 });
		cDebitos_LFlorianopolis.put("ano", new Integer[] { 21, 26 });
		cDebitos_LFlorianopolis.put("data_Venc", new Integer[] { 27, 38 });
		cDebitos_LFlorianopolis.put("historico", new Integer[] { 39, 76 });
		cDebitos_LFlorianopolis.put("processo", new Integer[] { 77, 91 });
		cDebitos_LFlorianopolis.put("valor", new Integer[] { 92, 104 });
		cDebitos_LFlorianopolis.put("juros", new Integer[] { 105, 118 });
		cDebitos_LFlorianopolis.put("total", new Integer[] { 119, 132 });

		
	}

	public static Map<String, Integer[]> getcDebitos_DFlorianopolis() {
		return cDebitos_DFlorianopolis;
	}

	public static void setcDebitos_DFlorianopolis(Map<String, Integer[]> cDebitos_DFlorianopolis) {
		ProtocoloController_ControlesGerais_K.cDebitos_DFlorianopolis = cDebitos_DFlorianopolis;
	}

	public static Map<String, Integer[]> getcDebitos_GFlorianopolis() {
		return cDebitos_GFlorianopolis;
	}

	public static void setcDebitos_GFlorianopolis(Map<String, Integer[]> cDebitos_GFlorianopolis) {
		ProtocoloController_ControlesGerais_K.cDebitos_GFlorianopolis = cDebitos_GFlorianopolis;
	}

	public static Map<String, Integer[]> getcDebitos_JFlorianopolis() {
		return cDebitos_JFlorianopolis;
	}

	public static void setcDebitos_JFlorianopolis(Map<String, Integer[]> cDebitos_JFlorianopolis) {
		ProtocoloController_ControlesGerais_K.cDebitos_JFlorianopolis = cDebitos_JFlorianopolis;
	}

	public static Map<String, Integer[]> getcDebitos_J1Florianopolis() {
		return cDebitos_J1Florianopolis;
	}

	public static void setcDebitos_J1Florianopolis(Map<String, Integer[]> cDebitos_J1Florianopolis) {
		ProtocoloController_ControlesGerais_K.cDebitos_J1Florianopolis = cDebitos_J1Florianopolis;
	}

	public static Map<String, Integer[]> getcDebitos_LFlorianopolis() {
		return cDebitos_LFlorianopolis;
	}

	public static void setcDebitos_LFlorianopolis(Map<String, Integer[]> cDebitos_LFlorianopolis) {
		ProtocoloController_ControlesGerais_K.cDebitos_LFlorianopolis = cDebitos_LFlorianopolis;
	}

	
}

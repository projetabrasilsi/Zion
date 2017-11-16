package controller.protocolos.controlesgerais;

import java.util.HashMap;
import java.util.Map;

public class ProtocoloController_ControlesGerais_J  extends ProtocoloController_ControlesGerais_K {
	protected static Map<String , Integer[]> cDebitos_A_A2Florianopolis = new HashMap<>();
	protected static Map<String , Integer[]> cDebitos_B_IFlorianopolis = new HashMap<>();
	protected static Map<String , Integer[]> cDebitos_B1_I1Florianopolis = new HashMap<>();
	protected static Map<String , Integer[]> cDebitos_CFlorianopolis = new HashMap<>();
	protected static Map<String , Integer[]> cDebitos_C1_L1Florianopolis = new HashMap<>();
	
	
	
	public ProtocoloController_ControlesGerais_J() {
		adicionaMap();
		adicionaMap2();
	}
	
	public static void adicionaMap() {
		//No   RADC.DAM TRIBUTOS         PROCESSO     PARCELAS EM ABERTO                          
		//VALOR       MULTA       JUROS         TOTAL
		cDebitos_A_A2Florianopolis.put("seq", new Integer[] {1,5});
		cDebitos_A_A2Florianopolis.put("radicalDam", new Integer[] {6,15});		
		cDebitos_A_A2Florianopolis.put("tributos", new Integer[] {16,32});		
		cDebitos_A_A2Florianopolis.put("processo", new Integer[] {33,45});
		cDebitos_A_A2Florianopolis.put("parAberto", new Integer[] {46,81});				
		cDebitos_A_A2Florianopolis.put("valor", new Integer[] {82,95});
		cDebitos_A_A2Florianopolis.put("multa", new Integer[] {96,107});
		cDebitos_A_A2Florianopolis.put("juros", new Integer[] {108,119});
		cDebitos_A_A2Florianopolis.put("total", new Integer[] {120,132});
		
		//No   DAM          LIV/FOLHA/CERT.      DATA  INSC  HISTORICO                                    
		//LOCALIZ.  PROCESSO            VALOR
		cDebitos_B_IFlorianopolis.put("seq", new Integer[] {1,5});
		cDebitos_B_IFlorianopolis.put("dam", new Integer[] {6,18});
		cDebitos_B_IFlorianopolis.put("liv_Folha_Cert", new Integer[] {19,39});
		cDebitos_B_IFlorianopolis.put("data_Insc", new Integer[] {40,51});
		cDebitos_B_IFlorianopolis.put("historico", new Integer[] {52,96});
		cDebitos_B_IFlorianopolis.put("localizacao", new Integer[] {97,106});
		cDebitos_B_IFlorianopolis.put("processo", new Integer[] {107,119});			
		cDebitos_B_IFlorianopolis.put("valor", new Integer[] {120,132});
		
		//DAM          LIV/FOLHA/CERT.     HISTORICO                                    PROCESSO
		
		cDebitos_B1_I1Florianopolis.put("dam", new Integer[] {1,18});
		cDebitos_B1_I1Florianopolis.put("liv_Folha_Cert", new Integer[] {19,38});		
		cDebitos_B1_I1Florianopolis.put("historico", new Integer[] {39,83});		
		cDebitos_B1_I1Florianopolis.put("processo", new Integer[] {84,132});
		
		//No   DAM            ANO   DATA  VENC  PROCESSO      HISTORICO                                    VALOR          JUROS         TOTAL
		
				cDebitos_CFlorianopolis.put("seq", new Integer[] {1,5});
				cDebitos_CFlorianopolis.put("dam", new Integer[] {6,20});
				cDebitos_CFlorianopolis.put("ano", new Integer[] {21,26});
				cDebitos_CFlorianopolis.put("data_Venc", new Integer[] {27,38});
				cDebitos_CFlorianopolis.put("processo", new Integer[] {39,52});
				cDebitos_CFlorianopolis.put("historico", new Integer[] {53,90});
				cDebitos_CFlorianopolis.put("valor", new Integer[] {91,104});
				cDebitos_CFlorianopolis.put("juros", new Integer[] {105,118});			
				cDebitos_CFlorianopolis.put("total", new Integer[] {119,132});
		 
		
		//DAM           CMC/INSCRICAO          DATA  VENC PROCESSO       TIPO         HISTORICO		
		cDebitos_C1_L1Florianopolis.put("dam", new Integer[] {1,19});
		cDebitos_C1_L1Florianopolis.put("inscricao", new Integer[] {20,42});		
		cDebitos_C1_L1Florianopolis.put("data_Venc", new Integer[] {43,53});
		cDebitos_C1_L1Florianopolis.put("processo", new Integer[] {54,68});
		cDebitos_C1_L1Florianopolis.put("tipo", new Integer[] {69,81});		
		cDebitos_C1_L1Florianopolis.put("historico", new Integer[] {82,132});
		adicionaMap2();
		
		
	
	}

	public static Map<String, Integer[]> getcDebitos_A_A2Florianopolis() {
		return cDebitos_A_A2Florianopolis;
	}

	public static void setcDebitos_A_A2Florianopolis(Map<String, Integer[]> cDebitos_A_A2Florianopolis) {
		ProtocoloController_ControlesGerais_J.cDebitos_A_A2Florianopolis = cDebitos_A_A2Florianopolis;
	}

	public static Map<String, Integer[]> getcDebitos_B_IFlorianopolis() {
		return cDebitos_B_IFlorianopolis;
	}

	public static void setcDebitos_B_IFlorianopolis(Map<String, Integer[]> cDebitos_B_IFlorianopolis) {
		ProtocoloController_ControlesGerais_J.cDebitos_B_IFlorianopolis = cDebitos_B_IFlorianopolis;
	}

	public static Map<String, Integer[]> getcDebitos_B1_I1Florianopolis() {
		return cDebitos_B1_I1Florianopolis;
	}

	public static void setcDebitos_B1_I1Florianopolis(Map<String, Integer[]> cDebitos_B1_I1Florianopolis) {
		ProtocoloController_ControlesGerais_J.cDebitos_B1_I1Florianopolis = cDebitos_B1_I1Florianopolis;
	}

	public static Map<String, Integer[]> getcDebitos_CFlorianopolis() {
		return cDebitos_CFlorianopolis;
	}

	public static void setcDebitos_CFlorianopolis(Map<String, Integer[]> cDebitos_CFlorianopolis) {
		ProtocoloController_ControlesGerais_J.cDebitos_CFlorianopolis = cDebitos_CFlorianopolis;
	}

	public static Map<String, Integer[]> getcDebitos_C1_L1Florianopolis() {
		return cDebitos_C1_L1Florianopolis;
	}

	public static void setcDebitos_C1_L1Florianopolis(Map<String, Integer[]> cDebitos_C1_L1Florianopolis) {
		ProtocoloController_ControlesGerais_J.cDebitos_C1_L1Florianopolis = cDebitos_C1_L1Florianopolis;
	}

	
		
}

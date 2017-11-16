package model.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_J;

public enum Enum_Aux_Tipo_Conferencia {
	
	INSCRICACAO_INEXISTENTE("Inscricao Inexistente.","",true,0,null),
	SEM_DEBITOS_PENDENTES("SEM DEBITOS PENDENTES NA DATA DE EMISSAO","",true,0,null),
	CPF_CNPJ_INVALIDO("CNPJ/CPF Inv&aacutelido","",true,0,null),	
	A_TRIBUTOS_IMOBILIARIOS("A - TRIB. IMOBILIARIOS - PARCELAS ANUAIS: *** R$ ***","SUB-TOTAL ...................",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_A_A2Florianopolis()),
	A2_IPTU_ENGLOBADO("A.2 - IPTU ENGLOBADO","",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_A_A2Florianopolis()),
	B_DIVIDA_ATIVA_DE_TRIBUTOS("B - DIVIDA ATIVA DE TRIB. IMOBILIARIOS: *** EM R$ ***","TOTAL DE DIVIDA ATIVA DE TRIB. IMOBILIARIOS EM ABERTO ..............",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_B_IFlorianopolis()),
	B1_PROCESSOS_DA_DIVIDA_ATIVA_AJUIZADA("B.1 - PROCESSOS DA DIVIDA AJUIZADA","",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_B1_I1Florianopolis()),
	C_PARCELAMENTO_DE_TRIBUTOS("C - PARCELAMENTO DE TRIB. IMOBILIARIOS: *** EM R$ ***","SUB-TOTAL",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_CFlorianopolis()),
	C1_DIVIDA_REFERENTE_AO_PARCELAMENTO("C.1 - DIVIDA(S) REFERENTE AO PARCELAMENTO","",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_C1_L1Florianopolis()),
	D_DEBITOS_DE_ITBI("D - DEBITOS DE I.T.B.I.","SUB-TOTAL ...............",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_DFlorianopolis()),
	J_PARCELAMENTO_JUDICIAL("J - PARCELAMENTO JUDICIAL","TOTAL DO PARCELAMENTO JUDICIAL",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_JFlorianopolis()),
	J1_DIVIDA_REFERENTE_AO_PARCELAMENTO_JUDICIAL("J.1 - DIVIDA(S) REFERENTE AO PARCELAMENTO JUDICIAL","TOTAL DA(S) DIVIDA(S) PARCELADA(S)",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_J1Florianopolis()),
	G_DEBITOS_DE_TRIBUTOS_DIVERSOS("G - DEBITOS DE TRIBUTOS DIVERSOS: *** EM R$ ***","SUB-TOTAL",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_GFlorianopolis()),
	I_DEBITOS_DE_DIVIDA_ATIVA_DE_TRIB_MOBILIARIOS_TRIBUTOS_MOTILIARIOS_TRIBUTOS_DIVERSOS_PARC_UNIFICADO("I - DEBITOS DE DIVIDA ATIVA DE TRIB. MOBILIARIOS/TRIBUTOS DIVERSOS/PARC. UNIFICADO: *** EM R$ ***","TOTAL DE DIVIDA ATIVA DE TRIB. MOBILIARIOS/DIVERSOS EM ABERTO ......",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_B_IFlorianopolis()),
	I1_PROCESSOS_DA_DIVIDA_AJUIZADA("I.1 - PROCESSOS DA DIVIDA AJUIZADA","",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_B1_I1Florianopolis()),
	L_PARCELAMENTO_UNIFICADO("L - PARCELAMENTO UNIFICADO *** EM R$ ***","TOTAL DO PARCELAMENTO UNIFICADO ...................................",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_LFlorianopolis()),
	L1_DIVIDA_REFERENTE_AO_PARCELAMENTO("L.1 - DIVIDA(S) REFERENTE AO PARCELAMENTO","",false,3,ProtocoloController_ControlesGerais_J.getcDebitos_C1_L1Florianopolis()),
	PROPRIETARIO_ANTERIOR_DA_INSCRICAO_IMOBILIARIA("*** PROPRIETARIO ANTERIOR DA INSCRICAO IMOBILIARIA","",false,0,null),
	RETORNOSVARIADOS("RETORNOS VARIADOS","RETORNOS VARIADOS",false,0,null);
	private String cabecalho;
	private String rodape;
	private boolean prioritario;
	private int saltaLinha;
	private Map<String , Integer[]> map;
	
	Enum_Aux_Tipo_Conferencia(String cabecalho,String rodape, boolean prioritario,int saltaLinha,Map<String , Integer[]> map){
		this.cabecalho = cabecalho;
		this.rodape = rodape;
		this.prioritario = prioritario;
		this.saltaLinha = saltaLinha;
		this.map = map;
	}
	public static List<Enum_Aux_Tipo_Conferencia> retornaAsPrioritarias(boolean prioritario){
		List<Enum_Aux_Tipo_Conferencia> l = new ArrayList<>();
		for (Enum_Aux_Tipo_Conferencia e : Enum_Aux_Tipo_Conferencia.values()) {
			if(e.isPrioritario() == prioritario )
				l.add(e);
		}
		return l;
	}

	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}

	public String getRodape() {
		return rodape;
	}

	public void setRodape(String rodape) {
		this.rodape = rodape;
	}

	public boolean isPrioritario() {
		return prioritario;
	}

	public void setPrioritario(boolean prioritario) {
		this.prioritario = prioritario;
	}
	public int getSaltaLinha() {
		return saltaLinha;
	}
	public void setSaltaLinha(int saltaLinha) {
		this.saltaLinha = saltaLinha;
	}
	public Map<String, Integer[]> getMap() {
		return map;
	}
	public void setMap(Map<String, Integer[]> map) {
		this.map = map;
	}

	

	       

}

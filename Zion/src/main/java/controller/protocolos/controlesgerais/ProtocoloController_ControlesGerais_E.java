package controller.protocolos.controlesgerais;

import java.util.ArrayList;
import java.util.List;

import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Servicos_Composicoes;
import model.enums.Enum_Aux_Servicos_Restricoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;

public class ProtocoloController_ControlesGerais_E {
	protected static int nLista = 1;	
	protected static int MesAnt = 0;		
	protected static int MesAtual = 0;
	protected static Enum_Aux_Servicos_Classificacoes ServicosClassificacoes;
	protected static Enum_Aux_Servicos_Restricoes servicosrestricoes;
	protected static Enum_Aux_Servicos_Sub_Classificacoes servicosSubClassificacoes;
	
	protected static List<Enum_Aux_Servicos_Classificacoes> listaClassificacoes = new ArrayList<>();
	protected static List<Enum_Aux_Servicos_Sub_Classificacoes> listaSubClassificacoes = new ArrayList<>();
	protected static List<Enum_Aux_Servicos_Restricoes> listaRestricoes = new ArrayList<>();
	protected static List<Enum_Aux_Servicos_Composicoes> listaComposicoes = new ArrayList<>();	 
	protected static Thread sync = new Thread();
	
	public static void setnLista(int nLista) {
		ProtocoloController_ControlesGerais_E.nLista = nLista;
	}
	public static int getMesAnt() {
		return MesAnt;
	}
	public static void setMesAnt(int mesAnt) {
		MesAnt = mesAnt;
	}
	public static int getMesAtual() {
		return MesAtual;
	}
	public static void setMesAtual(int mesAtual) {
		MesAtual = mesAtual;
	}
	public static Enum_Aux_Servicos_Classificacoes getServicosClassificacoes() {
		return ServicosClassificacoes;
	}
	public static void setServicosClassificacoes(Enum_Aux_Servicos_Classificacoes servicosClassificacoes) {
		ServicosClassificacoes = servicosClassificacoes;
	}
	public static Enum_Aux_Servicos_Restricoes getServicosrestricoes() {
		return servicosrestricoes;
	}
	public static void setServicosrestricoes(Enum_Aux_Servicos_Restricoes servicosrestricoes) {
		ProtocoloController_ControlesGerais_E.servicosrestricoes = servicosrestricoes;
	}
	public static Enum_Aux_Servicos_Sub_Classificacoes getServicosSubClassificacoes() {
		return servicosSubClassificacoes;
	}
	public static void setServicosSubClassificacoes(Enum_Aux_Servicos_Sub_Classificacoes servicosSubClassificacoes) {
		ProtocoloController_ControlesGerais_E.servicosSubClassificacoes = servicosSubClassificacoes;
	}
	
	public static List<Enum_Aux_Servicos_Classificacoes> getListaClassificacoes() {
		return listaClassificacoes;
	}
	public static void setListaClassificacoes(List<Enum_Aux_Servicos_Classificacoes> listaClassificacoes) {
		ProtocoloController_ControlesGerais_E.listaClassificacoes = listaClassificacoes;
	}
	public static List<Enum_Aux_Servicos_Sub_Classificacoes> getListaSubClassificacoes() {
		return listaSubClassificacoes;
	}
	public static void setListaSubClassificacoes(List<Enum_Aux_Servicos_Sub_Classificacoes> listaSubClassificacoes) {
		ProtocoloController_ControlesGerais_E.listaSubClassificacoes = listaSubClassificacoes;
	}
	public static List<Enum_Aux_Servicos_Restricoes> getListaRestricoes() {
		return listaRestricoes;
	}
	public static void setListaRestricoes(List<Enum_Aux_Servicos_Restricoes> listaRestricoes) {
		ProtocoloController_ControlesGerais_E.listaRestricoes = listaRestricoes;
	}
	public static List<Enum_Aux_Servicos_Composicoes> getListaComposicoes() {
		return listaComposicoes;
	}
	public static void setListaComposicoes(List<Enum_Aux_Servicos_Composicoes> listaComposicoes) {
		ProtocoloController_ControlesGerais_E.listaComposicoes = listaComposicoes;
	}
	public static Thread getSync() {
		return sync;
	}
	public static void setSync(Thread sync) {
		ProtocoloController_ControlesGerais_E.sync = sync;
	}
	public static int getnLista() {
		return nLista;
	}	
}

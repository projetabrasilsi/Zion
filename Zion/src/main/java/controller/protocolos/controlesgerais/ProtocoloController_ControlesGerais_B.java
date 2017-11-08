package controller.protocolos.controlesgerais;

import java.util.List;

import model.entities.Comparativos;
import model.entities.ProtocolosdeServicos;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Servicos_Composicoes;

public class ProtocoloController_ControlesGerais_B  extends ProtocoloController_ControlesGerais_C {
	
	protected static boolean finalizado = false;	
	protected static boolean ok = false;
	protected static boolean escolhido = false;
	protected static Enum_Aux_Servicos_Composicoes enum_Aux_Servicos_Composicoes;
	protected static Enum_Aux_Servicos_Composicoes ComposicaoServicosNavega;
	protected static List<ProtocolosdeServicos_Detalhe> protocolosdeServicos_DetalheLista;
	protected static ProtocolosdeServicos protocolosdeServicos = null;
	protected static List<Comparativos> comparativos_1;
	public static boolean isFinalizado() {
		return finalizado;
	}
	public static void setFinalizado(boolean finalizado) {
		ProtocoloController_ControlesGerais_B.finalizado = finalizado;
	}
	public static boolean isOk() {
		return ok;
	}
	public static void setOk(boolean ok) {
		ProtocoloController_ControlesGerais_B.ok = ok;
	}
	public static boolean isEscolhido() {
		return escolhido;
	}
	public static void setEscolhido(boolean escolhido) {
		ProtocoloController_ControlesGerais_B.escolhido = escolhido;
	}
	
	public static Enum_Aux_Servicos_Composicoes getComposicaoServicosNavega() {
		return ComposicaoServicosNavega;
	}
	public static void setComposicaoServicosNavega(Enum_Aux_Servicos_Composicoes composicaoServicosNavega) {
		ComposicaoServicosNavega = composicaoServicosNavega;
	}
	public static List<ProtocolosdeServicos_Detalhe> getProtocolosdeServicos_DetalheLista() {
		return protocolosdeServicos_DetalheLista;
	}
	public static void setProtocolosdeServicos_DetalheLista(
			List<ProtocolosdeServicos_Detalhe> protocolosdeServicos_DetalheLista) {
		ProtocoloController_ControlesGerais_B.protocolosdeServicos_DetalheLista = protocolosdeServicos_DetalheLista;
	}
	public static ProtocolosdeServicos getProtocolosdeServicos() {
		return protocolosdeServicos;
	}
	public static void setProtocolosdeServicos(ProtocolosdeServicos protocolosdeServicos) {
		ProtocoloController_ControlesGerais_B.protocolosdeServicos = protocolosdeServicos;
	}
	public static List<Comparativos> getComparativos_1() {
		return comparativos_1;
	}
	public static void setComparativos_1(List<Comparativos> comparativos_1) {
		ProtocoloController_ControlesGerais_B.comparativos_1 = comparativos_1;
	}
	public static Enum_Aux_Servicos_Composicoes getEnum_Aux_Servicos_Composicoes() {
		return enum_Aux_Servicos_Composicoes;
	}
	public static void setEnum_Aux_Servicos_Composicoes(Enum_Aux_Servicos_Composicoes enum_Aux_Servicos_Composicoes) {
		ProtocoloController_ControlesGerais_B.enum_Aux_Servicos_Composicoes = enum_Aux_Servicos_Composicoes;
	}
		
	
	
		
}

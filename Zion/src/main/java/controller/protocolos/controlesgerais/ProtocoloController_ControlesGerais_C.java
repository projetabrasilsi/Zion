package controller.protocolos.controlesgerais;

import java.io.File;
import java.util.List;

import javafx.stage.FileChooser;
import model.entities.Comparativos;
import model.entities.ProtocolosdeServicos;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Servicos_Composicoes;

public class ProtocoloController_ControlesGerais_C extends ProtocoloController_ControlesGerais_D {

	protected static boolean finalizado = false;
	protected static boolean ok = false;
	protected static boolean escolhido = false;
	protected static Enum_Aux_Servicos_Composicoes enum_Aux_Servicos_Composicoes;
	protected static List<ProtocolosdeServicos_Detalhe> protocolosdeServicos_DetalheLista;
	protected static ProtocolosdeServicos protocolosdeServicos = null;
	protected static List<Comparativos> comparativos_1;
	protected static List<Comparativos> comparativos_2;
	protected static FileChooser fileChooser;
	protected static File selectedFile;
	protected static String textoResposta;

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

	public static List<Comparativos> getComparativos_2() {
		return comparativos_2;
	}

	public static void setComparativos_2(List<Comparativos> comparativos_2) {
		ProtocoloController_ControlesGerais_C.comparativos_2 = comparativos_2;
	}

	public static FileChooser getFileChooser() {
		return fileChooser;
	}

	public static void setFileChooser(FileChooser fileChooser) {
		ProtocoloController_ControlesGerais_C.fileChooser = fileChooser;
	}

	public static File getSelectedFile() {
		return selectedFile;
	}

	public static void setSelectedFile(File selectedFile) {
		ProtocoloController_ControlesGerais_C.selectedFile = selectedFile;
	}

	public static String getTextoResposta() {
		return textoResposta;
	}

	public static void setTextoResposta(String textoResposta) {
		ProtocoloController_ControlesGerais_C.textoResposta = textoResposta;
	}

}

package controller.protocolos.controlesgerais;

import java.io.File;
import java.util.List;

import javafx.stage.FileChooser;
import model.entities.Comparativos;

public class ProtocoloController_ControlesGerais_C extends ProtocoloController_ControlesGerais_D{
	protected static List<Comparativos> comparativos_2;
	protected static List<Comparativos> comparativos_Join;
	protected static FileChooser fileChooser;
	protected static File selectedFile;
	protected static String textoResposta;	
	protected static int mesAnt = 0;
	protected static int mesAtual = 0;
	protected static int ano = 0;
	protected static int mes = 0;
	protected static int anoAnt = 0;
	protected static int anoAtual = 0;	
	protected static int nLista = 1;
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
	public static int getMesAnt() {
		return mesAnt;
	}
	public static void setMesAnt(int mesAnt) {
		ProtocoloController_ControlesGerais_C.mesAnt = mesAnt;
	}
	public static int getMesAtual() {
		return mesAtual;
	}
	public static void setMesAtual(int mesAtual) {
		ProtocoloController_ControlesGerais_C.mesAtual = mesAtual;
	}
	public static int getAno() {
		return ano;
	}
	public static void setAno(int ano) {
		ProtocoloController_ControlesGerais_C.ano = ano;
	}
	public static int getMes() {
		return mes;
	}
	public static void setMes(int mes) {
		ProtocoloController_ControlesGerais_C.mes = mes;
	}
	public static int getAnoAnt() {
		return anoAnt;
	}
	public static void setAnoAnt(int anoAnt) {
		ProtocoloController_ControlesGerais_C.anoAnt = anoAnt;
	}
	public static int getAnoAtual() {
		return anoAtual;
	}
	public static void setAnoAtual(int anoAtual) {
		ProtocoloController_ControlesGerais_C.anoAtual = anoAtual;
	}
	public static int getnLista() {
		return nLista;
	}
	public static void setnLista(int nLista) {
		ProtocoloController_ControlesGerais_C.nLista = nLista;
	}
	public static List<Comparativos> getComparativos_Join() {
		return comparativos_Join;
	}
	public static void setComparativos_Join(List<Comparativos> comparativos_Join) {
		ProtocoloController_ControlesGerais_C.comparativos_Join = comparativos_Join;
	}
	
}

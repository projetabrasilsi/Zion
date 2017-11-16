package controller.protocolos.controlesgerais;

import java.util.List;

import model.entities.Comparativos;

public class ProtocoloController_ControlesGerais_D extends ProtocoloController_ControlesGerais_E {
	protected static int mesAnt = 0;
	protected static int mesAtual = 0;
	protected static int ano = 0;
	protected static int mes = 0;
	protected static int anoAnt = 0;
	protected static int anoAtual = 0;
	protected static int nLista = 1;
	protected static List<Comparativos> comparativos_Join;
	protected static int nTotalReg = 0;
	protected static int nRegAnt = 0;
	protected static int nRegAtual = 0;
	protected static double vlTot = 0;

	public static int getMesAnt() {
		return mesAnt;
	}

	public static void setMesAnt(int mesAnt) {
		ProtocoloController_ControlesGerais_D.mesAnt = mesAnt;
	}

	public static int getMesAtual() {
		return mesAtual;
	}

	public static void setMesAtual(int mesAtual) {
		ProtocoloController_ControlesGerais_D.mesAtual = mesAtual;
	}

	public static int getAno() {
		return ano;
	}

	public static void setAno(int ano) {
		ProtocoloController_ControlesGerais_D.ano = ano;
	}

	public static int getMes() {
		return mes;
	}

	public static void setMes(int mes) {
		ProtocoloController_ControlesGerais_D.mes = mes;
	}

	public static int getAnoAnt() {
		return anoAnt;
	}

	public static void setAnoAnt(int anoAnt) {
		ProtocoloController_ControlesGerais_D.anoAnt = anoAnt;
	}

	public static int getAnoAtual() {
		return anoAtual;
	}

	public static void setAnoAtual(int anoAtual) {
		ProtocoloController_ControlesGerais_D.anoAtual = anoAtual;
	}

	public static int getnLista() {
		return nLista;
	}

	public static void setnLista(int nLista) {
		ProtocoloController_ControlesGerais_D.nLista = nLista;
	}

	public static List<Comparativos> getComparativos_Join() {
		return comparativos_Join;
	}

	public static void setComparativos_Join(List<Comparativos> comparativos_Join) {
		ProtocoloController_ControlesGerais_D.comparativos_Join = comparativos_Join;
	}

	public static int getnTotalReg() {
		return nTotalReg;
	}

	public static void setnTotalReg(int nTotalReg) {
		ProtocoloController_ControlesGerais_D.nTotalReg = nTotalReg;
	}

	public static int getnRegAnt() {
		return nRegAnt;
	}

	public static void setnRegAnt(int nRegAnt) {
		ProtocoloController_ControlesGerais_D.nRegAnt = nRegAnt;
	}

	public static int getnRegAtual() {
		return nRegAtual;
	}

	public static void setnRegAtual(int nRegAtual) {
		ProtocoloController_ControlesGerais_D.nRegAtual = nRegAtual;
	}

	public static double getVlTot() {
		return vlTot;
	}

	public static void setVlTot(double vlTot) {
		ProtocoloController_ControlesGerais_D.vlTot = vlTot;
	}

}

package controller.protocolos.controlesgerais;

public class ProtocoloController_ControlesGerais_G extends ProtocoloController_ControlesGerais_H {
	protected static double aquisicaoPercentual = 0;
	protected static double crescimentoPercentual = 0;
	protected static double novosPercentual = 0;
	protected static double permaneceuPercentual = 0;
	protected static double nRegAtualPerc = 0;
	protected static double nRegAntPerc = 0;
	protected static double nRegAumentouValorPerc = 0;
	protected static double nRegDiminuiValorPerc = 0;
	protected static double nRegPermaneceuValorPerc = 0;
	protected static double vlTotAtual = 0;
	protected static int nRegSomenteAnt = 0;
	protected static int nRegSomenteAtual = 0;
	protected static Thread sync = new Thread();

	public static double getAquisicaoPercentual() {
		return aquisicaoPercentual;
	}

	public static void setAquisicaoPercentual(double aquisicaoPercentual) {
		ProtocoloController_ControlesGerais_G.aquisicaoPercentual = aquisicaoPercentual;
	}

	public static double getCrescimentoPercentual() {
		return crescimentoPercentual;
	}

	public static void setCrescimentoPercentual(double crescimentoPercentual) {
		ProtocoloController_ControlesGerais_G.crescimentoPercentual = crescimentoPercentual;
	}

	public static double getNovosPercentual() {
		return novosPercentual;
	}

	public static void setNovosPercentual(double novosPercentual) {
		ProtocoloController_ControlesGerais_G.novosPercentual = novosPercentual;
	}

	public static double getPermaneceuPercentual() {
		return permaneceuPercentual;
	}

	public static void setPermaneceuPercentual(double permaneceuPercentual) {
		ProtocoloController_ControlesGerais_G.permaneceuPercentual = permaneceuPercentual;
	}

	public static double getnRegAtualPerc() {
		return nRegAtualPerc;
	}

	public static void setnRegAtualPerc(double nRegAtualPerc) {
		ProtocoloController_ControlesGerais_G.nRegAtualPerc = nRegAtualPerc;
	}

	public static double getnRegAntPerc() {
		return nRegAntPerc;
	}

	public static void setnRegAntPerc(double nRegAntPerc) {
		ProtocoloController_ControlesGerais_G.nRegAntPerc = nRegAntPerc;
	}

	public static double getnRegAumentouValorPerc() {
		return nRegAumentouValorPerc;
	}

	public static void setnRegAumentouValorPerc(double nRegAumentouValorPerc) {
		ProtocoloController_ControlesGerais_G.nRegAumentouValorPerc = nRegAumentouValorPerc;
	}

	public static double getnRegDiminuiValorPerc() {
		return nRegDiminuiValorPerc;
	}

	public static void setnRegDiminuiValorPerc(double nRegDiminuiValorPerc) {
		ProtocoloController_ControlesGerais_G.nRegDiminuiValorPerc = nRegDiminuiValorPerc;
	}

	public static double getnRegPermaneceuValorPerc() {
		return nRegPermaneceuValorPerc;
	}

	public static void setnRegPermaneceuValorPerc(double nRegPermaneceuValorPerc) {
		ProtocoloController_ControlesGerais_G.nRegPermaneceuValorPerc = nRegPermaneceuValorPerc;
	}

	public static double getVlTotAtual() {
		return vlTotAtual;
	}

	public static void setVlTotAtual(double vlTotAtual) {
		ProtocoloController_ControlesGerais_G.vlTotAtual = vlTotAtual;
	}

	public static int getnRegSomenteAnt() {
		return nRegSomenteAnt;
	}

	public static void setnRegSomenteAnt(int nRegSomenteAnt) {
		ProtocoloController_ControlesGerais_G.nRegSomenteAnt = nRegSomenteAnt;
	}

	public static int getnRegSomenteAtual() {
		return nRegSomenteAtual;
	}

	public static void setnRegSomenteAtual(int nRegSomenteAtual) {
		ProtocoloController_ControlesGerais_G.nRegSomenteAtual = nRegSomenteAtual;
	}

	public static Thread getSync() {
		return sync;
	}

	public static void setSync(Thread sync) {
		ProtocoloController_ControlesGerais_G.sync = sync;
	}

}

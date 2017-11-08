package controller.protocolos.controlesgerais;

public class ProtocoloController_ControlesGerais_D extends ProtocoloController_ControlesGerais_E{
	protected static int nTotalReg = 0;	
	protected static int nRegAnt = 0;	
	protected static int nRegAtual = 0;
	protected static double vlTot = 0;
	protected static double vlTotAnt = 0;	
	protected static double vlTotAtual = 0;
	protected static int nRegSomenteAnt = 0;
	protected static int nRegSomenteAtual = 0;
	protected static int nRegPermanentes = 0;
	protected static double vlTotSomenteAnt = 0;
	protected static double vlTotSomenteAtual = 0;
	protected static double vlTotPermaneceu = 0;
	protected static double vlTotAumentou = 0;
	protected static double vlTotDiminuiu = 0;
	
	protected static int nRegAumentouValor = 0;
	protected static int nRegDiminuiValor = 0;
	protected static int nRegPermaneceuValor = 0;
	protected static double vlTotPermaneceuValor = 0;
	protected static double vlTotDifInflacao = 0;
	protected static double vlTotDifDeflacao = 0;
	
	protected static double CarteiraDiferencaInflacao = 0;
	protected static double CarteiraDiferencaDeflacao = 0;
	protected static double CarteiraClientesNovos = 0;
	protected static double CarteiraClientesBaixados = 0;
	protected static double CarteiraResultadoA = 0;
	protected static double CarteiraResultadoB = 0;
	protected static double CarteiraResultadoFinal = 0;
	protected static double CarteiraResultadoPercentualFinal = 0;
    protected static int crescimento = 0;
    protected static double perdaPercentual = 0;
    protected static double aquisicaoPercentual = 0;
    protected static double crescimentoPercentual = 0;
    protected static double novosPercentual = 0;
    protected static double permaneceuPercentual = 0;
    protected static double nRegAtualPerc = 0;
    protected static double nRegAntPerc = 0;
    protected static double nRegAumentouValorPerc = 0;
    protected static double nRegDiminuiValorPerc = 0;
    protected static double nRegPermaneceuValorPerc = 0;
	
	
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
	public static double getVlTotAnt() {
		return vlTotAnt;
	}
	public static void setVlTotAnt(double vlTotAnt) {
		ProtocoloController_ControlesGerais_D.vlTotAnt = vlTotAnt;
	}
	public static double getVlTotAtual() {
		return vlTotAtual;
	}
	public static void setVlTotAtual(double vlTotAtual) {
		ProtocoloController_ControlesGerais_D.vlTotAtual = vlTotAtual;
	}
	public static int getnRegSomenteAnt() {
		return nRegSomenteAnt;
	}
	public static void setnRegSomenteAnt(int nRegSomenteAnt) {
		ProtocoloController_ControlesGerais_D.nRegSomenteAnt = nRegSomenteAnt;
	}
	public static int getnRegSomenteAtual() {
		return nRegSomenteAtual;
	}
	public static void setnRegSomenteAtual(int nRegSomenteAtual) {
		ProtocoloController_ControlesGerais_D.nRegSomenteAtual = nRegSomenteAtual;
	}
	public static int getnRegPermanentes() {
		return nRegPermanentes;
	}
	public static void setnRegPermanentes(int nRegPermanentes) {
		ProtocoloController_ControlesGerais_D.nRegPermanentes = nRegPermanentes;
	}
	public static double getVlTotSomenteAnt() {
		return vlTotSomenteAnt;
	}
	public static void setVlTotSomenteAnt(double vlTotSomenteAnt) {
		ProtocoloController_ControlesGerais_D.vlTotSomenteAnt = vlTotSomenteAnt;
	}
	public static double getVlTotSomenteAtual() {
		return vlTotSomenteAtual;
	}
	public static void setVlTotSomenteAtual(double vlTotSomenteAtual) {
		ProtocoloController_ControlesGerais_D.vlTotSomenteAtual = vlTotSomenteAtual;
	}

	public static void setnRegAumentouValor(int nRegAumentouValor) {
		ProtocoloController_ControlesGerais_D.nRegAumentouValor = nRegAumentouValor;
	}
	public static int getnRegDiminuiValor() {
		return nRegDiminuiValor;
	}
	public static void setnRegDiminuiValor(int nRegDiminuiValor) {
		ProtocoloController_ControlesGerais_D.nRegDiminuiValor = nRegDiminuiValor;
	}
	
	public static double getVlTotAumentou() {
		return vlTotAumentou;
	}
	public static void setVlTotAumentou(double vlTotAumentou) {
		ProtocoloController_ControlesGerais_D.vlTotAumentou = vlTotAumentou;
	}
	public static double getVlTotDiminuiu() {
		return vlTotDiminuiu;
	}
	public static void setVlTotDiminuiu(double vlTotDiminuiu) {
		ProtocoloController_ControlesGerais_D.vlTotDiminuiu = vlTotDiminuiu;
	}
	public static double getVlTotPermaneceu() {
		return vlTotPermaneceu;
	}
	public static void setVlTotPermaneceu(double vlTotPermaneceu) {
		ProtocoloController_ControlesGerais_D.vlTotPermaneceu = vlTotPermaneceu;
	}
	public static int getnRegAumentouValor() {
		return nRegAumentouValor;
	}
	@Override
	public String toString() {
		return "ProtocoloController_ControlesGerais_D []";
	}
	public static int getnRegPermaneceuValor() {
		return nRegPermaneceuValor;
	}
	public static void setnRegPermaneceuValor(int nRegPermaneceuValor) {
		ProtocoloController_ControlesGerais_D.nRegPermaneceuValor = nRegPermaneceuValor;
	}
	public static double getVlTotPermaneceuValor() {
		return vlTotPermaneceuValor;
	}
	public static void setVlTotPermaneceuValor(double vlTotPermaneceuValor) {
		ProtocoloController_ControlesGerais_D.vlTotPermaneceuValor = vlTotPermaneceuValor;
	}
	public static double getVlTotDifInflacao() {
		return vlTotDifInflacao;
	}
	public static void setVlTotDifInflacao(double vlTotDifInflacao) {
		ProtocoloController_ControlesGerais_D.vlTotDifInflacao = vlTotDifInflacao;
	}
	public static double getVlTotDifDeflacao() {
		return vlTotDifDeflacao;
	}
	public static void setVlTotDifDeflacao(double vlTotDifDeflacao) {
		ProtocoloController_ControlesGerais_D.vlTotDifDeflacao = vlTotDifDeflacao;
	}
	public static double getCarteiraDiferencaInflacao() {
		return CarteiraDiferencaInflacao;
	}
	public static void setCarteiraDiferencaInflacao(double carteiraDiferencaInflacao) {
		CarteiraDiferencaInflacao = carteiraDiferencaInflacao;
	}
	public static double getCarteiraDiferencaDeflacao() {
		return CarteiraDiferencaDeflacao;
	}
	public static void setCarteiraDiferencaDeflacao(double carteiraDiferencaDeflacao) {
		CarteiraDiferencaDeflacao = carteiraDiferencaDeflacao;
	}
	public static double getCarteiraClientesNovos() {
		return CarteiraClientesNovos;
	}
	public static void setCarteiraClientesNovos(double carteiraClientesNovos) {
		CarteiraClientesNovos = carteiraClientesNovos;
	}
	public static double getCarteiraClientesBaixados() {
		return CarteiraClientesBaixados;
	}
	public static void setCarteiraClientesBaixados(double carteiraClientesBaixados) {
		CarteiraClientesBaixados = carteiraClientesBaixados;
	}
	public static double getCarteiraResultadoA() {
		return CarteiraResultadoA;
	}
	public static void setCarteiraResultadoA(double carteiraResultadoA) {
		CarteiraResultadoA = carteiraResultadoA;
	}
	public static double getCarteiraResultadoB() {
		return CarteiraResultadoB;
	}
	public static void setCarteiraResultadoB(double carteiraResultadoB) {
		CarteiraResultadoB = carteiraResultadoB;
	}
	public static double getCarteiraResultadoFinal() {
		return CarteiraResultadoFinal;
	}
	public static void setCarteiraResultadoFinal(double carteiraResultadoFinal) {
		CarteiraResultadoFinal = carteiraResultadoFinal;
	}
	public static double getCarteiraResultadoPercentualFinal() {
		return CarteiraResultadoPercentualFinal;
	}
	public static void setCarteiraResultadoPercentualFinal(double carteiraResultadoPercentualFinal) {
		CarteiraResultadoPercentualFinal = carteiraResultadoPercentualFinal;
	}
	public static int getCrescimento() {
		return crescimento;
	}
	public static void setCrescimento(int crescimento) {
		ProtocoloController_ControlesGerais_D.crescimento = crescimento;
	}
	public static double getPerdaPercentual() {
		return perdaPercentual;
	}
	public static void setPerdaPercentual(double perdaPercentual) {
		ProtocoloController_ControlesGerais_D.perdaPercentual = perdaPercentual;
	}
	public static double getAquisicaoPercentual() {
		return aquisicaoPercentual;
	}
	public static void setAquisicaoPercentual(double aquisicaoPercentual) {
		ProtocoloController_ControlesGerais_D.aquisicaoPercentual = aquisicaoPercentual;
	}
	public static double getCrescimentoPercentual() {
		return crescimentoPercentual;
	}
	public static void setCrescimentoPercentual(double crescimentoPercentual) {
		ProtocoloController_ControlesGerais_D.crescimentoPercentual = crescimentoPercentual;
	}
	public static double getNovosPercentual() {
		return novosPercentual;
	}
	public static void setNovosPercentual(double novosPercentual) {
		ProtocoloController_ControlesGerais_D.novosPercentual = novosPercentual;
	}
	public static double getPermaneceuPercentual() {
		return permaneceuPercentual;
	}
	public static void setPermaneceuPercentual(double permaneceuPercentual) {
		ProtocoloController_ControlesGerais_D.permaneceuPercentual = permaneceuPercentual;
	}
	public static double getnRegAtualPerc() {
		return nRegAtualPerc;
	}
	public static void setnRegAtualPerc(double nRegAtualPerc) {
		ProtocoloController_ControlesGerais_D.nRegAtualPerc = nRegAtualPerc;
	}
	public static double getnRegAntPerc() {
		return nRegAntPerc;
	}
	public static void setnRegAntPerc(double nRegAntPerc) {
		ProtocoloController_ControlesGerais_D.nRegAntPerc = nRegAntPerc;
	}
	public static double getnRegAumentouValorPerc() {
		return nRegAumentouValorPerc;
	}
	public static void setnRegAumentouValorPerc(double nRegAumentouValorPerc) {
		ProtocoloController_ControlesGerais_D.nRegAumentouValorPerc = nRegAumentouValorPerc;
	}
	public static double getnRegDiminuiValorPerc() {
		return nRegDiminuiValorPerc;
	}
	public static void setnRegDiminuiValorPerc(double nRegDiminuiValorPerc) {
		ProtocoloController_ControlesGerais_D.nRegDiminuiValorPerc = nRegDiminuiValorPerc;
	}
	public static double getnRegPermaneceuValorPerc() {
		return nRegPermaneceuValorPerc;
	}
	public static void setnRegPermaneceuValorPerc(double nRegPermaneceuValorPerc) {
		ProtocoloController_ControlesGerais_D.nRegPermaneceuValorPerc = nRegPermaneceuValorPerc;
	}
	
		
}

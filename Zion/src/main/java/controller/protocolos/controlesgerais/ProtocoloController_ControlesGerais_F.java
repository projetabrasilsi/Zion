package controller.protocolos.controlesgerais;

public class ProtocoloController_ControlesGerais_F extends ProtocoloController_ControlesGerais_G {
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

	public static double getVlTotDifInflacao() {
		return vlTotDifInflacao;
	}

	public static void setVlTotDifInflacao(double vlTotDifInflacao) {
		ProtocoloController_ControlesGerais_F.vlTotDifInflacao = vlTotDifInflacao;
	}

	public static double getVlTotDifDeflacao() {
		return vlTotDifDeflacao;
	}

	public static void setVlTotDifDeflacao(double vlTotDifDeflacao) {
		ProtocoloController_ControlesGerais_F.vlTotDifDeflacao = vlTotDifDeflacao;
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
		ProtocoloController_ControlesGerais_F.crescimento = crescimento;
	}

	public static double getPerdaPercentual() {
		return perdaPercentual;
	}

	public static void setPerdaPercentual(double perdaPercentual) {
		ProtocoloController_ControlesGerais_F.perdaPercentual = perdaPercentual;
	}

}

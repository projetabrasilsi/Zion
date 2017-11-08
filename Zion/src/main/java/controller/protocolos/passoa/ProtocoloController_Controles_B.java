package controller.protocolos.passoa;

import java.util.Calendar;

import model.dao.ProtocolosdeServicosDAO;
import util.Utilidades;

public class ProtocoloController_Controles_B {
	protected ProtocolosdeServicosDAO pSDAO = new ProtocolosdeServicosDAO();
	protected Calendar tempoInicial = Utilidades.retornaCalendario();
	protected Calendar tempoFinal = Utilidades.retornaCalendario();	
	
	public Calendar getTempoInicial() {
		return tempoInicial;
	}
	public void setTempoInicial(Calendar tempoInicial) {
		this.tempoInicial = tempoInicial;
	}
	public Calendar getTempoFinal() {
		return tempoFinal;
	}
	public void setTempoFinal(Calendar tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

	
	
}

package controller.protocolos.passoa;

import java.util.Calendar;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.dao.ProtocolosdeServicosDAO;
import util.Utilidades;

public class ProtocoloController_Controles_C {
	@FXML
	protected Label lb_VlTotAnt_Value = new Label();
	@FXML
	protected Label lb_VlTotSomenteAtual_Value = new Label();
	@FXML
	protected Label lb_VlTotSomenteAnt_Value = new Label();
	@FXML
	protected Label lb_VlTotPermaneceu_Value = new Label();

	@FXML
	protected Label lb_VlTotAumentouValor_Value = new Label();

	@FXML
	protected Label lb_VlTotDiminuiValor_Value = new Label();
	@FXML
	protected Label lb_VlTotPermaneceuValor_Value = new Label();
	@FXML
	protected Label lb_DifInflacao_Value = new Label();
	@FXML
	protected Label lb_DifDeflanflacao_Value = new Label();

	@FXML
	protected Label lb_CarteiraDiferencaInflacao = new Label();
	@FXML
	protected Label lb_CarteiraDiferencaDeflacao = new Label();
	@FXML
	protected Label lb_CarteiraClientesNovos = new Label();
	@FXML
	protected Label lb_CarteiraClientesBaixados = new Label();
	@FXML
	protected Label lb_CarteiraResultadoA = new Label();
	@FXML
	protected Label lb_CarteiraResultadoB = new Label();
	@FXML
	protected Label lb_CarteiraResultadoFinal = new Label();
	@FXML
	protected Label lb_CarteiraResultadoPercentualFinal = new Label();
	@FXML
	protected Label lb_nRegDiminuiValorPerc_Value = new Label();
	@FXML
	protected Label lb_nRegAumentouValorPerc_Value = new Label();
	@FXML
	protected Label lb_nRegDiminuiuValorPerc_Value = new Label();
	protected Label lb_nRegPermaneceuValorPerc_Value = new Label();

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

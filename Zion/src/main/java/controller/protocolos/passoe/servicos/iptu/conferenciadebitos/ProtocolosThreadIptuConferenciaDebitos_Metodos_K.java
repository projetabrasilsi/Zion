package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.io.File;
import java.util.Date;
import java.util.List;

import javafx.stage.Stage;
import model.enums.Enum_Aux_Status_Consulta;
import model.enums.Enum_Aux_Tipo_Conferencia;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_K extends ProtocolosThreadIptuConferenciaDebitos_Controles {
	protected String anual = "ANUAL";
	protected String seq = "";
	protected String radicalDam = "";
	protected String tributos = "";
	protected String processo = "";
	protected String parAberto = "";
	protected double valor = 0;
	protected double multa = 0;
	protected double juros = 0;
	protected double total = 0;
	protected String seqStr = "";
	protected String radicalDamStr = "";
	protected String tributosStr = "";
	protected String processoStr = "";
	protected String parAbertoStr = "";
	protected String valorStr = "";
	protected String multaStr = "";
	protected String jurosStr = "";
	protected String totalStr = "";
	protected static int i = 0;
	protected int qtde = 0;
	protected Enum_Aux_Status_Consulta etapaAtual;
	protected String dam = "";
	protected String liv_Folha_Cert = "";
	protected String localizacao = "";
	protected String inscricao = "";
	protected String fiti = "";
	protected String cartorio = "";
	protected String nParcelamento = "";
	protected int ano = 0;
	protected String historico = "";
	protected Date data_Insc;
	protected Date data_Venc;
	protected static Integer[] inicioFim = null;
	protected static List<Enum_Aux_Tipo_Conferencia> l;
	protected static List<Enum_Aux_Tipo_Conferencia> l2;
	protected static File folder = null;
	protected void fechatela() {
		Stage stage = (Stage) bt_Fechar.getScene().getWindow();
		stage.close();
	}
	

	
}

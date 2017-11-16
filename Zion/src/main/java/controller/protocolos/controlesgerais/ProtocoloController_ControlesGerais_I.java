package controller.protocolos.controlesgerais;

import java.util.Calendar;

import model.dao.ProtocolosdeServicosDAO;
import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;
import util.Utilidades;

public class ProtocoloController_ControlesGerais_I extends ProtocoloController_ControlesGerais_J {
	protected static Enum_Aux_Servicos_Classificacoes ServicosClassificacoes;
	protected static String sequencia;
	protected static int nSeq; 
	protected static int totSeq;
	
	public static void iniciaSequencia(Enum_Aux_Servicos_Sub_Classificacoes sequencias) {
		setnSeq(1);
		setTotSeq(sequencias.getnSeq());
		setSequencia("Evolução: "+getnSeq()+"/"+getTotSeq() );
	}
	public  static void evoluisequencia() {
		setnSeq(getnSeq()+1);		
		setSequencia("Evolução: "+getnSeq()+"/"+getTotSeq() );
	}
	
	public static void salvaProtocoloServicos() {
		Calendar inicio = Calendar.getInstance();
		Calendar fim = Calendar.getInstance();
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.setUltimaAtualizacao(Utilidades.retornaCalendario());
		if (ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getId() == null
				|| ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getId() <= 0) {
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setTempoInicial(inicio);

		} else {
			inicio = ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getTempoInicial();
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setTempoFinal(fim);
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setDiferencadeTempo(
					ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getTempoFinal().getTimeInMillis()
							- ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getTempoInicial()
									.getTimeInMillis());
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
					.setDiferencadeTempoTexto(Utilidades.calculadiferencaTempo(inicio, fim));
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setEnum_Aux_Servicos_Composicoes(
					ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes());
		}
		ProtocolosdeServicosDAO dao = new ProtocolosdeServicosDAO();
		ProtocoloController_ControlesGerais_A
				.setProtocolosdeServicos(dao.merge(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()));
	}

	public static Enum_Aux_Servicos_Classificacoes getServicosClassificacoes() {
		return ServicosClassificacoes;
	}

	public static void setServicosClassificacoes(Enum_Aux_Servicos_Classificacoes servicosClassificacoes) {
		ServicosClassificacoes = servicosClassificacoes;
	}

	public static String getSequencia() {
		return sequencia;
	}

	public static int getnSeq() {
		return nSeq;
	}

	public static void setnSeq(int nSeq) {
		ProtocoloController_ControlesGerais_I.nSeq = nSeq;
	}

	public static int getTotSeq() {
		return totSeq;
	}

	public static void setTotSeq(int totSeq) {
		ProtocoloController_ControlesGerais_I.totSeq = totSeq;
	}

	public static void setSequencia(String sequencia) {
		ProtocoloController_ControlesGerais_I.sequencia = sequencia;
	}

	

}

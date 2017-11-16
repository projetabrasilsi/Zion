package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.text.ParseException;
import java.util.Map;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.entities.Inscricao_Historico_Detalhe;
import util.Utilidades;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_F extends ProtocolosThreadIptuConferenciaDebitos_Metodos_G {
	@SuppressWarnings("unused")
	protected static Inscricao_Historico_Detalhe montaCDebitos_A_A2(String linha,Inscricao_Historico_Detalhe iHD){
		String texto = "";
		Map<String , Integer[]> m =  ProtocoloController_ControlesGerais_A.getcDebitos_A_A2Florianopolis();
		String formacao = "";
		
		
		inicioFim = m.get("seq");
		texto = linha.substring(inicioFim[0], inicioFim[1]);
		formacao+=texto;
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);				
		iHD.setSeq(texto);
		
		inicioFim = m.get("radicalDam");
		texto = linha.substring(inicioFim[0], inicioFim[1]);
		formacao+=texto;
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);		
		iHD.setRadicalDam(texto);
		
		inicioFim = m.get("tributos");
		texto = linha.substring(inicioFim[0], inicioFim[1]);
		formacao+=texto;
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);		
		iHD.setTributos(texto);
		
		inicioFim = m.get("processo");		
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		formacao+=texto;
		iHD.setProcesso(texto);
		
		inicioFim = m.get("parAberto");
		texto = linha.substring(inicioFim[0], inicioFim[1]);
		formacao+=texto;
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);		
		iHD.setParAberto(texto);
		
		inicioFim = m.get("valor");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		formacao+=texto;
		iHD.setValor(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("multa");
		texto = linha.substring(inicioFim[0], inicioFim[1]);
		formacao+=texto;
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);		
		iHD.setMulta(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("juros");
		texto = linha.substring(inicioFim[0], inicioFim[1]);
		formacao+=texto;
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);		
		iHD.setJuros(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("total");
		texto = linha.substring(inicioFim[0], inicioFim[1]);
		formacao+=texto;
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);		
		iHD.setTotal(Utilidades.transformaemMoeda(texto));
		
		
		
		
		

		return iHD;		
	}
	
	protected static Inscricao_Historico_Detalhe montaCDebitos_B_I(String linha,Inscricao_Historico_Detalhe iHD){
		String texto = "";
		Map<String , Integer[]> m =  ProtocoloController_ControlesGerais_A.getcDebitos_B_IFlorianopolis();
		inicioFim = m.get("seq");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setSeq(texto);
		
		inicioFim = m.get("dam");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setDam(texto);

		inicioFim = m.get("liv_Folha_Cert");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setLiv_Folha_Cert(texto);
		
		inicioFim = m.get("data_Insc");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		try {
			iHD.setData_Insc(Utilidades.transformaStringEmData(texto,false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		inicioFim = m.get("historico");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setHistorico(texto);

		inicioFim = m.get("localizacao");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setLocalizacao(texto);
				
		inicioFim = m.get("processo");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setProcesso(texto);
		
		inicioFim = m.get("valor");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setValor(Utilidades.transformaemMoeda(texto));
		
		return iHD;
	}
	
	protected static Inscricao_Historico_Detalhe montaCDebitos_B1_I1(String linha,Inscricao_Historico_Detalhe iHD){
		String texto = "";
		Map<String , Integer[]> m =  ProtocoloController_ControlesGerais_A.getcDebitos_B1_I1Florianopolis();
		inicioFim = m.get("dam");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setDam(texto);

		inicioFim = m.get("liv_Folha_Cert");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setLiv_Folha_Cert(texto);

		inicioFim = m.get("historico");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setHistorico(texto);

		inicioFim = m.get("processo");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setProcesso(texto);
		return iHD;
		
	}
	
		
	
	
}

package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.text.ParseException;
import java.util.Map;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.entities.Inscricao_Historico_Detalhe;
import util.Utilidades;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_I extends ProtocolosThreadIptuConferenciaDebitos_Metodos_J {
	protected static Inscricao_Historico_Detalhe montaCDebitos_J(String linha,Inscricao_Historico_Detalhe iHD){
		String texto = "";
		Map<String , Integer[]> m =  ProtocoloController_ControlesGerais_A.getcDebitos_JFlorianopolis();
		
		
		inicioFim = m.get("seq");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setSeq(texto);
		
		inicioFim = m.get("dam");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setDam(texto);
		
		inicioFim = m.get("ano");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setAno(Integer.parseInt(texto));
		
		inicioFim = m.get("data_Venc");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		try {
			iHD.setData_Venc(Utilidades.transformaStringEmData(texto,false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inicioFim = m.get("processo");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setProcesso(texto);
		
		inicioFim = m.get("nParcelamento");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setnParcelamento(texto);
				
		inicioFim = m.get("valor");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setValor(Utilidades.transformaemMoeda(texto));
				
		inicioFim = m.get("juros");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setJuros(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("total");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setTotal(Utilidades.transformaemMoeda(texto));
		
		return iHD;
	}
	protected static Inscricao_Historico_Detalhe montaCDebitos_J1(String linha,Inscricao_Historico_Detalhe iHD){
		String texto = "";
		Map<String , Integer[]> m =  ProtocoloController_ControlesGerais_A.getcDebitos_J1Florianopolis();
		
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
		
		inicioFim = m.get("inscricao");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setInscricao(texto);
		
		inicioFim = m.get("valor");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setValor(Utilidades.transformaemMoeda(texto));

		return iHD;
	}

		

}

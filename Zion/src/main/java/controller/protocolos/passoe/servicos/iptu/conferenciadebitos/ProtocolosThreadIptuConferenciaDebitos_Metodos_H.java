package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.text.ParseException;
import java.util.Map;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.entities.Inscricao_Historico_Detalhe;
import util.Utilidades;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_H extends  ProtocolosThreadIptuConferenciaDebitos_Metodos_I {
	protected static Inscricao_Historico_Detalhe montaCDebitos_D(String linha,Inscricao_Historico_Detalhe iHD){
		String texto = "";
		Map<String , Integer[]> m =  ProtocoloController_ControlesGerais_A.getcDebitos_DFlorianopolis();
		
		inicioFim = m.get("seq");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setSeq(texto);
		
		inicioFim = m.get("dam");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setDam(texto);
		
		inicioFim = m.get("fiti");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setFiti(texto);
		inicioFim = m.get("data_Venc");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		try {
			iHD.setData_Venc(Utilidades.transformaStringEmData(texto,false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inicioFim = m.get("cartorio");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setCartorio(texto);
		
		inicioFim = m.get("valor");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setValor(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("multa");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setMulta(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("juros");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setJuros(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("total");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setTotal(Utilidades.transformaemMoeda(texto));
		
		return iHD;
		
	}
	protected static Inscricao_Historico_Detalhe montaCDebitos_G(String linha,Inscricao_Historico_Detalhe iHD){
		String texto = "";
		Map<String , Integer[]> m =  ProtocoloController_ControlesGerais_A.getcDebitos_GFlorianopolis();
		
		inicioFim = m.get("seq");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setSeq(texto);
		
		inicioFim = m.get("dam");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setDam(texto);
		
		
		inicioFim = m.get("processo");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setProcesso(texto);
		
		inicioFim = m.get("data_Venc");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		try {
			iHD.setData_Venc(Utilidades.transformaStringEmData(texto,false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inicioFim = m.get("tributos");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setTributos(texto);
		
		inicioFim = m.get("historico");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setHistorico(texto);
		
		inicioFim = m.get("valor");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setValor(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("multa");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setMulta(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("juros");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setJuros(Utilidades.transformaemMoeda(texto));
		
		inicioFim = m.get("total");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setTotal(Utilidades.transformaemMoeda(texto));
			
		return iHD;
	}

	
	
}

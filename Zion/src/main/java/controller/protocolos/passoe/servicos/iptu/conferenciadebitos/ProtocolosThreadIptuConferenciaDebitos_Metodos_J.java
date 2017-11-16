package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.entities.Inscricao_Historico_Detalhe;
import model.entities.Inscricao_Historico_Header;
import model.enums.Enum_Aux_Tipo_Conferencia;
import util.Utilidades;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_J extends ProtocolosThreadIptuConferenciaDebitos_Metodos_K {
	protected static Inscricao_Historico_Detalhe montaCDebitos_L(String linha, Inscricao_Historico_Detalhe iHD) {
		String texto = "";
		Map<String, Integer[]> m = ProtocoloController_ControlesGerais_A.getcDebitos_LFlorianopolis();

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
			iHD.setData_Venc(Utilidades.transformaStringEmData(texto, false));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		inicioFim = m.get("historico");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setHistorico(texto);

		inicioFim = m.get("processo");
		texto = retornaTexto(inicioFim[0], inicioFim[1], linha);
		iHD.setProcesso(texto);

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

	protected static String retornaTexto(int inicio, int fim, String linha) {
		String texto = linha.substring(inicio-1, fim);
		
		texto = texto.trim();
		return texto;
	}

	public static List<Enum_Aux_Tipo_Conferencia> checaPrioridades(boolean prioridade) {
		return Enum_Aux_Tipo_Conferencia.retornaAsPrioritarias(prioridade);
	}

	public static Inscricao_Historico_Detalhe montaIHDBase(Inscricao_Historico_Header iHH,
			Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia) {
		Inscricao_Historico_Detalhe iHD = new Inscricao_Historico_Detalhe();
		iHD.setAno(iHH.getAno_Consulta());
		iHD.setMes_Ref(iHH.getMes_Consulta());
		iHD.setAno_Ref(iHH.getAno_Consulta());
		iHD.setEnum_Aux_Tipo_Conferencia(enum_Aux_Tipo_Conferencia);
		iHD.setEnum_Aux_Servicos_Sub_Classificacoes(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao());
		iHD.setInscricao_Historico_Header(iHH);
		return iHD;
	}

	

	

}

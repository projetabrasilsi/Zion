package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import model.dao.Inscricao_Historico_HeaderDAO;
import model.entities.Conferencia_Limites;
import model.entities.Inscricao_Historico_Header;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Sim_ou_Nao;
import model.enums.Enum_Aux_Status_Consulta;
import util.Utilidades;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_E extends ProtocolosThreadIptuConferenciaDebitos_Metodos_F {

	public static Inscricao_Historico_Header constroiIHH(Conferencia_Limites cL, ProtocolosdeServicos_Detalhe pd,
			int tam, int cabecalho, int rodape) {
		Inscricao_Historico_Header iHH = new Inscricao_Historico_Header();
		Inscricao_Historico_Header iHH1 = new Inscricao_Historico_Header();
		Inscricao_Historico_HeaderDAO iHHDAO = new Inscricao_Historico_HeaderDAO();
		iHH.setAno_Consulta(Utilidades.retornaAno());
		iHH.setMes_Consulta(Utilidades.retornaMes());
		
		iHH.setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta.INVALIDADO);
		iHH.setBaixado(Enum_Aux_Sim_ou_Nao.NAO);
		iHH.setData_Consulta(Utilidades.retornaCalendario2());
		
		iHH.setEnum_Aux_Tipo_Conferencia(cL.getEnum_Aux_Tipo_Conferencia());
		
			
		iHH.setData_Consulta(Utilidades.retornaCalendario2());
		iHH.setId_Empresa(1);
		iHH.setId_Inscricao(pd.getId_Inscricao());
		iHH.setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
		iHH.setUltimaAtualizacao(Utilidades.retornaCalendario());
		iHH.setSeq("");
		iHH.setTotal(0);
		iHH1 = iHHDAO.verificaSeExiste(iHH);
		if (iHH1 == null) {
			iHH = iHHDAO.merge(iHH);
		} else
			iHH = iHH1;
		// CUIDADO -- coloquei cabeçalho e rodapé aqui para pegar o tamanho certo.. na busca está zerando
		iHH.setCabecalho(cabecalho);
		iHH.setRodape(rodape);
		
		return iHH;
	}

	
}

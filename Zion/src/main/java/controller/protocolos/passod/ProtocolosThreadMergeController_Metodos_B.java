package controller.protocolos.passod;

import java.util.ArrayList;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import model.dao.InscricaoDAO;
import model.dao.Inscricao_Historico_DetalheDAO;
import model.dao.ProtocolosdeServicos_DetalheDAO;
import model.entities.Comparativos;
import model.entities.Inscricao;
import model.entities.Inscricao_Historico_Detalhe;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Comparativos_Resultados;
import model.enums.Enum_Aux_Sim_ou_Nao;
import model.enums.Enum_Aux_Status_Consulta;
import util.Utilidades;

public class ProtocolosThreadMergeController_Metodos_B extends ProtocolosThreadMergeController_Controles_A {
	public void falha() {
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
		ProtocoloController_ControlesGerais_A.setOk(false);
		bt_Fechar.setVisible(true);
		bt_Fechar.setDisable(false);
		pBar = new ProgressBar(0);
		pBI = new ProgressIndicator(0);
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
		ProtocoloController_ControlesGerais_A.setTextoResposta("FALHA: Ao tentar gravar a listagem de inscrições");
		lb_Titulo_Merge.setText(ProtocoloController_ControlesGerais_A.getTextoResposta());
		bt_Fechar.setVisible(false);
		bt_Fechar.setDisable(true);
	}

	public Inscricao preenchecampos(Comparativos comp, Inscricao insc) {
		insc.setDados_Base("");
		insc.setnInsc(comp.getnInsc());
		insc.setCpf_Cnpj(comp.getCpf_Cnpj());
		insc.setEnum_Aux_Servicos_Classificacoes(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.getEnum_Aux_Servicos_Composicoes().getClassificacao());
		insc.setId_Empresa(1);
		insc.setStatus(true);
		insc.setUltimaAtualizacao(Utilidades.retornaCalendario());
		insc.setId_Mestre(Utilidades.getpPL().getEmpresa_Logada());
		insc.setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
		insc.setDados_Base("");
		insc.setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta.SALVO);
		return insc;
	}

	public Inscricao geraInscricaoAserGravada(Comparativos comp) {
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
		tV_ProtServicos_Detalhe.getItems().clear();
		Inscricao insc = new Inscricao();
		insc = preenchecampos(comp, insc);

		InscricaoDAO dao = new InscricaoDAO();
		Inscricao insc1 = dao.verificaSeExiste(insc);
		if (insc1 == null) {
			insc = dao.merge(insc);
		} else {

			if ((insc1.getCpf_Cnpj() == null || insc1.getCpf_Cnpj().length() == 0) && insc.getCpf_Cnpj().length() > 0) {
				insc1.setCpf_Cnpj(comp.getCpf_Cnpj());
				insc = insc1;
				insc = dao.merge(insc);

			} else {
				insc = insc1;
			}
		}
		if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao()
				.isComparativo()) {
			Inscricao_Historico_Detalhe iH = new Inscricao_Historico_Detalhe();
			iH.setAno_Ref(comp.getAno());
			iH.setPago(Enum_Aux_Sim_ou_Nao.NAO);
			iH.setEnum_Aux_Servicos_Sub_Classificacoes(comp.getEnum_Aux_Servicos_Sub_Classificacoes());
			iH.setId_Empresa(1);

			iH.setId_Inscricao(insc);
			iH.setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
			iH.setMes_Ref(0);
			iH.setUltimaAtualizacao(Utilidades.retornaCalendario());
			iH.setValor(comp.getValor());
			Inscricao_Historico_Detalhe iHSeg = iH;
			Inscricao_Historico_DetalheDAO idao = new Inscricao_Historico_DetalheDAO();
			iHSeg = idao.verificaSeExiste(iH);
			if (iHSeg == null)
				iH = idao.merge(iH);
		}
		return insc;
	}

	public ProtocolosdeServicos_Detalhe geraProtocoloDetalhe(Comparativos comp, Inscricao insc) {
		ProtocolosdeServicos_Detalhe pd = new ProtocolosdeServicos_Detalhe();
		pd.setId_Empresa(1);
		pd.setId_Inscricao(insc);
		pd.setId_ProtocolosdeServicos(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos());
		pd.setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
		pd.setNum_Codigo_Barras("");
		pd.setNum_Dam("");
		pd.setNum_Dam_Sub("");
		pd.setUltimaAtualizacao(Utilidades.retornaCalendario());
		pd.setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
		pd.setValor(0);
		pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.NAO_AVALIADO);
		ProtocolosdeServicos_Detalhe pd1 = pd;
		ProtocolosdeServicos_DetalheDAO pddao = new ProtocolosdeServicos_DetalheDAO();
		pd = pddao.verificaseExistedetalhe(pd);
		if (pd == null) {
			pd = pd1;
		}
		return pd;
	}

}

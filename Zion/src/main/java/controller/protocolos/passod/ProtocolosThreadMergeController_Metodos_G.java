package controller.protocolos.passod;

import java.util.ArrayList;
import java.util.List;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import model.dao.InscricaoDAO;
import model.dao.Inscricao_HistoricoDAO;
import model.dao.ProtocolosdeServicos_DetalheDAO;
import model.entities.Comparativos;
import model.entities.Inscricao;
import model.entities.Inscricao_Historico;
import model.entities.ProtocolosdeServicos_Detalhe;
import util.Utilidades;

public class ProtocolosThreadMergeController_Metodos_G extends ProtocolosThreadMergeController_Metodos_H {
	
	public Inscricao geraInscricaoAserGravada(Comparativos comp) {
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
		tV_ProtServicos_Detalhe.getItems().clear();
		Inscricao insc = new Inscricao();
		insc.setDados_Base("");
		insc.setnInsc(comp.getnInsc());
		
		insc.setEnum_Aux_Servicos_Classificacoes(
				ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getEnum_Aux_Servicos_Composicoes().getClassificacao());
		insc.setId_Empresa(1);
		insc.setStatus(true);
		insc.setUltimaAtualizacao(Utilidades.retornaCalendario());
		insc.setId_Mestre(Utilidades.getpPL().getEmpresa_Logada());
		insc.setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
		insc.setDados_Base("");
		Inscricao insc1 = insc;
		InscricaoDAO dao = new InscricaoDAO();
		insc = dao.verificaSeExiste(insc);
		if (insc == null)
			insc = insc1;
		insc = dao.merge(insc);
		Inscricao_Historico iH = new Inscricao_Historico();
		iH.setAno_Ref(comp.getAno());
		iH.setEnum_Aux_Servicos_Sub_Classificacoes(comp.getEnum_Aux_Servicos_Sub_Classificacoes());
		iH.setId_Empresa(1);
		iH.setId_Inscricao(insc);
		iH.setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
		iH.setMes_Ref(0);
		iH.setUltimaAtualizacao(Utilidades.retornaCalendario());
		iH.setValor(comp.getValor());
		Inscricao_Historico iHSeg = iH;
		
		Inscricao_HistoricoDAO  idao = new Inscricao_HistoricoDAO();
		iHSeg = idao.verificaSeExiste(iHSeg);
		if(iHSeg == null)
			iH = idao.merge(iH);
		return insc;
	}
	public ProtocolosdeServicos_Detalhe geraProtocoloDetalhe(Comparativos comp,Inscricao insc) {
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
		ProtocolosdeServicos_Detalhe pd1 = pd;
		ProtocolosdeServicos_DetalheDAO pddao = new ProtocolosdeServicos_DetalheDAO();
		pd = pddao.verificaseExistedetalhe(pd);
		if (pd == null) {
			pd = pd1;		
		}
		return pd;
	}
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

	public void populatV_ProtServicos_Detalhe(List<ProtocolosdeServicos_Detalhe> lista) {
		ProtocolosdeServicos_DetalheObsList.addAll(lista);
		tV_ProtServicos_Detalhe.setItems(ProtocolosdeServicos_DetalheObsList);
		tV_ProtServicos_Detalhe.getSelectionModel().selectLast();
		
		//tV_ProtServicos_Detalhe.setItems(FXCollections.observableArrayList(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista()));
		//tV_ProtServicos_Detalhe.setItems(FXCollections.observableArrayList(listaLocal));
		//tV_ProtServicos_Detalhe.getSelectionModel().selectLast();
	}
	public void inicializaControles() {
		bt_Fechar.setOnAction((e) -> {
			Stage stage = (Stage) bt_Fechar.getScene().getWindow(); // Obtendo a janela atual
			stage.close();
		});
	}
	
}

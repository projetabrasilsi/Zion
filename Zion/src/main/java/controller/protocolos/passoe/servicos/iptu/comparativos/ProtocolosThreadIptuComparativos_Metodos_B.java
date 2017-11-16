package controller.protocolos.passoe.servicos.iptu.comparativos;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.dao.Inscricao_Historico_DetalheDAO;
import model.entities.Inscricao_Historico_Detalhe;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Comparativos_Resultados;

public class ProtocolosThreadIptuComparativos_Metodos_B extends ProtocolosThreadIptuComparativos_Controles {
	public ProtocolosdeServicos_Detalhe geraComparativos(ProtocolosdeServicos_Detalhe pd) {
		Inscricao_Historico_Detalhe iH1 = new Inscricao_Historico_Detalhe();
		Inscricao_Historico_Detalhe iH2 = new Inscricao_Historico_Detalhe();
		iH1.setEnum_Aux_Servicos_Sub_Classificacoes(
				ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao());
		iH1.setId_Inscricao(pd.getId_Inscricao());
		iH1.setAno_Ref(ProtocoloController_ControlesGerais_A.getAnoAnt());
		iH2.setEnum_Aux_Servicos_Sub_Classificacoes(
				ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao());
		iH2.setId_Inscricao(pd.getId_Inscricao());
		iH2.setAno_Ref(ProtocoloController_ControlesGerais_A.getAnoAtual());
		iH1 = verificaSeInscHisotircoExiste(iH1);
		iH2 = verificaSeInscHisotircoExiste(iH2);
		pd.setAnoAtual(ProtocoloController_ControlesGerais_A.getAnoAtual());
		pd.setMesAtual(0);
		pd.setAnoAnt(ProtocoloController_ControlesGerais_A.getAnoAnt());
		pd.setMesAnt(0);
		if (iH1 == null)
			pd.setValorAnt(0);
		else
			pd.setValorAnt(iH1.getValor());
		if (iH2 == null)
			pd.setValorAtual(0);
		else
			pd.setValorAtual(iH2.getValor());

		if (pd.getValorAnt() > 0 && pd.getValorAtual() > 0) {
			if (pd.getValorAnt() > pd.getValorAtual()) {
				pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.DIMINIUIU);
				pd.setDiferenca(pd.getValorAnt() - pd.getValorAtual());
			} else if (pd.getValorAnt() < pd.getValorAtual()) {
				pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.AUMENTOU);
				pd.setDiferenca(pd.getValorAtual() - pd.getValorAnt());
			} else {
				pd.setDiferenca(0);
				pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.MANTEVE);
			}
		} else {
			pd.setDiferenca(0);
			pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.NAO_AVALIADO);
		}
		if (pd.getValorAnt() > 0)
			pd.setPercentual((pd.getDiferenca() / pd.getValorAnt()));
		else
			pd.setPercentual(0);
		return pd;
	}

	public Inscricao_Historico_Detalhe verificaSeInscHisotircoExiste(Inscricao_Historico_Detalhe iH) {
		Inscricao_Historico_DetalheDAO iDAO = new Inscricao_Historico_DetalheDAO();
		iH = iDAO.verificaSeExiste(iH);
		return iH;
	}

	public void sucesso() {
		lb_Titulo_Tela.setTextFill(Color.web("#0a7cdf"));
		bt_Fechar.setVisible(true);
		bt_Fechar.setDisable(false);

		if (ProtocoloController_ControlesGerais_A.isOk() && ProtocoloController_ControlesGerais_A.isFinalizado())
			lb_Titulo_Tela.setText("ETAPA DE COMPARAÇÕES: Finalizada com Sucesso!!!");
		else {
			lb_Titulo_Tela.setTextFill(Color.web("#ff0000"));
			lb_Titulo_Tela.setText("ETAPA DE COMPARAÇÕES: NÃO FOI REALIZADA. ERRO!");
		}
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
		ProtocoloController_ControlesGerais_A.setTextoResposta("FALHA: Ao tentar realizar comparações");
		lb_Titulo_Merge.setText(ProtocoloController_ControlesGerais_A.getTextoResposta());
	}

	protected void fechatela() {
		Stage stage = (Stage) bt_Fechar.getScene().getWindow();
		stage.close();
	}
}

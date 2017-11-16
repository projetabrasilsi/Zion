package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.paint.Color;
import model.dao.Inscricao_Historico_DetalheDAO;
import model.entities.Inscricao;
import model.entities.Inscricao_Historico_Detalhe;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Status_Consulta;
import util.Utilidades;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_C extends ProtocolosThreadIptuConferenciaDebitos_Metodos_D {
	protected Inscricao_Historico_Detalhe veRificaSeJaExisteHistorico(Inscricao insc) {
		Inscricao_Historico_Detalhe iHD = new Inscricao_Historico_Detalhe();
		iHD.setAno(Utilidades.retornaAno());
		iHD.setMes_Ref(Utilidades.retornaMes());
		iHD.setEnum_Aux_Servicos_Sub_Classificacoes(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getEnum_Aux_Servicos_Composicoes().getSub_Classificacao());		 		
		iHD.setId_Inscricao(insc);
		Inscricao_Historico_DetalheDAO iHDAO = new Inscricao_Historico_DetalheDAO();
		iHD = iHDAO.verificaSeExiste(iHD);
		return iHD;
	}
	
	
	public Inscricao_Historico_Detalhe verificaSeInscHisotircoExiste(Inscricao_Historico_Detalhe iH) {
		Inscricao_Historico_DetalheDAO iDAO = new Inscricao_Historico_DetalheDAO();
		iH = iDAO.verificaSeExiste(iH);
		return iH;
	}
	
	public ProtocolosdeServicos_Detalhe download(ProtocolosdeServicos_Detalhe pd, int linha) {
		String request = "http://www.pmf.sc.gov.br/cgi-bin/tm38220.sh";
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("SEFIN", "0");
		map.put("inscricao", pd.getId_Inscricao().getnInsc());
		map.put("nu_pess", pd.getId_Inscricao().getCpf_Cnpj());
		map.put("submit", "Consultar");
		Document doc = null;
		try {
			doc =    Jsoup.connect(request).data(map).followRedirects(false).timeout(25000).post();
			doc.outputSettings().charset("UTF-8");			
			String texto = doc.body().text();
			FileWriter fileWriter = new FileWriter(
					"C:\\zionArquivos\\" + linha + " - " + pd.getId_Inscricao().getnInsc() + ".txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(texto);
			bufferedWriter.close();
			pd.setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta.BAIXADO);
			return pd;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pd;
	}
	
	Task<Void>  task;
	public void sucesso() {
		lb_Titulo_Tela.setTextFill(Color.web("#0a7cdf"));		
		if (ProtocoloController_ControlesGerais_A.isOk() && ProtocoloController_ControlesGerais_A.isFinalizado()) {			
		lb_Titulo_Tela.setText(""+etapaAtual.getDescricao2()+": Finalizada com Sucesso!!!");
		fechatela();
		 
		}
		 else {
			lb_Titulo_Tela.setTextFill(Color.web("#ff0000"));	
		    lb_Titulo_Tela.setText(""+etapaAtual.getDescricao2()+": NÃO FOI REALIZADA. ERRO!");
		
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
		ProtocoloController_ControlesGerais_A.setTextoResposta(""+etapaAtual.getDescricao2()+" - FALHA: Ao tentar realizar Downloads");					
		lb_Titulo_Merge.setText(ProtocoloController_ControlesGerais_A.getTextoResposta());
	}
	
	



}

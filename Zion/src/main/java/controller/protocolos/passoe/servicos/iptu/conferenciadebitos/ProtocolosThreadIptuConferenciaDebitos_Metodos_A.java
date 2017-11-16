package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.util.ArrayList;
import java.util.List;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import model.dao.ProtocolosdeServicos_DetalheDAO;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Comparativos_Resultados;
import model.enums.Enum_Aux_Status_Consulta;
import util.Utilidades;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_A extends ProtocolosThreadIptuConferenciaDebitos_Metodos_B {
	public void downloadDebitos() {
		Utilidades.setOk(false);
		Utilidades.setFinalizado(false);
		lb_Titulo_Tela.setText("REALIZANDO PROCESSO DE CONFERENCIA");
		tV_ProtServicos_Detalhe.requestFocus();
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
		tV_ProtServicos_Detalhe.getItems().clear();
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
		List<ProtocolosdeServicos_Detalhe> pDs = ProtocoloController_ControlesGerais_A.buscaprotocoloservicosDetalhes();
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista().clear();
		// populatV_ProtServicos_Detalhe();
		tV_ProtServicos_Detalhe.getItems().clear();
		ProtocoloController_ControlesGerais_A
				.setAnoAnt(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getAnoAnt());
		ProtocoloController_ControlesGerais_A
				.setAnoAtual(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getAnoAtual());
		if (pDs != null)
			qtde = pDs.size();
		Task<Void> task = new Task<Void>() {
			@Override

			public Void call() throws Exception {
				etapaAtual = Enum_Aux_Status_Consulta.BAIXADO;
				updateMessage("iniciando");
				i = 1;
				for (ProtocolosdeServicos_Detalhe pd : pDs) {
					updateMessage("Acessando servidor  (" + i + "/" + qtde + ")");
					pd.setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta.INVALIDADO);
					if (!Utilidades.verificaSeArquivoExiste("C:\\zionArquivos\\teste\\",

							pd.getId_Inscricao().getnInsc() + ".txt")) {
						pd = download(pd, i);
						if (pd.getEnum_Aux_Status_Consulta().equals(Enum_Aux_Status_Consulta.BAIXADO)) {
							updateMessage("download realizado!!!");
						} else {
							updateMessage("download NÃO foi realizado!!!");
						}
					} else {
						updateMessage("download já havia ocorrido!!!");
						pd.setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta.ANALISADO);
						pd.setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados.NAO_AVALIADO);
					}

					ProtocolosdeServicos_DetalheDAO pddao = new ProtocolosdeServicos_DetalheDAO();
					pd = pddao.merge(pd);
					if (ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista() == null)
						ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
					ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista().add(pd);
					updateProgress(i, qtde);
					if (i == qtde) {
						ProtocoloController_ControlesGerais_A.setFinalizado(true);
					} else
						ProtocoloController_ControlesGerais_A.setFinalizado(false);
					i++;
				}
				ProtocoloController_ControlesGerais_A.setOk(ProtocoloController_ControlesGerais_A.isFinalizado());
				return null;
			}
		};

		task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				if (ProtocoloController_ControlesGerais_A.isFinalizado()) {
					if (ProtocoloController_ControlesGerais_A.isOk()) {
						ProtocoloController_ControlesGerais_A.salvaProtocoloServicos();
						sucesso();						
						analisandoDebitos();
						
					} else
						falha();
				} else {
					falha();
				}
			}
		});
		task.messageProperty().addListener((obs, oldMessage, newMessage) -> {
			lb_Titulo_Merge.setText(newMessage);
			pBar.progressProperty().bind(task.progressProperty());
			pBI.progressProperty().bind(task.progressProperty());
		});
		task.setOnFailed(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				falha();
			}
		});
		if (qtde > 0) {
			ProtocoloController_ControlesGerais_A.setSync(new Thread(task));
			ProtocoloController_ControlesGerais_A.getSync().start();
		} else {
			lb_Titulo_Tela.setText("Não há registros para realizar Importação");
			lb_Titulo_Merge.setText("0/0");
		}
	}

}

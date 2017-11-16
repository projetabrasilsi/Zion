
package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import model.dao.ProtocolosdeServicos_DetalheDAO;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Status_Consulta;
import util.Utilidades;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_B extends ProtocolosThreadIptuConferenciaDebitos_Metodos_C {
	int qt = 1;
	int contador = 1;
	public void analisandoDebitos() {
		
		lb_Titulo_Tela.setText("REALIZANDO PROCESSO DE ANÁLISE");
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
		List<ProtocolosdeServicos_Detalhe> pDs = ProtocoloController_ControlesGerais_A.buscaprotocoloservicosDetalhes();
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista().clear();
		ProtocoloController_ControlesGerais_A
				.setAnoAnt(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getAnoAnt());
		ProtocoloController_ControlesGerais_A
				.setAnoAtual(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getAnoAtual());
		
		if (pDs != null)
			qt = pDs.size();
		task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				etapaAtual = Enum_Aux_Status_Consulta.ANALISADO;
				updateMessage("iniciando");
				contador = 1;				
				for (ProtocolosdeServicos_Detalhe pd : pDs) {
					
					updateMessage("análise (" + contador + "/" + qt + ")");
					pd.setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta.INVALIDADO);
					
					

					if (!Utilidades.verificaSeArquivoExiste("C:\\zionArquivos\\teste\\",
							pd.getId_Inscricao().getnInsc() + ".txt")) {
							pd = download(pd, i);
						if (pd.getEnum_Aux_Status_Consulta().equals(Enum_Aux_Status_Consulta.BAIXADO)) {
							updateMessage("download realizado!!!");
						} else {
							updateMessage("download NÃO foi realizado!!!");
						}
					} else
						updateMessage("download já foi realizado!!!");
					
					File f = Utilidades.retornaUmArquivoExistente("C:\\zionArquivos\\teste\\",pd.getId_Inscricao().getnInsc() + ".txt");
					System.out.println("Contador: "+contador+" / "+qt+" - "+f.getName() );
					pd = iniciaOProcessoDeAnalise(f,pd);
					pd.setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta.ANALISADO);
					ProtocolosdeServicos_DetalheDAO pddao = new ProtocolosdeServicos_DetalheDAO();
					pd = pddao.merge(pd);
					if (ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista() == null)
						ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
					ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista().add(pd);
					updateProgress(contador, qt);
					
					if (contador == qt) {
						ProtocoloController_ControlesGerais_A.setFinalizado(true);
						updateMessage("Análise realidada com Sucesso!!!");
					} else
						ProtocoloController_ControlesGerais_A.setFinalizado(false);
					contador++;
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

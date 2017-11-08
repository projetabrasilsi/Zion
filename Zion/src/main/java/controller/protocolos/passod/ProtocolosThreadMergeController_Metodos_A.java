package controller.protocolos.passod;

import java.util.ArrayList;
import java.util.List;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import model.dao.ProtocolosdeServicos_DetalheDAO;
import model.entities.Comparativos;
import model.entities.Inscricao;
import model.entities.ProtocolosdeServicos_Detalhe;

public class ProtocolosThreadMergeController_Metodos_A extends ProtocolosThreadMergeController_Metodos_B {
	private int i = 0;
	private int qtde = 0;
	private int contador = 0;
	private List<Comparativos> lista = new ArrayList<>();

	public void salvandoListaImportada() {
		setaLabelsEValoresIniciais();
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				updateMessage("iniciando");
				ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
				ProtocoloController_ControlesGerais_A.setComparativos_Join(new ArrayList<>());
				if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao().isComparativo()) {
					ProtocoloController_ControlesGerais_A.getComparativos_Join().addAll(ProtocoloController_ControlesGerais_A.getComparativos_1());
					ProtocoloController_ControlesGerais_A.getComparativos_Join().addAll(ProtocoloController_ControlesGerais_A.getComparativos_2());					
				} else {
					ProtocoloController_ControlesGerais_A.getComparativos_Join().addAll(ProtocoloController_ControlesGerais_A.getComparativos_1());
					
				}
				lista.addAll(ProtocoloController_ControlesGerais_A.getComparativos_Join());
				i = 1;
				qtde = lista.size();				
				
				List<ProtocolosdeServicos_Detalhe> listaLocal = new ArrayList<>();
				
				for (Comparativos l : lista) {
					Inscricao insc = geraInscricaoAserGravada(l);
					ProtocolosdeServicos_Detalhe pd = geraProtocoloDetalhe(l, insc);
					ProtocolosdeServicos_DetalheDAO pddao = new ProtocolosdeServicos_DetalheDAO();
					if (pd.getId() == null) {
						contador++;
						pd.setContador(contador);
						pd = pddao.merge(pd);
					}
					// estava dando problema ao adicionar diretamente em ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista()
					// por isso criei esta lista local;
					listaLocal.add(pd);					
					ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista().addAll(listaLocal);
					//populatV_ProtServicos_Detalhe(listaLocal);
					updateProgress(i, qtde);
					if (i == qtde)
						ProtocoloController_ControlesGerais_A.setFinalizado(true);
					updateMessage("Gravando Inscrições (" + i + "/" + qtde + ")");
					i++;

				}
				ProtocoloController_ControlesGerais_A.setOk(true);
				return null;
			}
		};
		task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				if (ProtocoloController_ControlesGerais_A.isFinalizado()) {
					sucesso();
					fechatela();
				} else
					falha();
					fechatela();
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
		ProtocoloController_ControlesGerais_A.setSync(new Thread(task));
		inicializarObservadores();
		ProtocoloController_ControlesGerais_A.getSync().start();
	}

}

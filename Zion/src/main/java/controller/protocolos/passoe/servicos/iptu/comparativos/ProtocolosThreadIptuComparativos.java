package controller.protocolos.passoe.servicos.iptu.comparativos;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import model.dao.ProtocolosdeServicos_DetalheDAO;
import model.entities.ProtocolosdeServicos_Detalhe;

public class ProtocolosThreadIptuComparativos extends ProtocolosThreadIptuComparativos_Metodos_A
		implements Initializable {
	private int i = 0;
	int qtde = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ProtocoloController_ControlesGerais_A.evoluisequencia();
		lb_Etapas.setText(ProtocoloController_ControlesGerais_A.getSequencia());		
		bt_Fechar.setVisible(false);
		bt_Fechar.setDisable(true);
		inicializaEventos();
		realizandoComparacao();
	}

	public void realizandoComparacao() {		
		lb_Titulo_Tela.setText("REALIZANDO PROCESSO DE COMPARAÇÃO");
		tV_ProtServicos_Detalhe.requestFocus();
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
		tV_ProtServicos_Detalhe.getItems().clear();
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
		List<ProtocolosdeServicos_Detalhe> pDs = ProtocoloController_ControlesGerais_A.buscaprotocoloservicosDetalhes();
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista().clear();
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
				updateMessage("iniciando");
				i = 1;
				for (ProtocolosdeServicos_Detalhe pd : pDs) {
					updateMessage("Realizando comparação  (" + i + "/" + qtde + ")");
					pd = geraComparativos(pd);
					ProtocolosdeServicos_DetalheDAO pddao = new ProtocolosdeServicos_DetalheDAO();
					pd = pddao.merge(pd);
					if (ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista() == null)
						ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(new ArrayList<>());
					ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista().add(pd);					
					updateProgress(i, qtde);
					if (i == qtde)
						ProtocoloController_ControlesGerais_A.setFinalizado(true);
					else
						ProtocoloController_ControlesGerais_A.setFinalizado(false);
					i++;
				}
				return null;
			}
		};

		task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				if (ProtocoloController_ControlesGerais_A.isFinalizado()) {
					ProtocoloController_ControlesGerais_A.setOk(gravadados());
					// deverá gravar dados
					if (ProtocoloController_ControlesGerais_A.isOk())
						sucesso();
					else
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
	public void inicializaEventos() {
		bt_Fechar.setOnAction((e) -> {
			fechatela();
		});
	}
}

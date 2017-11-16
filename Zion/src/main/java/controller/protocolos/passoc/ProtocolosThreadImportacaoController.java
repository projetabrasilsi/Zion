package controller.protocolos.passoc;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import util.Utilidades;

public class ProtocolosThreadImportacaoController extends ProtocolosThreadImportacaoController_Metodos_A
		implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lb_Etapas.setText(ProtocoloController_ControlesGerais_A.getSequencia());
		inicializaEventos();
		bt_Fechar.setVisible(false);
		bt_Fechar.setDisable(true);
		GeraListadeInscricoes(ProtocoloController_ControlesGerais_A.getAno(),
				ProtocoloController_ControlesGerais_A.getnLista());
	}

	public boolean GeraListadeInscricoes(int anoPar, int nLista) {
		boolean retorno = true;
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
		ProtocoloController_ControlesGerais_A.setTextoResposta("");

		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				int i = 1;
				String texto = "";

				updateMessage("Aguarde...");
				Workbook workbook = retornaWorkbook();
				if (workbook == null) {
					updateMessage(ProtocoloController_ControlesGerais_A.getTextoResposta());
					ProtocoloController_ControlesGerais_A.setOk(false);
					ProtocoloController_ControlesGerais_A.setFinalizado(false);
				}
				Sheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
				int totLinha = sheet.getLastRowNum() + 1;
				Utilidades.setOk(false);
				texto = "iniciando:";
				updateMessage(texto);
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					if (!formataLista(row, anoPar, totLinha, ProtocoloController_ControlesGerais_A.getnLista(), i)) {
						updateMessage(ProtocoloController_ControlesGerais_A.getTextoResposta());
						ProtocoloController_ControlesGerais_A.setOk(false);
						ProtocoloController_ControlesGerais_A.setFinalizado(false);
						break;
					}
					updateMessage(ProtocoloController_ControlesGerais_A.getTextoResposta());
					if (i == totLinha) {
						ProtocoloController_ControlesGerais_A.setFinalizado(true);
					}
					updateProgress(i, totLinha);
					i++;
				}
				ProtocoloController_ControlesGerais_A.setOk(ProtocoloController_ControlesGerais_A.isFinalizado());
				return null;
			}
		};
		task.messageProperty().addListener((obs, oldMessage, newMessage) -> {
			lb_Titulo.setText(newMessage);
			pBar.progressProperty().bind(task.progressProperty());
			pBI.progressProperty().bind(task.progressProperty());

		});
		task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				sucesso(ProtocoloController_ControlesGerais_A.getnLista());
			}
		});
		task.setOnFailed(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				falha();
			}
		});
		new Thread(task).start();
		retorno = Utilidades.isOk();
		return retorno;
	}
}

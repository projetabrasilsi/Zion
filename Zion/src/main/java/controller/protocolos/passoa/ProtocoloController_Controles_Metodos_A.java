package controller.protocolos.passoa;

import java.util.ArrayList;
import java.util.List;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import controller.protocolos.passoe.servicos.iptu.comparativos.IptuComparativosFlorianopolisScReport;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import model.entities.ProtocolosdeServicos;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Navegadores;
import model.enums.Enum_Aux_Servicos_Status;
import net.sf.jasperreports.engine.JRException;
import util.Utilidades;

public class ProtocoloController_Controles_Metodos_A extends ProtocoloController_Controles_Metodos_B {
	private int i = 0;
	ObservableList<ProtocolosdeServicos_Detalhe> ff = FXCollections.observableArrayList();
	
	
	
	protected void inicializa_Eventos() {
		inicializaRolagem();
		
		
		
		bt_Inicio.setOnAction((e) -> {
			navegacao(Enum_Aux_Navegadores.INICIO);
		});
		bt_Anterior.setOnAction((e) -> {
			navegacao(Enum_Aux_Navegadores.ANTERIOR);
		});
		bt_Proximo.setOnAction((e) -> {			
			navegacao(Enum_Aux_Navegadores.PROXIMO);
		});
		bt_Fim.setOnAction((e) -> {
			navegacao(Enum_Aux_Navegadores.FIM);
		});

		bt_Novo.setOnAction((e) -> {
			ProtocoloController_ControlesGerais_A.setOk(false);		
			// para escolher o tipo de serviço 
			ProtocoloController_ControlesGerais_A.setOk(chamaTelaPassoB());
			if (ProtocoloController_ControlesGerais_A.isOk())
				novoProtocolo();
		});

		bt_Rolagem.setOnAction((e) -> {              
			rolar();
			
			
		});

		bt_Relatorio_Analitico.setOnAction((e) -> {
			IptuComparativosFlorianopolisScReport relatorio = new IptuComparativosFlorianopolisScReport();
			try {
				List<ProtocolosdeServicos_Detalhe> lista = new ArrayList<>();
				lista.addAll(tV_ProtServicos_Detalhe.getItems());
				relatorio.gerarrelatorioAnalitico(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos() , lista);
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Utilidades.enviaAlertError("Impressão","ERRO:" ,"Erro ao tentar imprimir o relatório: "+e1.getMessage());
			}
		});
		bt_Relatorio_Sintetico.setOnAction((e) -> {
			IptuComparativosFlorianopolisScReport relatorio = new IptuComparativosFlorianopolisScReport();
			try {
				relatorio.gerarrelatorioSintetico(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos());
			} catch (JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Utilidades.enviaAlertError("Impressão","ERRO:" ,"Erro ao tentar imprimir o relatório: "+e1.getMessage());
			}
		});
		navegacao(Enum_Aux_Navegadores.FIM);
		
		
	}
	
	public void inicializaRolagem() {
		
		sB.setMax(tV_ProtServicos_Detalhe.getItems().size()-1); 
		sB.setMin(0);
		
		sB.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldV, Number newV) {
				tV_ProtServicos_Detalhe.scrollTo(newV.intValue());
				tV_ProtServicos_Detalhe.getSelectionModel().select(newV.intValue());
				tV_ProtServicos_Detalhe.requestFocus();
			}
		});
	}
	
	public void rolar() {
		i = 0;
		
		ff = tV_ProtServicos_Detalhe.getItems();
		System.out.println("tamanho: " +ff.size());
		
		
		Task<Void> task = new Task<Void>() {
			@SuppressWarnings("unused")
			@Override
			public Void call() throws Exception {
				updateMessage("iniciando");
				
				for (ProtocolosdeServicos_Detalhe pd : ff) {	
					updateMessage(""+i+"/"+ff.size());
					
					
					i++;
				}
				return null;
			}
		};

		task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				

			}
		});
		task.messageProperty().addListener((obs, oldMessage, newMessage) -> {
			sB.setValue(i);
			lb_Rolagem.setText(newMessage);
			
		});
		task.setOnFailed(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				
			}
		});
		ProtocoloController_ControlesGerais_A.setSync(new Thread(task));		
		ProtocoloController_ControlesGerais_A.getSync().start();

		
	}

	public void novoProtocolo() {
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos(new ProtocolosdeServicos());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setEnum_Aux_Servicos_Status(Enum_Aux_Servicos_Status.IMPORTANDO);
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setId_Mestre(Utilidades.getpPL().getEmpresa_Logada());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setEnum_Aux_Servicos_Composicoes(ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes());
		
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
		ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setId_Empresa(1);
		if(ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao().isComparativo()) {
			if(ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao().isComparativo()) {
				ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setAnoAnt(ProtocoloController_ControlesGerais_A.getAnoAnt());
				ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setAnoAtual(ProtocoloController_ControlesGerais_A.getAnoAtual()); 
				ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setMesAnt(0);
				ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setMesAtual(0);			
				if(ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().isAnoEMes()) {
					// mudar valores;
					ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setMesAnt(0);
					ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setMesAtual(0);
				}
			}
			else {
				ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setAnoAnt(0);
				ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setAnoAtual(0);
				ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setMesAnt(0);
				ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setMesAtual(0);
			}
		}
		
		
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos());
		salvaProtocoloServicos();
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos());
		// para importar lista em xls --- a chamada da tela de passo c ocorre dentro do passo b - então daqui já vamos para d
			ProtocoloController_ControlesGerais_A.setOk(false);
			ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setEnum_Aux_Servicos_Status(Enum_Aux_Servicos_Status.SALVANDO);
			if(chamateladePassoD()){
				//salvaProtocoloServicos();
				ProtocoloController_ControlesGerais_A.setOk(false);
				if(chamateladePassoE()){
					ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setEnum_Aux_Servicos_Status(Enum_Aux_Servicos_Status.FINALIZADO);
					salvaProtocoloServicos();
					navegacao(Enum_Aux_Navegadores.FIM);							
					ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista());
					carregandoControles();					
				}
			}
		//}
		
	}
}

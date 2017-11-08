package controller.protocolos.passoa;

import java.util.ArrayList;
import java.util.List;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import controller.protocolos.passoe.servicos.iptu.comparativos.IptuComparativosFlorianopolisScReport;
import model.entities.ProtocolosdeServicos;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Navegadores;
import model.enums.Enum_Aux_Servicos_Status;
import net.sf.jasperreports.engine.JRException;
import util.Utilidades;

public class ProtocoloController_Controles_Metodos_A extends ProtocoloController_Controles_Metodos_B {

	protected void inicializa_Eventos() {
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

		bt_Alterar.setOnAction((e) -> {
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

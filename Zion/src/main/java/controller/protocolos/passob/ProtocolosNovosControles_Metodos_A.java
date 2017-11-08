package controller.protocolos.passob;

import java.util.ArrayList;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Servicos_Composicoes;
import model.enums.Enum_Aux_Servicos_Restricoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;
import util.Utilidades;

public class ProtocolosNovosControles_Metodos_A extends ProtocolosNovosControles_A {

	public void inicializaControles() {
		ProtocoloController_ControlesGerais_A.setServicosClassificacoes(Utilidades.getpPL().getServicosClassificacoes());
		preenchecB_Sub_Classificacao(Utilidades.getpPL().getServicosClassificacoes());
		cB_Sub_Classificacao.getSelectionModel().select(-1);
		cB_Escolha_Restricao.getSelectionModel().select(-1);
		cB_Sub_Classificacao.valueProperty().addListener(new ChangeListener<Enum_Aux_Servicos_Sub_Classificacoes>() {
			@Override
			public void changed(ObservableValue<? extends Enum_Aux_Servicos_Sub_Classificacoes> observable,
					Enum_Aux_Servicos_Sub_Classificacoes oldValue, Enum_Aux_Servicos_Sub_Classificacoes newValue) {
				ProtocoloController_ControlesGerais_A.setServicosSubClassificacoes(newValue);
				preenchecB_Escolha_Restricao(newValue);
				liberaControlesOuNao();
			}
		});

		cB_Escolha_Restricao.valueProperty().addListener(new ChangeListener<Enum_Aux_Servicos_Restricoes>() {
			@Override
			public void changed(ObservableValue<? extends Enum_Aux_Servicos_Restricoes> observable,
					Enum_Aux_Servicos_Restricoes oldValue, Enum_Aux_Servicos_Restricoes newValue) {
				ProtocoloController_ControlesGerais_A.setServicosrestricoes(newValue);
				
				ProtocoloController_ControlesGerais_A.setEnum_Aux_Servicos_Composicoes(
						Enum_Aux_Servicos_Composicoes.retornaComposicao(
						ProtocoloController_ControlesGerais_A.getServicosClassificacoes(),
						ProtocoloController_ControlesGerais_A.getServicosSubClassificacoes(),
						ProtocoloController_ControlesGerais_A.getServicosrestricoes()));
				liberaControlesOuNao();
				
				//Enum_Aux_Servicos_Classificacoes classif, 
				//Enum_Aux_Servicos_Sub_Classificacoes subClass, Enum_Aux_Servicos_Restricoes restr 
			}
		});

		cB_Comp_1.valueProperty().addListener(new ChangeListener<Integer>() {
			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				ProtocoloController_ControlesGerais_A.setAnoAnt(newValue);
				liberaControlesOuNao();

			}
		});

		cB_Comp_2.valueProperty().addListener(new ChangeListener<Integer>() {
			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				ProtocoloController_ControlesGerais_A.setAnoAtual(newValue);
				liberaControlesOuNao();
			}
		});

		bt_Confirmar.setOnAction((e) -> {
			if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes() == null) {
				ProtocoloController_ControlesGerais_A.setTextoResposta(
						"ERRO\nEscolha de Serviço e Restrição\nPor Favor Escolher Serviço e Restrição!");
				return;
			}
			

			
			if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao().isComparativo()) {
				ProtocoloController_ControlesGerais_A.setAnoAnt(cB_Comp_1.getValue());
				ProtocoloController_ControlesGerais_A.setAnoAtual(cB_Comp_2.getValue());
				ProtocoloController_ControlesGerais_A.setMesAnt(0);
				ProtocoloController_ControlesGerais_A.setMesAtual(0);
				if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().isAnoEMes()) {
					// mudar valores;
					ProtocoloController_ControlesGerais_A.setMesAnt(0);
					ProtocoloController_ControlesGerais_A.setMesAtual(0);
				}
			} else {
				ProtocoloController_ControlesGerais_A.setAnoAnt(0);
				ProtocoloController_ControlesGerais_A.setAnoAtual(0);
				ProtocoloController_ControlesGerais_A.setMesAnt(0);
				ProtocoloController_ControlesGerais_A.setMesAtual(0);

			}

			Stage stage = (Stage) bt_Confirmar.getScene().getWindow();
			ProtocoloController_ControlesGerais_A.setOk(true);
			stage.close();

		});

		bt_Cancelar.setOnAction((e) -> {
			Stage stage = (Stage) bt_Cancelar.getScene().getWindow();
			ProtocoloController_ControlesGerais_A.setOk(false);
			stage.close();
		});

		bt_Confirmar.setDisable(true);
		bt_Escolher_Arquivo_1.setDisable(true);
		bt_Escolher_Arquivo_2.setDisable(true);

	}

	public void preenchecB_Escolha_Restricao(Enum_Aux_Servicos_Sub_Classificacoes subClass) {
		ProtocoloController_ControlesGerais_A.setListaRestricoes(new ArrayList<>());
		ProtocoloController_ControlesGerais_A.setListaRestricoes(Enum_Aux_Servicos_Composicoes.retornaListaRestricoes(ProtocoloController_ControlesGerais_A.getServicosClassificacoes(), subClass));
		cB_Escolha_Restricao.getItems().clear();
		cB_Escolha_Restricao.getItems().setAll(ProtocoloController_ControlesGerais_A.getListaRestricoes());

	}

	public void preenchecB_Sub_Classificacao(Enum_Aux_Servicos_Classificacoes classif) {
		ProtocoloController_ControlesGerais_A.setListaSubClassificacoes(new ArrayList<>());
		ProtocoloController_ControlesGerais_A.setListaSubClassificacoes(
				Enum_Aux_Servicos_Composicoes.retornaListaSubClassificacoes(ProtocoloController_ControlesGerais_A.getServicosClassificacoes()));
		cB_Sub_Classificacao.getItems().clear();
		cB_Sub_Classificacao.getItems().setAll(ProtocoloController_ControlesGerais_A.getListaSubClassificacoes());

	}

	public void liberaControlesOuNao() {
		if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes() != null) {
			if (anualAtualEMaior()) {
				if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes() != null)
					bt_Escolher_Arquivo_1.setDisable(!anualAtualEMaior());
				else
					bt_Escolher_Arquivo_1.setDisable(true);

				bt_Escolher_Arquivo_2.setDisable(true);
				bt_Confirmar.setDisable(true);

			} else {
				bt_Escolher_Arquivo_1.setDisable(true);
				bt_Escolher_Arquivo_2.setDisable(true);
			}
		} else {

			bt_Escolher_Arquivo_1.setDisable(true);
			bt_Escolher_Arquivo_2.setDisable(true);
		}
	}

	public boolean anualAtualEMaior() {
		if (ProtocoloController_ControlesGerais_A.getAnoAtual() > ProtocoloController_ControlesGerais_A.getAnoAnt())
			return true;
		else
			return false;
	}

}

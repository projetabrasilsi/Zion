package controller.protocolos.passoe.servicos.iptu.comparativos;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.collections.FXCollections;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Comparativos_Resultados;

public class ProtocolosThreadIptuComparativos_Metodos_D extends  ProtocolosThreadIptuComparativos_Controles {
		public void configuraTableView_4(){
		tC_Diferenca.setCellFactory(
				new Callback<TableColumn<ProtocolosdeServicos_Detalhe, Double>, TableCell<ProtocolosdeServicos_Detalhe, Double>>() {
					@Override
					public TableCell<ProtocolosdeServicos_Detalhe, Double> call(
							TableColumn<ProtocolosdeServicos_Detalhe, Double> param) {
						final TableCell<ProtocolosdeServicos_Detalhe, Double> cell = new TableCell<ProtocolosdeServicos_Detalhe, Double>() {
							@Override
							public void updateItem(final Double item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									this.setText("");
								} else {
									int currentIndex = indexProperty().getValue() < 0 ? 0 : indexProperty().getValue();
									Enum_Aux_Comparativos_Resultados resultado = param.getTableView().getItems().get(currentIndex).getEnum_Aux_Comparativos_Resultados();																		
									this.setStyle("-fx-text-fill: "+ProtocoloController_ControlesGerais_A.retornaCor(resultado)+";");									
									this.setStyle("-fx-background-color: "+ProtocoloController_ControlesGerais_A.retornaCorPreenchimento(resultado)+";");
									String strDate = ProtocoloController_ControlesGerais_A.retornaFormato(item.doubleValue(), false);
									this.setText(strDate);
								}
							}
						};
						return cell;
					}
				});
		

		tC_Valor_Anterior.setCellFactory(
				new Callback<TableColumn<ProtocolosdeServicos_Detalhe, Double>, TableCell<ProtocolosdeServicos_Detalhe, Double>>() {
					@Override
					public TableCell<ProtocolosdeServicos_Detalhe, Double> call(
							TableColumn<ProtocolosdeServicos_Detalhe, Double> p) {
						final TableCell<ProtocolosdeServicos_Detalhe, Double> cell = new TableCell<ProtocolosdeServicos_Detalhe, Double>() {
							@Override
							public void updateItem(final Double item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									this.setText("");
								} else {
									String strDate = ProtocoloController_ControlesGerais_A.retornaFormato(item.doubleValue(), false);
									this.setText(strDate);
								}
							}
						};
						return cell;
					}
				});

		tC_Valor_Atual.setCellFactory(
				new Callback<TableColumn<ProtocolosdeServicos_Detalhe, Double>, TableCell<ProtocolosdeServicos_Detalhe, Double>>() {
					@Override
					public TableCell<ProtocolosdeServicos_Detalhe, Double> call(
							TableColumn<ProtocolosdeServicos_Detalhe, Double> p) {
						final TableCell<ProtocolosdeServicos_Detalhe, Double> cell = new TableCell<ProtocolosdeServicos_Detalhe, Double>() {
							@Override
							public void updateItem(final Double item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									this.setText("");
								} else {
									String strDate = ProtocoloController_ControlesGerais_A.retornaFormato(item.doubleValue(), false);
									this.setText(strDate);
								}
							}
						};
						return cell;
					}
				});

		tC_Percentual.setCellFactory(
				new Callback<TableColumn<ProtocolosdeServicos_Detalhe, Double>, TableCell<ProtocolosdeServicos_Detalhe, Double>>() {
					@Override
					public TableCell<ProtocolosdeServicos_Detalhe, Double> call(
							TableColumn<ProtocolosdeServicos_Detalhe, Double> p) {
						final TableCell<ProtocolosdeServicos_Detalhe, Double> cell = new TableCell<ProtocolosdeServicos_Detalhe, Double>() {
							@Override
							public void updateItem(final Double item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									this.setText("");
								} else {
									String strDate = ProtocoloController_ControlesGerais_A.retornaFormato(item.doubleValue(), true);
									this.setText(strDate);
								}
							}
						};
						return cell;
					}
				});
	}
	
	public void populatV_ProtServicos_Detalhe() {		
		tV_ProtServicos_Detalhe.setItems(FXCollections.observableArrayList(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista()));
		tV_ProtServicos_Detalhe.getSelectionModel().selectLast();
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
	

}

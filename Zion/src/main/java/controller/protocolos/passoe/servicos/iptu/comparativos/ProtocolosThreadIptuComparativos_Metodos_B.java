package controller.protocolos.passoe.servicos.iptu.comparativos;

import java.util.Calendar;
import java.util.Collections;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.entities.Inscricao;
import model.entities.Pessoa;
import model.entities.ProtocolosdeServicos_Detalhe;

public class ProtocolosThreadIptuComparativos_Metodos_B extends  ProtocolosThreadIptuComparativos_Metodos_C {
	public void configuraTableView_1() {
		final ComboBox<TableColumn<ProtocolosdeServicos_Detalhe, ?>> sortCombo = new ComboBox<>(
				tV_ProtServicos_Detalhe.getColumns());

		final Callback<ListView<TableColumn<ProtocolosdeServicos_Detalhe, ?>>, ListCell<TableColumn<ProtocolosdeServicos_Detalhe, ?>>> cellFactory = new Callback<ListView<TableColumn<ProtocolosdeServicos_Detalhe, ?>>, ListCell<TableColumn<ProtocolosdeServicos_Detalhe, ?>>>() {
			@Override
			public ListCell<TableColumn<ProtocolosdeServicos_Detalhe, ?>> call(
					ListView<TableColumn<ProtocolosdeServicos_Detalhe, ?>> listView) {
				return createListCell();
			}
		};
		sortCombo.setCellFactory(cellFactory);
		sortCombo.setButtonCell(createListCell());
		sortCombo.valueProperty().addListener(new ChangeListener<TableColumn<ProtocolosdeServicos_Detalhe, ?>>() {
			@Override
			public void changed(ObservableValue<? extends TableColumn<ProtocolosdeServicos_Detalhe, ?>> obs,
					TableColumn<ProtocolosdeServicos_Detalhe, ?> oldCol,
					TableColumn<ProtocolosdeServicos_Detalhe, ?> newCol) {
				if (newCol != null) {
					tV_ProtServicos_Detalhe.getSortOrder().setAll(Collections.singletonList(newCol));
					newCol.setSortType(SortType.ASCENDING);
				} else {
					tV_ProtServicos_Detalhe.getSortOrder().clear();
				}
			}
		});
		aPane.getChildren().add(sortCombo);
		tV_ProtServicos_Detalhe.getSortOrder()
				.addListener(new ListChangeListener<TableColumn<ProtocolosdeServicos_Detalhe, ?>>() {
					@Override
					public void onChanged(Change<? extends TableColumn<ProtocolosdeServicos_Detalhe, ?>> change) {
						while (change.next()) {
							if (change.wasAdded()) {
								sortCombo.setValue(tV_ProtServicos_Detalhe.getSortOrder().get(0));
							}
						}
					}
				});

	}

	private ListCell<TableColumn<ProtocolosdeServicos_Detalhe, ?>> createListCell() {
		final ListCell<TableColumn<ProtocolosdeServicos_Detalhe, ?>> cell = new ListCell<>();
		cell.itemProperty().addListener(new ChangeListener<TableColumn<ProtocolosdeServicos_Detalhe, ?>>() {
			@Override
			public void changed(ObservableValue<? extends TableColumn<ProtocolosdeServicos_Detalhe, ?>> obs,
					TableColumn<ProtocolosdeServicos_Detalhe, ?> oldColumn,
					TableColumn<ProtocolosdeServicos_Detalhe, ?> newColumn) {
				if (newColumn == null) {
					cell.setText(null);
				} else {
					cell.setText(newColumn.getText());
				}
			}
		});
		return cell;
	}
	
	public void configuraTableView_2() {
		tC_Contador.setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Integer>("contador"));
		tC_Contador.setSortType(TableColumn.SortType.ASCENDING);
		tC_Contador.setPrefWidth(80);
		tC_Valor_Anterior
				.setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Double>("valorAnt"));
		tC_Valor_Anterior.setPrefWidth(120);
		tC_Valor_Anterior.setSortType(TableColumn.SortType.ASCENDING);
		tC_Valor_Atual
				.setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Double>("valorAtual"));
		tC_Valor_Atual.setPrefWidth(120);
		tC_Valor_Atual.setSortType(TableColumn.SortType.ASCENDING);
		tC_Diferenca.setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Double>("diferenca"));
		tC_Diferenca.setPrefWidth(120);
		tC_Diferenca.setSortType(TableColumn.SortType.ASCENDING);
		tC_Percentual.setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Double>("percentual"));
		tC_Percentual.setPrefWidth(80);
		tC_Percentual.setSortType(TableColumn.SortType.DESCENDING);
		tC_Inscricao
				.setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Inscricao>("id_Inscricao"));
		tC_Inscricao.setPrefWidth(120);
		tC_Inscricao.setSortType(TableColumn.SortType.ASCENDING);
		tC_Data_Hora.setCellValueFactory(
				new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Calendar>("ultimaAtualizacao"));		
		tC_Data_Hora.setPrefWidth(130);
		tC_Data_Hora.setSortType(TableColumn.SortType.ASCENDING);
		tC_Responsavel.setCellValueFactory(
				new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Pessoa>("id_Pessoa_Registro"));
		tC_Responsavel.setPrefWidth(250);	
		tC_Responsavel.setSortType(TableColumn.SortType.ASCENDING);
		tV_ProtServicos_Detalhe.getSortOrder().add(tC_Percentual);
					
		}
	
		

}

package controller.protocolos.passoa;

import java.io.IOException;
import java.util.Collections;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.entities.ProtocolosdeServicos_Detalhe;

public class ProtocoloController_Controles_Metodos_B extends ProtocoloController_Controles_Metodos_C {
	public void inicializarObservadores() {
		configuraTableView_1();
		configuraTableView_2();
		configuraTableView_3();
		configuraTableView_4();
	}
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
	
	public boolean chamaTelaPassoB() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("protocolos_passob.fxml"));
		AnchorPane page = null;
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Passo B - " + ProtocoloController_ControlesGerais_A.getServicosClassificacoes().getDescricao());
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);

		ProtocoloController_ControlesGerais_A.setOk(false);		
		dialogStage.showAndWait();
		
		return ProtocoloController_ControlesGerais_A.isOk();
	}

}

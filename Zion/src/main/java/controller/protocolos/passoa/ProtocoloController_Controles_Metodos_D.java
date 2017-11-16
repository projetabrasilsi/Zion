package controller.protocolos.passoa;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import model.entities.Inscricao;
import model.entities.Pessoa;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Comparativos_Resultados;
import model.enums.Enum_Aux_Tipo_Conferencia;

public class ProtocoloController_Controles_Metodos_D extends ProtocoloController_Controles_Metodos_E {
	public void configuraTableView_3() {
		tC_Inscricao.setCellFactory(
				new Callback<TableColumn<ProtocolosdeServicos_Detalhe, Inscricao>, TableCell<ProtocolosdeServicos_Detalhe, Inscricao>>() {
					@Override
					public TableCell<ProtocolosdeServicos_Detalhe, Inscricao> call(
							TableColumn<ProtocolosdeServicos_Detalhe, Inscricao> p) {
						final TableCell<ProtocolosdeServicos_Detalhe, Inscricao> cell = new TableCell<ProtocolosdeServicos_Detalhe, Inscricao>() {
							@Override
							public void updateItem(final Inscricao item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									this.setText("");
								} else {

									if (item != null && item.getnInsc() != null)
										this.setText(item.getnInsc());
									else
										this.setText("");
								}
							}
						};
						return cell;
					}
				});

		tC_Responsavel.setCellFactory(
				new Callback<TableColumn<ProtocolosdeServicos_Detalhe, Pessoa>, TableCell<ProtocolosdeServicos_Detalhe, Pessoa>>() {
					@Override
					public TableCell<ProtocolosdeServicos_Detalhe, Pessoa> call(
							TableColumn<ProtocolosdeServicos_Detalhe, Pessoa> p) {
						final TableCell<ProtocolosdeServicos_Detalhe, Pessoa> cell = new TableCell<ProtocolosdeServicos_Detalhe, Pessoa>() {
							@Override
							public void updateItem(final Pessoa item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									this.setText("");
								} else {
									if (item != null && item.getDescricao() != null)
										this.setText(item.getDescricao());
									else
										this.setText("");
								}
							}
						};
						return cell;
					}
				});

		tC_Resultado.setCellFactory(
				new Callback<TableColumn<ProtocolosdeServicos_Detalhe, Enum_Aux_Comparativos_Resultados>, TableCell<ProtocolosdeServicos_Detalhe, Enum_Aux_Comparativos_Resultados>>() {
					@Override
					public TableCell<ProtocolosdeServicos_Detalhe, Enum_Aux_Comparativos_Resultados> call(
							TableColumn<ProtocolosdeServicos_Detalhe, Enum_Aux_Comparativos_Resultados> p) {
						final TableCell<ProtocolosdeServicos_Detalhe, Enum_Aux_Comparativos_Resultados> cell = new TableCell<ProtocolosdeServicos_Detalhe, Enum_Aux_Comparativos_Resultados>() {
							@Override
							public void updateItem(final Enum_Aux_Comparativos_Resultados item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									this.setText("");
								} else {
									if (item != null && item.getDescricao() != null)
										this.setText(item.getDescricao());
									else
										this.setText("");
								}
							}
						};
						return cell;
					}
				});

		tC_Data_Hora.setCellFactory(
				new Callback<TableColumn<ProtocolosdeServicos_Detalhe, Calendar>, TableCell<ProtocolosdeServicos_Detalhe, Calendar>>() {
					@Override
					public TableCell<ProtocolosdeServicos_Detalhe, Calendar> call(
							TableColumn<ProtocolosdeServicos_Detalhe, Calendar> p) {
						final TableCell<ProtocolosdeServicos_Detalhe, Calendar> cell = new TableCell<ProtocolosdeServicos_Detalhe, Calendar>() {
							@Override
							public void updateItem(final Calendar item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									this.setText("");
								} else {
									if (item != null && item.getTime() != null) {

										SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
										String strDate = sdf.format(item.getTime());
										this.setText(strDate);
									} else
										this.setText("");
								}
							}
						};
						return cell;
					}
				});
		
		tC_TipoConferencia.setCellFactory(
				new Callback<TableColumn<ProtocolosdeServicos_Detalhe, Enum_Aux_Tipo_Conferencia>, TableCell<ProtocolosdeServicos_Detalhe, Enum_Aux_Tipo_Conferencia>>() {
					@Override
					public TableCell<ProtocolosdeServicos_Detalhe, Enum_Aux_Tipo_Conferencia> call(
							TableColumn<ProtocolosdeServicos_Detalhe, Enum_Aux_Tipo_Conferencia> p) {
						final TableCell<ProtocolosdeServicos_Detalhe, Enum_Aux_Tipo_Conferencia> cell = new TableCell<ProtocolosdeServicos_Detalhe, Enum_Aux_Tipo_Conferencia>() {
							@Override
							public void updateItem(final Enum_Aux_Tipo_Conferencia item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									this.setText("");
								} else {
									if (item != null && item.getCabecalho() != null) {
										this.setText(item.getCabecalho());
									} else
										this.setText("");
								}
							}
						};
						return cell;
					}
				});
	}

}

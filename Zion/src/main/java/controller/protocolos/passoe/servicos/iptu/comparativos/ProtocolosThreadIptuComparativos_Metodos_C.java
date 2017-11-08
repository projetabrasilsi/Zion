package controller.protocolos.passoe.servicos.iptu.comparativos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import model.entities.Inscricao;
import model.entities.Pessoa;
import model.entities.ProtocolosdeServicos_Detalhe;

public class ProtocolosThreadIptuComparativos_Metodos_C extends  ProtocolosThreadIptuComparativos_Metodos_D {
	public void configuraTableView_3() {
		tV_ProtServicos_Detalhe.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				KeyCode keyCode = keyEvent.getCode();
				if (keyEvent.isControlDown() && keyCode == KeyCode.END) {

				}
			}
		});
		
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
									this.setText(item.getnInsc());
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
									this.setText(item.getDescricao());
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

									SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
									String strDate = sdf.format(item.getTime());
									this.setText(strDate);
								}
							}
						};
						return cell;
					}
				});
	}
	public void sucesso() {
		lb_Titulo_Tela.setTextFill(Color.web("#0a7cdf"));		
		bt_Fechar.setVisible(true);
		bt_Fechar.setDisable(false);

		if (ProtocoloController_ControlesGerais_A.isOk() && ProtocoloController_ControlesGerais_A.isFinalizado())			
		lb_Titulo_Tela.setText("ETAPA DE COMPARAÇÕES: Finalizada com Sucesso!!!");			
		 else {
			lb_Titulo_Tela.setTextFill(Color.web("#ff0000"));	
		    lb_Titulo_Tela.setText("ETAPA DE COMPARAÇÕES: NÃO FOI REALIZADA. ERRO!");
		
		}
	}
	
		

}

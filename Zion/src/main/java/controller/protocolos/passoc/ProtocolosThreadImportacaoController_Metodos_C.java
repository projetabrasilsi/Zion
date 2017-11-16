package controller.protocolos.passoc;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import util.Utilidades;

public class ProtocolosThreadImportacaoController_Metodos_C extends ProtocolosThreadImportacaoController_Metodos_D {
	public boolean verificaCpfCnpj(int celula, Row row) {
		Cell cell;
		cell = row.getCell(celula, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			setarNegativo("ERROR - CPF/CNPJ. \nNão existe. Favor Verificar coluna (" + celulaAviso + ") - Linha(" + (i)
					+ ")");
			return false;
		}
		cpf_Cnpj = row.getCell(celula).getStringCellValue();
		cpf_Cnpj = Utilidades.retiraCaracteres(cpf_Cnpj);
		if (cpf_Cnpj.length() != 11 && cpf_Cnpj.length() != 14) {
			setarNegativo("ERROR - Validação de CPF/CNPJ. \nNão Validado. Favor Verificar coluna (" + celulaAviso
					+ ") - Linha(" + (i) + ")");
			cpf_Cnpj = "";
			return false;
		} else {
			if (cpf_Cnpj.length() == 11) {
				if (!Utilidades.isValidCPF(cpf_Cnpj)) {
					cpf_Cnpj = "";
					setarNegativo("ERROR - Validação de CPF. \nNão é Válido. Favor Verificar coluna (" + celulaAviso
							+ ") - Linha(" + (i) + ")");
					return false;
				}
			} else if (cpf_Cnpj.length() == 14) {
				if (!Utilidades.isValidCNPJ(cpf_Cnpj)) {
					cpf_Cnpj = "";
					setarNegativo("ERROR - Validação de CNPJ. \nNão é Válido. Favor Verificar coluna (" + celulaAviso
							+ ") - Linha(" + (i) + ")");
					return false;
				}
			}
		}
		this.celula++;
		return true;
	}

	public void sucesso(int nLista) {
		lb_Titulo.setTextFill(Color.web("#0a7cdf"));
		bt_Fechar.setVisible(true);
		bt_Fechar.setDisable(false);
		if (ProtocoloController_ControlesGerais_A.isOk() && ProtocoloController_ControlesGerais_A.isFinalizado()) {
			if (nLista == 1)
				lb_Titulo.setText("PRIMEIRA LISTA IMPORTADA: Com Sucesso!!!");
			else
				lb_Titulo.setText("SEGUNDA LISTA IMPORTADA: Com com Sucesso!!!");
		} else {
			lb_Titulo.setTextFill(Color.web("#ff0000"));

			if (nLista == 1)

				lb_Titulo.setText("PRIMEIRA LISTA Não foi Importada: ERROR!!!\n" + lb_Titulo.getText());
			else
				lb_Titulo.setText("SEGUNDA LISTA não foi Importada: ERROR!!!\n" + lb_Titulo.getText());
		}
	}

	public void falha() {
		bt_Fechar.setVisible(true);
		bt_Fechar.setDisable(false);
		pBar = new ProgressBar(0);
		pBI = new ProgressIndicator(0);
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
		lb_Titulo.setText(ProtocoloController_ControlesGerais_A.getTextoResposta());
	}

	public void inicializaEventos() {
		bt_Fechar.setOnAction((e) -> {
			fechatela();
		});
	}

	protected void fechatela() {
		Stage stage = (Stage) lb_Titulo.getScene().getWindow();
		stage.close();
	}
	public void setarNegativo(String resposta) {
		ProtocoloController_ControlesGerais_A.setTextoResposta(resposta);
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
	}


}

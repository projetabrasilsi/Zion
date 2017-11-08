package controller.protocolos.passoc;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProtocolosThreadImportacaoController_Metodos_B extends ProtocolosThreadImportacaoController_Metodos_C {
	public void inicializaEventos() {
		bt_Fechar.setOnAction((e) -> {
			fechatela();
		});
	}
	protected void fechatela() {
		Stage stage = (Stage) lb_Titulo.getScene().getWindow();
		stage.close();
	}
	public String retornaMensagemFormatada(String texto) {
		String subTexto_1 = "";
		String subTexto_2 = "";
		String subTexto_3 = "";
		String subTexto_4 = "";
		String subTexto_5 = "";
		String subTexto_6 = "";
		int tam = texto.length();
		int nCar = 40;
		int qtde = 0;

		qtde = tam / nCar;
		if (tam % nCar > 0)
			qtde++;

		if (qtde > 6)
			qtde = 6;
		for (int i = 0; i < qtde; i++) {
			String ret = "";
			if (qtde - 1 > i)
				ret = texto.substring((i) * 40, (i + 1) * 40);
			else
				ret = texto.substring((i) * 40, texto.length());
			if (ret.length() > 0)
				ret = ret + "\n";
			if (subTexto_1.length() == 0)
				subTexto_1 = ret;
			else if (subTexto_2.length() == 0)
				subTexto_2 = ret;
			else if (subTexto_3.length() == 0)
				subTexto_3 = ret;
			else if (subTexto_4.length() == 0)
				subTexto_4 = ret;
			else if (subTexto_5.length() == 0)
				subTexto_5 = ret;
			else if (subTexto_6.length() == 0)
				subTexto_6 = ret;
		}
		texto = subTexto_1 + subTexto_2 + subTexto_3 + subTexto_4 + subTexto_5 + subTexto_6;
		return texto;
	}
	public Workbook retornaWorkbook() {
		String texto = "";
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(ProtocoloController_ControlesGerais_A.getSelectedFile());
		} catch (InvalidFormatException e) {
			workbook = null;
			texto = "FORMATO INVÁLIDO: " + e.getMessage();
			
			ProtocoloController_ControlesGerais_A.setTextoResposta(retornaMensagemFormatada(texto));
			e.printStackTrace();			
		} catch (IOException e) {
			workbook = null;
			texto = "EXCEÇÃO: " + e.getMessage();
			ProtocoloController_ControlesGerais_A.setTextoResposta(retornaMensagemFormatada(texto));
			e.printStackTrace();			
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				texto = "EXCEÇÃO NO FECHAMENTO DE ARQUIVO: " + e.getMessage();
				ProtocoloController_ControlesGerais_A.setTextoResposta(retornaMensagemFormatada(texto));
				e.printStackTrace();
			}
		}
		return workbook;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getAno() {
		return ano;
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
}

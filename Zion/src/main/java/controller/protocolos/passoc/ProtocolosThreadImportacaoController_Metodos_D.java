package controller.protocolos.passoc;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;

public class ProtocolosThreadImportacaoController_Metodos_D extends ProtocolosThreadImportacaoController_Controles_A  {
	
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
		
}

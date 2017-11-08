package controller.protocolos.passoc;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.entities.Comparativos;
import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Servicos_Restricoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;
import util.Utilidades;

public class ProtocolosThreadImportacaoController_Metodos_A extends ProtocolosThreadImportacaoController_Metodos_B {
	@SuppressWarnings({ "deprecation" })
	public boolean formataLista(Row row, int anoPar, int totLinha, int nLista) {
		String texto = "";
		String nInsc = "";
		double valor = 0;
		int ano = 0;
		int i = 1;
		Cell cell;
		cell = row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell != null) {
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				nInsc = "" + String.valueOf(cell.getNumericCellValue());
			else
				nInsc = "" + cell.getStringCellValue();
			nInsc = Utilidades.retornaSomenteNumeros(nInsc).trim();
			if (nInsc.isEmpty()) {				
				setarNegativo(
						"ERROR - NÚMERO DE INSCRIÇÃO. \nNão existe. Favor Verificar coluna 1 - Linha(" + (i) + ")" );
				return false;
			}
		} else {
			setarNegativo(
					"ERROR - NÚMERO DE INSCRIÇÃO. \nNão existe. Favor Verificar coluna 1 - Linha(" + (i) + ")");			
			return false;
		}
		cell = row.getCell(1, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell != null) {
			valor = cell.getNumericCellValue();
		} else {
			setarNegativo("ERROR - VALOR. \nNão existe. Favor Verificar coluna 2 - Linha(" + (i) + ")");			
			return false;
		}
		cell = row.getCell(2, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell != null) {
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				ano = (int) cell.getNumericCellValue();
			else {
				String s = cell.getStringCellValue();
				s = Utilidades.retiraCaracteres(s);
				ano = Integer.parseInt(s);
			}
			if (ano != anoPar) {
				setarNegativo("ERROR - ano da Listagem.(" + ano + ") \nNão confere com ano escolhido("
								+ anoPar + ").\nFavor Verificar coluna 3 - Linha(" + (i) + ")");				
				return false;
			}
		} else {
			setarNegativo("ERROR - ano. \nNão existe. Favor Verificar coluna 3 - Linha(" + (i) + ")");			
			return false;
		}
		String stringClassif = row.getCell(3).getStringCellValue();
		Enum_Aux_Servicos_Classificacoes classif = Enum_Aux_Servicos_Classificacoes.retornaEnum(stringClassif);
		if (classif == null) {
			setarNegativo("ERROR - CLASSIFICAÇÃO DE SERVIÇO. \nNão existe. Favor Verificar coluna 4 - Linha(" + (i) + ")");			
			return false;
		}
		String stringSub = row.getCell(4).getStringCellValue();
		Enum_Aux_Servicos_Sub_Classificacoes sub = Enum_Aux_Servicos_Sub_Classificacoes.retornaEnum(stringSub);
		if (sub == null) {
			setarNegativo(
					"ERROR - SUB-CLASSIFICAÇÃO DE SERVIÇO. \nNão existe. Favor Verificar coluna 5 - Linha(" + (i)
							+ ")");
			
			return false;
		}
		String stringRestr = row.getCell(5).getStringCellValue();
		Enum_Aux_Servicos_Restricoes restr = Enum_Aux_Servicos_Restricoes.retornaEnum(stringRestr);
		if (restr == null) {
			setarNegativo("ERROR - RESTRIÇÃO DE SERVIÇO. \nNão existe. Favor Verificar coluna 6 - Linha(" + (i) + ")");
			
			return false;
		}
		nInsc = Utilidades.retornaSomenteNumeros(nInsc);
		texto = "Gerando";
		Comparativos comp = new Comparativos(nInsc, valor, ano, classif, sub, restr);
		if (nLista == 1  ) {
			texto += " PRIMEIRA ";
			if (ProtocoloController_ControlesGerais_A.getComparativos_1() == null)
				ProtocoloController_ControlesGerais_A.setComparativos_1(new ArrayList<>());
			ProtocoloController_ControlesGerais_A.getComparativos_1().add(comp);
		} else {
			texto += " SEGUNDA ";
			if (ProtocoloController_ControlesGerais_A.getComparativos_2() == null)
				ProtocoloController_ControlesGerais_A.setComparativos_2(new ArrayList<>());
			ProtocoloController_ControlesGerais_A.getComparativos_2().add(comp);
		}
		texto += "LISTA (" + i + "/" + totLinha + ")\nI.M: " + nInsc;
		ProtocoloController_ControlesGerais_A.setTextoResposta(texto);
		return true;
	}
	
	public void setarNegativo(String resposta ) {		
		ProtocoloController_ControlesGerais_A.setTextoResposta(resposta);
		ProtocoloController_ControlesGerais_A.setOk(false);
		ProtocoloController_ControlesGerais_A.setFinalizado(false);
	}

}

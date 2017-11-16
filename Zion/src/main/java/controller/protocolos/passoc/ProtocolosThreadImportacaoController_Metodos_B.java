package controller.protocolos.passoc;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Servicos_Restricoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;
import util.Utilidades;

public class ProtocolosThreadImportacaoController_Metodos_B extends ProtocolosThreadImportacaoController_Metodos_C {
	@SuppressWarnings("deprecation")
	public boolean verificaAno(int celula, Row row, int anoPar) {
		Cell cell;
		cell = row.getCell(celula, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			setarNegativo(
					"ERROR - ano. \nNão existe. Favor Verificar coluna (" + celulaAviso + ") - Linha(" + (i) + ")");
			return false;
		}

		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			ano1 = (int) cell.getNumericCellValue();
		else {
			String s = cell.getStringCellValue();
			s = Utilidades.retiraCaracteres(s);
			ano1 = Integer.parseInt(s);
		}
		if (ano1 != anoPar) {
			setarNegativo("ERROR - ano da Listagem.(" + ano + ") \nNão confere com ano escolhido(" + anoPar
					+ ").\nFavor Verificar coluna (" + celulaAviso + ") - Linha(" + (i) + ")");
			return false;
		}
		this.celula++;

		return true;
	}

	public boolean verificaClassificacao(int celula, Row row) {
		Cell cell;
		cell = row.getCell(celula, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			setarNegativo("ERROR - CLASSIFICAÇÃO DE SERVIÇO. \nNão existe. Favor Verificar coluna (" + celulaAviso
					+ ") - Linha(" + (i) + ")");
			return false;
		}

		stringClassif = row.getCell(celula).getStringCellValue();
		classif = Enum_Aux_Servicos_Classificacoes.retornaEnum(stringClassif);
		if (classif == null) {
			setarNegativo("ERROR - CLASSIFICAÇÃO DE SERVIÇO. \nNão existe. Favor Verificar coluna (" + celulaAviso
					+ ") - Linha(" + (i) + ")");
			return false;
		}
		if (!classif
				.equals(ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getClassificacao())) {
			setarNegativo(
					"ERROR - CLASSIFICAÇÃO DE SERVIÇO. \nServido descrito na listagem não é o mesmo do painel de controle. Favor Verificar coluna ("
							+ celulaAviso + ") - Linha(" + (i) + ")");

			return false;

		}
		this.celula++;
		return true;
	}

	public boolean verificaSubClassificacao(int celula, Row row) {
		Cell cell;
		cell = row.getCell(celula, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			setarNegativo("ERROR - SUB-CLASSIFICAÇÃO DE SERVIÇO. \nNão existe. Favor Verificar coluna (" + celulaAviso
					+ ") - Linha(" + (i) + ")");
			return false;
		}
		stringSub = row.getCell(celula).getStringCellValue();
		sub = Enum_Aux_Servicos_Sub_Classificacoes.retornaEnum(stringSub);
		if (sub == null) {
			setarNegativo("ERROR - SUB-CLASSIFICAÇÃO DE SERVIÇO. \nNão existe. Favor Verificar coluna (" + celulaAviso
					+ ") - Linha(" + (i) + ")");
			return false;
		}
		if (!sub.equals(
				ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao())) {
			setarNegativo(
					"ERROR - SUB-CLASSIFICAÇÃO DE SERVIÇO. \nServido descrito na listagem não é o mesmo do painel de controle. Favor Verificar coluna ("
							+ celulaAviso + ") - Linha(" + (i) + ")");
			return false;
		}
		this.celula++;
		return true;
	}

	public boolean verificaRestricao(int celula, Row row) {
		Cell cell;
		cell = row.getCell(celula, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			setarNegativo("ERROR - RESTRIÇÃO DE SERVIÇO. \nNão existe. Favor Verificar coluna (" + celulaAviso
					+ ") - Linha(" + (i) + ")");
			return false;
		}
		stringRestr = row.getCell(celula).getStringCellValue();
		restr = Enum_Aux_Servicos_Restricoes.retornaEnum(stringRestr);
		if (restr == null) {
			setarNegativo("ERROR - RESTRIÇÃO DE SERVIÇO. \nNão existe. Favor Verificar coluna (" + celulaAviso
					+ ") - Linha(" + (i) + ")");
			return false;
		}
		if (!restr.equals(ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getRestricao())) {
			setarNegativo(
					"ERROR - RESTRIÇÃO DE SERVIÇO. \nServido descrito na listagem não é o mesmo do painel de controle. Favor Verificar coluna ("
							+ celulaAviso + ") - Linha(" + (i) + ")");
			return false;
		}
		this.celula++;
		return true;
	}

}

package controller.protocolos.passoc;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.entities.Comparativos;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;
import util.Utilidades;

public class ProtocolosThreadImportacaoController_Metodos_A extends ProtocolosThreadImportacaoController_Metodos_B {
	public boolean formataLista(Row row, int anoPar, int totLinha, int nLista, int linha) {
		celula = 0;
		i = linha;
		if (!VerificacaoBase(row))
			return false;
		if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao()
				.equals(Enum_Aux_Servicos_Sub_Classificacoes.COMPARATIVOS)) {
			if (!verificaComparativos(row, anoPar))
				return false;
		} else if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao()
				.equals(Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS)) {
			if (!verificaConferenciadeDebito(row))
				return false;
		}
		this.celula--;
		nInsc = Utilidades.retornaSomenteNumeros(nInsc);
		texto = "Gerando";
		if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao()
				.equals(Enum_Aux_Servicos_Sub_Classificacoes.COMPARATIVOS)) {
			Comparativos comp = new Comparativos(nInsc, valor, ano1, classif, sub, restr, cpf_Cnpj);
			if (nLista == 1) {
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
		} else if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao()
				.equals(Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS)) {
			Comparativos comp = new Comparativos(nInsc, valor, ano1, classif, sub, restr, cpf_Cnpj);
			texto = "LISTAGEM ";
			if (ProtocoloController_ControlesGerais_A.getComparativos_1() == null)
				ProtocoloController_ControlesGerais_A.setComparativos_1(new ArrayList<>());
			ProtocoloController_ControlesGerais_A.getComparativos_1().add(comp);
		}
		texto += "LISTA (" + i + "/" + totLinha + ")\nI.M: " + nInsc;
		ProtocoloController_ControlesGerais_A.setTextoResposta(texto);
		return true;
	}

	public boolean VerificacaoBase(Row row) {
		celulaAviso = celula + 1;
		if (!verificaClassificacao(celula, row))
			return false;
		if (!verificaSubClassificacao(celula, row))
			return false;
		if (!verificaRestricao(celula, row))
			return false;
		if (!verificaInscricao(celula, row))
			return false;
		return true;
	}

	public boolean verificaComparativos(Row row, int anoPar) {
		if (!verificaValor(celula, row))
			return false;
		if (!verificaAno(celula, row, anoPar))
			return false;
		return true;
	}

	public boolean verificaConferenciadeDebito(Row row) {
		if (!verificaCpfCnpj(celula, row))
			return false;
		this.celula++;
		return true;
	}

	@SuppressWarnings({ "deprecation" })
	public boolean verificaInscricao(int celula, Row row) {
		Cell cell;
		cell = row.getCell(celula, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			nInsc = "";
			setarNegativo("ERROR - NÚMERO DE INSCRIÇÃO. \nNão existe. Favor Verificar coluna (" + celulaAviso
					+ ") - Linha(" + (i) + ")");
			return false;
		}
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			nInsc = "" + String.valueOf(cell.getNumericCellValue());
		else
			nInsc = "" + cell.getStringCellValue();
		nInsc = Utilidades.retornaSomenteNumeros(nInsc).trim();
		if (nInsc.isEmpty()) {
			setarNegativo("ERROR - NÚMERO DE INSCRIÇÃO. \nNão existe. Favor Verificar coluna (" + celulaAviso
					+ ") - Linha(" + (i) + ")");
			return false;
		}
		this.celula++;
		return true;
	}

	public boolean verificaValor(int celula, Row row) {
		Cell cell;
		cell = row.getCell(celula, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			nInsc = "";
			setarNegativo(
					"ERROR - VALOR. \nNão existe. Favor Verificar coluna (" + celulaAviso + ") - Linha(" + (i) + ")");
			return false;
		}
		valor = cell.getNumericCellValue();
		this.celula++;
		return true;
	}

}

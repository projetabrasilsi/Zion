package controller.protocolos.passoa;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TableColumn;
import util.Utilidades;

public class ProtocoloController_Controles_Metodos_J extends ProtocoloController_Controles_A {
	@SuppressWarnings({ "rawtypes" })
	public void configuraPainelPrincipal() {
		List<TableColumn> tCLista = new ArrayList<>();

		if (Utilidades.getpPL().getEnum_Aux_Servicos_Composicoes().getSub_Classificacao().isComparativo()) {
			if (!aPane.getChildren().contains(group_Quadro_Resumo))
				aPane.getChildren().add(group_Quadro_Resumo);
			if (!aPane.getChildren().contains(group_Quadro))
				aPane.getChildren().add(group_Quadro);
			if (!aPane.getChildren().contains(group_Comparativos))
				aPane.getChildren().add(group_Comparativos);
			
			tCLista.add(tC_Contador);
			tCLista.add(tC_Inscricao);
			tCLista.add(tC_Data_Hora);
			tCLista.add(tC_Valor_Anterior);
			tCLista.add(tC_Valor_Atual);
			tCLista.add(tC_Diferenca);
			tCLista.add(tC_Percentual);
			tCLista.add(tC_Resultado);
			tCLista.add(tC_Ordem);			
			adicionaOuRemoveColunas(tCLista);			
			cB_FilterField.setVisible(true);					
		} else {
			if (aPane.getChildren().contains(group_Quadro_Resumo))
				aPane.getChildren().remove(group_Quadro_Resumo);
			if (aPane.getChildren().contains(group_Quadro))
				aPane.getChildren().remove(group_Quadro);

			if (aPane.getChildren().contains(group_Comparativos))
				aPane.getChildren().remove(group_Comparativos);
			
			tCLista.add(tC_Contador);
			tCLista.add(tC_Inscricao);
			tCLista.add(tC_Data_Hora);			
			tCLista.add(tC_StatusConsulta);
			tCLista.add(tC_TipoConferencia);
			//tCLista.add(tC_Ordem);
			
			adicionaOuRemoveColunas(tCLista);			
			cB_FilterField.setVisible(false);			
		}
		
				
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void adicionaOuRemoveColunas(List<TableColumn> tCLista) {
		tV_ProtServicos_Detalhe.getColumns().clear();
		for (TableColumn tbc : tCLista) {
			tV_ProtServicos_Detalhe.getColumns().add(tbc);
		}

	}

}

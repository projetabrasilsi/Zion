package controller.protocolos.passoa;

import java.util.Calendar;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dao.ProtocolosdeServicosDAO;
import model.entities.Inscricao;
import model.entities.Pessoa;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Comparativos_Resultados;
import util.Utilidades;

public class ProtocoloController_Controles_Metodos_C extends ProtocoloController_Controles_Metodos_D {
    public void configuraTableView_2() {
        tC_Contador.setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Integer>("contador"));
        tC_Contador.setSortType(TableColumn.SortType.ASCENDING);
        tC_Contador.setPrefWidth(80);
        tC_Valor_Anterior
                .setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Double>("valorAnt"));
        tC_Valor_Anterior.setPrefWidth(120);
        tC_Valor_Anterior.setSortType(TableColumn.SortType.ASCENDING);
        tC_Valor_Atual
                .setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Double>("valorAtual"));
        tC_Valor_Atual.setPrefWidth(120);
        tC_Valor_Atual.setSortType(TableColumn.SortType.ASCENDING);
        tC_Diferenca.setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Double>("diferenca"));
        tC_Diferenca.setPrefWidth(120);
        tC_Diferenca.setSortType(TableColumn.SortType.ASCENDING);
        tC_Percentual.setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Double>("percentual"));
        tC_Percentual.setPrefWidth(80);
        tC_Percentual.setSortType(TableColumn.SortType.DESCENDING);
        tC_Inscricao
                .setCellValueFactory(new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Inscricao>("id_Inscricao"));
        tC_Inscricao.setPrefWidth(120);
        tC_Inscricao.setSortType(TableColumn.SortType.ASCENDING);
        tC_Data_Hora.setCellValueFactory(
                new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Calendar>("ultimaAtualizacao"));
        tC_Data_Hora.setPrefWidth(130);
        tC_Data_Hora.setSortType(TableColumn.SortType.ASCENDING);
        tC_Responsavel.setCellValueFactory(
                new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Pessoa>("id_Pessoa_Registro"));
        tC_Responsavel.setPrefWidth(250);
        tC_Resultado.setCellValueFactory(
                new PropertyValueFactory<ProtocolosdeServicos_Detalhe, Enum_Aux_Comparativos_Resultados>(
                        "enum_Aux_Comparativos_Resultados"));
        tC_Resultado.setSortType(TableColumn.SortType.ASCENDING);
        tC_Resultado.setPrefWidth(170);
        cB_FilterField.setPrefWidth(tC_Resultado.getPrefWidth());

        tV_ProtServicos_Detalhe.getSortOrder().add(tC_Percentual);
        
        
        
        
        filteredData.addAll(ProtocolosdeServicos_DetalheObsList);
        
        ProtocolosdeServicos_DetalheObsList.addListener(new ListChangeListener<ProtocolosdeServicos_Detalhe>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends ProtocolosdeServicos_Detalhe> change) {
                updateFilteredData();
            }
        });
        
         cB_FilterField.valueProperty().addListener(new ChangeListener<Enum_Aux_Comparativos_Resultados>() {
 			@Override
 			public void changed(ObservableValue<? extends Enum_Aux_Comparativos_Resultados> observable,
 					Enum_Aux_Comparativos_Resultados oldValue, Enum_Aux_Comparativos_Resultados newValue) {
 				updateFilteredData();

 			}
 		});
    }
    
    private void updateFilteredData() {
        filteredData.clear();
        
        for (ProtocolosdeServicos_Detalhe p : ProtocolosdeServicos_DetalheObsList) {
            if (matchesFilter(p)) {
                filteredData.add(p);
            }
        }

        // Must re-sort table after items changed
        reapplyTableSortOrder();
        
    }
    
    private boolean matchesFilter(ProtocolosdeServicos_Detalhe p) {
        if(cB_FilterField.getValue() == null || cB_FilterField.getValue().getDescricao() == "")
            return true;
        String filterString = cB_FilterField.getValue().getDescricao();
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();
        
      

        if (p.getEnum_Aux_Comparativos_Resultados().getDescricao().toLowerCase().indexOf(lowerCaseFilterString) != -1)
            return true;
        else
        return false; // Does not match
    }

    

	private void reapplyTableSortOrder() {
		
		  //ArrayList<TableColumn<ProtocolosdeServicos_Detalhe, ?>> sortOrder = new ArrayList<>(tV_ProtServicos_Detalhe.getSortOrder());
 		  tV_ProtServicos_Detalhe.getSortOrder().clear();
		  SortedList<ProtocolosdeServicos_Detalhe> sortedData = new SortedList<>(filteredData);
		  tV_ProtServicos_Detalhe.setItems(sortedData);
        
    }
        
    public void salvaProtocoloServicos() {
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();
        ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setUltimaAtualizacao(Utilidades.retornaCalendario());
        if (ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getId() == null
                || ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getId() <= 0) {
            ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setTempoInicial(inicio);

        } else {
            inicio = ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getTempoInicial();
            ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setTempoFinal(fim);
            ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setDiferencadeTempo(
                    ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getTempoFinal().getTimeInMillis()
                            - ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().getTempoInicial()
                                    .getTimeInMillis());
            ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
                    .setDiferencadeTempoTexto(Utilidades.calculadiferencaTempo(inicio, fim));
            ProtocoloController_ControlesGerais_A.getProtocolosdeServicos().setEnum_Aux_Servicos_Composicoes(
                    ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes());
        }
        ProtocolosdeServicosDAO dao = new ProtocolosdeServicosDAO();
        ProtocoloController_ControlesGerais_A
                .setProtocolosdeServicos(dao.merge(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()));
    }

}

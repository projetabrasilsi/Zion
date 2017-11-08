package controller.protocolos.passoa;

import java.text.ParseException;
import java.util.List;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.entities.ProtocolosdeServicos;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Navegadores;
import util.Utilidades;

public class ProtocoloController_Controles_Metodos_F extends ProtocoloController_Controles_Metodos_G {
	public void navegacao(Enum_Aux_Navegadores nav) {
		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos(pSDAO.Navegar(nav, Utilidades.getpPL().getEmpresa_Logada(),
				ProtocoloController_ControlesGerais_A.getComposicaoServicosNavega(), ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()));		
		   
		   ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(ProtocoloController_ControlesGerais_A.buscaprotocoloservicosDetalhes());
		
		carregandoControles();
	}

	public void carregandoControles() {
		setarResumo(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos());
		if (ProtocoloController_ControlesGerais_A.getProtocolosdeServicos() != null)
			carregaControles(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos());
		else
			carregaControles(null);

	}

	public void carregaControles(ProtocolosdeServicos pS) {
		if (pS != null) {
			lb_Resp_Registro_Value.setText(pS.getId_Pessoa_Registro().getDescricao());
			try {
				lb_Ultima_Alteracao_Value.setText(Utilidades.transformaDataEmString(pS.getUltimaAtualizacao(), true));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lb_Id_Value.setText("" + pS.getId());
			if (pS.getDiferencadeTempoTexto() != null) {
				String texto = pS.getDiferencadeTempoTexto();
				lb_Duracao_Value.setText("");
				lb_Duracao_Value.setText(texto);

			} else
				lb_Duracao_Value.setText("");
			lb_Status_Value.setText(pS.getEnum_Aux_Servicos_Status().getStatus());
			lb_Escolha_Restricao_Value.setText(pS.getEnum_Aux_Servicos_Composicoes().getRestricao().getDescricao());
			lb_Tipo_Servico_Value.setText(pS.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao().getDescricao());
			lb_Classificacao_Value.setText(pS.getEnum_Aux_Servicos_Composicoes().getClassificacao().getDescricao());
			lb_Progresso.setText(pS.getEnum_Aux_Servicos_Status().getStatus());
			populatV_ProtServicos_Detalhe(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista());

		}

		else {
			lb_Duracao_Value.setText("");
			lb_Resp_Registro_Value.setText("");
			lb_Ultima_Alteracao_Value.setText("");
			lb_Id_Value.setText("");
			lb_Total_Inscricoes_Value.setText("");
			lb_Total_Valido_Value.setText("");
			lb_Total_Invalidado_Value.setText("");
			lb_Status_Value.setText("");
			lb_Escolha_Restricao_Value.setText("");
			lb_Tipo_Servico_Value.setText("");
			lb_Classificacao_Value.setText("");
			lb_Progresso.setText("");
			

			
			populatV_ProtServicos_Detalhe(null);
		}
	}

	public void populatV_ProtServicos_Detalhe(List<ProtocolosdeServicos_Detalhe> lista) {
		if (lista != null) {
			ProtocolosdeServicos_DetalheObsList.addAll(lista);
			tV_ProtServicos_Detalhe.setItems(ProtocolosdeServicos_DetalheObsList);
			tV_ProtServicos_Detalhe.getSelectionModel().selectLast();
		}
		else
			tV_ProtServicos_Detalhe.getItems().clear();
	}

	public void setarResumo(ProtocolosdeServicos pS) {
        if(pS!=null) {
        	lb_nTotalRegPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(1.0,true));
        	lb_PermanenciaPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getPermaneceuPercentual(),true));
		lb_nTotalReg_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnTotalReg()));
		lb_nRegAnt_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegAnt()));
		lb_nRegAtual_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegAtual()));

		
		lb_nRegDiminuiValor_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegDiminuiValor()));
		lb_nRegPermaneceuValor.setText("Permaneceram: " + pS.getAnoAnt() + "/" + pS.getAnoAtual());
		lb_nRegPermaneceuValor_Value.setPrefWidth(lb_nRegPermaneceuValor.getPrefWidth());
		lb_nRegAnt1111.setPrefWidth(lb_nRegPermaneceuValor.getPrefWidth());
		

		lb_nRegPermaneceuValor_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegPermaneceuValor()));
		lb_nRegSomenteAnt_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegSomenteAnt()));

		lb_nRegSomenteAtual_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegSomenteAtual()));
		lb_nRegPermanentes_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegPermanentes()));
		lb_nRegAnt.setText("" + pS.getAnoAnt());
		lb_nRegAnt_Value.setPrefWidth(lb_nRegAnt.getPrefWidth());
		lb_nRegAntPerc_Value.setPrefWidth(lb_nRegAnt.getPrefWidth());
		
		lb_nRegAtual.setText("" + pS.getAnoAtual());
		lb_nRegAtual_Value.setPrefWidth(lb_nRegAtual.getPrefWidth());
		lb_nRegAtualPerc_Value.setPrefWidth(lb_nRegAtual.getPrefWidth());		

		lb_nRegSomenteAtual.setText("Aquisições : " + pS.getAnoAtual());
		lb_nRegSomenteAnterior.setText("Perdas : " + pS.getAnoAnt());
		lb_nRegAtualExistentenoAnt.setText("Em: " + pS.getAnoAnt() + "/" + pS.getAnoAtual());
		
		lb_nRegSomenteAntPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getPerdaPercentual(),true) );
		lb_nRegSomenteAtualPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getNovosPercentual(),true) );
		lb_CrescimentoPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getCrescimentoPercentual(),true));
		
		lb_PermanenciaFinalPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getPermaneceuPercentual(),true));
		lb_Permanencia_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegPermanentes()));
		lb_Crescimento_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getCrescimento()));
		lb_nRegAumentouValor_Value.setText(ProtocoloController_ControlesGerais_A.formataNumeros(pS.getnRegAumentouValor()));
		lb_nRegAtualPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegAtualPerc(),true));
		lb_nRegAntPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegAntPerc(),true));
		
		
		
		lb_VlTotAnt_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotAnt(),false));
		lb_vlTotAtual_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotAtual(),false));
		lb_VlTotSomenteAtual_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotSomenteAtual(),false));
		lb_VlTotSomenteAnt_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotSomenteAnt(),false));
		lb_VlTotPermaneceu_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotPermaneceu(),false));		
		lb_VlTotAumentouValor_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotAumentou(),false));		
		lb_VlTotDiminuiValor_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotDiminuiu(),false));		
		lb_VlTotPermaneceuValor_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotPermaneceuValor(),false));
		lb_DifInflacao_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotDifInflacao(),false));
		lb_DifDeflanflacao_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getVlTotDifDeflacao(),false));
		
		lb_CarteiraDiferencaInflacao.setText(lb_DifInflacao_Value.getText());
		lb_CarteiraDiferencaDeflacao.setText(lb_DifDeflanflacao_Value.getText());
											 
		lb_CarteiraClientesNovos.setText(lb_VlTotSomenteAtual_Value.getText());
		lb_CarteiraDiferencaInflacao.setText(lb_DifInflacao_Value.getText());
		lb_CarteiraDiferencaDeflacao.setText(lb_DifDeflanflacao_Value.getText());
		lb_CarteiraClientesBaixados.setText(lb_VlTotSomenteAnt_Value.getText());
		lb_CarteiraResultadoA.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getCarteiraResultadoA(),false));
		lb_CarteiraResultadoB.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getCarteiraResultadoB(),false));
		lb_CarteiraResultadoFinal.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getCarteiraResultadoFinal(),false));
		lb_CarteiraResultadoPercentualFinal.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getCarteiraResultadoPercentualFinal(),true));
		
		lb_nRegAumentouValorPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegAumentouValorPerc(),true));
		lb_nRegDiminuiValorPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegDiminuiValorPerc(),true));
		lb_nRegPermaneceuValorPerc_Value.setText(ProtocoloController_ControlesGerais_A.retornaFormato(pS.getnRegAumentouValorPerc(),true));
		
		
		
		
		
		
		
		
        }else {
        	lb_PermanenciaFinalPerc_Value.setText("");
        	lb_nTotalRegPerc_Value.setText("");
        	lb_PermanenciaPerc_Value.setText("");
        	lb_nTotalReg_Value.setText("");
    		lb_nRegAnt_Value.setText("");
    		lb_nRegAtual_Value.setText("");

    		lb_nRegAumentouValor_Value.setText("");
    		lb_nRegDiminuiValor_Value.setText("");
    		lb_nRegPermaneceuValor.setText("");
    		lb_nRegPermaneceuValor_Value.setPrefWidth(lb_nRegPermaneceuValor.getPrefWidth());
    		lb_nRegAnt1111.setPrefWidth(lb_nRegPermaneceuValor.getPrefWidth());
    		

    		lb_nRegPermaneceuValor_Value.setText("");
    		lb_nRegSomenteAnt_Value.setText("");

    		lb_nRegSomenteAtual_Value.setText("");
    		lb_nRegPermanentes_Value.setText("");
    		lb_nRegAnt.setText("");
    		lb_nRegAnt_Value.setPrefWidth(lb_nRegAnt.getPrefWidth());
    		lb_nRegAntPerc_Value.setPrefWidth(lb_nRegAnt.getPrefWidth());
    		
    		lb_nRegAtual.setText("");
    		lb_nRegAtual_Value.setPrefWidth(lb_nRegAtual.getPrefWidth());
    		lb_nRegAtualPerc_Value.setPrefWidth(lb_nRegAtual.getPrefWidth());

    		lb_nRegSomenteAtual.setText("Aquisições : ");
    		lb_nRegSomenteAnterior.setText("Perdas : ");
    		lb_nRegAtualExistentenoAnt.setText("Em: ");
    		
    		lb_nRegSomenteAntPerc_Value.setText("");
    		lb_nRegSomenteAtualPerc_Value.setText("");
    		lb_CrescimentoPerc_Value.setText("");
    		lb_PermanenciaPerc_Value.setText("");
    		lb_Permanencia_Value.setText("");
    		lb_Crescimento_Value.setText("");
    		lb_nRegAtualPerc_Value.setText("");
    		lb_nRegAntPerc_Value.setText("");
    		
			
			lb_PermanenciaFinalPerc_Value.setText("");
			
			lb_VlTotAnt_Value.setText("");
			lb_VlTotSomenteAtual_Value.setText("");
			lb_VlTotSomenteAnt_Value.setText("");
			lb_VlTotPermaneceu_Value.setText("");
			lb_nRegAumentouValorPerc_Value.setText("");
			lb_VlTotAumentouValor_Value.setText("");
			lb_nRegDiminuiValorPerc_Value.setText("");
			lb_VlTotDiminuiValor_Value.setText("");
			lb_nRegPermaneceuValor_Value.setText("");
			lb_VlTotPermaneceuValor_Value.setText("");
			
			lb_CarteiraDiferencaInflacao.setText("");
			lb_CarteiraDiferencaDeflacao.setText("");
			lb_CarteiraClientesNovos.setText("");
			lb_CarteiraClientesBaixados.setText("");
			lb_CarteiraResultadoA.setText("");
			lb_CarteiraResultadoB.setText("");
			lb_CarteiraResultadoFinal.setText("");
			lb_CarteiraResultadoPercentualFinal.setText("");
        }

	}

}

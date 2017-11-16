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

		ProtocoloController_ControlesGerais_A
				.setProtocolosdeServicos(pSDAO.Navegar(nav, Utilidades.getpPL().getEmpresa_Logada(),
						ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes(),
						ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()));

		ProtocoloController_ControlesGerais_A.setProtocolosdeServicos_DetalheLista(
				ProtocoloController_ControlesGerais_A.buscaprotocoloservicosDetalhes());
		carregandoControles();
		if (ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista() != null
				&& ProtocoloController_ControlesGerais_A.getProtocolosdeServicos_DetalheLista().size() > 0)
			rolarIndicando(0);
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
			ProtocolosdeServicos_DetalheObsList.clear();
			tV_ProtServicos_Detalhe.getItems().clear();
			ProtocolosdeServicos_DetalheObsList.addAll(lista);
			tV_ProtServicos_Detalhe.setItems(ProtocolosdeServicos_DetalheObsList);
			tV_ProtServicos_Detalhe.getSelectionModel().selectLast();
		} else
			tV_ProtServicos_Detalhe.getItems().clear();
	}

}

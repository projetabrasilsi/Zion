package controller.pessoas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import model.entities.Pessoa;
import model.enums.Enum_Aux_Sexo;
import model.enums.Enum_Aux_Tipo_Pessoa;
import util.Utilidades;

public class PessoaController extends Metodos_A implements Initializable {

	// Metodos_A e B em Geral diz a respeito de dados pessoais(pessoa) e também
	// algum método que precisou ser encaixado em A ou B
	// para organizar o código de cada unit entre 100 e 120 linhas

	// Métodos C --> Diz a Respeito de Usuário e Pessoa_Perfil_E_Vinculo;
	// Método D,F e G --> Diz a respeito de métodos em geral

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		setConsultar(true);
		setConfirmado(false);
		
		lb_Titulo.setText(Utilidades.getpPL().getFormulario_Atual().getDescricao());
		

		inicializa_Eventos();
		/**
		 * para os botões - inicio/anterior/próximo/ fim, a SEQUENCIA(um abaixo do
		 * outro) como foi colocado os métodos precisam serem RESPEITADAS;
		 */

		bt_Inicio.setOnAction((e) -> {

			Pessoa p = inicio(Utilidades.getpPL());
			if(p != null )
			setPessoa(p);
			
			configuraPessoaeUsuario(p);
			//mudaTab_TbP_Outros(tb_Usuario_Senha);

		});
		bt_Anterior.setOnAction((e) -> {
			Pessoa p = anterior(Utilidades.getpPL(), getPessoa());
			if(p != null )
				setPessoa(p);
			configuraPessoaeUsuario(p);
			
			// mudaTab_TbP_Outros(tb_Usuario_Senha);

		});
		bt_Proximo.setOnAction((e) -> {
			Pessoa p = proximo(Utilidades.getpPL(), getPessoa());
			if(p != null )
				setPessoa(p);
			configuraPessoaeUsuario(p);
			// mudaTab_TbP_Outros(tb_Usuario_Senha);

		});
		bt_Fim.setOnAction((e) -> {
			
			Pessoa p = fim(Utilidades.getpPL());
			if(p != null )
				setPessoa(p);
			configuraPessoaeUsuario(p);

			// mudaTab_TbP_Outros(tb_Usuario_Senha);

		});

		bt_Novo.setOnAction((e) -> {
			setConsultar(true);
			setConfirmado(false);

			Pessoa p = chamaTelaConsultaCPFCNPJ(null);
			if (isConfirmado()) {
				setPessoa(p);
				
				configuraPessoaeUsuario(p);
				bloquearDesbloqueiaEditaveis(false);
				tf_Rg_Inscricao_Estadual.requestFocus();

				/*
				 * mudaTab_TbP_Outros(tb_Perfis); mudaTab_TbP_Outros(tb_Usuario_Senha);
				 */

			}

		});

		bt_Alterar.setOnAction((e) -> {
			if (getPessoa() != null) {
				bloquearDesbloqueiaEditaveis(false);
				CarregaControlesVisuaisPessoa(true, getPessoa());
			}

		});

		bt_Salvar.setOnAction((e) -> {

			CarregaControlesVisuaisPessoa(false, getPessoa());
			CarregaControlesVisuaisUsuario(false, getUsuario());
			CarregaControlesVisuaisPessoa_Perfil_E_Vinculo(false, getpPVs(), Utilidades.getpPL().getFormulario_Atual());

			if (getPessoa() != null && getUsuario() != null && getpPVs() != null && Utilidades.getpPL() != null) {
				if (validarAntesdoMerge(getPessoa(), null, getUsuario(), null, null, getpPV(), getpPVs(), Utilidades.getpPL())) {
					if (merge_Geral()) {
						//mudaTab_TbP_Outros(tb_Usuario_Senha);
						bloquearDesbloqueiaEditaveis(true);
						CarregaControlesVisuaisPessoa(true, getPessoa());

					}
				}

			}
		});
		formatDataPicker();
		tf_Cpf_CnpjKeyReleased();

		cb_Sexo.getItems().setAll(Enum_Aux_Sexo.values());
		cb_Tipo_Pessoa.getItems().setAll(Enum_Aux_Tipo_Pessoa.values());
		cb_Tipo_Pessoa.getSelectionModel().select(Enum_Aux_Tipo_Pessoa.FISICA);

		setPessoa(fim(Utilidades.getpPL()));
		configura_tela();
		bloquearDesbloqueiaEditaveis(true);
		CarregaControlesVisuaisPessoa(true, getPessoa());
		mudaTab_TbP_Outros(tb_Perfis);
		mudaTab_TbP_Outros(tb_Usuario_Senha);
		trocaTabPorEnter();

	}

}

package controller.pessoas;

import adaptadores.TextFieldFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import model.enums.Enum_Aux_Perfil_Pessoa;
import model.enums.Enum_Aux_Sexo;
import model.enums.Enum_Aux_Tipo_Pessoa;
import util.Utilidades;

public class Metodos_E extends Metodos_F {
	@SuppressWarnings("unchecked")
	protected void trocaTabPorEnter() {
		tf_Cpf_Cnpj = (TextField)  Utilidades.trocaTabPorEnter(tf_Cpf_Cnpj);
		tf_Id = (TextField) Utilidades.trocaTabPorEnter(tf_Id);
		tf_Nome_Razao_Social = (TextField) Utilidades.trocaTabPorEnter(tf_Nome_Razao_Social);
		tf_Fantasia_Apelido = (TextField) Utilidades.trocaTabPorEnter(tf_Fantasia_Apelido);
		tf_Resp_Registro = (TextField) Utilidades.trocaTabPorEnter(tf_Resp_Registro);
		tf_Rg_Inscricao_Estadual = (TextField) Utilidades.trocaTabPorEnter(tf_Rg_Inscricao_Estadual);
		tf_Ultima_Alteracao = (TextField) Utilidades.trocaTabPorEnter(tf_Ultima_Alteracao);
		dp_Data_Nascimento_Abertura = (DatePicker) Utilidades.trocaTabPorEnter(dp_Data_Nascimento_Abertura);
		cb_Sexo = (ComboBox<Enum_Aux_Sexo>) Utilidades.trocaTabPorEnter(cb_Sexo);
		cb_Tipo_Pessoa = (ComboBox<Enum_Aux_Tipo_Pessoa>) Utilidades.trocaTabPorEnter(cb_Tipo_Pessoa);
		psf_Senha = (PasswordField) Utilidades.trocaTabPorEnter(psf_Senha);
		psf_ConfSenha = (PasswordField) Utilidades.trocaTabPorEnter(psf_ConfSenha);
		cb_Perfil_Pessoa = (ComboBox<Enum_Aux_Perfil_Pessoa>) Utilidades.trocaTabPorEnter(cb_Perfil_Pessoa);
		bt_Inicio = (Button) Utilidades.trocaTabPorEnter(bt_Inicio);
		bt_Anterior = (Button) Utilidades.trocaTabPorEnter(bt_Anterior);
		bt_Proximo = (Button) Utilidades.trocaTabPorEnter(bt_Proximo);
		bt_Fim = (Button) Utilidades.trocaTabPorEnter(bt_Fim);
		bt_Novo = (Button) Utilidades.trocaTabPorEnter(bt_Novo);
		bt_Alterar = (Button) Utilidades.trocaTabPorEnter(bt_Alterar);
		bt_Salvar = (Button) Utilidades.trocaTabPorEnter(bt_Salvar);
		

	}

	

	protected void bloquearDesbloqueiaEditaveis(boolean bloqueia) {

		tv_Perfil_Pessoa.setDisable(bloqueia);

		tf_Cpf_Cnpj.setDisable(true);
		tf_Id.setDisable(true);
		cb_Tipo_Pessoa.setDisable(true);
		tf_Ultima_Alteracao.setDisable(true);
		tf_Nome_Razao_Social.setDisable(bloqueia);
		tf_Fantasia_Apelido.setDisable(bloqueia);
		tf_Resp_Registro.setDisable(true);
		tf_Rg_Inscricao_Estadual.setDisable(bloqueia);

		dp_Data_Nascimento_Abertura.setDisable(bloqueia);
		cb_Sexo.setDisable(bloqueia);

		psf_Senha.setDisable(bloqueia);
		psf_ConfSenha.setDisable(bloqueia);
		cb_Perfil_Pessoa.setDisable(bloqueia);
		tv_Perfil_Pessoa.setDisable(bloqueia);
		bt_Perfil_Confirma.setDisable(bloqueia);

		bt_Novo.setDisable(!bloqueia);
		bt_Alterar.setDisable(!bloqueia);
		
		if(getPessoa() == null || getPessoa().getId() == null || getPessoa().getId()<=0)
			
		bt_Alterar.setDisable(true);
		
		bt_Salvar.setDisable(bloqueia);
		bt_Inicio.setDisable(!bloqueia);
		bt_Anterior.setDisable(!bloqueia);
		bt_Proximo.setDisable(!bloqueia);
		bt_Fim.setDisable(!bloqueia);
		bt_AtvDatv.setDisable(true);
	}
	public void mudaTab_TbP_Outros(Tab obj) {
		tbP_Outros.getSelectionModel().select(obj);
	}
	
	@FXML
	protected void tf_Cpf_CnpjKeyReleased() {
		if (cb_Tipo_Pessoa != null && cb_Tipo_Pessoa.getValue() != null) {
			TextFieldFormatter formatter = new TextFieldFormatter(tf_Cpf_Cnpj);
			formatter.setMask(cb_Tipo_Pessoa.getSelectionModel().getSelectedItem().getMascara());
			formatter.showMask();
		}
	}
	
}

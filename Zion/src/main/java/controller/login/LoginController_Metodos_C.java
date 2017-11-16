package controller.login;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import util.Utilidades;

public class LoginController_Metodos_C extends LoginControles {
	@SuppressWarnings("unchecked")
	protected void trocaTabPorEnter() {
		cB_Empresa = (ComboBox<String>) Utilidades.trocaTabPorEnter(cB_Empresa);
		cB_Usuario = (ComboBox<String>) Utilidades.trocaTabPorEnter(cB_Usuario);
		psf_Senha = (PasswordField) Utilidades.trocaTabPorEnter(psf_Senha);
		bt_Confirmar = (Button) Utilidades.trocaTabPorEnter(bt_Confirmar);
		bt_Cancelar = (Button) Utilidades.trocaTabPorEnter(bt_Cancelar);
		Utilidades.addTextLimiter(psf_Senha, 8);
		cB_Empresa.requestFocus();
	}

	public void carregaEmpresaEUsuarios() {

	}

	public void salvaEmpresaEUsuario() {

	}

}

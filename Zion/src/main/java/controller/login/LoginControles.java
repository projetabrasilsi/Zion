package controller.login;

import controller.application.AplicacaoControles;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginControles extends AplicacaoControles {
	@FXML ComboBox<String> cB_Empresa = new ComboBox<>(); 
	@FXML ComboBox<String> cB_Usuario = new ComboBox<>();
	@FXML protected PasswordField psf_Senha = new PasswordField();
	@FXML protected Label lb_Empresa = new Label();
	@FXML protected Label lb_Usuario = new Label();
	@FXML protected Label lb_Senha = new Label();
	@FXML protected Button bt_Confirmar = new Button();
	@FXML protected Button bt_Cancelar = new Button();
	@FXML protected AnchorPane aP_Cpf_Cnpj = new AnchorPane();
	private boolean confirmado = false;
	private boolean existeAlguemPerfilVinculadoAoMestre = false;
	private Stage dialogStage;
	public ComboBox<String> getcB_Empresa() {
		return cB_Empresa;
	}
	public void setcB_Empresa(ComboBox<String> cB_Empresa) {
		this.cB_Empresa = cB_Empresa;
	}
	public ComboBox<String> getcB_Usuario() {
		return cB_Usuario;
	}
	public void setcB_Usuario(ComboBox<String> cB_Usuario) {
		this.cB_Usuario = cB_Usuario;
	}
	public PasswordField getPsf_Senha() {
		return psf_Senha;
	}
	public void setPsf_Senha(PasswordField psf_Senha) {
		this.psf_Senha = psf_Senha;
	}
	public Label getLb_Empresa() {
		return lb_Empresa;
	}
	public void setLb_Empresa(Label lb_Empresa) {
		this.lb_Empresa = lb_Empresa;
	}
	public Label getLb_Usuario() {
		return lb_Usuario;
	}
	public void setLb_Usuario(Label lb_Usuario) {
		this.lb_Usuario = lb_Usuario;
	}
	public Label getLb_Senha() {
		return lb_Senha;
	}
	public void setLb_Senha(Label lb_Senha) {
		this.lb_Senha = lb_Senha;
	}
	public Button getBt_Confirmar() {
		return bt_Confirmar;
	}
	public void setBt_Confirmar(Button bt_Confirmar) {
		this.bt_Confirmar = bt_Confirmar;
	}
	public Button getBt_Cancelar() {
		return bt_Cancelar;
	}
	public void setBt_Cancelar(Button bt_Cancelar) {
		this.bt_Cancelar = bt_Cancelar;
	}
	public AnchorPane getaP_Cpf_Cnpj() {
		return aP_Cpf_Cnpj;
	}
	public void setaP_Cpf_Cnpj(AnchorPane aP_Cpf_Cnpj) {
		this.aP_Cpf_Cnpj = aP_Cpf_Cnpj;
	}
	public boolean isConfirmado() {
		return confirmado;
	}
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	public Stage getDialogStage() {
		return dialogStage;
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public boolean isExisteAlguemPerfilVinculadoAoMestre() {
		return existeAlguemPerfilVinculadoAoMestre;
	}
	public void setExisteAlguemPerfilVinculadoAoMestre(boolean existeAlguemPerfilVinculadoAoMestre) {
		this.existeAlguemPerfilVinculadoAoMestre = existeAlguemPerfilVinculadoAoMestre;
	}
	
	
	
	
}

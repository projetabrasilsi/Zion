package controller.pessoas;

import adaptadores.TextFieldFormatter;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.enums.Enum_Aux_Tipo_Pessoa;

public class Cpf_Cnpj_Consulta_A {

	@FXML AnchorPane aP_Cpf_Cnpj = new AnchorPane();
	@FXML protected Label lb_Cpf_Cnpj = new Label();
	@FXML protected Label lb_Tipo_Pessoa = new Label();
	@FXML protected ComboBox<Enum_Aux_Tipo_Pessoa> cB_Tipo_Pessoa = new ComboBox<>();
	@FXML protected TextField tF_Cpf_Cnpj = new TextField();
	@FXML protected Button bt_Confirmar = new Button();
	@FXML protected Button bt_Cancelar = new Button();
	
	private Stage dialogStage;
	private boolean buttonConfirmarClicked = false;
	private boolean cpf_Cnpj_Valido = false;
	private String cpf_Cnpj_Numeros = "";
	private Enum_Aux_Tipo_Pessoa tipo_Pessoa;
	
	protected void configura_tela() {
		if (cB_Tipo_Pessoa.getValue() != null && cB_Tipo_Pessoa.getValue().equals(Enum_Aux_Tipo_Pessoa.JURIDICA)) {
			lb_Cpf_Cnpj.setText("CNPJ");
		} else if (cB_Tipo_Pessoa.getValue() == null
				|| !cB_Tipo_Pessoa.getValue().equals(Enum_Aux_Tipo_Pessoa.JURIDICA)) {
			lb_Cpf_Cnpj.setText("CPF");
		}
		tF_Cpf_CnpjKeyReleased();
	}
	
	@SuppressWarnings("unchecked")
	protected void trocaTabPorEnter() {		
		tF_Cpf_Cnpj = (TextField) trocaTabPorEnter(tF_Cpf_Cnpj);		
		cB_Tipo_Pessoa = (ComboBox<Enum_Aux_Tipo_Pessoa>) trocaTabPorEnter(cB_Tipo_Pessoa);
	}
	
	protected Node trocaTabPorEnter(Node no) {
		no.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
			if (event.getCode() == KeyCode.ENTER) {
				KeyEvent newEvent = new KeyEvent(null, null, KeyEvent.KEY_PRESSED, "", "\t", KeyCode.TAB,
						event.isShiftDown(), event.isControlDown(), event.isAltDown(), event.isMetaDown());

				Event.fireEvent(event.getTarget(), newEvent);
				event.consume();
			}
		});
		return no;
	}

	@FXML
	protected void tF_Cpf_CnpjKeyReleased() {
		if (cB_Tipo_Pessoa != null && cB_Tipo_Pessoa.getValue() != null) {
			TextFieldFormatter formatter = new TextFieldFormatter(tF_Cpf_Cnpj);
			formatter.setMask(cB_Tipo_Pessoa.getSelectionModel().getSelectedItem().getMascara());
			formatter.showMask();
		}
	}

	protected Stage getDialogStage() {
		return dialogStage;
	}

	protected void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	protected boolean isButtonConfirmarClicked() {
		return buttonConfirmarClicked;
	}

	protected void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
		this.buttonConfirmarClicked = buttonConfirmarClicked;
	}

	protected boolean isCpf_Cnpj_Valido() {
		return cpf_Cnpj_Valido;
	}

	protected void setCpf_Cnpj_Valido(boolean cpf_Cnpj_Valido) {
		this.cpf_Cnpj_Valido = cpf_Cnpj_Valido;
	}

	protected String getCpf_Cnpj_Numeros() {
		return cpf_Cnpj_Numeros;
	}

	protected void setCpf_Cnpj_Numeros(String cpf_Cnpj_Numeros) {
		this.cpf_Cnpj_Numeros = cpf_Cnpj_Numeros;
	}

	protected Enum_Aux_Tipo_Pessoa getTipo_Pessoa() {
		return tipo_Pessoa;
	}

	protected void setTipo_Pessoa(Enum_Aux_Tipo_Pessoa tipo_Pessoa) {
		this.tipo_Pessoa = tipo_Pessoa;
	}
}

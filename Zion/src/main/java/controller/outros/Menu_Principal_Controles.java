package controller.outros;

import controller.application.AplicacaoControles;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Menu_Principal_Controles  extends AplicacaoControles {
	
	@FXML protected MenuItem  mI_ProjetaBrasil =  new MenuItem ();
	
	@FXML protected MenuItem  mI_Contratantes =  new MenuItem ();
	@FXML protected MenuItem  mI_Administradores_GERAL =  new MenuItem ();
	@FXML protected MenuItem  mI_Administradores_IPTU =  new MenuItem ();
	@FXML protected MenuItem  mI_Administradores_AGUA =  new MenuItem ();
	@FXML protected MenuItem  mI_Administradores_ENERGIA =  new MenuItem ();
	@FXML protected MenuItem  mI_Administradores_CONDOMINIOS =  new MenuItem ();
	@FXML protected MenuItem  mI_Gerentes =  new MenuItem ();
	@FXML protected MenuItem  mI_Funcionarios =  new MenuItem ();
	@FXML protected MenuItem  mI_Clientes =  new MenuItem ();
	@FXML protected MenuItem  mI_Configurar_Servicos_Por_Contratante =  new MenuItem ();
	@FXML protected MenuItem  mI_Configurar_Acessos_Por_Perfil =  new MenuItem ();
	
	
	@FXML protected MenuItem  mI_Servicos_IPTU =  new MenuItem ();
	@FXML protected MenuItem  mI_Servicos_ENERGIA =  new MenuItem ();
	@FXML protected MenuItem  mI_Servicos_AGUA =  new MenuItem ();
	@FXML protected MenuItem  mI_Servicos_CONDOMINIOS =  new MenuItem ();

	@FXML protected AnchorPane ap_Pessoas = new AnchorPane();
	@FXML protected BorderPane bp_Principal = new BorderPane();
	@FXML
	protected Label lb_Perfil_Pessoa_Logada = new Label();
	@FXML
	protected Label lb_Empresa_Logada = new Label();
	@FXML
	protected Label lb_Pessoa_Logada = new Label();
	@FXML
	protected Label lb_Formulario_Atual = new Label();
	
	Parent root;
	


}

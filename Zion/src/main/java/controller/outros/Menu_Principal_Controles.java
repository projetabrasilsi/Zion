package controller.outros;

import controller.application.AplicacaoControles;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
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
	@FXML protected Menu menu_Servicos = new Menu();
	@FXML protected Menu menu_Agua = new Menu();
	@FXML protected Menu menu_Agua_CNDS = new Menu(); 
	
	@FXML protected MenuItem mI_Agua_CNDS_Santa_Catarina_SC = new MenuItem();
	@FXML protected Menu menu_Agua_Conferencia = new Menu();
	
	@FXML protected MenuItem mI_Agua_Conferencia_Santa_Catarina_SC = new MenuItem();
	@FXML protected Menu menu_Agua_Comparativos = new Menu();
	@FXML protected MenuItem mI_Agua_Comparativos_Santa_Catarina_SC = new MenuItem();
	@FXML protected Menu menu_DAMS = new Menu();
	@FXML protected MenuItem mI_DAMS_Santa_Catarina_SC = new MenuItem();
	@FXML protected Menu menu_Condominios = new Menu();
	@FXML protected Menu menu_Energia = new Menu();
	@FXML protected Menu menu_Energia_DAMS = new Menu();
	@FXML protected MenuItem mI_Energia_DAMS_Santa_Catarina_SC = new MenuItem();
	@FXML protected Menu menu_Energia_Comparativos = new Menu();
	@FXML protected MenuItem mI_Energia_Comparativos_Santa_Catarina_SC = new MenuItem();
	@FXML protected Menu menu_Energia_Conferencia_de_Debitos = new Menu();
	@FXML protected MenuItem mI_Energia_Conferencia_de_Debitos_SC = new MenuItem();
	@FXML protected Menu menu_Energia_CNDS = new Menu();
	@FXML protected MenuItem mI_Energia_CNDS_Santa_Catarina_SC = new MenuItem();
	@FXML protected Menu menu_Energia_Transferencias = new Menu();
	@FXML protected MenuItem mI_Energia_Transferencias_Santa_Catarina_SC = new MenuItem();
	@FXML protected Menu menu_IPTU = new Menu();
	@FXML protected Menu menu_IPTU_DAMS = new Menu();
	@FXML protected MenuItem mI_IPTU_DAMS_Biguacu_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_DAMS_Florianopolis_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_DAMS_Palhoca_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_DAMS_Sao_Jose_SC = new MenuItem(); 
	
	@FXML protected MenuItem mI_IPTU_CNDS_Biguacu_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_CNDS_Florianopolis_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_CNDS_Palhoca_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_CNDS_Sao_Jose_SC = new MenuItem();
	
	@FXML protected Menu menu_IPTU_Comparativos = new Menu();
	@FXML protected MenuItem mI_IPTU_Comparativos_Biguacu_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_Comparativos_Florianopolis_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_Comparativos_Palhoca_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_Comparativos_Sao_Jose_SC = new MenuItem();
	@FXML protected Menu menu_IPTU_Conferencia_de_debito = new Menu();
	@FXML protected MenuItem mI_IPTU_Conferencia_de_debito_Biguacu_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_Conferencia_de_debito_Florianopolis_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_Conferencia_de_debito_Sao_Jose_SC = new MenuItem();
	@FXML protected MenuItem mI_IPTU_Conferencia_de_debito_Palhoca_SC = new MenuItem();
	@FXML protected Menu menu_CNDS = new Menu();
	@FXML protected MenuItem mI_CNDS_Biguacu_SC  = new MenuItem();
	@FXML protected MenuItem mI_CNDS_Florianopolis_SC = new MenuItem();
	@FXML protected MenuItem mI_CNDS_Sao_Jose_SC = new MenuItem();
	@FXML protected MenuItem mI_CNDS_Palhoca_SC = new MenuItem();
	
	
	
	
	

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

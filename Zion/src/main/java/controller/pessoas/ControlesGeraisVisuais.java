package controller.pessoas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.enums.Enum_Aux_Perfil_Pessoa;
import model.enums.Enum_Aux_Sexo;
import model.enums.Enum_Aux_Tipo_Pessoa;

public class ControlesGeraisVisuais  extends ControlesGeraisNaoVisuais {
	
	// controles visuais de pessoa
	@FXML protected Label lb_Ultima_Alteracao = new Label();
	@FXML protected Label lb_Cpf_Cnpj = new Label();
	@FXML protected Label lb_Data_Nascimento_Abertura = new Label();
	@FXML protected Label lb_Id = new Label();
	@FXML protected Label lb_Nome_Razao_Social = new Label();
	@FXML protected Label lb_Fantasia_Apelido = new Label();
	@FXML protected Label lb_Rg_Inscricao_Estadual = new Label();
	@FXML protected Label lb_Sexo = new Label();
	@FXML protected Label lb_Tipo_Pessoa = new Label();
	@FXML protected Label lb_Resp_Registro = new Label();
	@FXML protected Label lb_Titulo = new Label();
	@FXML protected ComboBox<Enum_Aux_Sexo> cb_Sexo = new ComboBox<>();
	@FXML protected ComboBox<Enum_Aux_Tipo_Pessoa> cb_Tipo_Pessoa = new ComboBox<>();
	@FXML protected TextField tf_Cpf_Cnpj = new TextField();
	@FXML protected TextField tf_Id = new TextField();
	@FXML protected TextField tf_Nome_Razao_Social = new TextField();
	@FXML protected TextField tf_Fantasia_Apelido = new TextField();
	@FXML protected TextField tf_Resp_Registro = new TextField();
	@FXML protected TextField tf_Rg_Inscricao_Estadual = new TextField();
	@FXML protected TextField tf_Ultima_Alteracao = new TextField();
	@FXML protected DatePicker dp_Data_Nascimento_Abertura = new DatePicker();
	@FXML protected ObservableList<Pessoa> pessoaObsList = FXCollections.observableArrayList();
	
	// controles visuais para usuario
	
	@FXML protected Label lb_ConfSenha = new Label();
	@FXML protected Label lb_Senha = new Label();
	@FXML protected PasswordField psf_Senha = new PasswordField();
	@FXML protected PasswordField psf_ConfSenha = new PasswordField();
	
	// controles visuais para contatos;
	// controles visuais para perfis;
	@FXML protected Button bt_Perfil_Confirma = new Button();
	@FXML protected ComboBox<Enum_Aux_Perfil_Pessoa> cb_Perfil_Pessoa = new ComboBox<>();
	@FXML protected TableView<Pessoa_Perfil_e_Vinculo> tv_Perfil_Pessoa = new TableView<Pessoa_Perfil_e_Vinculo>();
	@FXML protected TableColumn<Pessoa_Perfil_e_Vinculo, Enum_Aux_Perfil_Pessoa> tc_Perfil_Perfil = new TableColumn<>("Perfil");
	@FXML protected TableColumn<Pessoa_Perfil_e_Vinculo, Pessoa> tc_Perfil_Responsavel = new TableColumn<>("Responsavel");
	@FXML protected ObservableList<Pessoa_Perfil_e_Vinculo> perfilPessoaObsList = FXCollections.observableArrayList();
	
	
	
	

    // controles gerais
	@FXML protected Button bt_Alterar = new Button();
	@FXML protected Button bt_Anterior = new Button();
	@FXML protected Button bt_AtvDatv = new Button();
	@FXML protected Button bt_Fim = new Button();
	@FXML protected Button bt_Inicio = new Button();
	@FXML protected Button bt_Novo = new Button();
	@FXML protected Button bt_Proximo = new Button();
	@FXML protected Button bt_Salvar = new Button();
	@FXML protected Group group_Buttons = new Group();
	@FXML protected Group group_Pessoas = new Group();
	@FXML protected AnchorPane ap_Pessoas = new AnchorPane();
	@FXML protected TabPane tbP_Outros = new TabPane();
	@FXML protected Tab tb_Endereco = new Tab();
	@FXML protected Tab tb_Usuario_Senha = new Tab();
	@FXML protected Tab tb_Contatos = new Tab();
	@FXML protected Tab tb_Perfis = new Tab();
	@FXML protected Tab tb_Configuracoes = new Tab();	
	
	
}

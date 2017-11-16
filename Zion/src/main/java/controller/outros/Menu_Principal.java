package controller.outros;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import model.enums.Enum_Aux_Formularios;
import model.enums.Enum_Aux_Perfil_Pessoa;
import model.enums.Enum_Aux_Servicos_Composicoes;
import model.enums.Enum_Aux_Tipo_Pessoa;
import util.Utilidades;

public class Menu_Principal extends Menu_Principal_Controles implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Utilidades.getpPL().setFormulario_Atual(Enum_Aux_Formularios.MENU_PRINCIPAL);

		mI_ProjetaBrasil.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_CONTRATADOS);
		});

		mI_Contratantes.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_CONTRATANTES);
		});

		mI_Administradores_GERAL.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_ADMINISTRADORES_GERAL);
		});

		mI_Administradores_IPTU.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_ADMINISTRADORES_IPTU);
		});

		mI_Administradores_AGUA.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_ADMINISTRADORES_AGUA);
		});

		mI_Administradores_ENERGIA.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_ADMINISTRADORES_ENERGIA);
		});

		mI_Administradores_CONDOMINIOS.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_ADMINISTRADORES_CONDOMINIOS);
		});

		mI_Gerentes.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_GERENTES);
		});

		mI_Funcionarios.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_FUNCIONARIOS);
		});

		mI_Clientes.setOnAction((e) -> {
			chamaformulariodeClientes(Enum_Aux_Formularios.CAD_CLIENTES);
		});

		mI_IPTU_Comparativos_Biguacu_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_COMPARATIVOS_BIGUACU_SC);

		});
		
		mI_IPTU_Comparativos_Florianopolis_SC.setOnAction((e) -> {
			chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_COMPARATIVOS_FLORIANOPOLIS_SC);

		});
		
		mI_IPTU_Comparativos_Palhoca_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_COMPARATIVOS_PALHOCA_SC);

		});
		
		mI_IPTU_Comparativos_Sao_Jose_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_COMPARATIVOS_SAO_JOSE_SC);

		});
		
		
		mI_IPTU_Conferencia_de_debito_Biguacu_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_CONFERENCIA_DEBITOS_BIGUACU_SC);

		});
		
		mI_IPTU_Conferencia_de_debito_Florianopolis_SC.setOnAction((e) -> {
			chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_CONFERENCIA_DEBITOS_FLORIANOPOLIS_SC);

		});
		
		mI_IPTU_Conferencia_de_debito_Palhoca_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_CONFERENCIA_DEBITOS_PALHOCA_SC);

		});
		
		mI_IPTU_Conferencia_de_debito_Sao_Jose_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_CONFERENCIA_DEBITOS_SAO_JOSE_SC);

		});
		
		
		mI_IPTU_DAMS_Biguacu_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_DAMS_BIGUACU_SC);

		});
		
		mI_IPTU_DAMS_Florianopolis_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_DAMS_FLORIANOPOLIS_SC);

		});
		
		mI_IPTU_DAMS_Palhoca_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_DAMS_PALHOCA_SC);

		});
		
		mI_IPTU_DAMS_Sao_Jose_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_DAMS_SAO_JOSE_SC);

		});
		
		
		
		
		mI_IPTU_CNDS_Biguacu_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_CNDS_BIGUACU_SC);

		});
		
		mI_IPTU_CNDS_Florianopolis_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_CNDS_FLORIANOPOLIS_SC);

		});
		
		mI_IPTU_CNDS_Palhoca_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_CNDS_PALHOCA_SC);

		});
		
		mI_IPTU_CNDS_Sao_Jose_SC.setOnAction((e) -> {
			//chamaformulariodeServicos(Enum_Aux_Formularios.FORM_IPTU, Enum_Aux_Servicos_Composicoes.IPTU_CNDS_SAO_JOSE_SC);

		});
		

		verificaLiberacoesdeMenus();
		configuraMenus();
		preencherodape();
		// configuraAcessos();
	}

	public void chamaformulariodeServicos(Enum_Aux_Formularios formulario_Atual,
			Enum_Aux_Servicos_Composicoes enum_Aux_Servicos_Composicoes) {
		try {
			Utilidades.getpPL().setFormulario_Atual(formulario_Atual);
			Utilidades.getpPL().setEnum_Aux_Servicos_Composicoes(enum_Aux_Servicos_Composicoes);
			Parent protocolo = FXMLLoader.load(getClass().getClassLoader().getResource("protocolos_passoa.fxml"));
			bp_Principal.setCenter(protocolo);
			preencherodape();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	public void chamaformulariodeClientes(Enum_Aux_Formularios formulario) {
		try {
			Utilidades.getpPL().setFormulario_Atual(formulario);
			Parent pessoas = FXMLLoader.load(getClass().getClassLoader().getResource("pessoas.fxml"));
			bp_Principal.setCenter(pessoas);
			preencherodape();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	public void configuraMenus() {
		mI_ProjetaBrasil.setUserData(Enum_Aux_Formularios.CAD_CONTRATADOS);
		mI_Contratantes.setUserData(Enum_Aux_Formularios.CAD_CONTRATANTES);
		mI_Administradores_GERAL.setUserData(Enum_Aux_Formularios.CAD_ADMINISTRADORES_GERAL);
		mI_Administradores_IPTU.setUserData(Enum_Aux_Formularios.CAD_ADMINISTRADORES_IPTU);
		mI_Administradores_AGUA.setUserData(Enum_Aux_Formularios.CAD_ADMINISTRADORES_AGUA);
		mI_Administradores_ENERGIA.setUserData(Enum_Aux_Formularios.CAD_ADMINISTRADORES_ENERGIA);
		mI_Administradores_CONDOMINIOS.setUserData(Enum_Aux_Formularios.CAD_ADMINISTRADORES_CONDOMINIOS);
		mI_Gerentes.setUserData(Enum_Aux_Formularios.CAD_GERENTES);
		mI_Funcionarios.setUserData(Enum_Aux_Formularios.CAD_FUNCIONARIOS);
		mI_Clientes.setUserData(Enum_Aux_Formularios.CAD_CLIENTES);
		
		mI_Configurar_Servicos_Por_Contratante.setUserData(Enum_Aux_Formularios.CAD_CLIENTES);
		mI_Configurar_Acessos_Por_Perfil.setUserData(Enum_Aux_Formularios.CAD_CLIENTES);

		
		mI_ProjetaBrasil = configuraAcessos(mI_ProjetaBrasil);
		mI_Contratantes = configuraAcessos(mI_Contratantes);
		mI_Administradores_GERAL = configuraAcessos(mI_Administradores_GERAL);
		mI_Administradores_IPTU = configuraAcessos(mI_Administradores_IPTU);
		mI_Administradores_AGUA = configuraAcessos(mI_Administradores_AGUA);
		mI_Administradores_ENERGIA = configuraAcessos(mI_Administradores_ENERGIA);
		mI_Administradores_CONDOMINIOS = configuraAcessos(mI_Administradores_CONDOMINIOS);
		mI_Gerentes = configuraAcessos(mI_Gerentes);
		mI_Funcionarios = configuraAcessos(mI_Funcionarios);
		mI_Clientes = configuraAcessos(mI_Clientes);

		/*
		 * mI_Servicos_IPTU = configuraAcessos(mI_Servicos_IPTU); mI_Servicos_ENERGIA =
		 * configuraAcessos(mI_Servicos_ENERGIA); mI_Servicos_AGUA =
		 * configuraAcessos(mI_Servicos_AGUA); mI_Servicos_CONDOMINIOS =
		 * configuraAcessos(mI_Servicos_CONDOMINIOS);
		 * mI_Configurar_Servicos_Por_Contratante =
		 * configuraAcessos(mI_Configurar_Servicos_Por_Contratante);
		 * mI_Configurar_Acessos_Por_Perfil =
		 * configuraAcessos(mI_Configurar_Acessos_Por_Perfil);
		 */

	}

	public void verificaLiberacoesdeMenus() {
		if (Utilidades.getpPL().isExistemPessoasCadatradas()) {
			mI_ProjetaBrasil.setDisable(!Utilidades.getpPL().isEmpresaPossuiAlguemVinculado());
			mI_Contratantes.setDisable(!Utilidades.getpPL().isEmpresaPossuiAlguemVinculado());

			if (Utilidades.getpPL().isEmpresaPossuiAlguemVinculado())
				mI_Administradores_GERAL.setDisable(!podeCadastrarAdministradores());
			else
				mI_Administradores_GERAL.setDisable(false);

			mI_Gerentes.setDisable(!Utilidades.getpPL().isEmpresaPossuiAlguemVinculado());
			mI_Funcionarios.setDisable(!Utilidades.getpPL().isEmpresaPossuiAlguemVinculado());
			mI_Clientes.setDisable(!Utilidades.getpPL().isEmpresaPossuiAlguemVinculado());
			mI_Administradores_IPTU.setDisable(!Utilidades.getpPL().isEmpresaPossuiAlguemVinculado());
			mI_Administradores_AGUA.setDisable(!Utilidades.getpPL().isEmpresaPossuiAlguemVinculado());
			mI_Administradores_ENERGIA.setDisable(!Utilidades.getpPL().isEmpresaPossuiAlguemVinculado());
			mI_Administradores_CONDOMINIOS.setDisable(!Utilidades.getpPL().isEmpresaPossuiAlguemVinculado());
		} else {
			mI_ProjetaBrasil.setDisable(false);
			mI_Contratantes.setDisable(true);

			mI_Administradores_GERAL.setDisable(true);
			mI_Administradores_IPTU.setDisable(true);
			mI_Administradores_AGUA.setDisable(true);
			mI_Administradores_ENERGIA.setDisable(true);
			mI_Administradores_CONDOMINIOS.setDisable(true);

			mI_Gerentes.setDisable(true);
			mI_Funcionarios.setDisable(true);
			mI_Clientes.setDisable(true);
		}
		
	}

	public boolean podeCadastrarAdministradores() {
		if (Utilidades.getpPL().getPerfil_Logado() != null
				&& (Utilidades.getpPL().getPerfil_Logado().equals(Enum_Aux_Perfil_Pessoa.ADMINISTRADORES_GERAL)
						|| Utilidades.getpPL().getPerfil_Logado().equals(Enum_Aux_Perfil_Pessoa.CONTRATANTES)
						|| Utilidades.getpPL().getPerfil_Logado().equals(Enum_Aux_Perfil_Pessoa.CONTRATADOS)))
			return true;
		return false;

	}

	public void preencherodape() {

		if (Utilidades.getpPL().getPerfil_Logado() != null) {
			lb_Perfil_Pessoa_Logada.setText("Perfil Atual: " + Utilidades.getpPL().getPerfil_Logado().getDescricao());
			if (Utilidades.getpPL().getPerfil_Logado().getEnum_Aux_Tipo_Pessoa().equals(Enum_Aux_Tipo_Pessoa.FISICA)) {
				if(Utilidades.getpPL().getPessoa_Logada() != null)
				lb_Pessoa_Logada.setText("Usuário Atual: " + Utilidades.getpPL().getPessoa_Logada().getDescricao());
				else {
					  if(Utilidades.getpPL().isExistemPessoasCadatradas())  
					lb_Pessoa_Logada.setText("Usuário Atual: NÃO LOGADO"  );
					  else
						  lb_Pessoa_Logada.setText("Usuário Atual: AINDA NÃO HÁ CADASTRO" );
				}
				
			} else
				lb_Pessoa_Logada
						.setText("Usuário Atual: " + Utilidades.getpPL().getPessoa_Logada().getFantasia_Apelido());
		} else {
			lb_Perfil_Pessoa_Logada.setText("Perfil Atual: SEM PERFIL");
			lb_Pessoa_Logada.setText("Usuário Atual: SEM USUARIO");
		}
		lb_Perfil_Pessoa_Logada.setText(lb_Perfil_Pessoa_Logada.getText() + "          ");
		lb_Pessoa_Logada.setText(lb_Pessoa_Logada.getText() + "          ");
		if (Utilidades.getpPL().getEmpresa_Logada() != null)
			lb_Empresa_Logada.setText("Empresa: " + Utilidades.getpPL().getEmpresa_Logada().getFantasia_Apelido());
		else
			lb_Empresa_Logada.setText("Empresa: NÃO IDENTIFICADA");

		lb_Empresa_Logada.setText(lb_Empresa_Logada.getText() + "          ");

		lb_Formulario_Atual.setText("Formulário Atual: " + Utilidades.getpPL().getFormulario_Atual().getDescricao());
		lb_Formulario_Atual.setText(lb_Formulario_Atual.getText() + "          ");

	}

	public MenuItem configuraAcessos(MenuItem item) {
		item.setDisable(true);

		if (Utilidades.getpPL() != null && Utilidades.getpPL().getAcessos() != null
				&& Utilidades.getpPL().getAcessos().getFormularios() != null) {
			for (Enum_Aux_Formularios form : Utilidades.getpPL().getAcessos().getFormularios()) {

				if (item.getUserData().equals(form)) {
					item.setDisable(false);
					break;
				}
			}
		}
		return item;
	}

}

package controller.pessoas;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import model.dao.PessoaDAO;
import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.entities.Usuario;
import model.enums.Enum_Aux_Navegadores;
import model.enums.Enum_Aux_Sexo;
import model.enums.Enum_Aux_Tipo_Pessoa;
import model.outros.Perfil_Pessoa_Logada;
import util.Utilidades;

public class Metodos_A extends Metodos_B {
	public Pessoa inicio(Perfil_Pessoa_Logada pPL) {
		Pessoa p = null;
		PessoaDAO dao = new PessoaDAO();
		p = dao.navegarPessoaPeloPerfil(pPL, null, Enum_Aux_Navegadores.INICIO, true, true);
		return p;
	}

	public Pessoa anterior(Perfil_Pessoa_Logada pPL, Pessoa pessoaAtual) {
		Pessoa p = null;
		PessoaDAO dao = new PessoaDAO();
		p = dao.navegarPessoaPeloPerfil(pPL, pessoaAtual, Enum_Aux_Navegadores.ANTERIOR, true, true);
		return p;
	}

	public Pessoa proximo(Perfil_Pessoa_Logada pPL, Pessoa pessoaAtual) {
		Pessoa p = null;
		PessoaDAO dao = new PessoaDAO();
		p = dao.navegarPessoaPeloPerfil(pPL, pessoaAtual, Enum_Aux_Navegadores.PROXIMO, true, true);
		return p;
	}

	public Pessoa fim(Perfil_Pessoa_Logada pPL) {
		Pessoa p = null;
		PessoaDAO dao = new PessoaDAO();
		p = dao.navegarPessoaPeloPerfil(pPL, null, Enum_Aux_Navegadores.FIM, true, true);
		return p;
	}

	public Pessoa Novo(Perfil_Pessoa_Logada pPL) {
		Pessoa p = new Pessoa();
		p.setDataNascimento(Utilidades.retornaCalendario2());
		p.setId_Pessoa_Registro(pPL.getPessoa_Logada());
		p.setSexo(Enum_Aux_Sexo.MASCULINO);
		p.setEnum_Aux_Tipo_Pessoa(Enum_Aux_Tipo_Pessoa.FISICA);
		return p;

	}

	public void inicializa_Eventos() {
		Utilidades.addTextLimiter(psf_Senha, 8);
		Utilidades.addTextLimiter(psf_ConfSenha, 8);

		tbP_Outros.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

			@Override
			public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
				Pessoa p = null;

				setConsultar(bt_Salvar.disabledProperty().get());

				if (getPessoa() != null && getPessoa().getId() != null && getPessoa().getId() > 0)
					p = getPessoa();
				if (newTab == tb_Endereco) {

				} else if (newTab == tb_Contatos) {

				} else if (newTab == tb_Usuario_Senha) {
					setUsuario(usuario_Buscar(p));
					if (getUsuario() == null)
						setUsuario(new Usuario(p));
					CarregaControlesVisuaisUsuario(true, getUsuario());

				} else if (newTab == tb_Perfis) {
					setpPVs(preparaNovaLista());
					adicionaNaObservablelistPerfis();

				}

			}
		});

		cb_Tipo_Pessoa.valueProperty().addListener(new ChangeListener<Enum_Aux_Tipo_Pessoa>() {
			@Override
			public void changed(ObservableValue<? extends Enum_Aux_Tipo_Pessoa> observable,
					Enum_Aux_Tipo_Pessoa oldValue, Enum_Aux_Tipo_Pessoa newValue) {				
				configura_tela();
			}
		});
	}

	public void adicionaPerfilNaListaCasoNaoExista() {
		if (!pPVExisteempPVs()) {
			getpPVs().add(retornaumVinculoPreenchido(true));

		}
	}

	public List<Pessoa_Perfil_e_Vinculo> preparaNovaLista() {
		List<Pessoa_Perfil_e_Vinculo> ppvs = pessoa_Perfil_e_Vinculo_Listar(retornaumVinculoPreenchido(true));
		if (ppvs == null) {
			ppvs = new ArrayList<>();
			ppvs.add(retornaumVinculoPreenchido(true));
		}
		return ppvs;

	}

	public void configuraPessoaeUsuario(Pessoa p) {
		if (p != null)
			if (p.getId() != null && p.getId() > 0) {
				setUsuario(usuario_Buscar(p));
				if (getUsuario() == null)
					setUsuario(new Usuario(p));
				
				
				
				

			} else {
				setUsuario(new Usuario(p));
				setpPV(new Pessoa_Perfil_e_Vinculo());
			}

		CarregaControlesVisuaisPessoa(true, getPessoa());
		CarregaControlesVisuaisUsuario(true, getUsuario());
		configura_tela();

		bloquearDesbloqueiaEditaveis(true);
	}

}

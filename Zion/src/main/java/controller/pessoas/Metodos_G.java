package controller.pessoas;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dao.PessoaDAO;
import model.dao.Pessoa_Perfil_e_VinculoDAO;
import model.dao.UsuarioDAO;
import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.entities.Usuario;
import model.enums.Enum_Aux_Tipo_Pessoa;
import util.Utilidades;

public class Metodos_G extends ControlesGeraisVisuais {
	protected void configura_tela() {
		if (cb_Tipo_Pessoa.getValue() != null && cb_Tipo_Pessoa.getValue().equals(Enum_Aux_Tipo_Pessoa.JURIDICA)) {
			lb_Cpf_Cnpj.setText("CNPJ");
			lb_Data_Nascimento_Abertura.setText("Abertura em:");
			lb_Rg_Inscricao_Estadual.setText("Inscrição Estadual");
			lb_Nome_Razao_Social.setText("Razão Social");
			lb_Sexo.setVisible(false);
			cb_Sexo.setVisible(false);
			lb_Fantasia_Apelido.setVisible(true);
			tf_Fantasia_Apelido.setVisible(true);
			lb_Fantasia_Apelido.setText("Nome Fantasia");
			tf_Nome_Razao_Social.setPrefWidth(569);
			lb_Senha.setLayoutX(272);
			psf_Senha.setLayoutX(272);

			lb_ConfSenha.setLayoutX(463);
			psf_ConfSenha.setLayoutX(463);

		} else if (cb_Tipo_Pessoa.getValue() == null
				|| !cb_Tipo_Pessoa.getValue().equals(Enum_Aux_Tipo_Pessoa.JURIDICA)) {
			lb_Cpf_Cnpj.setText("CPF");
			;
			lb_Data_Nascimento_Abertura.setText("Nascimento em:");
			lb_Rg_Inscricao_Estadual.setText("Rg");
			lb_Nome_Razao_Social.setText("Nome");
			lb_Sexo.setVisible(true);
			cb_Sexo.setVisible(true);
			lb_Fantasia_Apelido.setVisible(false);
			tf_Fantasia_Apelido.setVisible(false);
			tf_Nome_Razao_Social.setPrefWidth(966);

			lb_Senha.setLayoutX(582);
			psf_Senha.setLayoutX(582);

			lb_ConfSenha.setLayoutX(773);
			psf_ConfSenha.setLayoutX(773);

		}
	}

	public boolean merge_Geral() {
		try {
			if (Utilidades.getpPL().getPessoa_Logada() != null
					&& Utilidades.getpPL().getPessoa_Logada().getId() != null)
				getPessoa().setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());

			setPessoa(pessoa_Merge(getPessoa()));
			if (getPessoa() != null) {
				getUsuario().setAtivo(true);
				getUsuario().setId_Empresa(1);
				getUsuario().setId_Pessoa(getPessoa());
				if (Utilidades.getpPL().getPessoa_Logada() != null
						&& Utilidades.getpPL().getPessoa_Logada().getId() != null)
					getUsuario().setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
				else
					getUsuario().setId_Pessoa_Registro(getPessoa());
				getUsuario().setUltimaAtualizacao(Utilidades.retornaCalendario());
				setUsuario(usuario_Merge(getUsuario()));
				if (getUsuario() != null) {

					setpPV(new Pessoa_Perfil_e_Vinculo());
					

					if (Utilidades.getpPL().getFormulario_Atual().isPossui_Vinculos()
							|| (Utilidades.getpPL().getPerfil_Logado().isPossuiVinculo()
									&& Utilidades.getpPL().isVinculoproprio()))
						getpPV().setId_Pessoa_M(verificaSePessoa_MestreEstaDefinido());
					else
						getpPV().setId_Pessoa_M(null);

					getpPV().setId_Pessoa_D(getPessoa());
					getpPV().setId_Empresa(1);
					getpPV().setAtivo(true);
					getpPV().setEnum_Aux_Perfil_Pessoa(Utilidades.getpPL().getFormulario_Atual().getPerfil_Pessoa());
					getpPV().setUltimaAtualizacao(Utilidades.retornaCalendario());
					if (Utilidades.getpPL().getPessoa_Logada() == null
							|| Utilidades.getpPL().getPessoa_Logada().getId() != null
							|| Utilidades.getpPL().getPessoa_Logada().getId() <= 0)
						getpPV().setId_Pessoa_Registro(getPessoa());
					else
						getpPV().setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());

					Pessoa_Perfil_e_Vinculo ppv = new Pessoa_Perfil_e_Vinculo();
					ppv = getpPV();

					ppv = pessoa_Perfil_e_Vinculo_Buscar(ppv);
					if (ppv == null) {
						setpPV(pessoa_Perfil_e_Vinculo_Merge(getpPV()));
					}
				}
			}
			return true;

		} catch (Exception e) {
			Utilidades.enviaAlertError("Merge Geral", "MERGE", "Erro ao tentar gravar Dados");
		}

		return false;
	}

	public Pessoa pessoa_Merge(Pessoa p) {

		try {
			PessoaDAO dao = new PessoaDAO();
			p = dao.merge(p);
			return p;
		} catch (Exception e) {

			Utilidades.enviaAlertError("MERGE", "PESSOA", "Erro ao tentar Gravar PESSOA");
		}
		return null;

	}

	public Usuario usuario_Merge(Usuario us) {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			us = dao.merge(us);
			return us;
		} catch (Exception e) {

			Utilidades.enviaAlertError("MERGE", "USUARIO", "Erro ao tentar Gravar USUARIO");
		}
		return null;
	}

	public List<Pessoa_Perfil_e_Vinculo> pPVs_Merge(List<Pessoa_Perfil_e_Vinculo> pPVs) {
		try {
			Pessoa_Perfil_e_VinculoDAO pPVDAO = new Pessoa_Perfil_e_VinculoDAO();
			List<Pessoa_Perfil_e_Vinculo> pPVsRet = new ArrayList<>();
			for (Pessoa_Perfil_e_Vinculo pPV : pPVs) {
				pPV = pPVDAO.merge(pPV);
				pPVsRet.add(pPV);
			}
			return pPVsRet;

		} catch (Exception e) {

			Utilidades.enviaAlertError("MERGE", "PERFIL", "Erro ao tentar Gravar PESSOA PERFIL E VINCULO");
		}
		return null;

	}

	public Pessoa verificaSePessoa_MestreEstaDefinido() {
		if (Utilidades.getpPL() != null && Utilidades.getpPL().getEmpresa_Logada() != null
				&& Utilidades.getpPL().getEmpresa_Logada().getId() != null
				&& Utilidades.getpPL().getEmpresa_Logada().getId() > 0)
			return Utilidades.getpPL().getEmpresa_Logada();
		else
			return null;
	}

	public Pessoa verificaSePessoa_DetalheEstaDefinido() {
		if (Utilidades.getpPL() != null && Utilidades.getpPL().getPessoa_Logada() != null
				&& Utilidades.getpPL().getPessoa_Logada().getId() != null
				&& Utilidades.getpPL().getPessoa_Logada().getId() > 0)
			return Utilidades.getpPL().getPessoa_Logada();
		else
			return null;
	}

	public Pessoa_Perfil_e_Vinculo atribuipPV() {
		Pessoa_Perfil_e_Vinculo pPV = new Pessoa_Perfil_e_Vinculo();
		pPV.setEnum_Aux_Perfil_Pessoa(Utilidades.getpPL().getFormulario_Atual().getPerfil_Pessoa());
		pPV.setId_Pessoa_D(verificaSePessoa_DetalheEstaDefinido());
		pPV.setId_Pessoa_M(verificaSePessoa_MestreEstaDefinido());
		return pPV;
	}

	public List<Pessoa_Perfil_e_Vinculo> atribuipPVs(Pessoa_Perfil_e_Vinculo pPV) {
		List<Pessoa_Perfil_e_Vinculo> pPVs = new ArrayList<>();
		pPVs.add(pPV);
		return pPVs;
	}

	public boolean pPVExisteempPVs() {
		boolean ret = false;
		if (getpPVs() == null || getpPVs().size() <= 0)
			ret = false;

		Pessoa_Perfil_e_Vinculo pPVCons = retornaumVinculoPreenchido(true);
		ret = getpPVs().contains(pPVCons);

		return ret;
	}

	public boolean confirmapPV(Pessoa_Perfil_e_Vinculo pPV) {
		if (getpPV() == null || getpPV().getId_Pessoa_D() == null)
			return false;
		if (pPV == null || pPV.getId_Pessoa_D() == null)
			return false;

		if (getpPV().getId_Pessoa_D() == getPessoa() && getpPV().getId_Pessoa_M() == pPV.getId_Pessoa_M()
				&& getpPV().getEnum_Aux_Perfil_Pessoa() == pPV.getEnum_Aux_Perfil_Pessoa())
			return true;
		return false;
	}

	public void adicionaNaObservablelistPerfis() {
		perfilPessoaObsList.clear();
		if (getpPVs() != null)
			perfilPessoaObsList.addAll(getpPVs());
		populaTvPerfil();

	}

	public boolean pPVExisteempPVsObsvable() {
		boolean ret = false;
		if (perfilPessoaObsList == null || perfilPessoaObsList.size() <= 0)
			ret = false;
		for (Pessoa_Perfil_e_Vinculo pPVcons : perfilPessoaObsList) {
			if (confirmapPV(pPVcons) == true) {
				ret = true;
				break;
			}
		}

		return ret;
	}

	public Pessoa_Perfil_e_Vinculo retornaumVinculoPreenchido(boolean comperfil) {
		Pessoa_Perfil_e_Vinculo pPV = new Pessoa_Perfil_e_Vinculo();
		pPV.setId_Pessoa_D(getPessoa());
		pPV.setId_Pessoa_M(Utilidades.getpPL().getEmpresa_Logada());
		if (comperfil)
			pPV.setEnum_Aux_Perfil_Pessoa(Utilidades.getpPL().getFormulario_Atual().getPerfil_Pessoa());
		else
			pPV.setEnum_Aux_Perfil_Pessoa(null);
		return pPV;
	}

	public Pessoa_Perfil_e_Vinculo pessoa_Perfil_e_Vinculo_Buscar(Pessoa_Perfil_e_Vinculo pPV) {
		Pessoa_Perfil_e_VinculoDAO dao = new Pessoa_Perfil_e_VinculoDAO();
		return dao.Pessoa_Perfil_e_VinculoExiste(pPV, true, true);
	}

	public Pessoa_Perfil_e_Vinculo pessoa_Perfil_e_Vinculo_Merge(Pessoa_Perfil_e_Vinculo pPV) {
		Pessoa_Perfil_e_VinculoDAO dao = new Pessoa_Perfil_e_VinculoDAO();
		return dao.merge(pPV);
	}

	public void populaTvPerfil() {

		tv_Perfil_Pessoa.setItems(FXCollections.observableArrayList(getpPVs()));
		tc_Perfil_Perfil.setCellValueFactory(new PropertyValueFactory<>("enum_Aux_Perfil_Pessoa"));
		tc_Perfil_Responsavel.setCellValueFactory(new PropertyValueFactory<>("id_Pessoa_Registro"));
		// tv_Perfil_Pessoa.getColumns().addAll(tc_Perfil_Perfil,
		// tc_Perfil_Responsavel);

	}

}

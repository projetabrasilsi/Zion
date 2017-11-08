package controller.pessoas;

import java.util.List;

import model.dao.Pessoa_Perfil_e_VinculoDAO;
import model.dao.UsuarioDAO;
import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.entities.Usuario;
import model.enums.Enum_Aux_Formularios;
import util.Utilidades;

public class Metodos_C extends Metodos_D {

	////////////////// parte destina a usuarios
	public Usuario usuario_Buscar(Pessoa p) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.buscaUsuarioPorPessoa(p);
	}

	public Usuario usuario_Novo(Pessoa p) {
		Usuario us = new Usuario();

		return us;

	}

	public Usuario usuario_Merge(Usuario us, Pessoa responsavel) {
		us.setId_Empresa(1);
		us.setUltimaAtualizacao(Utilidades.retornaCalendario());
		us.setId_Pessoa_Registro(responsavel);
		UsuarioDAO dao = new UsuarioDAO();
		return dao.merge(us);
	}

	public Usuario CarregaControlesVisuaisUsuario(boolean carregar, Usuario u) {
		if (carregar) {

			if (isConsultar()) {
				psf_Senha.setText(u.getSenha());
				psf_ConfSenha.setText(psf_Senha.getText());
			} else {
				if (u.getId_Pessoa() == null || u.getId_Pessoa() != getPessoa())
					setUsuario(new Usuario(getPessoa()));

				if (psf_Senha.getText().length() <= 0)					
					psf_Senha.setText(getUsuario().getSenha());
				
				psf_ConfSenha.setText(psf_Senha.getText());

			}

		} else {
			u.setSenha(psf_Senha.getText());
			u.setConfSenha(psf_ConfSenha.getText());
			
			
		}
		return u;
	}

	////////////////// parte destina a perfis

	public List<Pessoa_Perfil_e_Vinculo> pessoa_Perfil_e_Vinculo_Listar(Pessoa_Perfil_e_Vinculo pPV) {
		Pessoa_Perfil_e_VinculoDAO dao = new Pessoa_Perfil_e_VinculoDAO();
		return dao.Pessoa_Perfil_e_VinculoLista(pPV, true, true);
	}

	
	public List<Pessoa_Perfil_e_Vinculo> CarregaControlesVisuaisPessoa_Perfil_E_Vinculo(boolean carregar,
			List<Pessoa_Perfil_e_Vinculo> pPVs, Enum_Aux_Formularios form_Atual) {
		if (carregar) {

			if (pPVs != null) {
				perfilPessoaObsList.addAll(pPVs);
			} else {
				perfilPessoaObsList.clear();
			}

		} else {
			if (perfilPessoaObsList.size() > 0) {
				pPVs =  perfilPessoaObsList.subList(0, perfilPessoaObsList.size()-1) ;
			} else
				pPVs.clear();

		}
		return pPVs;
	}

}

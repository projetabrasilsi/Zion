package controller.pessoas;

import java.util.ArrayList;
import java.util.List;

import controller.application.AplicacaoControles;
import model.entities.Contato;
import model.entities.Endereco;
import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.entities.Usuario;

public class ControlesGeraisNaoVisuais extends AplicacaoControles {
	private Pessoa pessoa = new Pessoa();
	private Endereco endereco = new Endereco();
	private Usuario usuario = new Usuario();
	private Contato contato = new Contato();
	private List<Contato> contatos = new ArrayList<>();
	private Pessoa_Perfil_e_Vinculo pPV = new Pessoa_Perfil_e_Vinculo();
	private List<Pessoa_Perfil_e_Vinculo> pPVs = new ArrayList<>();

	
	private boolean confirmado = false;
	private boolean consultar = true;
	protected Pessoa getPessoa() {
		return pessoa;
	}
	protected void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	protected Endereco getEndereco() {
		return endereco;
	}
	protected void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	protected Usuario getUsuario() {
		return usuario;
	}
	protected void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	protected Contato getContato() {
		return contato;
	}
	protected void setContato(Contato contato) {
		this.contato = contato;
	}
	protected List<Contato> getContatos() {
		return contatos;
	}
	protected void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	protected Pessoa_Perfil_e_Vinculo getpPV() {
		return pPV;
	}
	protected void setpPV(Pessoa_Perfil_e_Vinculo pPV) {
		this.pPV = pPV;
	}
	protected List<Pessoa_Perfil_e_Vinculo> getpPVs() {
		return pPVs;
	}
	protected void setpPVs(List<Pessoa_Perfil_e_Vinculo> pPVs) {
		this.pPVs = pPVs;
	}
	
	protected boolean isConfirmado() {
		return confirmado;
	}
	protected void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	protected boolean isConsultar() {
		return consultar;
	}
	protected void setConsultar(boolean consultar) {
		this.consultar = consultar;
	}


}

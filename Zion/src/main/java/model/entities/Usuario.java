package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@SuppressWarnings("serial")
@Entity
@Table(name="Usuario")
public class Usuario extends GenericDomain implements Serializable{
	@Id
	@SequenceGenerator(name="pk_usuario",sequenceName="messsounds_usuario", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_usuario")
	private Long id;
	
	@Column(name="senha",length=32, nullable=false)
	private String senha;
	@Transient
	@Column(name="confSenha",length=32, nullable=false)
	private String confSenha;
	@Transient
	@Column(name="senhaSemCript",length=32, nullable=false)
	private String senhaSemCript;
	
	@Column(name="Ativo", nullable=false)
	private boolean Ativo;
	@ManyToOne
	@JoinColumn ( name ="id_Pessoa_Registro", nullable=false)	
	private Pessoa id_Pessoa_Registro;
	
	@ManyToOne
	@JoinColumn(name = "id_Pessoa")
	private Pessoa id_Pessoa;
	
	public Usuario() {
		  setId_Pessoa(new Pessoa());
		  setAtivo(true);
	}
	
	public Usuario(Pessoa p) {
		  super();
		  setId_Pessoa(p);
		  setSenha("");
		  setConfSenha("");
		  setAtivo(true);
		  setId_Empresa(1);
		  
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	public String getSenhaSemCript() {
		return senhaSemCript;
	}

	public void setSenhaSemCript(String senhaSemCript) {
		this.senhaSemCript = senhaSemCript;
	}

	public boolean isAtivo() {
		return Ativo;
	}

	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}

	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}

	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	}

	public Pessoa getId_Pessoa() {
		return id_Pessoa;
	}

	public void setId_Pessoa(Pessoa id_Pessoa) {
		this.id_Pessoa = id_Pessoa;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", senha=" + senha + ", confSenha=" + confSenha + ", senhaSemCript="
				+ senhaSemCript + ", Ativo=" + Ativo + ", id_Pessoa_Registro=" + id_Pessoa_Registro + ", id_Pessoa="
				+ id_Pessoa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (Ativo ? 1231 : 1237);
		result = prime * result + ((confSenha == null) ? 0 : confSenha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Pessoa == null) ? 0 : id_Pessoa.hashCode());
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((senhaSemCript == null) ? 0 : senhaSemCript.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Ativo != other.Ativo)
			return false;
		if (confSenha == null) {
			if (other.confSenha != null)
				return false;
		} else if (!confSenha.equals(other.confSenha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_Pessoa == null) {
			if (other.id_Pessoa != null)
				return false;
		} else if (!id_Pessoa.equals(other.id_Pessoa))
			return false;
		if (id_Pessoa_Registro == null) {
			if (other.id_Pessoa_Registro != null)
				return false;
		} else if (!id_Pessoa_Registro.equals(other.id_Pessoa_Registro))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (senhaSemCript == null) {
			if (other.senhaSemCript != null)
				return false;
		} else if (!senhaSemCript.equals(other.senhaSemCript))
			return false;
		return true;
	}
		
}

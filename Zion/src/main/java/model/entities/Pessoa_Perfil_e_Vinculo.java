package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import model.enums.Enum_Aux_Perfil_Pessoa;

@SuppressWarnings("serial")
@Entity
@Table(name="Pessoa_Perfil_e_Vinculo")
public class Pessoa_Perfil_e_Vinculo extends GenericDomain implements Serializable {
	
	@Id
	@SequenceGenerator(name="pk_pessoa_Perfil_e_Vinculo",sequenceName="messsounds_pessoa_Perfil_e_Vinculo", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_pessoa_Perfil_e_Vinculo")
	private Long id;
	
	@ManyToOne
	// estou vinculado a  qual empresa mestre?
	@JoinColumn(name="id_Pessoa_M")
	private Pessoa id_Pessoa_M;
	
	@ManyToOne
	// pessoa do cadastro atual
	@JoinColumn(name="id_Pessoa_D", nullable=false)	
	private Pessoa id_Pessoa_D;
	
	@Enumerated(EnumType.STRING)	
	@Column(name="enum_Aux_Perfil_Pessoa", nullable=false)
	private Enum_Aux_Perfil_Pessoa enum_Aux_Perfil_Pessoa;
	
	
	@ManyToOne
	@JoinColumn ( name ="id_Pessoa_Registro", nullable=false)	
	private Pessoa id_Pessoa_Registro ;

	

	@Column(name="ativo" , nullable=false)
	private boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getId_Pessoa_M() {
		return id_Pessoa_M;
	}

	public void setId_Pessoa_M(Pessoa id_Pessoa_M) {
		this.id_Pessoa_M = id_Pessoa_M;
	}

	public Pessoa getId_Pessoa_D() {
		return id_Pessoa_D;
	}

	public void setId_Pessoa_D(Pessoa id_Pessoa_D) {
		this.id_Pessoa_D = id_Pessoa_D;
	}

	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}

	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	}

	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Pessoa_Perfil_e_Vinculo [id=" + id + ", id_Pessoa_M=" + id_Pessoa_M + ", id_Pessoa_D=" + id_Pessoa_D
				+ ", enum_Aux_Perfil_Pessoa=" + enum_Aux_Perfil_Pessoa + ", id_Pessoa_Registro=" + id_Pessoa_Registro
				+ ", ativo=" + ativo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((enum_Aux_Perfil_Pessoa == null) ? 0 : enum_Aux_Perfil_Pessoa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Pessoa_D == null) ? 0 : id_Pessoa_D.hashCode());
		result = prime * result + ((id_Pessoa_M == null) ? 0 : id_Pessoa_M.hashCode());
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
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
		Pessoa_Perfil_e_Vinculo other = (Pessoa_Perfil_e_Vinculo) obj;
		if (ativo != other.ativo)
			return false;
		if (enum_Aux_Perfil_Pessoa != other.enum_Aux_Perfil_Pessoa)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_Pessoa_D == null) {
			if (other.id_Pessoa_D != null)
				return false;
		} else if (!id_Pessoa_D.equals(other.id_Pessoa_D))
			return false;
		if (id_Pessoa_M == null) {
			if (other.id_Pessoa_M != null)
				return false;
		} else if (!id_Pessoa_M.equals(other.id_Pessoa_M))
			return false;
		if (id_Pessoa_Registro == null) {
			if (other.id_Pessoa_Registro != null)
				return false;
		} else if (!id_Pessoa_Registro.equals(other.id_Pessoa_Registro))
			return false;
		return true;
	}

	public Enum_Aux_Perfil_Pessoa getEnum_Aux_Perfil_Pessoa() {
		return enum_Aux_Perfil_Pessoa;
	}

	public void setEnum_Aux_Perfil_Pessoa(Enum_Aux_Perfil_Pessoa enum_Aux_Perfil_Pessoa) {
		this.enum_Aux_Perfil_Pessoa = enum_Aux_Perfil_Pessoa;
	}
	
	
	

		
}

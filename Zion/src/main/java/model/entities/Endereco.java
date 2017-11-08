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

import com.google.gson.annotations.SerializedName;

import model.enums.Enum_Aux_Tipo_Endereco;

@SuppressWarnings("serial")
@Entity
@Table(name="Endereco")
public class Endereco extends GenericDomain implements Serializable {
	
	@Id
	@SequenceGenerator(name="pk_endereco",sequenceName="messsounds_endereco", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_endereco")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_Estado", nullable=true)
	private Estado id_Estado;
	
	@ManyToOne
	@JoinColumn(name = "id_Bairro", nullable=true)
	private Bairro id_Bairro;
	
	@ManyToOne
	@JoinColumn(name = "id_Logradouro")
	private Logradouro id_Logradouro;
	
	@ManyToOne
	@JoinColumn(name = "id_Pessoa")
	private Pessoa id_Pessoa;
	
	@Column(name="numero", nullable=true) 
	private Integer numero;
	
	
	@Column(name="complemento", length=50, nullable=true) 
	private String complemento;
	
	@Column(name="ponto_Ref", length=50, nullable=true) 
	private String ponto_Ref;
	
	
	@Column(name="id_Cidade", nullable=true)
	@SerializedName("id_Cidade")
	private Cidade id_Cidade;
	
	@Enumerated(EnumType.STRING)	
	@SerializedName("enum_Aux_Tipo_Endereco")
	@Column(name="enum_Aux_Tipo_Endereco")
	private Enum_Aux_Tipo_Endereco enum_Aux_Tipo_Endereco;
	
	/**
	 * 
	 */
	@Column(name="cep", length=20, nullable=true) 
	private String cep;
	
	public Endereco(){
		super();
	}
	
	
	public Endereco(Bairro id_Bairro, Cidade id_Cidade, Estado id_Estado) {
		super();
		this.setId_Bairro(id_Bairro);
		this.setId_Cidade(id_Cidade);
		this.getId_Cidade().setId_Estado(id_Estado);

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Bairro getId_Bairro() {
		return id_Bairro;
	}


	public void setId_Bairro(Bairro id_Bairro) {
		this.id_Bairro = id_Bairro;
	}


	public Logradouro getId_Logradouro() {
		return id_Logradouro;
	}


	public void setId_Logradouro(Logradouro id_Logradouro) {
		this.id_Logradouro = id_Logradouro;
	}


	public Pessoa getId_Pessoa() {
		return id_Pessoa;
	}


	public void setId_Pessoa(Pessoa id_Pessoa) {
		this.id_Pessoa = id_Pessoa;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getPonto_Ref() {
		return ponto_Ref;
	}


	public void setPonto_Ref(String ponto_Ref) {
		this.ponto_Ref = ponto_Ref;
	}


	public Cidade getId_Cidade() {
		return id_Cidade;
	}


	public void setId_Cidade(Cidade id_Cidade) {
		this.id_Cidade = id_Cidade;
	}


	public Enum_Aux_Tipo_Endereco getEnum_Aux_Tipo_Endereco() {
		return enum_Aux_Tipo_Endereco;
	}


	public void setEnum_Aux_Tipo_Endereco(Enum_Aux_Tipo_Endereco enum_Aux_Tipo_Endereco) {
		this.enum_Aux_Tipo_Endereco = enum_Aux_Tipo_Endereco;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	@Override
	public String toString() {
		return "Endereco [id=" + id + ", id_Estado=" + id_Estado + ", id_Bairro=" + id_Bairro + ", id_Logradouro="
				+ id_Logradouro + ", id_Pessoa=" + id_Pessoa + ", numero=" + numero + ", complemento=" + complemento
				+ ", ponto_Ref=" + ponto_Ref + ", id_Cidade=" + id_Cidade + ", enum_Aux_Tipo_Endereco="
				+ enum_Aux_Tipo_Endereco + ", cep=" + cep + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((enum_Aux_Tipo_Endereco == null) ? 0 : enum_Aux_Tipo_Endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Bairro == null) ? 0 : id_Bairro.hashCode());
		result = prime * result + ((id_Cidade == null) ? 0 : id_Cidade.hashCode());
		result = prime * result + ((id_Estado == null) ? 0 : id_Estado.hashCode());
		result = prime * result + ((id_Logradouro == null) ? 0 : id_Logradouro.hashCode());
		result = prime * result + ((id_Pessoa == null) ? 0 : id_Pessoa.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((ponto_Ref == null) ? 0 : ponto_Ref.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (enum_Aux_Tipo_Endereco != other.enum_Aux_Tipo_Endereco)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_Bairro == null) {
			if (other.id_Bairro != null)
				return false;
		} else if (!id_Bairro.equals(other.id_Bairro))
			return false;
		if (id_Cidade == null) {
			if (other.id_Cidade != null)
				return false;
		} else if (!id_Cidade.equals(other.id_Cidade))
			return false;
		if (id_Estado == null) {
			if (other.id_Estado != null)
				return false;
		} else if (!id_Estado.equals(other.id_Estado))
			return false;
		if (id_Logradouro == null) {
			if (other.id_Logradouro != null)
				return false;
		} else if (!id_Logradouro.equals(other.id_Logradouro))
			return false;
		if (id_Pessoa == null) {
			if (other.id_Pessoa != null)
				return false;
		} else if (!id_Pessoa.equals(other.id_Pessoa))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (ponto_Ref == null) {
			if (other.ponto_Ref != null)
				return false;
		} else if (!ponto_Ref.equals(other.ponto_Ref))
			return false;
		return true;
	}


	public Estado getId_Estado() {
		return id_Estado;
	}


	public void setId_Estado(Estado id_Estado) {
		this.id_Estado = id_Estado;
	}


					
}

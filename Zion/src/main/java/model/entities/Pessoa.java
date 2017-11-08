package model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import adaptadores.PessoaAdapter;
import model.enums.Enum_Aux_Sexo;
import model.enums.Enum_Aux_Tipo_Pessoa;
@SuppressWarnings("serial")
@Entity
@Table(name="Pessoa")
@JsonAdapter(PessoaAdapter.class)
public class Pessoa extends GenericDomain implements Serializable{
	
	@Id
	@SequenceGenerator(name="pk_pessoa",sequenceName="messsounds_pessoa", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_pessoa")
	@SerializedName("id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="enum_Aux_Tipo_Pessoa", nullable=true)
	@SerializedName("enum_Aux_Tipo_Pessoa")
	private Enum_Aux_Tipo_Pessoa enum_Aux_Tipo_Pessoa;
	
	
	@Column(name="descricao", length = 90, nullable=false)
	@SerializedName("descricao")
	private String descricao;
	
	@Column(name="fantasia_Apelido", length = 90, nullable=true)
	@SerializedName("fantasia_Apelido")
	private String fantasia_Apelido;
	
	
	@Column(name="dataNascimento", nullable=true)
	@Temporal(TemporalType.DATE)
	@SerializedName("dataNascimento")
	private Date dataNascimento;
	
	
	@Column(name="cpf_Cnpj", length=20)
	@SerializedName("cpf_Cnpj")
	private String cpf_Cnpj;
	@Column(name="rg_Insc", length=20)
	@SerializedName("rg_Insc")
	private String rg_Insc;
	@Enumerated(EnumType.STRING)
	@SerializedName("sexo")
	private Enum_Aux_Sexo sexo; 
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Pessoa_Registro")	
	@SerializedName("id_Pessoa_Registro")
	private Pessoa id_Pessoa_Registro;
	
	
	
	
	
	@OneToOne
	@JoinColumn ( name ="id_Profissao")
	@SerializedName("id_Profissao")
	private Profissao id_Profissao;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getFantasia_Apelido() {
		return fantasia_Apelido;
	}



	public void setFantasia_Apelido(String fantasia_Apelido) {
		this.fantasia_Apelido = fantasia_Apelido;
	}



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getCpf_Cnpj() {
		return cpf_Cnpj;
	}



	public void setCpf_Cnpj(String cpf_Cnpj) {
		this.cpf_Cnpj = cpf_Cnpj;
	}



	public String getRg_Insc() {
		return rg_Insc;
	}



	public void setRg_Insc(String rg_Insc) {
		this.rg_Insc = rg_Insc;
	}



	public Enum_Aux_Sexo getSexo() {
		return sexo;
	}



	public void setSexo(Enum_Aux_Sexo sexo) {
		this.sexo = sexo;
	}



	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}



	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	}



	public Profissao getId_Profissao() {
		return id_Profissao;
	}



	public void setId_Profissao(Profissao id_Profissao) {
		this.id_Profissao = id_Profissao;
	}



	public Enum_Aux_Tipo_Pessoa getEnum_Aux_Tipo_Pessoa() {
		return enum_Aux_Tipo_Pessoa;
	}



	public void setEnum_Aux_Tipo_Pessoa(Enum_Aux_Tipo_Pessoa enum_Aux_Tipo_Pessoa) {
		this.enum_Aux_Tipo_Pessoa = enum_Aux_Tipo_Pessoa;
	}



	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", enum_Aux_Tipo_Pessoa=" + enum_Aux_Tipo_Pessoa + ", descricao=" + descricao
				+ ", fantasia_Apelido=" + fantasia_Apelido + ", dataNascimento=" + dataNascimento + ", cpf_Cnpj="
				+ cpf_Cnpj + ", rg_Insc=" + rg_Insc + ", sexo=" + sexo + ", id_Pessoa_Registro=" + id_Pessoa_Registro
				
				+ ", id_Profissao=" + id_Profissao + "]";
	}



	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf_Cnpj == null) ? 0 : cpf_Cnpj.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((enum_Aux_Tipo_Pessoa == null) ? 0 : enum_Aux_Tipo_Pessoa.hashCode());
		result = prime * result + ((fantasia_Apelido == null) ? 0 : fantasia_Apelido.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
		result = prime * result + ((id_Profissao == null) ? 0 : id_Profissao.hashCode());
		result = prime * result + ((rg_Insc == null) ? 0 : rg_Insc.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpf_Cnpj == null) {
			if (other.cpf_Cnpj != null)
				return false;
		} else if (!cpf_Cnpj.equals(other.cpf_Cnpj))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (enum_Aux_Tipo_Pessoa != other.enum_Aux_Tipo_Pessoa)
			return false;
		if (fantasia_Apelido == null) {
			if (other.fantasia_Apelido != null)
				return false;
		} else if (!fantasia_Apelido.equals(other.fantasia_Apelido))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		if (id_Pessoa_Registro == null) {
			if (other.id_Pessoa_Registro != null)
				return false;
		} else if (!id_Pessoa_Registro.equals(other.id_Pessoa_Registro))
			return false;
		if (id_Profissao == null) {
			if (other.id_Profissao != null)
				return false;
		} else if (!id_Profissao.equals(other.id_Profissao))
			return false;
		if (rg_Insc == null) {
			if (other.rg_Insc != null)
				return false;
		} else if (!rg_Insc.equals(other.rg_Insc))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}



			
				
}

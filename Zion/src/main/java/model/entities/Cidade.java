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

@SuppressWarnings("serial")
@Entity
@Table(name="Cidade")
public class Cidade extends GenericDomain implements Serializable {
	
	@Id
	@SequenceGenerator(name="pk_cidade",sequenceName="messsounds_cidade", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_cidade")
	private Long id;
	
	@Column(name="descricao", length = 90, nullable=false)
	private String descricao;
	
	@Column(name="CEP", length = 90, nullable=false)
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "id_Estado")
	private Estado id_Estado;
	
	@ManyToOne
	@JoinColumn ( name ="id_Pessoa_Registro")	
	private Pessoa id_Pessoa_Registro;
	@Column(name="ibge", length = 20, nullable=false)
	private String ibge;
	
	
	
	
	public Cidade(){
		super();
		
	}
	
	public Cidade(Estado id_Estado) {
		super();			
		setId_Estado(id_Estado);
	
	}

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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Estado getId_Estado() {
		return id_Estado;
	}

	public void setId_Estado(Estado id_Estado) {
		this.id_Estado = id_Estado;
	}

	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}

	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((ibge == null) ? 0 : ibge.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Estado == null) ? 0 : id_Estado.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (ibge == null) {
			if (other.ibge != null)
				return false;
		} else if (!ibge.equals(other.ibge))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_Estado == null) {
			if (other.id_Estado != null)
				return false;
		} else if (!id_Estado.equals(other.id_Estado))
			return false;
		if (id_Pessoa_Registro == null) {
			if (other.id_Pessoa_Registro != null)
				return false;
		} else if (!id_Pessoa_Registro.equals(other.id_Pessoa_Registro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", descricao=" + descricao + ", cep=" + cep + ", id_Estado=" + id_Estado
				+ ", id_Pessoa_Registro=" + id_Pessoa_Registro + ", ibge=" + ibge + "]";
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

		
}

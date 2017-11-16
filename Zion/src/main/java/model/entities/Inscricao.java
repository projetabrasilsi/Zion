package model.entities;

import java.io.Serializable;

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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Status_Consulta;

@SuppressWarnings("serial")
@Entity
@Table(name="Inscricao")
public class Inscricao extends GenericDomain implements Serializable {
	@Id
	@SequenceGenerator(name="pk_inscricao",sequenceName="messsounds_inscricao", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_inscricao")
	@SerializedName("id")	
	private Long id;	
	@Enumerated(EnumType.STRING)
	private Enum_Aux_Servicos_Classificacoes enum_Aux_Servicos_Classificacoes;
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Mestre", nullable = false)	
	private Pessoa id_Mestre;
	@Column(name = "status") 
	private boolean status;
	@Column(name = "nInsc", length = 20)
	private String nInsc;
	@Column(name = "dados_Base", length = 50)
	private String dados_Base;
	@Column(name = "proprietario", length = 90)
	private String proprietario;
	@Column(name = "endereco", length = 120)
	private String endereco;
	@Column(name = "cpf_Cnpj", length = 20)
	private String cpf_Cnpj;
	@Enumerated(EnumType.STRING)
	@Column(name = "enum_Aux_Status_Consulta", nullable = false)
	private Enum_Aux_Status_Consulta enum_Aux_Status_Consulta;
	@Column(name = "motivo", length = 100)
	private String motivo;
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Pessoa_Registro", nullable = false)	
	@SerializedName("id_Pessoa_Registro")
	private Pessoa id_Pessoa_Registro;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Enum_Aux_Servicos_Classificacoes getEnum_Aux_Servicos_Classificacoes() {
		return enum_Aux_Servicos_Classificacoes;
	}
	public void setEnum_Aux_Servicos_Classificacoes(Enum_Aux_Servicos_Classificacoes enum_Aux_Servicos_Classificacoes) {
		this.enum_Aux_Servicos_Classificacoes = enum_Aux_Servicos_Classificacoes;
	}
	public Pessoa getId_Mestre() {
		return id_Mestre;
	}
	public void setId_Mestre(Pessoa id_Mestre) {
		this.id_Mestre = id_Mestre;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getnInsc() {
		return nInsc;
	}
	public void setnInsc(String nInsc) {
		this.nInsc = nInsc;
	}
	public String getDados_Base() {
		return dados_Base;
	}
	public void setDados_Base(String dados_Base) {
		this.dados_Base = dados_Base;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf_Cnpj() {
		return cpf_Cnpj;
	}
	public void setCpf_Cnpj(String cpf_Cnpj) {
		this.cpf_Cnpj = cpf_Cnpj;
	}
	public Enum_Aux_Status_Consulta getEnum_Aux_Status_Consulta() {
		return enum_Aux_Status_Consulta;
	}
	public void setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta enum_Aux_Status_Consulta) {
		this.enum_Aux_Status_Consulta = enum_Aux_Status_Consulta;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}
	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	}
	@Override
	public String toString() {
		return "Inscricao [id=" + id + ", enum_Aux_Servicos_Classificacoes=" + enum_Aux_Servicos_Classificacoes
				+ ", id_Mestre=" + id_Mestre + ", status=" + status + ", nInsc=" + nInsc + ", dados_Base=" + dados_Base
				+ ", proprietario=" + proprietario + ", endereco=" + endereco + ", cpf_Cnpj=" + cpf_Cnpj
				+ ", enum_Aux_Status_Consulta=" + enum_Aux_Status_Consulta + ", motivo=" + motivo
				+ ", id_Pessoa_Registro=" + id_Pessoa_Registro + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf_Cnpj == null) ? 0 : cpf_Cnpj.hashCode());
		result = prime * result + ((dados_Base == null) ? 0 : dados_Base.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((enum_Aux_Servicos_Classificacoes == null) ? 0 : enum_Aux_Servicos_Classificacoes.hashCode());
		result = prime * result + ((enum_Aux_Status_Consulta == null) ? 0 : enum_Aux_Status_Consulta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Mestre == null) ? 0 : id_Mestre.hashCode());
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
		result = prime * result + ((nInsc == null) ? 0 : nInsc.hashCode());
		result = prime * result + ((proprietario == null) ? 0 : proprietario.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		Inscricao other = (Inscricao) obj;
		if (cpf_Cnpj == null) {
			if (other.cpf_Cnpj != null)
				return false;
		} else if (!cpf_Cnpj.equals(other.cpf_Cnpj))
			return false;
		if (dados_Base == null) {
			if (other.dados_Base != null)
				return false;
		} else if (!dados_Base.equals(other.dados_Base))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (enum_Aux_Servicos_Classificacoes != other.enum_Aux_Servicos_Classificacoes)
			return false;
		if (enum_Aux_Status_Consulta != other.enum_Aux_Status_Consulta)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_Mestre == null) {
			if (other.id_Mestre != null)
				return false;
		} else if (!id_Mestre.equals(other.id_Mestre))
			return false;
		if (id_Pessoa_Registro == null) {
			if (other.id_Pessoa_Registro != null)
				return false;
		} else if (!id_Pessoa_Registro.equals(other.id_Pessoa_Registro))
			return false;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		if (nInsc == null) {
			if (other.nInsc != null)
				return false;
		} else if (!nInsc.equals(other.nInsc))
			return false;
		if (proprietario == null) {
			if (other.proprietario != null)
				return false;
		} else if (!proprietario.equals(other.proprietario))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
		
	
}

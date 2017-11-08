package model.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;

@SuppressWarnings("serial")
@Entity
@Table(name="Inscricao_Historico")
public class Inscricao_Historico extends GenericDomain implements Serializable {
	@Id
	@SequenceGenerator(name="pk_inscricao_Historico",sequenceName="messsounds_inscricao_Historico", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_inscricao_Historico")
	@SerializedName("id")	
	private Long id;	
	@Enumerated(EnumType.STRING)
	private Enum_Aux_Servicos_Sub_Classificacoes enum_Aux_Servicos_Sub_Classificacoes;
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Inscricao")	
	private Inscricao id_Inscricao;

	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Pessoa_Registro")	
	@SerializedName("id_Pessoa_Registro")
	private Pessoa id_Pessoa_Registro;
	
	private double valor;
	private int ano_Ref;
	private int mes_Ref;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Enum_Aux_Servicos_Sub_Classificacoes getEnum_Aux_Servicos_Sub_Classificacoes() {
		return enum_Aux_Servicos_Sub_Classificacoes;
	}
	public void setEnum_Aux_Servicos_Sub_Classificacoes(
			Enum_Aux_Servicos_Sub_Classificacoes enum_Aux_Servicos_Sub_Classificacoes) {
		this.enum_Aux_Servicos_Sub_Classificacoes = enum_Aux_Servicos_Sub_Classificacoes;
	}
	public Inscricao getId_Inscricao() {
		return id_Inscricao;
	}
	public void setId_Inscricao(Inscricao id_Inscricao) {
		this.id_Inscricao = id_Inscricao;
	}
	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}
	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getAno_Ref() {
		return ano_Ref;
	}
	public void setAno_Ref(int ano_Ref) {
		this.ano_Ref = ano_Ref;
	}
	public int getMes_Ref() {
		return mes_Ref;
	}
	public void setMes_Ref(int mes_Ref) {
		this.mes_Ref = mes_Ref;
	}
	@Override
	public String toString() {
		return "Inscricao_Historico [id=" + id + ", enum_Aux_Servicos_Sub_Classificacoes="
				+ enum_Aux_Servicos_Sub_Classificacoes + ", id_Inscricao=" + id_Inscricao + ", id_Pessoa_Registro="
				+ id_Pessoa_Registro + ", valor=" + valor + ", ano_Ref=" + ano_Ref + ", mes_Ref=" + mes_Ref + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ano_Ref;
		result = prime * result + ((enum_Aux_Servicos_Sub_Classificacoes == null) ? 0
				: enum_Aux_Servicos_Sub_Classificacoes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Inscricao == null) ? 0 : id_Inscricao.hashCode());
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
		result = prime * result + mes_Ref;
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Inscricao_Historico other = (Inscricao_Historico) obj;
		if (ano_Ref != other.ano_Ref)
			return false;
		if (enum_Aux_Servicos_Sub_Classificacoes != other.enum_Aux_Servicos_Sub_Classificacoes)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_Inscricao == null) {
			if (other.id_Inscricao != null)
				return false;
		} else if (!id_Inscricao.equals(other.id_Inscricao))
			return false;
		if (id_Pessoa_Registro == null) {
			if (other.id_Pessoa_Registro != null)
				return false;
		} else if (!id_Pessoa_Registro.equals(other.id_Pessoa_Registro))
			return false;
		if (mes_Ref != other.mes_Ref)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	
	
	
	
		
	
}

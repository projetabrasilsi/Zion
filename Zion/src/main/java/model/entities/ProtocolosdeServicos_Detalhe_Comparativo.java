package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import util.Utilidades;

@SuppressWarnings("serial")
@Entity
@Table(name="ProtocolosdeServicos_Detalhe_Comparativo")
public class ProtocolosdeServicos_Detalhe_Comparativo extends GenericDomain implements Serializable {
	@Id
	@SequenceGenerator(name="pk_protocolosdeServicos_Detalhe_Comparativo",sequenceName="messsounds_protocolosdeServicos_Detalhe_Comparativo", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_protocolosdeServicos_Detalhe_Comparativo")
	@SerializedName("id")
	private Long id;
	@JoinColumn ( name ="id_ProtocolosdeServicos_Detalhe", nullable = false)
	private ProtocolosdeServicos_Detalhe id_ProtocolosdeServicos_Detalhe;
	@Column(name = "ano")
	private int ano;
	@Column(name="valor",precision=18,scale=4)
	private double valor;	
	@Column(name="id_Pessoa_Registro", nullable = false)
	@SerializedName("id_Pessoa_Registro")
	private Pessoa id_Pessoa_Registro;
	
	public ProtocolosdeServicos_Detalhe_Comparativo(ProtocolosdeServicos_Detalhe id_ProtocolosdeServicos_Detalhe,
	int ano, double valor,Pessoa id_Pessoa_Registro) {
		this.valor =valor;
		this.ano = ano;
		this.id_ProtocolosdeServicos_Detalhe = id_ProtocolosdeServicos_Detalhe;
		this.setUltimaAtualizacao(Utilidades.retornaCalendario());
		this.id_Pessoa_Registro = id_Pessoa_Registro;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProtocolosdeServicos_Detalhe getId_ProtocolosdeServicos_Detalhe() {
		return id_ProtocolosdeServicos_Detalhe;
	}
	public void setId_ProtocolosdeServicos_Detalhe(ProtocolosdeServicos_Detalhe id_ProtocolosdeServicos_Detalhe) {
		this.id_ProtocolosdeServicos_Detalhe = id_ProtocolosdeServicos_Detalhe;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "ProtocolosdeServicos_Detalhe_Comparativo [id=" + id + ", id_ProtocolosdeServicos_Detalhe="
				+ id_ProtocolosdeServicos_Detalhe + ", ano=" + ano + ", valor=" + valor + ", id_Pessoa_Registro="
				+ id_Pessoa_Registro + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ano;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
		result = prime * result
				+ ((id_ProtocolosdeServicos_Detalhe == null) ? 0 : id_ProtocolosdeServicos_Detalhe.hashCode());
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
		ProtocolosdeServicos_Detalhe_Comparativo other = (ProtocolosdeServicos_Detalhe_Comparativo) obj;
		if (ano != other.ano)
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
		if (id_ProtocolosdeServicos_Detalhe == null) {
			if (other.id_ProtocolosdeServicos_Detalhe != null)
				return false;
		} else if (!id_ProtocolosdeServicos_Detalhe.equals(other.id_ProtocolosdeServicos_Detalhe))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}

	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	} 
	

}

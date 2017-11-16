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
import com.google.gson.annotations.SerializedName;

import model.enums.Enum_Aux_Sim_ou_Nao;
import model.enums.Enum_Aux_Status_Consulta;
import model.enums.Enum_Aux_Tipo_Conferencia;

@SuppressWarnings("serial")
@Entity
@Table(name="Inscricao_Historico_Header")
public class Inscricao_Historico_Header extends GenericDomain implements Serializable {
	@Id
	@SequenceGenerator(name="pk_inscricao_Historico_Header",sequenceName="messsounds_inscricao_Historico_Header", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_inscricao_Historico_Header")
	@SerializedName("id")	
	private Long id;	
	@Enumerated(EnumType.STRING)
	@Column(name = "enum_Aux_Tipo_Conferencia", nullable = false)
	private Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Inscricao", nullable = false)	
	private Inscricao id_Inscricao;

	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Pessoa_Registro", nullable = false)	
	@SerializedName("id_Pessoa_Registro")
	private Pessoa id_Pessoa_Registro;
	@Column(name="ano_Consulta", nullable=false)
	private int ano_Consulta = 0 ;
	@Column(name="mes_Consulta", nullable=false)
	private int mes_Consulta = 0 ;		
	@Column(name="seq",length = 20)
	private String seq;
	@Column(name="data_Consulta", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data_Consulta;
	@Column(name="total", precision = 14, scale = 4)
	private double total = 0 ;
	@Column(name="baixado", nullable=false)
	@Enumerated(EnumType.STRING)
	private Enum_Aux_Sim_ou_Nao baixado;
	@Column(name="cabecalho")
	private int cabecalho = 0;
	@Column(name="rodape")
	private int rodape = 0;
	@Column(name = "num_Aux_Status_Consulta")
	@Enumerated(EnumType.STRING)
	private Enum_Aux_Status_Consulta enum_Aux_Status_Consulta;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Enum_Aux_Tipo_Conferencia getEnum_Aux_Tipo_Conferencia() {
		return enum_Aux_Tipo_Conferencia;
	}
	public void setEnum_Aux_Tipo_Conferencia(Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia) {
		this.enum_Aux_Tipo_Conferencia = enum_Aux_Tipo_Conferencia;
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
	public int getAno_Consulta() {
		return ano_Consulta;
	}
	public void setAno_Consulta(int ano_Consulta) {
		this.ano_Consulta = ano_Consulta;
	}
	public int getMes_Consulta() {
		return mes_Consulta;
	}
	public void setMes_Consulta(int mes_Consulta) {
		this.mes_Consulta = mes_Consulta;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Date getData_Consulta() {
		return data_Consulta;
	}
	public void setData_Consulta(Date data_Consulta) {
		this.data_Consulta = data_Consulta;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Enum_Aux_Sim_ou_Nao getBaixado() {
		return baixado;
	}
	public void setBaixado(Enum_Aux_Sim_ou_Nao baixado) {
		this.baixado = baixado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ano_Consulta;
		result = prime * result + ((baixado == null) ? 0 : baixado.hashCode());
		result = prime * result + cabecalho;
		result = prime * result + ((data_Consulta == null) ? 0 : data_Consulta.hashCode());
		result = prime * result + ((enum_Aux_Status_Consulta == null) ? 0 : enum_Aux_Status_Consulta.hashCode());
		result = prime * result + ((enum_Aux_Tipo_Conferencia == null) ? 0 : enum_Aux_Tipo_Conferencia.hashCode());
		result = prime * result + ((id_Inscricao == null) ? 0 : id_Inscricao.hashCode());
		result = prime * result + mes_Consulta;
		result = prime * result + rodape;
		result = prime * result + ((seq == null) ? 0 : seq.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
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
		Inscricao_Historico_Header other = (Inscricao_Historico_Header) obj;
		if (ano_Consulta != other.ano_Consulta)
			return false;
		if (baixado != other.baixado)
			return false;
		if (cabecalho != other.cabecalho)
			return false;
		if (data_Consulta == null) {
			if (other.data_Consulta != null)
				return false;
		} else if (!data_Consulta.equals(other.data_Consulta))
			return false;
		if (enum_Aux_Status_Consulta != other.enum_Aux_Status_Consulta)
			return false;
		if (enum_Aux_Tipo_Conferencia != other.enum_Aux_Tipo_Conferencia)
			return false;
		if (id_Inscricao == null) {
			if (other.id_Inscricao != null)
				return false;
		} else if (!id_Inscricao.equals(other.id_Inscricao))
			return false;
		if (mes_Consulta != other.mes_Consulta)
			return false;
		if (rodape != other.rodape)
			return false;
		if (seq == null) {
			if (other.seq != null)
				return false;
		} else if (!seq.equals(other.seq))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Inscricao_Historico_Header [id=" + id + ", enum_Aux_Tipo_Conferencia=" + enum_Aux_Tipo_Conferencia
				+ ", id_Inscricao=" + id_Inscricao + ", id_Pessoa_Registro=" + id_Pessoa_Registro + ", ano_Consulta="
				+ ano_Consulta + ", mes_Consulta=" + mes_Consulta + ", seq=" + seq + ", data_Consulta=" + data_Consulta
				+ ", total=" + total + ", baixado=" + baixado + ", cabecalho=" + cabecalho + ", rodape=" + rodape
				+ ", enum_Aux_Status_Consulta=" + enum_Aux_Status_Consulta + "]";
	}
	public int getCabecalho() {
		return cabecalho;
	}
	public void setCabecalho(int cabecalho) {
		this.cabecalho = cabecalho;
	}
	public int getRodape() {
		return rodape;
	}
	public void setRodape(int rodape) {
		this.rodape = rodape;
	}
	public Enum_Aux_Status_Consulta getEnum_Aux_Status_Consulta() {
		return enum_Aux_Status_Consulta;
	}
	public void setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta enum_Aux_Status_Consulta) {
		this.enum_Aux_Status_Consulta = enum_Aux_Status_Consulta;
	}
	
		
}

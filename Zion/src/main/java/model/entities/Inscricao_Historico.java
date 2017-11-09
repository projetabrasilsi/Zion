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
import model.enums.Enum_Aux_Sim_ou_Nao;

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
	private int ano_Ref;
	private int mes_Ref;
	private String seq;
	private String radicalDam;
	private String tributos;
	private String processo;
	private int parAberto;
	private double valor;
	private double multa;
	private double Juros;
	private double total;
	@Enumerated(EnumType.STRING)
	private Enum_Aux_Sim_ou_Nao pago;
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
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getRadicalDam() {
		return radicalDam;
	}
	public void setRadicalDam(String radicalDam) {
		this.radicalDam = radicalDam;
	}
	public String getTributos() {
		return tributos;
	}
	public void setTributos(String tributos) {
		this.tributos = tributos;
	}
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
	public int getParAberto() {
		return parAberto;
	}
	public void setParAberto(int parAberto) {
		this.parAberto = parAberto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getMulta() {
		return multa;
	}
	public void setMulta(double multa) {
		this.multa = multa;
	}
	public double getJuros() {
		return Juros;
	}
	public void setJuros(double juros) {
		Juros = juros;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Inscricao_Historico [id=" + id + ", enum_Aux_Servicos_Sub_Classificacoes="
				+ enum_Aux_Servicos_Sub_Classificacoes + ", id_Inscricao=" + id_Inscricao + ", id_Pessoa_Registro="
				+ id_Pessoa_Registro + ", ano_Ref=" + ano_Ref + ", mes_Ref=" + mes_Ref + ", seq=" + seq
				+ ", radicalDam=" + radicalDam + ", tributos=" + tributos + ", processo=" + processo + ", parAberto="
				+ parAberto + ", valor=" + valor + ", multa=" + multa + ", Juros=" + Juros + ", total=" + total
				+ ", pago=" + pago + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(Juros);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ano_Ref;
		result = prime * result + ((enum_Aux_Servicos_Sub_Classificacoes == null) ? 0
				: enum_Aux_Servicos_Sub_Classificacoes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Inscricao == null) ? 0 : id_Inscricao.hashCode());
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
		result = prime * result + mes_Ref;
		temp = Double.doubleToLongBits(multa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pago == null) ? 0 : pago.hashCode());
		result = prime * result + parAberto;
		result = prime * result + ((processo == null) ? 0 : processo.hashCode());
		result = prime * result + ((radicalDam == null) ? 0 : radicalDam.hashCode());
		result = prime * result + ((seq == null) ? 0 : seq.hashCode());
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tributos == null) ? 0 : tributos.hashCode());
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
		if (Double.doubleToLongBits(Juros) != Double.doubleToLongBits(other.Juros))
			return false;
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
		if (Double.doubleToLongBits(multa) != Double.doubleToLongBits(other.multa))
			return false;
		if (pago != other.pago)
			return false;
		if (parAberto != other.parAberto)
			return false;
		if (processo == null) {
			if (other.processo != null)
				return false;
		} else if (!processo.equals(other.processo))
			return false;
		if (radicalDam == null) {
			if (other.radicalDam != null)
				return false;
		} else if (!radicalDam.equals(other.radicalDam))
			return false;
		if (seq == null) {
			if (other.seq != null)
				return false;
		} else if (!seq.equals(other.seq))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (tributos == null) {
			if (other.tributos != null)
				return false;
		} else if (!tributos.equals(other.tributos))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	public Enum_Aux_Sim_ou_Nao getPago() {
		return pago;
	}
	public void setPago(Enum_Aux_Sim_ou_Nao pago) {
		this.pago = pago;
	}
		
}

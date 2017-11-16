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

import model.enums.Enum_Aux_Comparativos_Resultados;
import model.enums.Enum_Aux_Status_Consulta;
import model.enums.Enum_Aux_Tipo_Conferencia;

@SuppressWarnings("serial")
@Entity
@Table(name = "ProtocolosdeServicos_Detalhe")
public class ProtocolosdeServicos_Detalhe extends GenericDomain implements Serializable {

	@Id
	@SequenceGenerator(name = "pk_protocolosdeservicos_detalhe", sequenceName = "messsounds_protocolosdeservicos_detalhe", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_protocolosdeservicos_detalhe")
	@SerializedName("id")
	private Long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_ProtocolosdeServicos", nullable = false)	
	private ProtocolosdeServicos id_ProtocolosdeServicos;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Inscricao", nullable = false)	
	private Inscricao id_Inscricao;
	@Column(name = "valor", precision = 18, scale = 4)
	private double valor;
	@Temporal(TemporalType.DATE)
	@Column(name = "vencimento")
	private Date vencimento;
	@Column(name = "num_Dam", length = 20)
	private String num_Dam;
	@Column(name = "num_Dam_Sub", length = 20)
	private String num_Dam_Sub;
	@Column(name = "num_Codigo_Barras", length = 100)
	private String num_Codigo_Barras;
	@Column(name = "enum_Aux_Tipo_Conferencia")
	@Enumerated(EnumType.STRING)
	private Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia;
	
	
	@Column(name = "contador") 
	private int contador;
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Pessoa_Registro", nullable = false)	
	private Pessoa id_Pessoa_Registro;
	@Enumerated(EnumType.STRING)
	@Column(name = "enum_Aux_Comparativos_Resultados", nullable = false)
	private Enum_Aux_Comparativos_Resultados enum_Aux_Comparativos_Resultados;
	
	private int anoAnt;
	private int anoAtual;
	private int MesAtual;
	private int MesAnt;
	private double valorAnt;
	private double valorAtual;
	private double diferenca;
	private String cor;
	private double percentual;
	private Enum_Aux_Status_Consulta enum_Aux_Status_Consulta;
	private String motivo;
	   public ProtocolosdeServicos_Detalhe() {
		   anoAnt = 0;
		   anoAtual = 0;
		   valorAnt = 0;
		   valorAtual = 0;
		   diferenca = 0;
		   cor = "";
		   setComparadores();
	   }
	   
	   
	

	public void setComparadores() {
		if (anoAtual > 0) {
			if (anoAnt > 0) {
				if (valorAtual > 0) {
					if (valorAnt > 0) {
						if (valorAtual > valorAnt) {
							diferenca = valorAtual - valorAnt;
							cor = "000000";// preto -- valor foi atualizado a maior;
						} else if (valorAtual == valorAnt) {
							diferenca = 0;
							cor = "00BFFF";// deepskyblue; -- valor está igual
						} else {
							diferenca = valorAnt - valorAtual;
							cor = "006400"; // darkgreen; -- diminui o valor;

						}

					} else {
						diferenca = 0;
						cor = "00BFFF";
					}

				} else {
					diferenca = 0;
					cor = "00BFFF";
				}
			} else {
				diferenca = 0;
				cor = "00BFFF";
			}

		} else {
			diferenca = 0;
			cor = "00BFFF";

		}

	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public ProtocolosdeServicos getId_ProtocolosdeServicos() {
		return id_ProtocolosdeServicos;
	}




	public void setId_ProtocolosdeServicos(ProtocolosdeServicos id_ProtocolosdeServicos) {
		this.id_ProtocolosdeServicos = id_ProtocolosdeServicos;
	}




	public Inscricao getId_Inscricao() {
		return id_Inscricao;
	}




	public void setId_Inscricao(Inscricao id_Inscricao) {
		this.id_Inscricao = id_Inscricao;
	}




	public double getValor() {
		return valor;
	}




	public void setValor(double valor) {
		this.valor = valor;
	}




	public Date getVencimento() {
		return vencimento;
	}




	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}




	public String getNum_Dam() {
		return num_Dam;
	}




	public void setNum_Dam(String num_Dam) {
		this.num_Dam = num_Dam;
	}




	public String getNum_Dam_Sub() {
		return num_Dam_Sub;
	}




	public void setNum_Dam_Sub(String num_Dam_Sub) {
		this.num_Dam_Sub = num_Dam_Sub;
	}




	public String getNum_Codigo_Barras() {
		return num_Codigo_Barras;
	}




	public void setNum_Codigo_Barras(String num_Codigo_Barras) {
		this.num_Codigo_Barras = num_Codigo_Barras;
	}




	public int getContador() {
		return contador;
	}




	public void setContador(int contador) {
		this.contador = contador;
	}




	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}




	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	}




	public Enum_Aux_Comparativos_Resultados getEnum_Aux_Comparativos_Resultados() {
		return enum_Aux_Comparativos_Resultados;
	}




	public void setEnum_Aux_Comparativos_Resultados(Enum_Aux_Comparativos_Resultados enum_Aux_Comparativos_Resultados) {
		this.enum_Aux_Comparativos_Resultados = enum_Aux_Comparativos_Resultados;
	}




	public int getAnoAnt() {
		return anoAnt;
	}




	public void setAnoAnt(int anoAnt) {
		this.anoAnt = anoAnt;
	}




	public int getAnoAtual() {
		return anoAtual;
	}




	public void setAnoAtual(int anoAtual) {
		this.anoAtual = anoAtual;
	}




	public int getMesAtual() {
		return MesAtual;
	}




	public void setMesAtual(int mesAtual) {
		MesAtual = mesAtual;
	}




	public int getMesAnt() {
		return MesAnt;
	}




	public void setMesAnt(int mesAnt) {
		MesAnt = mesAnt;
	}




	public double getValorAnt() {
		return valorAnt;
	}




	public void setValorAnt(double valorAnt) {
		this.valorAnt = valorAnt;
	}




	public double getValorAtual() {
		return valorAtual;
	}




	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}




	public double getDiferenca() {
		return diferenca;
	}




	public void setDiferenca(double diferenca) {
		this.diferenca = diferenca;
	}




	public String getCor() {
		return cor;
	}




	public void setCor(String cor) {
		this.cor = cor;
	}




	public double getPercentual() {
		return percentual;
	}




	public void setPercentual(double percentual) {
		this.percentual = percentual;
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




	@Override
	public String toString() {
		return "ProtocolosdeServicos_Detalhe [id=" + id + ", id_ProtocolosdeServicos=" + id_ProtocolosdeServicos
				+ ", id_Inscricao=" + id_Inscricao + ", valor=" + valor + ", vencimento=" + vencimento + ", num_Dam="
				+ num_Dam + ", num_Dam_Sub=" + num_Dam_Sub + ", num_Codigo_Barras=" + num_Codigo_Barras
				+ ", enum_Aux_Tipo_Conferencia=" + enum_Aux_Tipo_Conferencia + ", contador=" + contador
				+ ", id_Pessoa_Registro=" + id_Pessoa_Registro + ", enum_Aux_Comparativos_Resultados="
				+ enum_Aux_Comparativos_Resultados + ", anoAnt=" + anoAnt + ", anoAtual=" + anoAtual + ", MesAtual="
				+ MesAtual + ", MesAnt=" + MesAnt + ", valorAnt=" + valorAnt + ", valorAtual=" + valorAtual
				+ ", diferenca=" + diferenca + ", cor=" + cor + ", percentual=" + percentual
				+ ", enum_Aux_Status_Consulta=" + enum_Aux_Status_Consulta + ", motivo=" + motivo + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + MesAnt;
		result = prime * result + MesAtual;
		result = prime * result + anoAnt;
		result = prime * result + anoAtual;
		result = prime * result + contador;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(diferenca);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((enum_Aux_Comparativos_Resultados == null) ? 0 : enum_Aux_Comparativos_Resultados.hashCode());
		result = prime * result + ((enum_Aux_Status_Consulta == null) ? 0 : enum_Aux_Status_Consulta.hashCode());
		result = prime * result + ((enum_Aux_Tipo_Conferencia == null) ? 0 : enum_Aux_Tipo_Conferencia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Inscricao == null) ? 0 : id_Inscricao.hashCode());
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
		result = prime * result + ((id_ProtocolosdeServicos == null) ? 0 : id_ProtocolosdeServicos.hashCode());
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
		result = prime * result + ((num_Codigo_Barras == null) ? 0 : num_Codigo_Barras.hashCode());
		result = prime * result + ((num_Dam == null) ? 0 : num_Dam.hashCode());
		result = prime * result + ((num_Dam_Sub == null) ? 0 : num_Dam_Sub.hashCode());
		temp = Double.doubleToLongBits(percentual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorAnt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorAtual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vencimento == null) ? 0 : vencimento.hashCode());
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
		ProtocolosdeServicos_Detalhe other = (ProtocolosdeServicos_Detalhe) obj;
		if (MesAnt != other.MesAnt)
			return false;
		if (MesAtual != other.MesAtual)
			return false;
		if (anoAnt != other.anoAnt)
			return false;
		if (anoAtual != other.anoAtual)
			return false;
		if (contador != other.contador)
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (Double.doubleToLongBits(diferenca) != Double.doubleToLongBits(other.diferenca))
			return false;
		if (enum_Aux_Comparativos_Resultados != other.enum_Aux_Comparativos_Resultados)
			return false;
		if (enum_Aux_Status_Consulta != other.enum_Aux_Status_Consulta)
			return false;
		if (enum_Aux_Tipo_Conferencia != other.enum_Aux_Tipo_Conferencia)
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
		if (id_ProtocolosdeServicos == null) {
			if (other.id_ProtocolosdeServicos != null)
				return false;
		} else if (!id_ProtocolosdeServicos.equals(other.id_ProtocolosdeServicos))
			return false;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		if (num_Codigo_Barras == null) {
			if (other.num_Codigo_Barras != null)
				return false;
		} else if (!num_Codigo_Barras.equals(other.num_Codigo_Barras))
			return false;
		if (num_Dam == null) {
			if (other.num_Dam != null)
				return false;
		} else if (!num_Dam.equals(other.num_Dam))
			return false;
		if (num_Dam_Sub == null) {
			if (other.num_Dam_Sub != null)
				return false;
		} else if (!num_Dam_Sub.equals(other.num_Dam_Sub))
			return false;
		if (Double.doubleToLongBits(percentual) != Double.doubleToLongBits(other.percentual))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		if (Double.doubleToLongBits(valorAnt) != Double.doubleToLongBits(other.valorAnt))
			return false;
		if (Double.doubleToLongBits(valorAtual) != Double.doubleToLongBits(other.valorAtual))
			return false;
		if (vencimento == null) {
			if (other.vencimento != null)
				return false;
		} else if (!vencimento.equals(other.vencimento))
			return false;
		return true;
	}




	public Enum_Aux_Tipo_Conferencia getEnum_Aux_Tipo_Conferencia() {
		return enum_Aux_Tipo_Conferencia;
	}




	public void setEnum_Aux_Tipo_Conferencia(Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia) {
		this.enum_Aux_Tipo_Conferencia = enum_Aux_Tipo_Conferencia;
	}


}

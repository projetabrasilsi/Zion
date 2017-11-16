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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;
import model.enums.Enum_Aux_Sim_ou_Nao;
import model.enums.Enum_Aux_Tipo_Conferencia;

@SuppressWarnings("serial")
@Entity
@Table(name="Inscricao_Historico_Detalhe")
public class Inscricao_Historico_Detalhe extends GenericDomain implements Serializable {
	@Id
	@SequenceGenerator(name="pk_inscricao_Historico_Detalhe",sequenceName="messsounds_inscricao_Historico_Detalhe", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_inscricao_Historico_Detalhe")
	@SerializedName("id")	
	private Long id;	
	@Enumerated(EnumType.STRING)
	@Column(name = "enum_Aux_Servicos_Sub_Classificacoes", nullable = false)
	private Enum_Aux_Servicos_Sub_Classificacoes enum_Aux_Servicos_Sub_Classificacoes;
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Inscricao", nullable = false)	
	private Inscricao id_Inscricao;
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Pessoa_Registro", nullable = false)	
	@SerializedName("id_Pessoa_Registro")
	private Pessoa id_Pessoa_Registro;
	@Column(name="ano_Ref")
	private int ano_Ref;
	@Column(name="mes_Ref")
	private int mes_Ref;
	@Column(name="seq",length =20)
	private String seq;
	@Column(name="radicalDAm",length =20)
	private String radicalDam;
	@Column(name="dAm",length =20)
	private String dam;
	@Column(name="tributos",length =30)	
	private String tributos;
	@Column(name="processos",length =90)	
	private String processo;
	@Column(name="parAberto", length = 60)
	private String parAberto;
	@Column(name="liv_Folha_Cert", length = 120)
	private String liv_Folha_Cert;
	@Column(name="data_Insc", nullable=true)
	@Temporal(TemporalType.DATE)
	@SerializedName("data_Insc")
	private Date data_Insc;
	@Column(name="localizacao", length = 120)
	private String localizacao;
	@Column(name="inscricao", length = 120)
	private String inscricao;
	@Column(name="fiti", length = 120)
	private String fiti;
	@Column(name="cartorio", length = 120)
	private String cartorio;
	@Column(name="nParcelamento" ,length = 120)
	private String nParcelamento;
	@Column(name="tipo" ,length = 120)
	private String tipo;
	@Column(name ="ano")
	private int ano;
	@Column(name="data_Venc", nullable=true)
	@Temporal(TemporalType.DATE)
	@SerializedName("data_Venc")
	private Date data_Venc;	 
	@Column(name="historico", length = 120)
	private String historico;
	@Column(name="valor", precision = 18, scale = 4)
	private double valor;
	@Column(name="multa", precision = 18, scale = 4)
	private double multa;
	@Column(name="juros", precision = 18, scale = 4)
	private double juros;
	@Column(name="total", precision = 18, scale = 4)
	private double total;
	@Enumerated(EnumType.STRING)
	@Column(name = "pago", nullable = false)
	private Enum_Aux_Sim_ou_Nao pago;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="inscricao_Historico_Header")
	private Inscricao_Historico_Header inscricao_Historico_Header;
	@Column(name= "enum_Aux_Tipo_Conferencia")
	@Enumerated(EnumType.STRING)
	private Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia;
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
	public String getDam() {
		return dam;
	}
	public void setDam(String dam) {
		this.dam = dam;
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
	public String getParAberto() {
		return parAberto;
	}
	public void setParAberto(String parAberto) {
		this.parAberto = parAberto;
	}
	public String getLiv_Folha_Cert() {
		return liv_Folha_Cert;
	}
	public void setLiv_Folha_Cert(String liv_Folha_Cert) {
		this.liv_Folha_Cert = liv_Folha_Cert;
	}
	public Date getData_Insc() {
		return data_Insc;
	}
	public void setData_Insc(Date data_Insc) {
		this.data_Insc = data_Insc;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getInscricao() {
		return inscricao;
	}
	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}
	public String getFiti() {
		return fiti;
	}
	public void setFiti(String fiti) {
		this.fiti = fiti;
	}
	public String getCartorio() {
		return cartorio;
	}
	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}
	public String getnParcelamento() {
		return nParcelamento;
	}
	public void setnParcelamento(String nParcelamento) {
		this.nParcelamento = nParcelamento;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Date getData_Venc() {
		return data_Venc;
	}
	public void setData_Venc(Date data_Venc) {
		this.data_Venc = data_Venc;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
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
		return juros;
	}
	public void setJuros(double juros) {
		this.juros = juros;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Enum_Aux_Sim_ou_Nao getPago() {
		return pago;
	}
	public void setPago(Enum_Aux_Sim_ou_Nao pago) {
		this.pago = pago;
	}
	public Inscricao_Historico_Header getInscricao_Historico_Header() {
		return inscricao_Historico_Header;
	}
	public void setInscricao_Historico_Header(Inscricao_Historico_Header inscricao_Historico_Header) {
		this.inscricao_Historico_Header = inscricao_Historico_Header;
	}
	public Enum_Aux_Tipo_Conferencia getEnum_Aux_Tipo_Conferencia() {
		return enum_Aux_Tipo_Conferencia;
	}
	public void setEnum_Aux_Tipo_Conferencia(Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia) {
		this.enum_Aux_Tipo_Conferencia = enum_Aux_Tipo_Conferencia;
	}
	@Override
	public String toString() {
		return "Inscricao_Historico_Detalhe [id=" + id + ", enum_Aux_Servicos_Sub_Classificacoes="
				+ enum_Aux_Servicos_Sub_Classificacoes + ", id_Inscricao=" + id_Inscricao + ", id_Pessoa_Registro="
				+ id_Pessoa_Registro + ", ano_Ref=" + ano_Ref + ", mes_Ref=" + mes_Ref + ", seq=" + seq
				+ ", radicalDam=" + radicalDam + ", dam=" + dam + ", tributos=" + tributos + ", processo=" + processo
				+ ", parAberto=" + parAberto + ", liv_Folha_Cert=" + liv_Folha_Cert + ", data_Insc=" + data_Insc
				+ ", localizacao=" + localizacao + ", inscricao=" + inscricao + ", fiti=" + fiti + ", cartorio="
				+ cartorio + ", nParcelamento=" + nParcelamento + ", tipo=" + tipo + ", ano=" + ano + ", data_Venc="
				+ data_Venc + ", historico=" + historico + ", valor=" + valor + ", multa=" + multa + ", juros=" + juros
				+ ", total=" + total + ", pago=" + pago + ", inscricao_Historico_Header=" + inscricao_Historico_Header
				+ ", enum_Aux_Tipo_Conferencia=" + enum_Aux_Tipo_Conferencia + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ano;
		result = prime * result + ano_Ref;
		result = prime * result + ((cartorio == null) ? 0 : cartorio.hashCode());
		result = prime * result + ((dam == null) ? 0 : dam.hashCode());
		result = prime * result + ((data_Insc == null) ? 0 : data_Insc.hashCode());
		result = prime * result + ((data_Venc == null) ? 0 : data_Venc.hashCode());
		result = prime * result + ((enum_Aux_Servicos_Sub_Classificacoes == null) ? 0
				: enum_Aux_Servicos_Sub_Classificacoes.hashCode());
		result = prime * result + ((enum_Aux_Tipo_Conferencia == null) ? 0 : enum_Aux_Tipo_Conferencia.hashCode());
		result = prime * result + ((fiti == null) ? 0 : fiti.hashCode());
		result = prime * result + ((historico == null) ? 0 : historico.hashCode());
		result = prime * result + ((id_Inscricao == null) ? 0 : id_Inscricao.hashCode());
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
		result = prime * result + ((inscricao == null) ? 0 : inscricao.hashCode());
		result = prime * result + ((inscricao_Historico_Header == null) ? 0 : inscricao_Historico_Header.hashCode());
		long temp;
		temp = Double.doubleToLongBits(juros);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((liv_Folha_Cert == null) ? 0 : liv_Folha_Cert.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result + mes_Ref;
		temp = Double.doubleToLongBits(multa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nParcelamento == null) ? 0 : nParcelamento.hashCode());
		result = prime * result + ((pago == null) ? 0 : pago.hashCode());
		result = prime * result + ((parAberto == null) ? 0 : parAberto.hashCode());
		result = prime * result + ((processo == null) ? 0 : processo.hashCode());
		result = prime * result + ((radicalDam == null) ? 0 : radicalDam.hashCode());
		result = prime * result + ((seq == null) ? 0 : seq.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Inscricao_Historico_Detalhe other = (Inscricao_Historico_Detalhe) obj;
		if (ano != other.ano)
			return false;
		if (ano_Ref != other.ano_Ref)
			return false;
		if (cartorio == null) {
			if (other.cartorio != null)
				return false;
		} else if (!cartorio.equals(other.cartorio))
			return false;
		if (dam == null) {
			if (other.dam != null)
				return false;
		} else if (!dam.equals(other.dam))
			return false;
		if (data_Insc == null) {
			if (other.data_Insc != null)
				return false;
		} else if (!data_Insc.equals(other.data_Insc))
			return false;
		if (data_Venc == null) {
			if (other.data_Venc != null)
				return false;
		} else if (!data_Venc.equals(other.data_Venc))
			return false;
		if (enum_Aux_Servicos_Sub_Classificacoes != other.enum_Aux_Servicos_Sub_Classificacoes)
			return false;
		if (enum_Aux_Tipo_Conferencia != other.enum_Aux_Tipo_Conferencia)
			return false;
		if (fiti == null) {
			if (other.fiti != null)
				return false;
		} else if (!fiti.equals(other.fiti))
			return false;
		if (historico == null) {
			if (other.historico != null)
				return false;
		} else if (!historico.equals(other.historico))
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
		if (inscricao == null) {
			if (other.inscricao != null)
				return false;
		} else if (!inscricao.equals(other.inscricao))
			return false;
		if (inscricao_Historico_Header == null) {
			if (other.inscricao_Historico_Header != null)
				return false;
		} else if (!inscricao_Historico_Header.equals(other.inscricao_Historico_Header))
			return false;
		if (Double.doubleToLongBits(juros) != Double.doubleToLongBits(other.juros))
			return false;
		if (liv_Folha_Cert == null) {
			if (other.liv_Folha_Cert != null)
				return false;
		} else if (!liv_Folha_Cert.equals(other.liv_Folha_Cert))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		if (mes_Ref != other.mes_Ref)
			return false;
		if (Double.doubleToLongBits(multa) != Double.doubleToLongBits(other.multa))
			return false;
		if (nParcelamento == null) {
			if (other.nParcelamento != null)
				return false;
		} else if (!nParcelamento.equals(other.nParcelamento))
			return false;
		if (pago != other.pago)
			return false;
		if (parAberto == null) {
			if (other.parAberto != null)
				return false;
		} else if (!parAberto.equals(other.parAberto))
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
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
				
}

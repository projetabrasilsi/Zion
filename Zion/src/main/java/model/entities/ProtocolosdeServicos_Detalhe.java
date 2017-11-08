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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import model.enums.Enum_Aux_Comparativos_Resultados;

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
	@JoinColumn ( name ="id_ProtocolosdeServicos")	
	private ProtocolosdeServicos id_ProtocolosdeServicos;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Inscricao")	
	private Inscricao id_Inscricao;
	@Column(name = "valor", precision = 18, scale = 4)
	private double valor;

	private Date vencimento;
	private String num_Dam;
	private String num_Dam_Sub;
	private String num_Codigo_Barras;
	 
	private int contador;
	@OneToOne(cascade = CascadeType.PERSIST)
	@Expose
	@JoinColumn ( name ="id_Pessoa_Registro")	
	private Pessoa id_Pessoa_Registro;
	@Enumerated(EnumType.STRING)
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


}

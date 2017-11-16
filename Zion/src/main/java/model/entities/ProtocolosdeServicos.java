package model.entities;

import java.io.Serializable;
import java.util.Calendar;

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

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import adaptadores.ProtocolosdeServicosAdapter;
import model.enums.Enum_Aux_Servicos_Composicoes;
import model.enums.Enum_Aux_Servicos_Status;

@SuppressWarnings("serial")
@Entity
@Table(name = "ProtocolosdeServicos")
@JsonAdapter(ProtocolosdeServicosAdapter.class)
public class ProtocolosdeServicos extends GenericDomain implements Serializable {

	@Id
	@SequenceGenerator(name = "pk_protocolosdeservicos", sequenceName = "messsounds_protocolosdeservicos", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_protocolosdeservicos")
	@SerializedName("id")
	private Long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_Pessoa_Registro", nullable = false)
	@SerializedName("id_Pessoa_Registro")
	private Pessoa id_Pessoa_Registro;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_Mestre", nullable = false)
	@SerializedName("id_Mestre")
	private Pessoa id_Mestre;
	@Enumerated(EnumType.STRING)
	@Column(name="enum_Aux_Servicos_Status", nullable=false)
	private Enum_Aux_Servicos_Status enum_Aux_Servicos_Status;
	@Enumerated(EnumType.STRING)
	@Column(name="enum_Aux_Servicos_Composicoes", nullable=false)
	
	private Enum_Aux_Servicos_Composicoes enum_Aux_Servicos_Composicoes;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar tempoInicial;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar tempoFinal;	
	@Column(name = "diferencadeTempo", precision = 18, scale = 8)
	private long diferencadeTempo;
	@Column(name = "diferencadeTempoTexto",length = 120)
	private String diferencadeTempoTexto;	
	@Column(name = "anoAnt")
	private int anoAnt = 0;
	@Column(name = "anoAtual")
	private int anoAtual = 0;
	@Column(name = "mesAnt")
	private int mesAnt = 0;
	@Column(name = "mesAtual")
	private int mesAtual = 0;
	@Column(name = "nTotalReg")
	private int nTotalReg = 0;
	@Column(name = "nRegAnt")
	private int nRegAnt = 0;
	@Column(name = "nRegAtual")
	private int nRegAtual = 0;
	@Column(name = "vlTot", precision = 18, scale = 4)
	private double vlTot = 0;
	@Column(name = "vlTotAnt", precision = 18, scale = 4)
	private double vlTotAnt = 0;
	@Column(name = "vlTotAtual", precision = 18, scale = 4)
	private double vlTotAtual = 0;
	@Column(name = "vlTotAumentou", precision = 18, scale = 4)
	private double vlTotAumentou = 0;
	@Column(name = "vlTotDifInflacao", precision = 18, scale = 4)
	private double vlTotDifInflacao = 0;
	@Column(name = "vlTotdifDeflacao", precision = 18, scale = 4)
	private double vlTotDifDeflacao = 0;
	
	
	@Column(name = "vlTotPermaneceu", precision = 18, scale = 4)
	private double vlTotPermaneceu = 0;
	@Column(name = "vlTotDiminuiu", precision = 18, scale = 4)
	private double vlTotDiminuiu = 0;
	
	//@Column(name="crescimento", nullable = true )
	@Column(name = "crescimento")
	private int crescimento = 0;
	//@Column(name="perdaPercentual", nullable = true )
	@Column(name = "perdaPercentual", precision = 18, scale = 4)
	private double perdaPercentual = 0;
	//@Column(name="aquisicaoPercentual", nullable = true )
	@Column(name = "aquisicaoPercentual", precision = 18, scale = 4)
	private double aquisicaoPercentual = 0;
	//@Column(name="crescimentoPercentual", nullable = true )
	@Column(name = "crescimentoPercentual", precision = 18, scale = 4)
	private double crescimentoPercentual = 0;
	@Column(name = "novosPercentual", precision = 18, scale = 4)
	private double novosPercentual = 0;
	@Column(name = "permaneceuPercentual", precision = 18, scale = 4)
	private double permaneceuPercentual = 0;
	@Column(name = "nRegAtualPerc", precision = 18, scale = 4)
	private double nRegAtualPerc = 0;
	@Column(name = "nRegAntPerc", precision = 18, scale = 4)
	private double nRegAntPerc = 0;
	
	
	@Column(name = "nRegSomenteAnt")	
	private int nRegSomenteAnt = 0;
	@Column(name = "nRegSomenteAtual")
	private int nRegSomenteAtual = 0;
	@Column(name = "nRegPermanentes")
	private int nRegPermanentes = 0;
	
	@Column(name = "vlTotSomenteAnt", precision = 18, scale = 4)
	private double vlTotSomenteAnt = 0;
	@Column(name = "vlTotSomenteAtual", precision = 18, scale = 4)	
	private double vlTotSomenteAtual = 0;
	@Column(name = "vlTotPermaneceuValor", precision = 18, scale = 4)
	private double vlTotPermaneceuValor = 0;
	
	@Column(name = "nRegAumentouValor")
	private int nRegAumentouValor = 0;
	@Column(name = "nRegDiminuiuValor")
	private int nRegDiminuiValor = 0;
	@Column(name = "nRegPermaneceuValor")
	private int nRegPermaneceuValor = 0;
	@Column(name = "nRegAumentouValorPerc", precision = 18, scale = 4)
	private double nRegAumentouValorPerc = 0;
	@Column(name = "nRegDiminuiuValorPerc", precision = 18, scale = 4)
	private double nRegDiminuiValorPerc = 0;
	@Column(name = "nRegPermaneceuValorPerc", precision = 18, scale = 4)
	private double nRegPermaneceuValorPerc = 0;
	@Column(name = "CarteiraDiferencaInflacao", precision = 18, scale = 4)
	private double CarteiraDiferencaInflacao = 0;
	@Column(name = "CarteiraDiferencaDeflacao", precision = 18, scale = 4)
	private double CarteiraDiferencaDeflacao = 0;
	@Column(name = "CarteiraClientesNovos", precision = 18, scale = 4)
	private double CarteiraClientesNovos = 0;
	@Column(name = "CarteiraClientesBaixados", precision = 18, scale = 4)
	private double CarteiraClientesBaixados = 0;
	@Column(name = "CarteiraResultadoA", precision = 18, scale = 4)
	private double CarteiraResultadoA = 0;
	@Column(name = "CarteiraResultadoB", precision = 18, scale = 4)
	private double CarteiraResultadoB = 0;
	@Column(name = "CarteiraResultadoFinal", precision = 18, scale = 4)
	private double CarteiraResultadoFinal = 0;
	@Column(name = "CarteiraResultadoPercentualFinal", precision = 18, scale = 4)
	private double CarteiraResultadoPercentualFinal = 0;
	
	
	
	public ProtocolosdeServicos() {		
		crescimento = 0;		
		perdaPercentual = 0;
		aquisicaoPercentual = 0;
		crescimentoPercentual = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getId_Pessoa_Registro() {
		return id_Pessoa_Registro;
	}

	public void setId_Pessoa_Registro(Pessoa id_Pessoa_Registro) {
		this.id_Pessoa_Registro = id_Pessoa_Registro;
	}

	public Pessoa getId_Mestre() {
		return id_Mestre;
	}

	public void setId_Mestre(Pessoa id_Mestre) {
		this.id_Mestre = id_Mestre;
	}

	public Enum_Aux_Servicos_Status getEnum_Aux_Servicos_Status() {
		return enum_Aux_Servicos_Status;
	}

	public void setEnum_Aux_Servicos_Status(Enum_Aux_Servicos_Status enum_Aux_Servicos_Status) {
		this.enum_Aux_Servicos_Status = enum_Aux_Servicos_Status;
	}

	public Calendar getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(Calendar tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public Calendar getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(Calendar tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

	public long getDiferencadeTempo() {
		return diferencadeTempo;
	}

	public void setDiferencadeTempo(long diferencadeTempo) {
		this.diferencadeTempo = diferencadeTempo;
	}

	public String getDiferencadeTempoTexto() {
		return diferencadeTempoTexto;
	}

	public void setDiferencadeTempoTexto(String diferencadeTempoTexto) {
		this.diferencadeTempoTexto = diferencadeTempoTexto;
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

	

	public int getnTotalReg() {
		return nTotalReg;
	}

	public void setnTotalReg(int nTotalReg) {
		this.nTotalReg = nTotalReg;
	}

	public int getnRegAnt() {
		return nRegAnt;
	}

	public void setnRegAnt(int nRegAnt) {
		this.nRegAnt = nRegAnt;
	}

	public int getnRegAtual() {
		return nRegAtual;
	}

	public void setnRegAtual(int nRegAtual) {
		this.nRegAtual = nRegAtual;
	}

	public double getVlTot() {
		return vlTot;
	}

	public void setVlTot(double vlTot) {
		this.vlTot = vlTot;
	}

	public double getVlTotAnt() {
		return vlTotAnt;
	}

	public void setVlTotAnt(double vlTotAnt) {
		this.vlTotAnt = vlTotAnt;
	}

	public double getVlTotAtual() {
		return vlTotAtual;
	}

	public void setVlTotAtual(double vlTotAtual) {
		this.vlTotAtual = vlTotAtual;
	}

	public double getVlTotAumentou() {
		return vlTotAumentou;
	}

	public void setVlTotAumentou(double vlTotAumentou) {
		this.vlTotAumentou = vlTotAumentou;
	}

	public double getVlTotDifInflacao() {
		return vlTotDifInflacao;
	}

	public void setVlTotDifInflacao(double vlTotDifInflacao) {
		this.vlTotDifInflacao = vlTotDifInflacao;
	}

	public double getVlTotDifDeflacao() {
		return vlTotDifDeflacao;
	}

	public void setVlTotDifDeflacao(double vlTotDifDeflacao) {
		this.vlTotDifDeflacao = vlTotDifDeflacao;
	}

	public double getVlTotPermaneceu() {
		return vlTotPermaneceu;
	}

	public void setVlTotPermaneceu(double vlTotPermaneceu) {
		this.vlTotPermaneceu = vlTotPermaneceu;
	}

	public double getVlTotDiminuiu() {
		return vlTotDiminuiu;
	}

	public void setVlTotDiminuiu(double vlTotDiminuiu) {
		this.vlTotDiminuiu = vlTotDiminuiu;
	}

	public int getCrescimento() {
		return crescimento;
	}

	public void setCrescimento(int crescimento) {
		this.crescimento = crescimento;
	}

	public double getPerdaPercentual() {
		return perdaPercentual;
	}

	public void setPerdaPercentual(double perdaPercentual) {
		this.perdaPercentual = perdaPercentual;
	}

	public double getAquisicaoPercentual() {
		return aquisicaoPercentual;
	}

	public void setAquisicaoPercentual(double aquisicaoPercentual) {
		this.aquisicaoPercentual = aquisicaoPercentual;
	}

	public double getCrescimentoPercentual() {
		return crescimentoPercentual;
	}

	public void setCrescimentoPercentual(double crescimentoPercentual) {
		this.crescimentoPercentual = crescimentoPercentual;
	}

	public double getNovosPercentual() {
		return novosPercentual;
	}

	public void setNovosPercentual(double novosPercentual) {
		this.novosPercentual = novosPercentual;
	}

	public double getPermaneceuPercentual() {
		return permaneceuPercentual;
	}

	public void setPermaneceuPercentual(double permaneceuPercentual) {
		this.permaneceuPercentual = permaneceuPercentual;
	}

	public double getnRegAtualPerc() {
		return nRegAtualPerc;
	}

	public void setnRegAtualPerc(double nRegAtualPerc) {
		this.nRegAtualPerc = nRegAtualPerc;
	}

	public double getnRegAntPerc() {
		return nRegAntPerc;
	}

	public void setnRegAntPerc(double nRegAntPerc) {
		this.nRegAntPerc = nRegAntPerc;
	}

	public int getnRegSomenteAnt() {
		return nRegSomenteAnt;
	}

	public void setnRegSomenteAnt(int nRegSomenteAnt) {
		this.nRegSomenteAnt = nRegSomenteAnt;
	}

	public int getnRegSomenteAtual() {
		return nRegSomenteAtual;
	}

	public void setnRegSomenteAtual(int nRegSomenteAtual) {
		this.nRegSomenteAtual = nRegSomenteAtual;
	}

	public int getnRegPermanentes() {
		return nRegPermanentes;
	}

	public void setnRegPermanentes(int nRegPermanentes) {
		this.nRegPermanentes = nRegPermanentes;
	}

	public double getVlTotSomenteAnt() {
		return vlTotSomenteAnt;
	}

	public void setVlTotSomenteAnt(double vlTotSomenteAnt) {
		this.vlTotSomenteAnt = vlTotSomenteAnt;
	}

	public double getVlTotSomenteAtual() {
		return vlTotSomenteAtual;
	}

	public void setVlTotSomenteAtual(double vlTotSomenteAtual) {
		this.vlTotSomenteAtual = vlTotSomenteAtual;
	}

	public double getVlTotPermaneceuValor() {
		return vlTotPermaneceuValor;
	}

	public void setVlTotPermaneceuValor(double vlTotPermaneceuValor) {
		this.vlTotPermaneceuValor = vlTotPermaneceuValor;
	}

	public int getnRegAumentouValor() {
		return nRegAumentouValor;
	}

	public void setnRegAumentouValor(int nRegAumentouValor) {
		this.nRegAumentouValor = nRegAumentouValor;
	}

	public int getnRegDiminuiValor() {
		return nRegDiminuiValor;
	}

	public void setnRegDiminuiValor(int nRegDiminuiValor) {
		this.nRegDiminuiValor = nRegDiminuiValor;
	}

	public int getnRegPermaneceuValor() {
		return nRegPermaneceuValor;
	}

	public void setnRegPermaneceuValor(int nRegPermaneceuValor) {
		this.nRegPermaneceuValor = nRegPermaneceuValor;
	}

	public Enum_Aux_Servicos_Composicoes getEnum_Aux_Servicos_Composicoes() {
		return enum_Aux_Servicos_Composicoes;
	}

	public void setEnum_Aux_Servicos_Composicoes(Enum_Aux_Servicos_Composicoes enum_Aux_Servicos_Composicoes) {
		this.enum_Aux_Servicos_Composicoes = enum_Aux_Servicos_Composicoes;
	}

	public int getMesAnt() {
		return mesAnt;
	}

	public void setMesAnt(int mesAnt) {
		this.mesAnt = mesAnt;
	}

	public int getMesAtual() {
		return mesAtual;
	}

	public void setMesAtual(int mesAtual) {
		this.mesAtual = mesAtual;
	}

	public double getnRegAumentouValorPerc() {
		return nRegAumentouValorPerc;
	}

	public void setnRegAumentouValorPerc(double nRegAumentouValorPerc) {
		this.nRegAumentouValorPerc = nRegAumentouValorPerc;
	}

	public double getnRegDiminuiValorPerc() {
		return nRegDiminuiValorPerc;
	}

	public void setnRegDiminuiValorPerc(double nRegDiminuiValorPerc) {
		this.nRegDiminuiValorPerc = nRegDiminuiValorPerc;
	}

	public double getnRegPermaneceuValorPerc() {
		return nRegPermaneceuValorPerc;
	}

	public void setnRegPermaneceuValorPerc(double nRegPermaneceuValorPerc) {
		this.nRegPermaneceuValorPerc = nRegPermaneceuValorPerc;
	}

	public double getCarteiraDiferencaInflacao() {
		return CarteiraDiferencaInflacao;
	}

	public void setCarteiraDiferencaInflacao(double carteiraDiferencaInflacao) {
		CarteiraDiferencaInflacao = carteiraDiferencaInflacao;
	}

	public double getCarteiraDiferencaDeflacao() {
		return CarteiraDiferencaDeflacao;
	}

	public void setCarteiraDiferencaDeflacao(double carteiraDiferencaDeflacao) {
		CarteiraDiferencaDeflacao = carteiraDiferencaDeflacao;
	}

	public double getCarteiraClientesNovos() {
		return CarteiraClientesNovos;
	}

	public void setCarteiraClientesNovos(double carteiraClientesNovos) {
		CarteiraClientesNovos = carteiraClientesNovos;
	}

	public double getCarteiraClientesBaixados() {
		return CarteiraClientesBaixados;
	}

	public void setCarteiraClientesBaixados(double carteiraClientesBaixados) {
		CarteiraClientesBaixados = carteiraClientesBaixados;
	}

	public double getCarteiraResultadoA() {
		return CarteiraResultadoA;
	}

	public void setCarteiraResultadoA(double carteiraResultadoA) {
		CarteiraResultadoA = carteiraResultadoA;
	}

	public double getCarteiraResultadoB() {
		return CarteiraResultadoB;
	}

	public void setCarteiraResultadoB(double carteiraResultadoB) {
		CarteiraResultadoB = carteiraResultadoB;
	}

	public double getCarteiraResultadoFinal() {
		return CarteiraResultadoFinal;
	}

	public void setCarteiraResultadoFinal(double carteiraResultadoFinal) {
		CarteiraResultadoFinal = carteiraResultadoFinal;
	}

	public double getCarteiraResultadoPercentualFinal() {
		return CarteiraResultadoPercentualFinal;
	}

	public void setCarteiraResultadoPercentualFinal(double carteiraResultadoPercentualFinal) {
		CarteiraResultadoPercentualFinal = carteiraResultadoPercentualFinal;
	}

	@Override
	public String toString() {
		return "ProtocolosdeServicos [id=" + id + ", id_Pessoa_Registro=" + id_Pessoa_Registro + ", id_Mestre="
				+ id_Mestre + ", enum_Aux_Servicos_Status=" + enum_Aux_Servicos_Status
				+ ", enum_Aux_Servicos_Composicoes=" + enum_Aux_Servicos_Composicoes + ", tempoInicial=" + tempoInicial
				+ ", tempoFinal=" + tempoFinal + ", diferencadeTempo=" + diferencadeTempo + ", diferencadeTempoTexto="
				+ diferencadeTempoTexto + ", anoAnt=" + anoAnt + ", anoAtual=" + anoAtual + ", mesAnt=" + mesAnt
				+ ", mesAtual=" + mesAtual + ", nTotalReg=" + nTotalReg + ", nRegAnt=" + nRegAnt + ", nRegAtual="
				+ nRegAtual + ", vlTot=" + vlTot + ", vlTotAnt=" + vlTotAnt + ", vlTotAtual=" + vlTotAtual
				+ ", vlTotAumentou=" + vlTotAumentou + ", vlTotDifInflacao=" + vlTotDifInflacao + ", vlTotDifDeflacao="
				+ vlTotDifDeflacao + ", vlTotPermaneceu=" + vlTotPermaneceu + ", vlTotDiminuiu=" + vlTotDiminuiu
				+ ", crescimento=" + crescimento + ", perdaPercentual=" + perdaPercentual + ", aquisicaoPercentual="
				+ aquisicaoPercentual + ", crescimentoPercentual=" + crescimentoPercentual + ", novosPercentual="
				+ novosPercentual + ", permaneceuPercentual=" + permaneceuPercentual + ", nRegAtualPerc="
				+ nRegAtualPerc + ", nRegAntPerc=" + nRegAntPerc + ", nRegSomenteAnt=" + nRegSomenteAnt
				+ ", nRegSomenteAtual=" + nRegSomenteAtual + ", nRegPermanentes=" + nRegPermanentes
				+ ", vlTotSomenteAnt=" + vlTotSomenteAnt + ", vlTotSomenteAtual=" + vlTotSomenteAtual
				+ ", vlTotPermaneceuValor=" + vlTotPermaneceuValor + ", nRegAumentouValor=" + nRegAumentouValor
				+ ", nRegDiminuiValor=" + nRegDiminuiValor + ", nRegPermaneceuValor=" + nRegPermaneceuValor
				+ ", nRegAumentouValorPerc=" + nRegAumentouValorPerc + ", nRegDiminuiValorPerc=" + nRegDiminuiValorPerc
				+ ", nRegPermaneceuValorPerc=" + nRegPermaneceuValorPerc + ", CarteiraDiferencaInflacao="
				+ CarteiraDiferencaInflacao + ", CarteiraDiferencaDeflacao=" + CarteiraDiferencaDeflacao
				+ ", CarteiraClientesNovos=" + CarteiraClientesNovos + ", CarteiraClientesBaixados="
				+ CarteiraClientesBaixados + ", CarteiraResultadoA=" + CarteiraResultadoA + ", CarteiraResultadoB="
				+ CarteiraResultadoB + ", CarteiraResultadoFinal=" + CarteiraResultadoFinal
				+ ", CarteiraResultadoPercentualFinal=" + CarteiraResultadoPercentualFinal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(CarteiraClientesBaixados);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(CarteiraClientesNovos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(CarteiraDiferencaDeflacao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(CarteiraDiferencaInflacao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(CarteiraResultadoA);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(CarteiraResultadoB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(CarteiraResultadoFinal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(CarteiraResultadoPercentualFinal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + anoAnt;
		result = prime * result + anoAtual;
		temp = Double.doubleToLongBits(aquisicaoPercentual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + crescimento;
		temp = Double.doubleToLongBits(crescimentoPercentual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (diferencadeTempo ^ (diferencadeTempo >>> 32));
		result = prime * result + ((diferencadeTempoTexto == null) ? 0 : diferencadeTempoTexto.hashCode());
		result = prime * result
				+ ((enum_Aux_Servicos_Composicoes == null) ? 0 : enum_Aux_Servicos_Composicoes.hashCode());
		result = prime * result + ((enum_Aux_Servicos_Status == null) ? 0 : enum_Aux_Servicos_Status.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_Mestre == null) ? 0 : id_Mestre.hashCode());
		result = prime * result + ((id_Pessoa_Registro == null) ? 0 : id_Pessoa_Registro.hashCode());
		result = prime * result + mesAnt;
		result = prime * result + mesAtual;
		result = prime * result + nRegAnt;
		temp = Double.doubleToLongBits(nRegAntPerc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nRegAtual;
		temp = Double.doubleToLongBits(nRegAtualPerc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nRegAumentouValor;
		temp = Double.doubleToLongBits(nRegAumentouValorPerc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nRegDiminuiValor;
		temp = Double.doubleToLongBits(nRegDiminuiValorPerc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nRegPermaneceuValor;
		temp = Double.doubleToLongBits(nRegPermaneceuValorPerc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nRegPermanentes;
		result = prime * result + nRegSomenteAnt;
		result = prime * result + nRegSomenteAtual;
		result = prime * result + nTotalReg;
		temp = Double.doubleToLongBits(novosPercentual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(perdaPercentual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(permaneceuPercentual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tempoFinal == null) ? 0 : tempoFinal.hashCode());
		result = prime * result + ((tempoInicial == null) ? 0 : tempoInicial.hashCode());
		temp = Double.doubleToLongBits(vlTot);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotAnt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotAtual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotAumentou);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotDifDeflacao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotDifInflacao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotDiminuiu);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotPermaneceu);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotPermaneceuValor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotSomenteAnt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlTotSomenteAtual);
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
		ProtocolosdeServicos other = (ProtocolosdeServicos) obj;
		if (Double.doubleToLongBits(CarteiraClientesBaixados) != Double
				.doubleToLongBits(other.CarteiraClientesBaixados))
			return false;
		if (Double.doubleToLongBits(CarteiraClientesNovos) != Double.doubleToLongBits(other.CarteiraClientesNovos))
			return false;
		if (Double.doubleToLongBits(CarteiraDiferencaDeflacao) != Double
				.doubleToLongBits(other.CarteiraDiferencaDeflacao))
			return false;
		if (Double.doubleToLongBits(CarteiraDiferencaInflacao) != Double
				.doubleToLongBits(other.CarteiraDiferencaInflacao))
			return false;
		if (Double.doubleToLongBits(CarteiraResultadoA) != Double.doubleToLongBits(other.CarteiraResultadoA))
			return false;
		if (Double.doubleToLongBits(CarteiraResultadoB) != Double.doubleToLongBits(other.CarteiraResultadoB))
			return false;
		if (Double.doubleToLongBits(CarteiraResultadoFinal) != Double.doubleToLongBits(other.CarteiraResultadoFinal))
			return false;
		if (Double.doubleToLongBits(CarteiraResultadoPercentualFinal) != Double
				.doubleToLongBits(other.CarteiraResultadoPercentualFinal))
			return false;
		if (anoAnt != other.anoAnt)
			return false;
		if (anoAtual != other.anoAtual)
			return false;
		if (Double.doubleToLongBits(aquisicaoPercentual) != Double.doubleToLongBits(other.aquisicaoPercentual))
			return false;
		if (crescimento != other.crescimento)
			return false;
		if (Double.doubleToLongBits(crescimentoPercentual) != Double.doubleToLongBits(other.crescimentoPercentual))
			return false;
		if (diferencadeTempo != other.diferencadeTempo)
			return false;
		if (diferencadeTempoTexto == null) {
			if (other.diferencadeTempoTexto != null)
				return false;
		} else if (!diferencadeTempoTexto.equals(other.diferencadeTempoTexto))
			return false;
		if (enum_Aux_Servicos_Composicoes != other.enum_Aux_Servicos_Composicoes)
			return false;
		if (enum_Aux_Servicos_Status != other.enum_Aux_Servicos_Status)
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
		if (mesAnt != other.mesAnt)
			return false;
		if (mesAtual != other.mesAtual)
			return false;
		if (nRegAnt != other.nRegAnt)
			return false;
		if (Double.doubleToLongBits(nRegAntPerc) != Double.doubleToLongBits(other.nRegAntPerc))
			return false;
		if (nRegAtual != other.nRegAtual)
			return false;
		if (Double.doubleToLongBits(nRegAtualPerc) != Double.doubleToLongBits(other.nRegAtualPerc))
			return false;
		if (nRegAumentouValor != other.nRegAumentouValor)
			return false;
		if (Double.doubleToLongBits(nRegAumentouValorPerc) != Double.doubleToLongBits(other.nRegAumentouValorPerc))
			return false;
		if (nRegDiminuiValor != other.nRegDiminuiValor)
			return false;
		if (Double.doubleToLongBits(nRegDiminuiValorPerc) != Double.doubleToLongBits(other.nRegDiminuiValorPerc))
			return false;
		if (nRegPermaneceuValor != other.nRegPermaneceuValor)
			return false;
		if (Double.doubleToLongBits(nRegPermaneceuValorPerc) != Double.doubleToLongBits(other.nRegPermaneceuValorPerc))
			return false;
		if (nRegPermanentes != other.nRegPermanentes)
			return false;
		if (nRegSomenteAnt != other.nRegSomenteAnt)
			return false;
		if (nRegSomenteAtual != other.nRegSomenteAtual)
			return false;
		if (nTotalReg != other.nTotalReg)
			return false;
		if (Double.doubleToLongBits(novosPercentual) != Double.doubleToLongBits(other.novosPercentual))
			return false;
		if (Double.doubleToLongBits(perdaPercentual) != Double.doubleToLongBits(other.perdaPercentual))
			return false;
		if (Double.doubleToLongBits(permaneceuPercentual) != Double.doubleToLongBits(other.permaneceuPercentual))
			return false;
		if (tempoFinal == null) {
			if (other.tempoFinal != null)
				return false;
		} else if (!tempoFinal.equals(other.tempoFinal))
			return false;
		if (tempoInicial == null) {
			if (other.tempoInicial != null)
				return false;
		} else if (!tempoInicial.equals(other.tempoInicial))
			return false;
		if (Double.doubleToLongBits(vlTot) != Double.doubleToLongBits(other.vlTot))
			return false;
		if (Double.doubleToLongBits(vlTotAnt) != Double.doubleToLongBits(other.vlTotAnt))
			return false;
		if (Double.doubleToLongBits(vlTotAtual) != Double.doubleToLongBits(other.vlTotAtual))
			return false;
		if (Double.doubleToLongBits(vlTotAumentou) != Double.doubleToLongBits(other.vlTotAumentou))
			return false;
		if (Double.doubleToLongBits(vlTotDifDeflacao) != Double.doubleToLongBits(other.vlTotDifDeflacao))
			return false;
		if (Double.doubleToLongBits(vlTotDifInflacao) != Double.doubleToLongBits(other.vlTotDifInflacao))
			return false;
		if (Double.doubleToLongBits(vlTotDiminuiu) != Double.doubleToLongBits(other.vlTotDiminuiu))
			return false;
		if (Double.doubleToLongBits(vlTotPermaneceu) != Double.doubleToLongBits(other.vlTotPermaneceu))
			return false;
		if (Double.doubleToLongBits(vlTotPermaneceuValor) != Double.doubleToLongBits(other.vlTotPermaneceuValor))
			return false;
		if (Double.doubleToLongBits(vlTotSomenteAnt) != Double.doubleToLongBits(other.vlTotSomenteAnt))
			return false;
		if (Double.doubleToLongBits(vlTotSomenteAtual) != Double.doubleToLongBits(other.vlTotSomenteAtual))
			return false;
		return true;
	}

			
}

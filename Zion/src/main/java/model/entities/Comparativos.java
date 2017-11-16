package model.entities;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Servicos_Restricoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;

public class Comparativos {
	@Column(name="nInsc", length = 90, nullable=false)
	private String nInsc;
	@Column(name="valor", precision = 18, scale = 4)
	private double valor;
	@Column(name="ano")
	private int ano;
	@Column(name="cpf_Cnpj", length = 20 )
	private String cpf_Cnpj;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "enum_Aux_Servicos_Classificacoes", nullable = false)
	private Enum_Aux_Servicos_Classificacoes enum_Aux_Servicos_Classificacoes;
	@Enumerated(EnumType.STRING)
	@Column(name = "enum_Aux_Servicos_Sub_Classificacoes", nullable = false)
	private Enum_Aux_Servicos_Sub_Classificacoes enum_Aux_Servicos_Sub_Classificacoes;
	@Enumerated(EnumType.STRING)
	@Column(name = "enum_Aux_Servicos_Restricoes", nullable = false)
	private Enum_Aux_Servicos_Restricoes enum_Aux_Servicos_Restricoes;

	public Comparativos(String nInsc, double valor, int ano,
			Enum_Aux_Servicos_Classificacoes enum_Aux_Servicos_Classificacoes,
			Enum_Aux_Servicos_Sub_Classificacoes enum_Aux_Servicos_Sub_Classificacoes,
			Enum_Aux_Servicos_Restricoes enum_Aux_Servicos_Restricoes, String cpf_Cnpj) {
		this.nInsc = nInsc;
		this.valor = valor;
		this.ano = ano;
		this.enum_Aux_Servicos_Classificacoes = enum_Aux_Servicos_Classificacoes;
		this.enum_Aux_Servicos_Sub_Classificacoes = enum_Aux_Servicos_Sub_Classificacoes;
		this.enum_Aux_Servicos_Restricoes = enum_Aux_Servicos_Restricoes;
		this.cpf_Cnpj = cpf_Cnpj;

	}

	public String getnInsc() {
		return nInsc;
	}

	public double getValor() {
		return valor;
	}

	public int getAno() {
		return ano;
	}

	public Enum_Aux_Servicos_Classificacoes getEnum_Aux_Servicos_Classificacoes() {
		return enum_Aux_Servicos_Classificacoes;
	}

	public Enum_Aux_Servicos_Sub_Classificacoes getEnum_Aux_Servicos_Sub_Classificacoes() {
		return enum_Aux_Servicos_Sub_Classificacoes;
	}

	public Enum_Aux_Servicos_Restricoes getEnum_Aux_Servicos_Restricoes() {
		return enum_Aux_Servicos_Restricoes;
	}

	public String getCpf_Cnpj() {
		return cpf_Cnpj;
	}

	public void setCpf_Cnpj(String cpf_Cnpj) {
		this.cpf_Cnpj = cpf_Cnpj;
	}

	public void setnInsc(String nInsc) {
		this.nInsc = nInsc;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setEnum_Aux_Servicos_Classificacoes(Enum_Aux_Servicos_Classificacoes enum_Aux_Servicos_Classificacoes) {
		this.enum_Aux_Servicos_Classificacoes = enum_Aux_Servicos_Classificacoes;
	}

	public void setEnum_Aux_Servicos_Sub_Classificacoes(
			Enum_Aux_Servicos_Sub_Classificacoes enum_Aux_Servicos_Sub_Classificacoes) {
		this.enum_Aux_Servicos_Sub_Classificacoes = enum_Aux_Servicos_Sub_Classificacoes;
	}

	public void setEnum_Aux_Servicos_Restricoes(Enum_Aux_Servicos_Restricoes enum_Aux_Servicos_Restricoes) {
		this.enum_Aux_Servicos_Restricoes = enum_Aux_Servicos_Restricoes;
	}

}

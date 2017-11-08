package model.entities;

import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Servicos_Restricoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;

public class Comparativos {
private String nInsc;
private double valor;
private int ano;

private Enum_Aux_Servicos_Classificacoes enum_Aux_Servicos_Classificacoes;
private Enum_Aux_Servicos_Sub_Classificacoes enum_Aux_Servicos_Sub_Classificacoes;
private Enum_Aux_Servicos_Restricoes enum_Aux_Servicos_Restricoes; 
public Comparativos(String nInsc, double valor, int ano,  Enum_Aux_Servicos_Classificacoes enum_Aux_Servicos_Classificacoes,
		Enum_Aux_Servicos_Sub_Classificacoes enum_Aux_Servicos_Sub_Classificacoes, Enum_Aux_Servicos_Restricoes enum_Aux_Servicos_Restricoes) {
	this.nInsc = nInsc;
	this.valor = valor;
	this.ano = ano;
	this.enum_Aux_Servicos_Classificacoes = enum_Aux_Servicos_Classificacoes;
	this.enum_Aux_Servicos_Sub_Classificacoes = enum_Aux_Servicos_Sub_Classificacoes;
	this.enum_Aux_Servicos_Restricoes = enum_Aux_Servicos_Restricoes;
	
	
	
	
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

}

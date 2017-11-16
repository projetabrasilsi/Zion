package model.entities;

import model.enums.Enum_Aux_Tipo_Conferencia;

public class Conferencia_Limites {

	Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia;
	int inicio;
	int fim;

	public Conferencia_Limites(Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia, int inicio, int fim) {
		this.enum_Aux_Tipo_Conferencia = enum_Aux_Tipo_Conferencia;
		this.inicio = inicio;
		this.fim = fim;

	}
	

	public Enum_Aux_Tipo_Conferencia getEnum_Aux_Tipo_Conferencia() {
		return enum_Aux_Tipo_Conferencia;
	}

	public void setEnum_Aux_Tipo_Conferencia(Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia) {
		this.enum_Aux_Tipo_Conferencia = enum_Aux_Tipo_Conferencia;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

}

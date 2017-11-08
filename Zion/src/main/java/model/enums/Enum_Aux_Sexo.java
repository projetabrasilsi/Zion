package model.enums;

public enum Enum_Aux_Sexo {
MASCULINO("M",0,true),
FEMININO("F",1,true),
OUTROS("O",2,true);

private String abrev;
private int id;
private boolean pessoa_Fisica;

Enum_Aux_Sexo( String abrev, int id,boolean pessoa_Fisica ){
	
	this.id = id;
	this.abrev = abrev;
	this.pessoa_Fisica = pessoa_Fisica; 
	
}


public int getId() {
	return id;
}


public String getAbrev() {
	return abrev;
}

public boolean isPessoa_Fisica() {
	return pessoa_Fisica;
}
}

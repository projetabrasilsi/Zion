package model.enums;

public enum Enum_Aux_Mascaras {
	
	CPF("###.###.###-##"),
	CNPJ("##.###.###/####-##"),
	TEL8DG("(##) #### - ####"),
	TEL9DG("(##) # #### - ####"),
	SEMMASC(""),
	DATATRACO("##/##/####"),
	DATABARRA("##-##-####");
	
	
    private String mascara;
    
    Enum_Aux_Mascaras(String mascara){
		this.mascara = mascara;
		
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}
    
    
    

	
}

package model.enums;

public enum Enum_Aux_Estados {
	AC("AC", "Acre"),  
    AL("AL","Alagoas"),  
    AM("AM","Amazonas"),  
    AP("AP","Amapá"),  
    BA("BA","Bahia"),  
    CE("CE","Ceará"),  
    DF("DF","Distrito Federal"),  
    ES("ES","Espirito Santo"),  
    GO("GO","Goias"),  
    MA("MA","Maranhão"),  
    MG("MG","Minas Gerais"),  
    MS("MS","Mato Grosso Sul"),  
    MT("MT","Mato Grosso"),  
    PA("PA","Pará"),  
    PB("PB","Paraiba"),  
    PE("PE","Pernanbuco"),  
    PI("PI","Piaui"),  
    PR("PR","Parana"),  
    RJ("RJ","Rio de Janeiro"),  
    RN("RN","Rio Grande do Norte"),  
    RO("RO","Rondônia"),  
    RR("RR","Roraima"),  
    RS("RS","Rio Grande do Sul"),  
    SC("SC","Santa Catarina"),  
    SE("","Sergipe"),  
    SP("","São Paulo"),  
    TO("","Tocantins");
	private String sigla;
    private String estado;  
    Enum_Aux_Estados(String sigla, String estado) {  
        this.estado = estado;  
        this.sigla = sigla;
    }  
    public String getEstado() {  
        return estado;  
    }  
    @Override  
    public String toString() {  
        return estado;  
    }
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}  

}

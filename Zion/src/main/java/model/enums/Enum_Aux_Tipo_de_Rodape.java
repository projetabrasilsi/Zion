package model.enums;

public enum Enum_Aux_Tipo_de_Rodape {
	
	
	TOTAL("TOTAL","TOTAL"),
	SUBTOTAL("SUB-TOTAL","SUB-TOTAL"),
	LINHA("LINHA","-------------------------------------------------------------------------------------------------");
	
	private String descricao;
	private String rodape;
	Enum_Aux_Tipo_de_Rodape(String descricao, String rodape){
		
		this.descricao = descricao;
		this.rodape = rodape;
	}
	public static boolean contemRodape(String texto) {
		boolean retorno = false;
		for (Enum_Aux_Tipo_de_Rodape e : Enum_Aux_Tipo_de_Rodape.values()) {
			if(texto.contains(e.getRodape())) {
				retorno = true;
				break;
			}
			
		}
		return retorno;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getRodape() {
		return rodape;
	}
	public void setRodape(String rodape) {
		this.rodape = rodape;
	}

	
	

	
}

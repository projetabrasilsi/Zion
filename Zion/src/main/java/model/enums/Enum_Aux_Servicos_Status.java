package model.enums;

public enum Enum_Aux_Servicos_Status {		
	IMPORTANDO("Importando Lista"),
	SALVANDO("Salvando Inscrições no Banco de Dados"),	
	FINALIZADO("Finalizado"),
	CANCELADO("Cancelado");
	
	private String status;
	
	Enum_Aux_Servicos_Status(String status){
		this.status = status;
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

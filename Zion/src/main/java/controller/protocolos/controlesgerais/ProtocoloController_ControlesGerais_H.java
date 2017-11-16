package controller.protocolos.controlesgerais;

import model.enums.Enum_Aux_Servicos_Classificacoes;

public class ProtocoloController_ControlesGerais_H extends ProtocoloController_ControlesGerais_I {


	public static Enum_Aux_Servicos_Classificacoes getServicosClassificacoes() {
		return ServicosClassificacoes;
	}

	public static void setServicosClassificacoes(Enum_Aux_Servicos_Classificacoes servicosClassificacoes) {
		ServicosClassificacoes = servicosClassificacoes;
	}
}

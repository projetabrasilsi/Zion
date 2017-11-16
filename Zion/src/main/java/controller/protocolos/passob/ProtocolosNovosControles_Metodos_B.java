package controller.protocolos.passob;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;

public class ProtocolosNovosControles_Metodos_B extends ProtocolosNovosControles_A {

	public void configuraformulario() {
		if (ProtocoloController_ControlesGerais_A.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao()
				.isComparativo()) {
			lb_Comp_1.setVisible(true);
			cB_Comp_1.setVisible(true);
			lb_Comp_2.setVisible(true);
			cB_Comp_2.setVisible(true);
			bt_Escolher_Arquivo_2.setVisible(true);
			bt_Escolher_Arquivo_1.setLayoutX(11);
			lb_Comp_1.setText("Informe o Ano de Comparação - 1");
			bt_Escolher_Arquivo_1.setText("Buscar arquivo - 1");
		} else {
			lb_Comp_1.setVisible(false);
			cB_Comp_1.setVisible(false);
			lb_Comp_2.setVisible(false);
			cB_Comp_2.setVisible(false);
			bt_Escolher_Arquivo_2.setVisible(false);
			bt_Escolher_Arquivo_1.setLayoutX(117);
			bt_Escolher_Arquivo_1.setText("Buscar arquivo");
		}
	}
}

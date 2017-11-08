package model.enums;

import java.util.ArrayList;
import java.util.List;

public enum Enum_Aux_Servicos_Composicoes {
	IPTU_COMPARATIVOS_FLORIANOPOLIS_SC(1, 1, 1, "IPTU_COMPARATIVOS_FLORIANOPOLIS_SC",
			"COMPARAÇÕES DE IPTU  - FLORIANÓPOLIS - SC ", Enum_Aux_Servicos_Classificacoes.IPTU,
			Enum_Aux_Servicos_Sub_Classificacoes.COMPARATIVOS, Enum_Aux_Servicos_Restricoes.FLORIANOPOLIS_SC,false),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_DAMS_FLORIANOPOLIS_SC(2, 1, 2, "IPTU_DAMS_FLORIANOPOLIS_SC", "DAMS DE IPTU  - FLORIANÓPOLIS - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.DAMS,
			Enum_Aux_Servicos_Restricoes.FLORIANOPOLIS_SC,true),
	// utilizar Object instanciar_Classe(String classe)
	IPTU_CNDS_FLORIANOPOLIS_SC(3, 1, 3, "IPTU_CNDS_FLORIANOPOLIS_SC",
			"CERTIDÃO NEGATIVA DE DÉBITO DE IPTU  - FLORIANÓPOLIS - SC ", Enum_Aux_Servicos_Classificacoes.IPTU,
			Enum_Aux_Servicos_Sub_Classificacoes.CNDS, Enum_Aux_Servicos_Restricoes.FLORIANOPOLIS_SC,true),
	// utilizar Object instanciar_Classe(String classe)
	IPTU_CONFERENCIA_DEBITOS_FLORIANOPOLIS_SC(4, 1, 4, "IPTU_CONFERENCIA_DEBITOS_FLORIANOPOLIS_SC",
			"CONFERÊNCIA DE DÉBITOS DE IPTU  - FLORIANÓPOLIS - SC ", Enum_Aux_Servicos_Classificacoes.IPTU,
			Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS, Enum_Aux_Servicos_Restricoes.FLORIANOPOLIS_SC,true),
	// utilizar Object instanciar_Classe(String classe)
	IPTU_COMPARATIVOS_SAO_JOSE_SC(5, 1, 1, "IPTU_COMPARATIVOS_SAO_JOSE_SC", "COMPARAÇÕES DE IPTU  - SÃO JOSÉ - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.COMPARATIVOS,
			Enum_Aux_Servicos_Restricoes.SAO_JOSE_SC,false),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_DAMS_SAO_JOSE_SC(6, 1, 2, "IPTU_DAMS_SAO_JOSE_SC", "DAMS DE IPTU  - SÃO JOSÉ - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.DAMS,
			Enum_Aux_Servicos_Restricoes.SAO_JOSE_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_CNDS_SAO_JOSE_SC(7, 1, 3, "IPTU_CNDS_SAO_JOSE_SC", "CERTIDÃO NEGATIVA DE DÉBITO DE IPTU  - SÃO JOSÉ - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.CNDS,
			Enum_Aux_Servicos_Restricoes.SAO_JOSE_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_CONFERENCIA_DEBITOS_SAO_JOSE_SC(8, 1, 4, "IPTU_CONFERÊNCIA_DEBITOS_SAO_JOSE_SC",
			"CONFERENCIA DE DÉBITOS DE IPTU  - SÃO JOSÉ - SC ", Enum_Aux_Servicos_Classificacoes.IPTU,
			Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS, Enum_Aux_Servicos_Restricoes.SAO_JOSE_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_COMPARATIVOS_BIGUACU_SC(9, 1, 1, "IPTU_COMPARATIVOS_BIGUACU_SC", "COMPARAÇÕES DE IPTU  - BIGUAÇU - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.COMPARATIVOS,
			Enum_Aux_Servicos_Restricoes.BIGUACU_SC,false),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_DAMS_BIGUACU_SC(10, 1, 2, "IPTU_DAMS_BIGUACU_SC", "DAMS DE IPTU  - BIGUAÇU - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.DAMS,
			Enum_Aux_Servicos_Restricoes.BIGUACU_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_CNDS_BIGUACU_SC(11, 1, 3, "IPTU_CNDS_BIGUACU_SC", "CERTIDÃO NEGATIVA DE DÉBITO DE IPTU  - BIGUAÇU - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.CNDS,
			Enum_Aux_Servicos_Restricoes.BIGUACU_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_CONFERENCIA_DEBITOS_BIGUACU_SC(12, 1, 4, "IPTU_CONFERÊNCIA_DEBITOS_BIGUACU_SC",
			"CONFERENCIA DE DÉBITOS DE IPTU  - BIGUAÇU - SC ", Enum_Aux_Servicos_Classificacoes.IPTU,
			Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS, Enum_Aux_Servicos_Restricoes.BIGUACU_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_COMPARATIVOS_PALHOCA_SC(13, 1, 1, "IPTU_COMPARATIVOS_PALHOCA_SC", "COMPARAÇÕES DE IPTU  - PALHOÇA - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.COMPARATIVOS,
			Enum_Aux_Servicos_Restricoes.PALHOCA_SC,false),
	// utilizar Object instanciar_Classe(String classe)
	IPTU_DAMS_PALHOCA_SC(14, 1, 2, "IPTU_DAMS_PALHOCA_SC", "DAMS DE IPTU  - PALHOÇA - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.DAMS,
			Enum_Aux_Servicos_Restricoes.PALHOCA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_CNDS_PALHOCA_SC(15, 1, 3, "IPTU_CNDS_PALHOCA_SC", "CERTIDÃO NEGATIVA DE DÉBITO DE IPTU  - PALHOÇA - SC ",
			Enum_Aux_Servicos_Classificacoes.IPTU, Enum_Aux_Servicos_Sub_Classificacoes.CNDS,
			Enum_Aux_Servicos_Restricoes.PALHOCA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	IPTU_CONFERENCIA_DEBITOS_PALHOCA_SC(16, 1, 4, "IPTU_CONFERÊNCIA_DEBITOS_PALHOCA_SC",
			"CONFERENCIA DE DÉBITOS DE IPTU  - PALHOÇA - SC ", Enum_Aux_Servicos_Classificacoes.IPTU,
			Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS, Enum_Aux_Servicos_Restricoes.PALHOCA_SC,true),
	// utilizar Object instanciar_Classe(String classe)
	AGUA_COMPARATIVOS_SANTA_CATARINA_SC(17, 2, 1, "AGUA_COMPARATIVOS_SANTA_CATARINA_SC",
			"COMPARATIVOS DE AGUA - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.AGUA,
			Enum_Aux_Servicos_Sub_Classificacoes.COMPARATIVOS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,false),
	// utilizar Object instanciar_Classe(String classe)

	AGUA_DAMS_SANTA_CATARINA_SC(18, 2, 2, "AGUA_DAMS_SANTA_CATARINA_SC", "DAMS DE AGUA - SANTA CATARINA SC",
			Enum_Aux_Servicos_Classificacoes.AGUA, Enum_Aux_Servicos_Sub_Classificacoes.DAMS,
			Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	AGUA_CNDS_SANTA_CATARINA_SC(19, 2, 3, "AGUA_CNDS_SANTA_CATARINA_SC",
			"CERTIDÃO NEGATIVA DE DÉBITOS DE AGUA - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.AGUA,
			Enum_Aux_Servicos_Sub_Classificacoes.CNDS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	AGUA_CONFERENCIA_DEBITOS_SANTA_CATARINA_SC(20, 2, 4, "AGUA_CONFERENCIA_DEBITOS_SANTA_CATARINA_SC",
			"CONFERÊNCIA DE DÉBITOS DE AGUA - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.AGUA,
			Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	ENERGIA_COMPARATIVOS_SANTA_CATARINA_SC(21, 3, 1, "ENERGIA_COMPARATIVOS_SANTA_CATARINA_SC",
			"COMPARATIVOS DE ENERGIA - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.ENERGIA,
			Enum_Aux_Servicos_Sub_Classificacoes.COMPARATIVOS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,false),
	// utilizar Object instanciar_Classe(String classe)

	ENERGIA_DAMS_SANTA_CATARINA_SC(22, 3, 2, "ENERGIA_DAMS_SANTA_CATARINA_SC", "DAMS DE ENERGIA - SANTA CATARINA SC",
			Enum_Aux_Servicos_Classificacoes.ENERGIA, Enum_Aux_Servicos_Sub_Classificacoes.DAMS,
			Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	ENERGIA_CNDS_SANTA_CATARINA_SC(23, 3, 3, "ENERGIA_CNDS_SANTA_CATARINA_SC",
			"CERTIDÃO NEGATIVA DE DÉBITOS DE ENERGIA - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.ENERGIA,
			Enum_Aux_Servicos_Sub_Classificacoes.CNDS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	ENERGIA_CONFERENCIA_DEBITOS_SANTA_CATARINA_SC(24, 3, 4, "ENERGIA_CONFERENCIA_DEBITOS_SANTA_CATARINA_SC",
			"CONFERÊNCIA DE DÉBITOS DE ENERGIA - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.ENERGIA,
			Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	ENERGIA_TRANSFERENCIA_TITULARIDADE_SANTA_CATARINA_SC(25, 3, 5,
			"ENERGIA_TRANSFERENCIA_TITULARIDADE_SANTA_CATARINA_SC",
			"TRANSFERENCIA DE CONTA DE DÉBITOS DE ENERGIA - SANTA CATARINA SC",
			Enum_Aux_Servicos_Classificacoes.ENERGIA, Enum_Aux_Servicos_Sub_Classificacoes.TRANSFERENCIA_TITULARIDADE,
			Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	CONDOMINIO_COMPARATIVOS_SANTA_CATARINA_SC(26, 4, 1, "CONDOMINIO_COMPARATIVOS_SANTA_CATARINA_SC",
			"COMPARATIVOS DE CONDOMÍNIOS - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.CONDOMINIO,
			Enum_Aux_Servicos_Sub_Classificacoes.COMPARATIVOS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,false),
	// utilizar Object instanciar_Classe(String classe)

	CONDOMINIO_DAMS_SANTA_CATARINA_SC(27, 4, 2, "CONDOMINIO_DAMS_SANTA_CATARINA_SC",
			"DAMS DE CONDOMÍNIOS - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.CONDOMINIO,
			Enum_Aux_Servicos_Sub_Classificacoes.DAMS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	CONDOMINIO_CNDS_SANTA_CATARINA_SC(28, 4, 3, "CONDOMINIO_CNDS_SANTA_CATARINA_SC",
			"CERTIDÃO NEGATIVA DE DÉBITOS - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.CONDOMINIO,
			Enum_Aux_Servicos_Sub_Classificacoes.CNDS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true),
	// utilizar Object instanciar_Classe(String classe)

	CONDOMINIO_CONFERENCIA_DEBITOS_SANTA_CATARINA_SC(29, 4, 4, "CONDOMINIO_CONFERENCIA_DEBITOS_SANTA_CATARINA_SC",
			"CONFERENCIA DE DÉBITOS DE CONDOMÍNIOS - SANTA CATARINA SC", Enum_Aux_Servicos_Classificacoes.CONDOMINIO,
			Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS, Enum_Aux_Servicos_Restricoes.SANTA_CATARINA_SC,true);
	// utilizar Object instanciar_Classe(String classe)

	private int id;
	private int contagem_de_tipos;
	private int contagem_de_qtde_tipos;
	private String descricao;
	private String descricao2;
	private Enum_Aux_Servicos_Classificacoes classificacao;
	private Enum_Aux_Servicos_Sub_Classificacoes sub_Classificacao;
	private Enum_Aux_Servicos_Restricoes restricao;
	private boolean anoEMes;

	private Enum_Aux_Servicos_Composicoes(int id, int contagem_de_tipos, int contagem_de_qtde_tipos, String descricao,
			String descricao2, Enum_Aux_Servicos_Classificacoes classificacao,
			Enum_Aux_Servicos_Sub_Classificacoes sub_Classificacao, Enum_Aux_Servicos_Restricoes restricao,boolean anoEMes) {
		this.id = id;
		this.descricao2 = descricao2;
		this.contagem_de_tipos = contagem_de_tipos;
		this.contagem_de_qtde_tipos = contagem_de_qtde_tipos;

		this.descricao = descricao;
		this.classificacao = classificacao;
		this.sub_Classificacao = sub_Classificacao;
		this.restricao = restricao;
		this.anoEMes = anoEMes;
	}
	public static Enum_Aux_Servicos_Composicoes retornaComposicao(
			Enum_Aux_Servicos_Classificacoes classif, Enum_Aux_Servicos_Sub_Classificacoes subClass, Enum_Aux_Servicos_Restricoes restr ) {
		
		Enum_Aux_Servicos_Composicoes compos = null;
		

		for (Enum_Aux_Servicos_Composicoes comp : Enum_Aux_Servicos_Composicoes.values()) {
			if (comp.getClassificacao().equals(classif) && comp.getSub_Classificacao().equals(subClass) &&
					comp.getRestricao().equals(restr)) {
				compos = comp;
				break;
				
			}
		}
		return compos;
		
	}
	

	public static List<Enum_Aux_Servicos_Composicoes> retornaListaComposicoesPorClassificacao(
			Enum_Aux_Servicos_Classificacoes par) {
		List<Enum_Aux_Servicos_Composicoes> lista = null;

		for (Enum_Aux_Servicos_Composicoes comp : Enum_Aux_Servicos_Composicoes.values()) {
			if (comp.getClassificacao().equals(par)) {
				if (lista == null)
					lista = new ArrayList<>();
				lista.add(comp);
			}
		}
		return lista;
	}

	public static List<Enum_Aux_Servicos_Composicoes> retornaListaComposicoesPorSubClassificacao(
			Enum_Aux_Servicos_Sub_Classificacoes par) {
		List<Enum_Aux_Servicos_Composicoes> lista = null;

		for (Enum_Aux_Servicos_Composicoes comp : Enum_Aux_Servicos_Composicoes.values()) {
			if (comp.getSub_Classificacao().equals(par)) {
				if (lista == null)
					lista = new ArrayList<>();
				lista.add(comp);
			}
		}
		return lista;
	}

	public static List<Enum_Aux_Servicos_Composicoes> retornaListaComposicoesPorRestricao(
			Enum_Aux_Servicos_Restricoes par) {
		List<Enum_Aux_Servicos_Composicoes> lista = null;

		for (Enum_Aux_Servicos_Composicoes comp : Enum_Aux_Servicos_Composicoes.values()) {
			if (comp.getRestricao().equals(par)) {
				if (lista == null)
					lista = new ArrayList<>();
				lista.add(comp);
			}
		}
		return lista;
	}

	public static List<Enum_Aux_Servicos_Classificacoes> retornaListaClassificacoes() {
		List<Enum_Aux_Servicos_Classificacoes> lista = null;

		return lista;

	}

	public static List<Enum_Aux_Servicos_Sub_Classificacoes> retornaListaSubClassificacoes(Enum_Aux_Servicos_Classificacoes classif){
		List<Enum_Aux_Servicos_Sub_Classificacoes> lista = null;
		
		
		for (Enum_Aux_Servicos_Composicoes c : Enum_Aux_Servicos_Composicoes.values()) {
			
			
			if(c.getClassificacao().equals(classif)){
				if(lista == null)
					lista = new ArrayList<>();
				
				if(!lista.contains(c.getSub_Classificacao()) ) {
				lista.add(c.getSub_Classificacao());
				
				}
			}
			
		}
		return lista;
		
	}

	public static List<Enum_Aux_Servicos_Restricoes> retornaListaRestricoes(Enum_Aux_Servicos_Classificacoes classif,
			Enum_Aux_Servicos_Sub_Classificacoes subClass) {
		List<Enum_Aux_Servicos_Restricoes> lista = null;

		for (Enum_Aux_Servicos_Composicoes c : Enum_Aux_Servicos_Composicoes.values()) {
			if (c.getClassificacao().equals(classif) && c.getSub_Classificacao().equals(subClass)) {
				if (lista == null)
					lista = new ArrayList<>();
				lista.add(c.getRestricao());
			}

		}

		return lista;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getContagem_de_tipos() {
		return contagem_de_tipos;
	}
	public void setContagem_de_tipos(int contagem_de_tipos) {
		this.contagem_de_tipos = contagem_de_tipos;
	}
	public int getContagem_de_qtde_tipos() {
		return contagem_de_qtde_tipos;
	}
	public void setContagem_de_qtde_tipos(int contagem_de_qtde_tipos) {
		this.contagem_de_qtde_tipos = contagem_de_qtde_tipos;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao2() {
		return descricao2;
	}
	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}
	public Enum_Aux_Servicos_Classificacoes getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Enum_Aux_Servicos_Classificacoes classificacao) {
		this.classificacao = classificacao;
	}
	public Enum_Aux_Servicos_Sub_Classificacoes getSub_Classificacao() {
		return sub_Classificacao;
	}
	public void setSub_Classificacao(Enum_Aux_Servicos_Sub_Classificacoes sub_Classificacao) {
		this.sub_Classificacao = sub_Classificacao;
	}
	public Enum_Aux_Servicos_Restricoes getRestricao() {
		return restricao;
	}
	public void setRestricao(Enum_Aux_Servicos_Restricoes restricao) {
		this.restricao = restricao;
	}
	public boolean isAnoEMes() {
		return anoEMes;
	}
	public void setAnoEMes(boolean anoEMes) {
		this.anoEMes = anoEMes;
	}

	
}

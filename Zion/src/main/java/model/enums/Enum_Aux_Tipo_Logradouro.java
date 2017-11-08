package model.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum Enum_Aux_Tipo_Logradouro {
	ACAMPAMENTO("ACAMPAMENTO",0,645),
	ACESSO("ACESSO",1,1),
	ADRO("ADRO",2,2),
	AEROPORTO("AEROPORTO",3,501),
	ALAMEDA("ALAMEDA",4,4),
	ALTO("ALTO",5,5),
	AREA("AREA",6,472),
	AREAESPECIAL("AREA ESPECIAL",7,654),
	ARTERIA("ARTERIA",8,465),
	ATALHO("ATALHO",9,7),
	AVENIDA("AVENIDA",10,8),
	AVENIDACONTORNO("AVENIDA CONTORNO",11,651),
	BAIXA("BAIXA",12,15),
	BALAO("BALAO",13,470),
	BALNEARIO("BALNEARIO",14,9),
	BECO("BECO",15,11),
	BELVEDERE("BELVEDERE",16,10),
	BLOCO("BLOCO",17,12),
	BOSQUE("BOSQUE",18,13),
	BOULEVARD("BOULEVARD",19,14),
	BURACO("BURACO",20,496),
	CAIS("CAIS",21,16),
	CALCADA("CALCADA",22,571),
	CAMINHO("CAMINHO",23,17),
	CAMPO("CAMPO",24,23),
	CANAL("CANAL",25,495),
	CHACARA("CHACARA",26,481),
	CHAPADAO("CHAPADAO",27,19),
	CIRCULAR("CIRCULAR",28,479),
	COLONIA("COLONIA",29,21),
	COMPLEXOVIARIO("COMPLEXO VIARIO",30,503),
	CONDOMINIO("CONDOMINIO",31,485),
	CONJUNTO("CONJUNTO",32,20),
	CORREDOR("CORREDOR",33,22),
	CORREGO("CORREGO",34,24),
	DESCIDA("DESCIDA",35,478),
	DESVIO("DESVIO",36,27),
	DISTRITO("DISTRITO",37,28),
	ELEVADA("ELEVADA",38,468),
	ENTRADAPARTICULAR("ENTRADA PARTICULAR",39,573),
	ENTREQUADRA("ENTRE QUADRA",40,652),
	ESCADA("ESCADA",41,30),
	ESPLANADA("ESPLANADA",42,474),
	ESTACAO("ESTACAO",43,32),
	ESTACIONAMENTO("ESTACIONAMENTO",44,564),
	ESTADIO("ESTADIO",45,33),
	ESTANCIA("ESTANCIA",46,498),
	ESTRADA("ESTRADA",47,31),
	ESTRADAMUNICIPAL("ESTRADA MUNICIPAL",48,650),
	FAVELA("FAVELA",49,36),
	FAZENDA("FAZENDA",50,37),
	FEIRA("FEIRA",51,40),
	FERROVIA("FERROVIA",52,38),
	FONTE("FONTE",53,39),
	FORTE("FORTE",54,43),
	GALERIA("GALERIA",55,45),
	GRANJA("GRANJA",56,46),
	HABITACIONAL("HABITACIONAL",57,486),
	ILHA("ILHA",58,50),
	JARDIM("JARDIM",59,52),
	JARDINETE("JARDINETE",60,473),
	LADEIRA("LADEIRA",61,53),
	LAGO("LAGO",62,499),
	LAGOA("LAGOA",63,55),
	LARGO("LARGO",64,54),
	LOTEAMENTO("LOTEAMENTO",65,56),
	MARINA("MARINA",66,477),
	MODULO("MODULO",67,497),
	MONTE("MONTE",68,60),
	MORRO("MORRO",69,59),
	NUCLEO("NUCLEO",70,500),
	PARADA("PARADA",71,67),
	PARADOURO("PARADOURO",72,471),
	PARALELA("PARALELA",73,62),
	PARQUE("PARQUE",74,72),
	PASSAGEM("PASSAGEM",75,74),
	PASSAGEMSUBTERRANEA("PASSAGEM SUBTERRANEA",76,502),
	PASSARELA("PASSARELA",77,73),
	PASSEIO("PASSEIO",78,63),
	PATIO("PATIO",79,64),
	PONTA("PONTA",80,483),
	PONTE("PONTE",81,76),
	PORTO("PORTO",82,469),
	PRACA("PRACA",83,65),
	PRACADEESPORTES("PRACA DE ESPORTES",84,504),
	PRAIA("PRAIA",85,70),
	PROLONGAMENTO("PROLONGAMENTO",86,71),
	QUADRA("QUADRA",87,77),	
	QUINTA("QUINTA",89,475),
	RAMAL("RAMAL",90,82),
	RAMPA("RAMPA",91,482),
	RECANTO("RECANTO",92,87),
	RESIDENCIAL("RESIDENCIAL",93,487),
	RETA("RETA",94,89),
	RETIRO("RETIRO",95,88),
	RETORNO("RETORNO",96,91),
	RODOANEL("RODO ANEL",97,569),
	RODOVIA("RODOVIA",98,90),
	ROTATORIA("ROTATORIA",99,506),
	ROTULA("ROTULA",100,476),
	RUA("RUA",101,81),
	RUADELIGACAO("RUA DE LIGACAO",102,653),
	RUADEPEDESTRE("RUA DE PEDESTRE",103,566),
	SERVIDAO("SERVIDAO",104,94),
	SETOR("SETOR",105,95),
	SITIO("SITIO",106,92),
	SUBIDA("SUBIDA",107,96),
	TERMINAL("TERMINAL",108,98),
	TRAVESSA("TRAVESSA",109,100),
	TRAVESSAPARTICULAR("TRAVESSA PARTICULAR",110,570),
	TRECHO("TRECHO",111,452),
	TREVO("TREVO",112,99),
	TRINCHEIRA("TRINCHEIRA",113,97),
	TUNEL("TUNEL",114,567),
	UNIDADE("UNIDADE",115,480),
	VALA("VALA",116,565),
	VALE("VALE",117,106),
	VARIANTE("VARIANTE",118,568),
	VEREDA("VEREDA",119,453),
	VIA("VIA",120,101),
	VIADEACESSO("VIA DE ACESSO",121,572),
	VIADEPEDESTRE("VIA DE PEDESTRE",122,484),
	VIAELEVADO("VIA ELEVADO",123,505),
	VIAEXPRESSA("VIA EXPRESSA",124,646),
	VIADUTO("VIADUTO",125,103),
	VIELA("VIELA",126,105),
	VILA("VILA",127,104),
	ZIGUEZAGUE("ZIGUE-ZAGUE",128,108);
	
	@Enumerated ( EnumType.STRING )
	private String descricao;
	private int id;	
	private int codigo;
	
	Enum_Aux_Tipo_Logradouro(String descricao, int id,int codigo){
		this.descricao = descricao;
		this.id = id;		
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getId() {
		return id;
	}

	public int getCodigo() {
		return codigo;
	}

	
	
	
}
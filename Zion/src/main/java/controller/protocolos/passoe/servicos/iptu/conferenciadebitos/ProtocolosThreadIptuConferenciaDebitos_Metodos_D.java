package controller.protocolos.passoe.servicos.iptu.conferenciadebitos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.protocolos.controlesgerais.ProtocoloController_ControlesGerais_A;
import model.dao.Inscricao_Historico_DetalheDAO;
import model.dao.Inscricao_Historico_HeaderDAO;
import model.entities.Conferencia_Limites;
import model.entities.Inscricao_Historico_Detalhe;
import model.entities.Inscricao_Historico_Header;
import model.entities.ProtocolosdeServicos_Detalhe;
import model.enums.Enum_Aux_Sim_ou_Nao;
import model.enums.Enum_Aux_Status_Consulta;
import model.enums.Enum_Aux_Tipo_Conferencia;
import model.enums.Enum_Aux_Tipo_de_Rodape;
import util.Utilidades;

public class ProtocolosThreadIptuConferenciaDebitos_Metodos_D extends ProtocolosThreadIptuConferenciaDebitos_Metodos_E {

	public static ProtocolosdeServicos_Detalhe iniciaOProcessoDeAnalise(File f, ProtocolosdeServicos_Detalhe pd) {

		List<Conferencia_Limites> l = new ArrayList<>();
		l.addAll(realizaVarreduranoArquivo(f));
		Inscricao_Historico_Header iHH = new Inscricao_Historico_Header();

		for (Conferencia_Limites cL : l) {
			System.out.println("conferencia: " + cL.getEnum_Aux_Tipo_Conferencia() + " - inicio: " + cL.getInicio()
					+ " - fim: " + cL.getFim());
			// grava o mestre
			iHH = constroiIHH(cL, pd, l.size(), cL.getInicio(), cL.getFim());
			if (cL.getEnum_Aux_Tipo_Conferencia().equals(Enum_Aux_Tipo_Conferencia.CPF_CNPJ_INVALIDO)
					|| cL.getEnum_Aux_Tipo_Conferencia().equals(Enum_Aux_Tipo_Conferencia.SEM_DEBITOS_PENDENTES)
					|| cL.getEnum_Aux_Tipo_Conferencia().equals(Enum_Aux_Tipo_Conferencia.INSCRICACAO_INEXISTENTE))
				pd.setEnum_Aux_Tipo_Conferencia(cL.getEnum_Aux_Tipo_Conferencia());
			else {
				pd.setEnum_Aux_Tipo_Conferencia(cL.getEnum_Aux_Tipo_Conferencia());
				montaIHDLista(f, iHH, cL.getEnum_Aux_Tipo_Conferencia());
			}
			iHH.setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta.ANALISADO);
			Inscricao_Historico_HeaderDAO iHHDAO = new Inscricao_Historico_HeaderDAO();
			iHH = iHHDAO.merge(iHH);

		}
		pd.setEnum_Aux_Status_Consulta(Enum_Aux_Status_Consulta.ANALISADO);
		if (l.size() > 1)
			pd.setEnum_Aux_Tipo_Conferencia(Enum_Aux_Tipo_Conferencia.RETORNOSVARIADOS);
		else
			pd.setEnum_Aux_Tipo_Conferencia(iHH.getEnum_Aux_Tipo_Conferencia());
		return pd;
	}

	public static List<Conferencia_Limites> realizaVarreduranoArquivo(File file) {
		BufferedReader reader = null;
		Conferencia_Limites cL = null;
		List<Conferencia_Limites> cLs = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			boolean prioTrue = false;
			boolean prioFalse = false;
			int contagem = 1;
			l = checaPrioridades(true);
			l2 = checaPrioridades(false);
			cLs = new ArrayList<>();
			while ((text = reader.readLine()) != null) {
				boolean contem = false;
				prioTrue = false;
				for (Enum_Aux_Tipo_Conferencia e : l) {
					if (text.length() > 0 && text.contains(e.getCabecalho())) {
						cL = new Conferencia_Limites(e, 0, 0);
						contem = jaContem(cLs,cL);						
						if (!contem)
							cLs.add(cL);
						prioTrue = true;
						break;
					}
				}
				if (!prioTrue) {
					prioFalse = false;
					for (Enum_Aux_Tipo_Conferencia e : l2) {
						if (text.length() > 0 && text.contains(e.getCabecalho())) {
							// achou o cabeçalho
							cL = new Conferencia_Limites(e, contagem + e.getSaltaLinha(), contagem + e.getSaltaLinha());
							prioFalse = true;
							break;
						}
					}

					if ((prioFalse && cL != null && cL.getEnum_Aux_Tipo_Conferencia() != null)) {
						if (prioFalse) {
							contagem++;
							// checaPrioridades(false);
							while ((text = reader.readLine()) != null) {
								String texto = text.trim();
								if (texto.length() == 0 || Enum_Aux_Tipo_de_Rodape.contemRodape(texto) ) {
									cL.setFim(contagem - 1);
									break;
								}

								contagem++;
							}

							if (cL != null & cL.getInicio() > 0 && cL.getFim() > 0) {
								contem = jaContem(cLs,cL);
								// SE JÁ EXISTE o cabeçalho adiconado. Não será adicionado novamente
								if (!contem)
									cLs.add(cL);

							}
						}
					}

				}
				contagem++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		return cLs;
	}
	public static boolean jaContem(List<Conferencia_Limites> cLs, Conferencia_Limites cL) {
		Boolean jaContem = false;
		for (Conferencia_Limites conf : cLs) {
			if (conf.getEnum_Aux_Tipo_Conferencia().equals(cL.getEnum_Aux_Tipo_Conferencia())) {
				jaContem=true;
				break;
			}
		}
		return jaContem;
	}

	public static Inscricao_Historico_Detalhe montaIHDLista(File f, Inscricao_Historico_Header iHH,
			Enum_Aux_Tipo_Conferencia enum_Aux_Tipo_Conferencia) {
		Inscricao_Historico_Detalhe iHD = new Inscricao_Historico_Detalhe();

		BufferedReader reader = null;
		String linha = "";
		int cont = 1;
		try {
			reader = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		cont = 1;
		try {

			while ((linha = reader.readLine()) != null) {

				if (cont >= iHH.getCabecalho() && cont <= iHH.getRodape()) {
					iHD = montaIHD(linha, enum_Aux_Tipo_Conferencia, iHH);
				}
				cont++;
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return iHD;

	}

	protected static Inscricao_Historico_Detalhe montaIHD(String linha, Enum_Aux_Tipo_Conferencia e,
			Inscricao_Historico_Header iHH) {
		Inscricao_Historico_Detalhe iHD = new Inscricao_Historico_Detalhe();
		iHD = montaGeral(iHD, e, iHH);
		ProtocoloController_ControlesGerais_A.adicionaMap();
		switch (e) {
		case A_TRIBUTOS_IMOBILIARIOS:

			iHD = montaCDebitos_A_A2(linha, iHD);
			break;
		case A2_IPTU_ENGLOBADO:

			iHD = montaCDebitos_A_A2(linha, iHD);
			break;
		case B_DIVIDA_ATIVA_DE_TRIBUTOS:

			iHD = montaCDebitos_B_I(linha, iHD);
			break;
		case B1_PROCESSOS_DA_DIVIDA_ATIVA_AJUIZADA:

			iHD = montaCDebitos_B1_I1(linha, iHD);
			break;
		case C_PARCELAMENTO_DE_TRIBUTOS:

			iHD = montaCDebitos_C(linha, iHD);
			break;
		case C1_DIVIDA_REFERENTE_AO_PARCELAMENTO:

			iHD = montaCDebitos_C1_L1(linha, iHD);
			break;
		case D_DEBITOS_DE_ITBI:

			iHD = montaCDebitos_D(linha, iHD);
			break;
		case G_DEBITOS_DE_TRIBUTOS_DIVERSOS:

			iHD = montaCDebitos_G(linha, iHD);
			break;
		case J_PARCELAMENTO_JUDICIAL:

			iHD = montaCDebitos_J(linha, iHD);
			break;
		case J1_DIVIDA_REFERENTE_AO_PARCELAMENTO_JUDICIAL:

			iHD = montaCDebitos_J1(linha, iHD);
			break;
		case I_DEBITOS_DE_DIVIDA_ATIVA_DE_TRIB_MOBILIARIOS_TRIBUTOS_MOTILIARIOS_TRIBUTOS_DIVERSOS_PARC_UNIFICADO:

			iHD = montaCDebitos_B_I(linha, iHD);
			break;
		case I1_PROCESSOS_DA_DIVIDA_AJUIZADA:

			iHD = montaCDebitos_B1_I1(linha, iHD);
			break;

		case L_PARCELAMENTO_UNIFICADO:

			iHD = montaCDebitos_L(linha, iHD);
			break;
		case L1_DIVIDA_REFERENTE_AO_PARCELAMENTO:

			iHD = montaCDebitos_C1_L1(linha, iHD);
			break;

		default:
			iHD = montaCDebitos_A_A2(linha, iHD);
			break;
		}
		Inscricao_Historico_DetalheDAO iHDDAO = new Inscricao_Historico_DetalheDAO();
		Inscricao_Historico_Detalhe iHD1 = new Inscricao_Historico_Detalhe();
		iHD1 = iHDDAO.verificaSeExiste(iHD);
		if (iHD1 == null)
			iHD = iHDDAO.merge(iHD);
		else
			iHD = iHD1;
		return iHD;
	}

	protected static Inscricao_Historico_Detalhe montaGeral(Inscricao_Historico_Detalhe iHD,
			Enum_Aux_Tipo_Conferencia e, Inscricao_Historico_Header iHH) {
		iHD.setAno(0);
		iHD.setAno_Ref(Utilidades.retornaAno());
		iHD.setCartorio("");
		iHD.setDam("");
		iHD.setData_Insc(null);
		iHD.setData_Venc(null);
		iHD.setEnum_Aux_Servicos_Sub_Classificacoes(ProtocoloController_ControlesGerais_A.getProtocolosdeServicos()
				.getEnum_Aux_Servicos_Composicoes().getSub_Classificacao());
		iHD.setEnum_Aux_Tipo_Conferencia(e);
		iHD.setFiti("");
		iHD.setHistorico("");
		iHD.setId_Empresa(1);
		iHD.setInscricao_Historico_Header(iHH);
		iHD.setId_Inscricao(iHH.getId_Inscricao());
		iHD.setId_Pessoa_Registro(Utilidades.getpPL().getPessoa_Logada());
		iHD.setInscricao("");
		iHD.setInscricao_Historico_Header(iHH);
		iHD.setJuros(0);
		iHD.setLiv_Folha_Cert("");
		iHD.setTipo("");
		iHD.setProcesso("");
		iHD.setLocalizacao("");
		iHD.setMes_Ref(Utilidades.retornaMes());
		iHD.setMulta(0);
		iHD.setnParcelamento("");
		iHD.setPago(Enum_Aux_Sim_ou_Nao.NAO);
		iHD.setParAberto("");
		iHD.setRadicalDam("");
		iHD.setSeq("");
		iHD.setTotal(0);
		iHD.setTributos("");
		iHD.setUltimaAtualizacao(Utilidades.retornaCalendario());
		iHD.setEnum_Aux_Tipo_Conferencia(e);
		iHD.setValor(0);
		return iHD;
	}

}

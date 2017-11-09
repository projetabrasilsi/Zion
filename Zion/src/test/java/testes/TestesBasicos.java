package testes;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import model.dao.InscricaoDAO;
import model.dao.Inscricao_HistoricoDAO;
import model.dao.PessoaDAO;
import model.entities.Inscricao;
import model.entities.Inscricao_Historico;
import model.entities.Pessoa;
import model.enums.Enum_Aux_Servicos_Classificacoes;
import model.enums.Enum_Aux_Servicos_Sub_Classificacoes;
import model.enums.Enum_Aux_Sim_ou_Nao;
import util.Utilidades;

public class TestesBasicos {
	@SuppressWarnings("static-access")
	@Test
	public void testando() {

		String request = "http://www.pmf.sc.gov.br/cgi-bin/tm38220.sh";

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("SEFIN", "0");
		map.put("inscricao", "52120910247090070");
		map.put("nu_pess", "99950375991");
		map.put("submit", "Consultar");
		Document doc = null;

		try {
			doc = Jsoup.connect(request).data(map).followRedirects(false).timeout(5000).post();
			String title = doc.body().text();

			InputStream is = new ByteArrayInputStream(title.getBytes());
			// read it with BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String proprietario = "SUJEITO PASSIVO      :";
			String nInscricao = "INSCRICAO MUNICIPAL  :";
			String endereco = "LOCALIZACAO IMOVEL   :";
			String cpf_Cnpj = "NP/CPF/CGC           :";
			
			String anual = "ANUAL";
			int seq = 5;
			int radicalDam = 9;
			int tributos = 17;
			int processo = 13;
			int parAberto = 36;
			int valor = 14;
			int multa = 12;
			int juros = 12;
			int total = 13;
			String seqStr = "";
			String radicalDamStr = "";
			String tributosStr = "";
			String processoStr = "";
			String parAbertoStr = "";
			String valorStr = "";
			String multaStr = "";
			String jurosStr = "";
			String totalStr = "";
			Inscricao_Historico iH = new Inscricao_Historico();
			List<Inscricao_Historico> iHLista = new ArrayList<>();
			Inscricao insc = new Inscricao();
			Inscricao_HistoricoDAO iHDAO = new Inscricao_HistoricoDAO();
			InscricaoDAO iDAO = new InscricaoDAO();
			PessoaDAO pDAO = new PessoaDAO();
			

			String line;
			
			while ((line = br.readLine()) != null) {				
				
				if (line.contains(proprietario))
					proprietario = line.substring(proprietario.length() + 1, line.length());
				else if (line.contains(nInscricao))
					nInscricao = line.substring(nInscricao.length() + 1, line.length());
				else if (line.contains(endereco))
					endereco = line.substring(endereco.length() + 1, line.length());
				else if (line.contains(cpf_Cnpj))
					cpf_Cnpj = line.substring(cpf_Cnpj.length() + 1, line.length());				
				else if (line.contains(anual)) {
					String montagem="";					
		            int tam = 0;
		            seqStr = line.substring(0,seq);
		            montagem=seqStr;
		            tam = montagem.length();		            
		            radicalDamStr = line.substring(tam,tam+radicalDam);
		            montagem+=radicalDamStr;
		            tam = montagem.length();
		            tributosStr = line.substring(tam,tam+tributos);
		            montagem+=tributosStr;
		            tam = montagem.length();
		            processoStr = line.substring(tam,tam+processo);
		            montagem+=processoStr;
		            tam = montagem.length();
		            parAbertoStr = line.substring(tam,tam+parAberto);
		            montagem+=parAbertoStr;
		            tam = montagem.length();
		            valorStr = line.substring(tam,tam+valor);
		            montagem+=valorStr;
		            tam = montagem.length();
		            multaStr = line.substring(tam,tam+multa);
		            montagem+=multaStr;
		            tam = montagem.length();
		            jurosStr = line.substring(tam,tam+juros);
		            montagem+=jurosStr;
		            tam = montagem.length();
		            totalStr = line.substring(tam,tam+total);
		            montagem+=totalStr;
		            tam = montagem.length();
					

					
					
					insc.setnInsc(map.get("inscricao"));					
					Pessoa p = pDAO.retornaPessoaPelocpf_Cnpj("27470300000190");
					insc.setId_Mestre(p);
					insc.setEnum_Aux_Servicos_Classificacoes(Enum_Aux_Servicos_Classificacoes.IPTU);
					insc = iDAO.verificaSeExiste(insc);
					insc.setDados_Base("");
					insc.setEndereco(endereco);
					insc.setProprietario(proprietario);
					insc = iDAO.merge(insc);

					Inscricao_Historico iHConf = new Inscricao_Historico();
					iHConf.setId_Inscricao(insc);
					radicalDamStr=Utilidades.retiraVazios(radicalDamStr);
					iHConf.setRadicalDam(radicalDamStr);
					iHConf.setEnum_Aux_Servicos_Sub_Classificacoes(
							Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS);
					iHConf.setParAberto(Utilidades.transformaemInteiro(parAbertoStr));
					
					iHConf = iHDAO.verificaSeExistePeloRadicalDam(iHConf);

					if (iHConf == null) {
						iH.setAno_Ref(Utilidades.retornaAno());
						iH.setMes_Ref(Utilidades.retornaMes());
						iH.setId_Empresa(1);
						iH.setId_Inscricao(insc);
						iH.setEnum_Aux_Servicos_Sub_Classificacoes(
								Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS);
						p = pDAO.retornaPessoaPelocpf_Cnpj("89230906115");

						iH.setId_Pessoa_Registro(p);
						double vl = Utilidades.transformaemMoeda(valorStr);
						double mt = Utilidades.transformaemMoeda(multaStr);
						double jr = Utilidades.transformaemMoeda(jurosStr);
						double tt = Utilidades.transformaemMoeda(totalStr);
						iH.setJuros(jr);
						iH.setPago(Enum_Aux_Sim_ou_Nao.NAO);
						iH.setMulta(mt);
						iH.setParAberto(Utilidades.transformaemInteiro(parAbertoStr));
						iH.setProcesso(Utilidades.retiraVazios(processoStr));
						iH.setRadicalDam(Utilidades.retiraVazios(radicalDamStr));
						iH.setSeq(Utilidades.retiraVazios(seqStr));
						iH.setTotal(tt);
						iH.setTributos(Utilidades.retiraVazios(tributosStr));
						iH.setUltimaAtualizacao(Utilidades.retornaCalendario());
						iH.setValor(vl);
						iH = iHDAO.merge(iH);
						iHLista.add(iH);
					}
				}
			}
			br.close();
			
			if(iHLista.size()>0) {				
				Inscricao_Historico iHConf = new Inscricao_Historico();
				insc.setnInsc(map.get("inscricao"));					
				Pessoa p = pDAO.retornaPessoaPelocpf_Cnpj("27470300000190");
				insc.setId_Mestre(p);
				insc.setEnum_Aux_Servicos_Classificacoes(Enum_Aux_Servicos_Classificacoes.IPTU);
				insc = iDAO.verificaSeExiste(insc);
				
				iHConf.setId_Inscricao(insc);		
				iHConf.setPago(Enum_Aux_Sim_ou_Nao.NAO);
				iHConf.setEnum_Aux_Servicos_Sub_Classificacoes(
						Enum_Aux_Servicos_Sub_Classificacoes.CONFERENCIA_DEBITOS);
				List<Inscricao_Historico> iHListaCompleta  =iHDAO.reTornaLista(iHConf);
				iHListaCompleta.removeAll(iHLista);
				// pega a relação que existe atuamente que acabou de ser consultada
				// retira esta relação(que está em aberta) da lista que está no banco de dados
				// fica só o restante que foi pago
				// DAR BAIXA
				for (Inscricao_Historico iH1 : iHListaCompleta) {
					iH1.setPago(Enum_Aux_Sim_ou_Nao.SIM);
					iHDAO.merge(iH1);
				}
			}
			

		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// BufferedReader in = new BufferedReader(new FileReader("BDParaTeste.txt")); //
		// declara o nome do arquivo

	}
}

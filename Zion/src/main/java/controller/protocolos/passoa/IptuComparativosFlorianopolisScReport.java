package controller.protocolos.passoa;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.entities.ProtocolosdeServicos;
import model.entities.ProtocolosdeServicos_Detalhe;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import util.Utilidades;

public class IptuComparativosFlorianopolisScReport {
	public void gerarrelatorioAnalitico(ProtocolosdeServicos pS, List<ProtocolosdeServicos_Detalhe> pSDs)
			throws JRException {
		InputStream fonte = IptuComparativosFlorianopolisScReport.class
				.getResourceAsStream("/MyReports/protocolosiptucomparativosflorianopolis_sc.jrxml");
		JasperReport report = JasperCompileManager.compileReport(fonte);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("tituloPar", pS.getEnum_Aux_Servicos_Composicoes().getDescricao2());		
		JasperPrint print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(pSDs));
		JasperViewer.viewReport(print, false);
	}

	public void gerarrelatorioSintetico(ProtocolosdeServicos pS) throws JRException {
		InputStream fonte = IptuComparativosFlorianopolisScReport.class
				.getResourceAsStream("/MyReports/protocolosiptucomparativosflorianopolis_scSintetico.jrxml");
		JasperReport report = JasperCompileManager.compileReport(fonte);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("tituloPar", pS.getEnum_Aux_Servicos_Composicoes().getDescricao2());
		parametros.put("lb_nTotalReg", "Total");
		parametros.put("lb_nTotalReg_Value", pS.getnTotalReg());
		parametros.put("lb_nTotalRegPerc_Value", 1.0);
		parametros.put("lb_nRegAnt", "Total " + pS.getAnoAnt());
		parametros.put("lb_nRegAnt_Value", pS.getnRegAnt());
		parametros.put("lb_nRegAntPerc_Value", pS.getnRegAntPerc());
		parametros.put("lb_TotAnt_Value", pS.getVlTotAnt());
		parametros.put("lb_nRegAtual", "Total " + pS.getAnoAtual());
		parametros.put("lb_nRegAtual_Value", pS.getnRegAtual());
		parametros.put("lb_nRegAtualPerc_Value", pS.getnRegAtualPerc());
		parametros.put("lb_TotAtual_Value", pS.getVlTotAtual());
		parametros.put("lb_nRegSomenteAtual", "Novos " + pS.getAnoAtual());
		parametros.put("lb_nRegSomenteAtual_Value", pS.getnRegSomenteAtual());
		parametros.put("lb_nRegSomenteAtualPerc_Value", pS.getNovosPercentual());
		parametros.put("lb_TotSomenteAnt_Value", pS.getVlTotSomenteAnt());
		parametros.put("lb_nRegSomenteAnterior", "Perdas " + pS.getAnoAnt());
		parametros.put("lb_nRegSomenteAnt_Value", pS.getnRegSomenteAnt());
		parametros.put("lb_nRegSomenteAntPerc_Value", pS.getPerdaPercentual());
		parametros.put("lb_TotSomenteAtual_Value", pS.getVlTotSomenteAtual());
		parametros.put("lb_nRegAtualExistentenoAnt", "Permaneceram em: " + pS.getAnoAnt() + "/" + pS.getAnoAtual());
		parametros.put("lb_nRegPermanentes_Value", pS.getnRegPermanentes());
		parametros.put("lb_PermanenciaPerc_Value", pS.getPermaneceuPercentual());
		parametros.put("lb_TotPermaneceu_Value", pS.getVlTotPermaneceu());
		parametros.put("lb_nRegAumentouValor", "Aumentaram");
		parametros.put("lb_nRegAumentouValor_Value", pS.getnRegAumentouValor());
		parametros.put("lb_nRegAumentouValorPerc_Value", pS.getnRegAumentouValorPerc());
		parametros.put("lb_TotAumentouValor_Value", pS.getVlTotAumentou());
		parametros.put("lb_DifInflacao", "Dif. Correção");
		parametros.put("lb_DifInflacao_Value", pS.getVlTotDifInflacao());
		parametros.put("lb_nRegDiminuiValor", "Diminuiram");
		parametros.put("lb_nRegDiminuiValor_Value", pS.getnRegDiminuiValor());
		parametros.put("lb_nRegDiminuiuValorPerc_Value", pS.getnRegDiminuiValorPerc());
		parametros.put("lb_TotDiminuiValor_Value", pS.getVlTotDiminuiu());
		parametros.put("lb_DifDeflacao", "Dif. Correção");
		parametros.put("lb_DifDeflanflacao_Value", pS.getVlTotDifDeflacao());
		parametros.put("lb_nRegPermaneceuValor", "Mantiveram valor: ");
		parametros.put("lb_nRegPermaneceuValor_Value", pS.getnRegPermaneceuValor());
		parametros.put("lb_nRegPermaneceuValorPerc_Value", pS.getnRegPermaneceuValorPerc());
		parametros.put("lb_TotPermaneceuValor_Value", pS.getVlTotPermaneceuValor());
		parametros.put("lb_Crescimento", "Crescimento");
		parametros.put("lb_Crescimento_Value", pS.getCrescimento());
		parametros.put("lb_CrescimentoPerc_Value", pS.getCrescimentoPercentual());
		parametros.put("lb_nCarteiraMais", "Cateira(+)");
		parametros.put("lb_DifCorrecaoMais", "Dif. Correção");
		parametros.put("lb_CarteiraDiferencaInflacao", pS.getVlTotDifInflacao());
		parametros.put("lb_NovosClientesMais", "Novos Clientes");
		parametros.put("lb_CarteiraClientesNovos", pS.getVlTotSomenteAtual());
		parametros.put("lb_CarteiraResultadoA", pS.getCarteiraResultadoA());
		parametros.put("lb_CarteiraMenos", "Cateira(-)");
		parametros.put("lb_DifCorrecaoMenos", "Dif. Correção");
		parametros.put("lb_CarteiraDiferencaDeflacao", pS.getVlTotDifDeflacao());
		parametros.put("lb_NovosClientesMenos", "Perdas");
		parametros.put("lb_CarteiraClientesBaixados", pS.getVlTotSomenteAnt());
		parametros.put("lb_CarteiraResultadoB", pS.getCarteiraResultadoB());
		parametros.put("lb_CarteiraResultadoFinal", pS.getCarteiraResultadoFinal());
		parametros.put("lb_CarteiraResultadoPercentualFinal", pS.getCarteiraResultadoPercentualFinal());
		parametros.put("lb_Id", "N. Protocolo");
		parametros.put("lb_Id_Value", pS.getId());
		parametros.put("lb_Ultima_Alteracao", "Data Requisição");
		try {
			parametros.put("lb_Ultima_Alteracao_Value",
					Utilidades.transformaDataEmString(pS.getUltimaAtualizacao(), true));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		parametros.put("lb_Resp_Registro", "Responsável");
		parametros.put("lb_Resp_Registro_Value", pS.getId_Pessoa_Registro().getDescricao());
		parametros.put("lb_CrescimentoEmQuantidade", "Crescimento em Qtde");
		parametros.put("lb_CrescimentoEmQuantidadePerc", "Crescimento em Qtde Perc");
		parametros.put("CrescimentoEmQuantidade", pS.getCrescimento());
		parametros.put("CrescimentoEmQuantidadePerc", pS.getCrescimentoPercentual());
		parametros.put("lb_TotalRegistros", "Total Registros para Análise");
		parametros.put("atual", "Atual");
		parametros.put("anterior", "Anterior");
		parametros.put("resultado", "Resultado");
		parametros.put("permaneceram", "Permaneceram");
		List<ProtocolosdeServicos> lista = new ArrayList<>();
		lista.add(pS);
		JasperPrint print = JasperFillManager.fillReport(report, parametros, new JRBeanCollectionDataSource(lista));
		JasperViewer jv = new JasperViewer(print, false);
		jv.setVisible(true);
	}
}

package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.entities.Inscricao_Historico_Detalhe;
import util.HibernateUtil;

public class Inscricao_Historico_DetalheDAO extends GenericDAO<Inscricao_Historico_Detalhe> {

	public Inscricao_Historico_Detalhe verificaSeExiste(Inscricao_Historico_Detalhe iHD) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
		Criteria crit = sessao.createCriteria(Inscricao_Historico_Detalhe.class);
		
		crit.add(Restrictions.eq("id_Inscricao",iHD.getId_Inscricao()));		
		crit.add(Restrictions.eq("inscricao_Historico_Header",iHD.getInscricao_Historico_Header()));
		crit.add(Restrictions.eq("enum_Aux_Servicos_Sub_Classificacoes", iHD.getEnum_Aux_Servicos_Sub_Classificacoes()));
		if(iHD.getEnum_Aux_Tipo_Conferencia() != null)
			crit.add(Restrictions.eq("enum_Aux_Tipo_Conferencia", iHD.getEnum_Aux_Tipo_Conferencia()));
		if(iHD.getAno_Ref()>0)
			crit.add(Restrictions.eq("ano_Ref", iHD.getAno_Ref()));
		if(iHD.getMes_Ref()>0)
			crit.add(Restrictions.eq("mes_Ref", iHD.getMes_Ref()));
		if(iHD.getRadicalDam().length()>0)
			crit.add(Restrictions.eq("radicalDam", iHD.getRadicalDam()));
		if(iHD.getDam().length()>0)
			crit.add(Restrictions.eq("dam", iHD.getDam()));
			
		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		 crit.setFirstResult(0);
		crit.setMaxResults(1);
		iHD = (Inscricao_Historico_Detalhe) crit.uniqueResult();
		}catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		
		return iHD;
	}
	
	public Inscricao_Historico_Detalhe verificaSeExistePeloRadicalDam(Inscricao_Historico_Detalhe insc_Hist_Detalhe) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
		Criteria crit = sessao.createCriteria(Inscricao_Historico_Detalhe.class);
		
		crit.add(Restrictions.eq("id_Inscricao",insc_Hist_Detalhe.getId_Inscricao()));
		crit.add(Restrictions.eq("enum_Aux_Servicos_Sub_Classificacoes", insc_Hist_Detalhe.getEnum_Aux_Servicos_Sub_Classificacoes()));		
		crit.add(Restrictions.eq("radicalDam", insc_Hist_Detalhe.getRadicalDam()));
		crit.add(Restrictions.eq("parAberto", insc_Hist_Detalhe.getParAberto()));
		
			
		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		 crit.setFirstResult(0);
		crit.setMaxResults(1);
		insc_Hist_Detalhe = (Inscricao_Historico_Detalhe) crit.uniqueResult();
		}catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		
		return insc_Hist_Detalhe;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inscricao_Historico_Detalhe> reTornaLista(Inscricao_Historico_Detalhe insc_Hist_Detalhe) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Inscricao_Historico_Detalhe> lista = null;
		
		try {
		Criteria crit = sessao.createCriteria(Inscricao_Historico_Detalhe.class);
		
		crit.add(Restrictions.eq("id_Inscricao",insc_Hist_Detalhe.getId_Inscricao()));
		crit.add(Restrictions.eq("enum_Aux_Servicos_Sub_Classificacoes", insc_Hist_Detalhe.getEnum_Aux_Servicos_Sub_Classificacoes()));		
		crit.add(Restrictions.eq("pago", insc_Hist_Detalhe.getPago()));		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		 
		
		lista =  crit.list();
		}catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inscricao_Historico_Detalhe> listagem(Inscricao_Historico_Detalhe insc_Hist_Detalhe) {
		List<Inscricao_Historico_Detalhe> lista = null;
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
		Criteria crit = sessao.createCriteria(Inscricao_Historico_Detalhe.class);
		crit.add(Restrictions.like("id_Inscricao",insc_Hist_Detalhe.getId_Inscricao()));
		crit.add(Restrictions.eq("enum_Aux_Servicos_Sub_Classificacoes", insc_Hist_Detalhe.getEnum_Aux_Servicos_Sub_Classificacoes()));
		crit.addOrder(Order.desc("ano_Ref"));
			
		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		 crit.setFirstResult(0);
		crit.setMaxResults(1);
		lista = crit.list();
		}catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		
		return lista;
	}
}

package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.entities.Inscricao_Historico;
import util.HibernateUtil;

public class Inscricao_HistoricoDAO extends GenericDAO<Inscricao_Historico> {

	public Inscricao_Historico verificaSeExiste(Inscricao_Historico insc_Hist) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
		Criteria crit = sessao.createCriteria(Inscricao_Historico.class);
		
		crit.add(Restrictions.eq("id_Inscricao",insc_Hist.getId_Inscricao()));
		crit.add(Restrictions.eq("enum_Aux_Servicos_Sub_Classificacoes", insc_Hist.getEnum_Aux_Servicos_Sub_Classificacoes()));
		if(insc_Hist.getAno_Ref()>0)
			crit.add(Restrictions.eq("ano_Ref", insc_Hist.getAno_Ref()));
		if(insc_Hist.getMes_Ref()>0)
			crit.add(Restrictions.eq("mes_Ref", insc_Hist.getMes_Ref()));
			
		
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		 crit.setFirstResult(0);
		crit.setMaxResults(1);
		insc_Hist = (Inscricao_Historico) crit.uniqueResult();
		}catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		
		return insc_Hist;
	}
	
	@SuppressWarnings("unchecked")
	public List<Inscricao_Historico> listagem(Inscricao_Historico insc_Hist) {
		List<Inscricao_Historico> lista = null;
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
		Criteria crit = sessao.createCriteria(Inscricao_Historico.class);
		crit.add(Restrictions.like("id_Inscricao",insc_Hist.getId_Inscricao()));
		crit.add(Restrictions.eq("enum_Aux_Servicos_Sub_Classificacoes", insc_Hist.getEnum_Aux_Servicos_Sub_Classificacoes()));
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

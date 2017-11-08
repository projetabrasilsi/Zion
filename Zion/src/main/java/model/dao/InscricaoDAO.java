package model.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.entities.Inscricao;
import util.HibernateUtil;

public class InscricaoDAO extends GenericDAO<Inscricao> {
	
	public Inscricao verificaSeExiste(Inscricao insc) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
		Criteria crit = sessao.createCriteria(Inscricao.class);
		crit.add(Restrictions.like("nInsc",insc.getnInsc()));
		crit.add(Restrictions.eq("enum_Aux_Servicos_Classificacoes", insc.getEnum_Aux_Servicos_Classificacoes()));
		crit.add(Restrictions.eq("id_Mestre",insc.getId_Mestre()));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		 crit.setFirstResult(0);
		crit.setMaxResults(1);
		insc = (Inscricao) crit.uniqueResult();
		}catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		
		return insc;
		
		
		
	}

}

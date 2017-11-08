package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.entities.ProtocolosdeServicos_Detalhe;
import model.entities.ProtocolosdeServicos_Detalhe_Comparativo;
import util.HibernateUtil;

public class ProtocolosdeServicos_Detalhe_ComparativoDAO extends GenericDAO<ProtocolosdeServicos_Detalhe_Comparativo> {
	@SuppressWarnings("unchecked")
	public List<ProtocolosdeServicos_Detalhe_Comparativo> retornaListadetalheComparativo(
			ProtocolosdeServicos_Detalhe id_ProtocolosdeServicos_Detalhe) {
		List<ProtocolosdeServicos_Detalhe_Comparativo> lista = null;
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria crit = sessao.createCriteria(ProtocolosdeServicos_Detalhe_Comparativo.class);

		crit.add(Restrictions.eq("id_ProtocolosdeServicos_Detalhe", id_ProtocolosdeServicos_Detalhe));
		crit.addOrder(Order.desc("ano"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		lista = crit.list();
		return lista;
	}

	public ProtocolosdeServicos_Detalhe_Comparativo verificaseExistedetalheComparativo(
			ProtocolosdeServicos_Detalhe_Comparativo pDC) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria crit = sessao.createCriteria(ProtocolosdeServicos_Detalhe.class);

		crit.add(Restrictions.eq("id_ProtocolosdeServicos_Detalhe", pDC.getId_ProtocolosdeServicos_Detalhe()));
		crit.add(Restrictions.eq("ano", pDC.getAno()));

		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.setFirstResult(0);
		crit.setMaxResults(1);
		pDC = (ProtocolosdeServicos_Detalhe_Comparativo) crit.uniqueResult();
		return pDC;
	}

	
}

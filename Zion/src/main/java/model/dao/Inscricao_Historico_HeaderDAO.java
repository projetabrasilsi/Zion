package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.entities.Inscricao_Historico_Header;
import util.HibernateUtil;

public class Inscricao_Historico_HeaderDAO extends GenericDAO<Inscricao_Historico_Header> {

	public Inscricao_Historico_Header verificaSeExiste(Inscricao_Historico_Header iHH) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria crit = sessao.createCriteria(Inscricao_Historico_Header.class);

			crit.add(Restrictions.eq("id_Inscricao", iHH.getId_Inscricao()));
			crit.add(Restrictions.eq("enum_Aux_Tipo_Conferencia", iHH.getEnum_Aux_Tipo_Conferencia()));
			crit.add(Restrictions.eq("ano_Consulta", iHH.getAno_Consulta()));
			crit.add(Restrictions.eq("mes_Consulta", iHH.getMes_Consulta()));

			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			crit.setFirstResult(0);
			crit.setMaxResults(1);
			iHH = (Inscricao_Historico_Header) crit.uniqueResult();
		} catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}

		return iHH;
	}

	@SuppressWarnings("unchecked")
	public List<Inscricao_Historico_Header> reTornaLista(Inscricao_Historico_Header iHH) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Inscricao_Historico_Header> lista = null;

		try {
			Criteria crit = sessao.createCriteria(Inscricao_Historico_Header.class);
			crit.add(Restrictions.eq("id_Inscricao", iHH.getId_Inscricao()));
			crit.add(Restrictions.eq("ano_Consulta", iHH.getAno_Consulta()));
			crit.add(Restrictions.eq("mes_Consulta", iHH.getMes_Consulta()));
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			lista = crit.list();
		} catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}

		return lista;
	}

}

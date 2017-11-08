package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import model.entities.ProtocolosdeServicos;
import model.entities.ProtocolosdeServicos_Detalhe;
import util.HibernateUtil;

public class ProtocolosdeServicos_DetalheDAO extends GenericDAO<ProtocolosdeServicos_Detalhe> {

	@SuppressWarnings("unchecked")
	public List<ProtocolosdeServicos_Detalhe> retornadetalhe(ProtocolosdeServicos id_ProtocolosdeServicos) {
		List<ProtocolosdeServicos_Detalhe> lista = null;
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria crit = sessao.createCriteria(ProtocolosdeServicos_Detalhe.class);

			crit.add(Restrictions.eq("id_ProtocolosdeServicos", id_ProtocolosdeServicos));
			crit.addOrder(Order.asc("contador"));
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

	
	public int retornadetalheTotalRegistros(ProtocolosdeServicos id_ProtocolosdeServicos,
			boolean total, boolean totalAnt, boolean totalAtual,   boolean somenteAnt, 
			boolean somenteAtual, boolean ambos, boolean aumentou, boolean diminuiu, boolean permaneceu) {
		int registro = 0; 
		Long i = Long.parseLong("0");		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria crit = sessao.createCriteria(ProtocolosdeServicos_Detalhe.class);

			crit.add(Restrictions.eq("id_ProtocolosdeServicos", id_ProtocolosdeServicos));
			if(total) {
				
				
			}	
			if(totalAnt) {
				crit.add(Restrictions.sqlRestriction("valorAnt >0 "));
				
			}
			if(totalAtual) {
				crit.add(Restrictions.sqlRestriction("valorAtual >0 "));
				
			}
			
			if(somenteAnt) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual = 0 "));
				
			}			
			if(somenteAtual) {
				crit.add(Restrictions.sqlRestriction("valorAnt = 0 and valorAtual >0 "));
				
			}
			if(ambos) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual >0 "));
				
				
			}
			
			if(aumentou) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual >0 "));
				crit.add(Restrictions.sqlRestriction("valorAtual > valorAnt"));
				
				
			}
			if(diminuiu) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual >0 "));
				crit.add(Restrictions.sqlRestriction("valorAtual < valorAnt"));
				
			}
			if(permaneceu) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual >0 "));
				crit.add(Restrictions.sqlRestriction("valorAtual = valorAnt"));
				
			}
			

			crit.setProjection(Projections.rowCount());
			
			String resultado = ""+ crit.uniqueResult();
			
			if(!resultado.equals("null"))
				i =  (Long)   crit.uniqueResult();
			else
				i = 0L;
			

			
			
			
			registro = (int) (double) i;
		} catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		return registro;
	}
	
	public double retornadetalheTotalRegistrosEmValor(ProtocolosdeServicos id_ProtocolosdeServicos,boolean total, boolean totalAnt, boolean totalAtual,  
			boolean somenteAnt, boolean somenteAtual, boolean ambos, boolean aumentou, 
			boolean diminuiu, boolean permaneceu,boolean atualizado,boolean DifInflacao,  boolean DifDeflacao) {
		double registro = 0; 
		 
				
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria crit = sessao.createCriteria(ProtocolosdeServicos_Detalhe.class);

			crit.add(Restrictions.eq("id_ProtocolosdeServicos", id_ProtocolosdeServicos));
			if(total) {
				
			}	
			if(totalAnt) {
				crit.add(Restrictions.sqlRestriction("valorAnt >0 "));
				crit.setProjection(Projections.sum("valorAnt"));
			}
			if(totalAtual) {
				crit.add(Restrictions.sqlRestriction("valorAtual >0 "));
				if(atualizado)
				crit.setProjection(Projections.sum("valorAtual"));
				else
					crit.setProjection(Projections.sum("valorAnt"));
			}
			
			if(somenteAnt) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual = 0 "));
				crit.setProjection(Projections.sum("valorAnt"));
			}			
			if(somenteAtual) {
				crit.add(Restrictions.sqlRestriction("valorAnt = 0 and valorAtual >0 "));
				if(atualizado)
				crit.setProjection(Projections.sum("valorAtual"));
				else
					crit.setProjection(Projections.sum("valorAnt"));
				
			}
			if(ambos) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual >0 "));
				if(atualizado)
				crit.setProjection(Projections.sum("valorAtual"));
				else
					crit.setProjection(Projections.sum("valorAnt"));
			}
			
			if(aumentou) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual >0 "));
				crit.add(Restrictions.sqlRestriction("valorAtual > valorAnt"));
				crit.setProjection(Projections.sum("valorAtual"));
				
			}
			if(diminuiu) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual >0 "));
				crit.add(Restrictions.sqlRestriction("valorAtual < valorAnt"));
				crit.setProjection(Projections.sum("valorAtual"));
			}
			if(permaneceu) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual >0 "));
				crit.add(Restrictions.sqlRestriction("valorAtual = valorAnt"));
				crit.setProjection(Projections.sum("valorAtual"));
			}
			
			if(DifInflacao) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual > 0 and valorAnt<ValorAtual"));
				
				crit.setProjection(Projections.sum("diferenca"));
				
			}
			if(DifDeflacao) {
				crit.add(Restrictions.sqlRestriction("valorAnt > 0 and valorAtual > 0 and valorAnt>ValorAtual"));				
				crit.setProjection(Projections.sum("diferenca"));
				
			}
			String resultado = ""+ crit.uniqueResult();
			
			if(!resultado.equals("null"))
			registro =  (Double)   crit.uniqueResult();
			else
				registro = 0;
			
		} catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		return registro;
	}

	public ProtocolosdeServicos_Detalhe verificaseExistedetalhe(ProtocolosdeServicos_Detalhe pd) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Criteria crit = sessao.createCriteria(ProtocolosdeServicos_Detalhe.class);

			crit.add(Restrictions.eq("id_ProtocolosdeServicos", pd.getId_ProtocolosdeServicos()));
			crit.add(Restrictions.eq("id_Inscricao", pd.getId_Inscricao()));

			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			crit.setFirstResult(0);
			crit.setMaxResults(1);
			pd = (ProtocolosdeServicos_Detalhe) crit.uniqueResult();
		} catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		return pd;
	}

}

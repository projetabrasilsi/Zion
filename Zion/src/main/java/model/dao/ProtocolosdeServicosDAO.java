package model.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.entities.Pessoa;
import model.entities.ProtocolosdeServicos;
import model.enums.Enum_Aux_Navegadores;
import model.enums.Enum_Aux_Servicos_Composicoes;
import util.HibernateUtil;

public class ProtocolosdeServicosDAO extends GenericDAO<ProtocolosdeServicos> {
	public ProtocolosdeServicos Navegar(Enum_Aux_Navegadores nav, Pessoa id_Mestre,
			Enum_Aux_Servicos_Composicoes enum_Aux_Servicos_Composicoes, ProtocolosdeServicos atual) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria crit = sessao.createCriteria(ProtocolosdeServicos.class);
		ProtocolosdeServicos prot = null;
		
		try {
			crit.add(Restrictions.eq("id_Mestre", id_Mestre));
			crit.add(Restrictions.eq("enum_Aux_Servicos_Composicoes", enum_Aux_Servicos_Composicoes));
			switch (nav){
			case INICIO:
				crit.addOrder(Order.asc("id"));
				break;
			case FIM:
				crit.addOrder(Order.desc("id"));
				break;
				
			case ANTERIOR:
				if(atual!=null) {
				crit.add(Restrictions.lt("id", atual.getId()));				
				crit.addOrder(Order.desc("id"));
				}else
					crit.addOrder(Order.asc("id"));
			
				break;
			case PROXIMO:		
				if(atual!=null) {
				crit.add(Restrictions.gt("id", atual.getId()));
				crit.addOrder(Order.asc("id"));
				}else
					crit.addOrder(Order.desc("id"));
					
				break;
			default:
				crit.addOrder(Order.desc("id"));
				break;
			}
			 crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			 crit.setFirstResult(0);
			 crit.setMaxResults(1);
			 prot = (ProtocolosdeServicos) crit.uniqueResult();
			 if(prot == null ) {
				 if(nav.equals(Enum_Aux_Navegadores.ANTERIOR))					 
				 prot = NavegarInicioFim(Enum_Aux_Navegadores.INICIO, id_Mestre, enum_Aux_Servicos_Composicoes, prot);
				 else
					 if(nav.equals(Enum_Aux_Navegadores.PROXIMO))
						 prot = NavegarInicioFim(Enum_Aux_Navegadores.FIM, id_Mestre, enum_Aux_Servicos_Composicoes, prot);
			 }
			 
		} catch (RuntimeException error) {
			error.printStackTrace();
		} finally {
			sessao.close();
		}
		return prot;
	}
	
	
	public ProtocolosdeServicos NavegarInicioFim(Enum_Aux_Navegadores nav, Pessoa id_Mestre,
			Enum_Aux_Servicos_Composicoes enum_Aux_Servicos_Composicoes, ProtocolosdeServicos atual) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria crit = sessao.createCriteria(ProtocolosdeServicos.class);
		ProtocolosdeServicos prot = null;
		
		try {
			crit.add(Restrictions.eq("id_Mestre", id_Mestre));
			crit.add(Restrictions.eq("enum_Aux_Servicos_Composicoes", enum_Aux_Servicos_Composicoes));
			switch (nav){
			case INICIO:
				crit.addOrder(Order.asc("id"));
				break;
			case FIM:
				crit.addOrder(Order.desc("id"));
				break;				
			default:
				crit.addOrder(Order.desc("id"));
				break;
			}
			 crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			 crit.setFirstResult(0);
			 crit.setMaxResults(1);
			 prot = (ProtocolosdeServicos) crit.uniqueResult();
			 
			 
		} catch (RuntimeException error) {
			error.printStackTrace();
		} finally {
			sessao.close();
		}
		return prot;
	}
	
	
	
	

}

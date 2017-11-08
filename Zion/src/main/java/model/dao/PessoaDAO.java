package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;


import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.enums.Enum_Aux_Navegadores;
import model.outros.Perfil_Pessoa_Logada;
import util.HibernateUtil;

public class PessoaDAO extends GenericDAO<Pessoa> {

	@SuppressWarnings("unchecked")
	public List<Pessoa> listagem(String descricao, Perfil_Pessoa_Logada pPL) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria crit = sessao.createCriteria(Pessoa.class);
		crit.add(Restrictions.like("descricao", descricao));
		crit.addOrder(Order.asc("id"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		if (pPL.getFormulario_Atual().getPerfil_Pessoa() != null) {
			crit.createCriteria("Pessoa_Enum_Aux_Perfil_Pessoa", "pP");
			crit.add(Restrictions.eq("pP.", pPL.getFormulario_Atual().getPerfil_Pessoa()));

			if (pPL.getFormulario_Atual().isPossui_Vinculos()) {
				crit.createCriteria("Pessoa_Vinculo", "p_V");
				crit.add(Restrictions.eq("p_V.id_Pessoa_M", pPL.getEmpresa_Logada()));
			}
		}
		return crit.list();
	}

	public Pessoa retornaPessoaPelocpf_Cnpj(String cpf_Cnpj) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria crit = sessao.createCriteria(Pessoa.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			crit.add(Restrictions.eq("cpf_Cnpj", cpf_Cnpj));
			crit.setFirstResult(0);
			crit.setMaxResults(1);
			crit.addOrder(Order.asc("id"));
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

			return (Pessoa) crit.uniqueResult();
		} catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
	}
	
	public boolean existemsPessoasCadatradas() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria crit = sessao.createCriteria(Pessoa.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);			
			crit.setFirstResult(0);
			crit.setMaxResults(1);
			crit.addOrder(Order.asc("id"));
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			Pessoa p = (Pessoa) crit.uniqueResult();
			if(p!= null)
			return true;
			else
				return false;
		} catch (RuntimeException error) {
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
	}

	public Pessoa navegarPessoaPeloPerfil(Perfil_Pessoa_Logada pPL, Pessoa pAtual, Enum_Aux_Navegadores nav,
			boolean verificaStatus, boolean ativo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria crit = sessao.createCriteria(Pessoa.class, "p");
		Pessoa p = null;

		try {
			DetachedCriteria sQ = null;
			sQ = DetachedCriteria.forClass(Pessoa_Perfil_e_Vinculo.class)
				    .setProjection(Property.forName("id_Pessoa_D"));		
			sQ.add(Restrictions.eq("enum_Aux_Perfil_Pessoa",pPL.getFormulario_Atual().getPerfil_Pessoa()));
			
			if(pPL.getFormulario_Atual().getPerfil_Pessoa().isPossuiVinculo())
				if(pPL.getEmpresa_Logada() != null && pPL.getEmpresa_Logada().getId() !=null && pPL.getEmpresa_Logada().getId()>0 )
			sQ.add(Restrictions.eq("id_Pessoa_M",pPL.getEmpresa_Logada()));
				else
					sQ.add(Restrictions.isNull("id_Pessoa_M"));
			else
				sQ.add(Restrictions.isNull("id_Pessoa_M"));
				
					
			
			if (verificaStatus) {
				sQ.add(Restrictions.eq("ativo", ativo));
			}
			
			if (nav == Enum_Aux_Navegadores.INICIO) {
				crit.addOrder(Order.asc("p.id"));
			} else if (nav == Enum_Aux_Navegadores.FIM) {
				crit.addOrder(Order.desc("p.id"));
			} else if (nav == Enum_Aux_Navegadores.ANTERIOR) {
				crit.add(Restrictions.lt("p.id", pAtual.getId()));
				crit.addOrder(Order.desc("p.id"));
			}
			if (nav == Enum_Aux_Navegadores.PROXIMO) {
				crit.add(Restrictions.gt("p.id", pAtual.getId()));
				crit.addOrder(Order.asc("p.id"));
			}else
				if (nav == Enum_Aux_Navegadores.ANTERIOR) {
					crit.add(Restrictions.lt("p.id", pAtual.getId()));
					crit.addOrder(Order.asc("p.id"));
				}
		    crit.add(Restrictions.and(Subqueries.propertyIn("p.id", sQ)));
		    crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		    crit.setFirstResult(0);
			crit.setMaxResults(1);
			
			p = (Pessoa) crit.uniqueResult();
		} catch (RuntimeException error) {
			error.printStackTrace();
		} finally {
			sessao.close();
		}
		return p;

	}

}

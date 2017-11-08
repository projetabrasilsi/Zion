package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.entities.Pessoa;
import model.entities.Pessoa_Perfil_e_Vinculo;
import util.HibernateUtil;

public class Pessoa_Perfil_e_VinculoDAO extends GenericDAO<Pessoa_Perfil_e_Vinculo> {

	public Pessoa_Perfil_e_Vinculo Pessoa_Perfil_e_VinculoExiste(Pessoa_Perfil_e_Vinculo pPV, boolean ativo,
			boolean verificaStatus) {
		if (pPV.getId_Pessoa_D() == null || pPV.getId_Pessoa_D().getId() == null || pPV.getId_Pessoa_D().getId() <= 0)
			return null;

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria crit = null;
		Pessoa_Perfil_e_Vinculo resultado = null;

		try {

			crit = sessao.createCriteria(Pessoa_Perfil_e_Vinculo.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

			crit.add(Restrictions.eq("id_Pessoa_D", pPV.getId_Pessoa_D()));
			if (pPV.getId_Pessoa_M() != null)
				crit.add(Restrictions.eq("id_Pessoa_M", pPV.getId_Pessoa_M()));
			else
				crit.add(Restrictions.isNull("id_Pessoa_M"));
			if (pPV.getEnum_Aux_Perfil_Pessoa() != null)
				crit.add(Restrictions.eq("enum_Aux_Perfil_Pessoa", pPV.getEnum_Aux_Perfil_Pessoa()));
			if (verificaStatus)
				crit.add(Restrictions.eq("ativo", ativo));
			crit.setMaxResults(1);

			resultado = (Pessoa_Perfil_e_Vinculo) crit.uniqueResult();

		} catch (RuntimeException error) {
			error.printStackTrace();
		} finally {
			sessao.close();
		}
		return resultado;
	}

	public boolean existeAlguemPerfilVinculadoAoMestre(Pessoa m) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria crit = null;
		Pessoa_Perfil_e_Vinculo resultado = null;

		try {

			crit = sessao.createCriteria(Pessoa_Perfil_e_Vinculo.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			crit.add(Restrictions.eq("id_Pessoa_M", m));

			crit.setMaxResults(1);

			resultado = (Pessoa_Perfil_e_Vinculo) crit.uniqueResult();
			if (resultado != null)
				return true;

		} catch (RuntimeException error) {
			error.printStackTrace();
		} finally {
			sessao.close();
		}
		return false;
	}

	public boolean IsPessoa_Perfil_e_VinculoExiste(Pessoa_Perfil_e_Vinculo pPV, boolean ativo, boolean verificaStatus) {
		if (pPV == null || pPV.getId_Pessoa_D() == null || pPV.getId_Pessoa_D().getId() == null
				|| pPV.getId_Pessoa_D().getId() <= 0)

			return false;
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Pessoa_Perfil_e_Vinculo resultado = null;
		Criteria crit = null;

		try {
			crit = sessao.createCriteria(Pessoa_Perfil_e_Vinculo.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			crit.add(Restrictions.eq("enum_Aux_Perfil_Pessoa", pPV.getEnum_Aux_Perfil_Pessoa()));
			crit.add(Restrictions.eq("id_Pessoa_D", pPV.getId_Pessoa_D()));
			crit.add(Restrictions.eq("id_Pessoa_M", pPV.getId_Pessoa_M()));
			if (pPV.getEnum_Aux_Perfil_Pessoa() != null)
				crit.add(Restrictions.eq("enum_Aux_Perfil_Pessoa", pPV.getEnum_Aux_Perfil_Pessoa()));
			if (verificaStatus)
				crit.add(Restrictions.eq("ativo", ativo));
			crit.setMaxResults(1);
			crit.setFirstResult(0);

			resultado = (Pessoa_Perfil_e_Vinculo) crit.uniqueResult();

		} catch (RuntimeException error) {
			error.printStackTrace();
		} finally {
			sessao.close();
		}
		if (resultado != null)
			return true;
		else
			return false;

	}

	@SuppressWarnings("unchecked")
	public List<Pessoa_Perfil_e_Vinculo> Pessoa_Perfil_e_VinculoLista(Pessoa_Perfil_e_Vinculo pPV, boolean ativo,
			boolean verificaStatus) {
		if (pPV == null || pPV.getId_Pessoa_D() == null || pPV.getId_Pessoa_D().getId() == null
				|| pPV.getId_Pessoa_D().getId() <= 0)
			return null;

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria crit = null;
		List<Pessoa_Perfil_e_Vinculo> resultado = null;

		try {
			crit = sessao.createCriteria(Pessoa_Perfil_e_Vinculo.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			crit.add(Restrictions.eq("id_Pessoa_D", pPV.getId_Pessoa_D()));
			crit.add(Restrictions.eq("id_Pessoa_M", pPV.getId_Pessoa_M()));

			if (verificaStatus)
				crit.add(Restrictions.eq("ativo", ativo));
			resultado = crit.list();

		} catch (RuntimeException error) {
			error.printStackTrace();
		} finally {
			sessao.close();
		}
		return resultado;
	}

}

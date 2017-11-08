package model.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.entities.Pessoa;
import model.entities.Usuario;
import model.enums.Enum_Aux_Perfil_Pessoa;
import util.HibernateUtil;


public class UsuarioDAO extends GenericDAO<Usuario> {

	@SuppressWarnings("unused")
	public Usuario autenticar(String identificadorUsuario, String senha) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.createAlias("id_Pessoa", "p");
			consulta.add(Restrictions.eq("p.cpf_Cnpj", identificadorUsuario));
			SimpleHash hash = new SimpleHash("md5", senha);
			
			consulta.add(Restrictions.eq("senha", senha /*hash.toHex()*/));
			Usuario resultado = (Usuario) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException error) {			
			error.printStackTrace();
			throw error;
		} finally {
			sessao.close();
		}
		
		
		
	}

	public Usuario checaUsuarioCadastrado(Pessoa pessoa, String senha) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);

			consulta.add(Restrictions.eq("id_Pessoa", pessoa));

			if (senha != null && senha.length() > 0) {
				SimpleHash hash = new SimpleHash("md5", senha);
				consulta.add(Restrictions.eq("senha", hash.toHex()));
				consulta.setMaxResults(1);
				
			}

			Usuario resultado = (Usuario) consulta.uniqueResult();

			return resultado;
		} catch (RuntimeException error) {
			throw error;
		} finally {
			sessao.close();
		}
	}
	
	public Usuario buscaUsuarioPorPessoa(Pessoa pessoa) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);

			consulta.add(Restrictions.eq("id_Pessoa", pessoa));
			consulta.setMaxResults(1);
			Usuario resultado = (Usuario) consulta.uniqueResult();

			return resultado;
		} catch (RuntimeException error) {
			throw error;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unused")
	public Usuario autenticar(Pessoa estab, Enum_Aux_Perfil_Pessoa perfil) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		return null;
		
	}

	public String criptografaSenha(String senha) {
		SimpleHash hash = new SimpleHash("md5", senha);
		return hash.toHex();
	}

	public Usuario retornaUsuarioPelaPessoa(Pessoa pessoa) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.add(Restrictions.eq("id_Pessoa", pessoa));
			Usuario resultado = (Usuario) consulta.uniqueResult();

			return resultado;
		} catch (RuntimeException error) {
			throw error;
		} finally {
			sessao.close();
		}

	}

}

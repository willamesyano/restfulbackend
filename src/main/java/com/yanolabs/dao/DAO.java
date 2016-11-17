package com.yanolabs.dao;

import com.yanolabs.core.exception.DAOException;
import com.yanolabs.core.utils.AnnotationsUtil;
import com.yanolabs.dao.factory.JpaUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class DAO<E> implements Serializable {

	@Inject
	private final Class<E> classePersistente;

	private EntityManager em = JpaUtil.getEntityManager();

	AnnotationsUtil annotationsUtil = new AnnotationsUtil();

	public DAO(Class<E> classePersistente) {
		this.classePersistente = classePersistente;
	}

	/**
	 * Inclui o objeto atual na base de dados.
	 *
	 * @param objeto
	 *            a ser salvo
	 */

	public void incluir(E objeto) {
		try {
			getEntityManager().persist(objeto);
		} catch (RuntimeException e) {
			handleException(e);
		}
	}

	/**
	 * Exclui o objeto da base de dados.
	 *
	 * @param objeto
	 *            a ser removido
	 */
	public final void excluir(E objeto) {
		try {
			getEntityManager().remove(getEntityManager().merge(objeto));
		} catch (RuntimeException e) {
			handleException(e);
		}
	}

	/**
	 * Executa o merge do objeto que se encontra em memória.
	 *
	 * @param objeto
	 *            a ser realizado o merge
	 * @return objeto que foi executado o merge
	 */

	public E atualizar(E objeto) {
		try {
			objeto = getEntityManager().merge(objeto);
			return objeto;
		} catch (RuntimeException e) {
			handleException(e);
		}

		return null;
	}

	/**
	 * Busca o objeto uma vez passado sua chave como parâmetro.
	 *
	 * @param chave
	 *            identificador
	 * @return Objeto do tipo T
	 */
	public final E buscarPorChave(Integer chave) {
		E instance = null;
		try {
			instance = getEntityManager().find(getClassePersistente(), chave);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return instance;
	}

	/**
	 * Retorna o objeto da clases Criteria.
	 *
	 * @return um objeto do tipo Criteria do Hibernate
	 */
	protected final Criteria criaCriteria() {
		Session session = (Session) getEntityManager().getDelegate();
		return session.createCriteria(getClassePersistente());
	}

	/**
	 * Busca a classe persistente do objeto utilizado na classe.
	 *
	 * @return classe persistente
	 */
	protected final Class<E> getClassePersistente() {
		return classePersistente;
	}

	/**
	 * Utilizado para se utilizar o entity manager nos DAOS que herdam do DAO
	 * genérico.
	 *
	 * @return Entity manager.
	 */
	protected EntityManager getEntityManager() {
		return em;
	}

	/**
	 * Executa o flush no entity manager.
	 *
	 */
	public final void flush() {
		getEntityManager().flush();
	}

	/**
	 * Executa o flush no entity manager.
	 *
	 */
	public final void clear() {
		flush();
		getEntityManager().clear();
	}

	public E buscaPorId(int id) {
		return getEntityManager().find(getClassePersistente(), id);
	}

	public Long getTotalRegistrosEntidade() {
		Criteria criteria = criaCriteria();
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	public void beginTrasaction() {
		EntityTransaction transaction = getEntityManager().getTransaction();
		if (!transaction.isActive()) {
			transaction.begin();
		}
	}

	public void commitTrasaction() {
		EntityTransaction transaction = getEntityManager().getTransaction();
		if (transaction != null && transaction.isActive()) {
			transaction.commit();
		}
	}

	public void rollbackTrasaction() {
		EntityTransaction transaction = getEntityManager().getTransaction();
		if (transaction != null && transaction.isActive()) {
			transaction.rollback();
		}
	}

	protected void handleException(RuntimeException e) throws DAOException {
		throw new DAOException(e);
	}

	/** Método utilizado para atualizar a sessão do objeto passado como
	 * parâmetro a fim de evitar uma LazyInitializationException  
	 * @param objeto
	 */
	public void atualizaSessaoHibernate(Object objeto) {
		Session session = (Session) getEntityManager().getDelegate();
		session.update(objeto);
	}
}
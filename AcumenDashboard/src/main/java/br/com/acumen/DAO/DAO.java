package br.com.acumen.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.acumen.util.BaseEntity;

public abstract class DAO<T extends BaseEntity<PK>, PK extends Serializable> {

	protected DAO(Class<T> persistenceClass){
		this();
		this.clazz = persistenceClass;
	}
	
	public DAO() {

	}

	protected Class<T> clazz;

	@PersistenceContext(unitName = "Acumen-PU")
	protected EntityManager em;

	public void delete(T t) throws DAOException {
		try {
			this.em.remove(t);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> find(List<? extends BaseEntity<PK>> entities) throws DAOException {
		if ((entities != null) && !entities.isEmpty()) {
			return this.find((T[]) entities.toArray(new BaseEntity[0]));
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> find(PK... ids) throws DAOException {
		if ((ids == null) || (ids.length == 0)) {
			return null;
		}

		try {
			TypedQuery<T> query = this.em.createQuery("from " + this.clazz.getSimpleName() + " where id in(:ids)", this.clazz);
			query.setParameter("ids", Arrays.asList(ids));
			List<T> list = query.getResultList();

			return list;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public T find(PK id) throws DAOException {
		try {
			return this.em.find(this.clazz, id);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> find(T... entities) throws DAOException {
		if ((entities != null) && (entities.length > 0)) {
			PK[] ids = (PK[]) new Serializable[entities.length];
			for (int i = 0; i < ids.length; i++) {
				ids[i] = entities[i].getId();
			}

			return this.find(ids);
		} else {
			return null;
		}
	}

	public T insert(T t) throws DAOException {
		try {
			this.em.persist(t);
			return t;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<T> list() throws DAOException {
		try {
			TypedQuery<T> query = this.em.createQuery("from " + this.clazz.getSimpleName() + " order by id desc", clazz);
			List<T> list = query.getResultList();

			return list;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void refresh(T t) throws DAOException {
		try {
			this.em.refresh(t);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public abstract void setEntityManager(EntityManager em);

	@SuppressWarnings("unchecked")
	protected final void setInternalEntityManager(EntityManager em) {
		this.em = em;
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		if(type.getActualTypeArguments()[0] instanceof java.lang.reflect.ParameterizedType) {
			this.clazz = (Class<T>) ((java.lang.reflect.ParameterizedType)type.getActualTypeArguments()[0]).getRawType();
		} else {
			this.clazz = (Class<T>) type.getActualTypeArguments()[0];
		}
		
	}

	public T update(T t) throws DAOException {
		try {
			t = this.em.merge(t);
			return t;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
}
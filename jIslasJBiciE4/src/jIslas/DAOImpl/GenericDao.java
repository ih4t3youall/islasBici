package jIslas.DAOImpl;

import jIslas.Utils.PersistentManagerFactory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDao {
	
	private EntityManager entityManager = PersistentManagerFactory.getEntityManager();

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Object> getAll(Class tipoPersistente){
		
		EntityTransaction et = this.entityManager.getTransaction();
		et.begin();
		@SuppressWarnings("unchecked")
		List<Object> result =  (List<Object>)(this.entityManager.createQuery("from "+ tipoPersistente.getSimpleName() +" m order by m.id asc")).getResultList();
		et.commit();
		return result;
	}

	@SuppressWarnings("rawtypes")
	public Object getObjectById(Class tipoPersistente,Long id){
		EntityTransaction et = this.entityManager.getTransaction();
		et.begin();
		Object result =  this.entityManager.createQuery("from "+ tipoPersistente.getSimpleName() +" m where m.id ="+id).getSingleResult();
		et.commit();
		return result;
	}

	public void alta(Object object){
		EntityTransaction et = this.entityManager.getTransaction();
		et.begin();
		this.entityManager.persist(object);
		et.commit();
	}

	public void update(Object object){
		EntityTransaction et = this.entityManager.getTransaction();
		et.begin();
		this.entityManager.merge(object);
		et.commit();
	}
	
	public void eliminar(Object object){
		EntityTransaction et = this.entityManager.getTransaction();
		et.begin();
		this.entityManager.remove(object);
		et.commit();
	}
	
	
}

package jIslas.DAOImpl;

import jIslas.DAO.EstadisticasDAO;
import jIslas.Utils.PersistentManagerFactory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import rest.EstadisticaOperacion;

public class EstadisticasDaoImpl implements EstadisticasDAO {
	private EntityManager entityManager = PersistentManagerFactory
			.getEntityManager();

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<EstadisticaOperacion> getAll() {

		EntityTransaction et = this.entityManager.getTransaction();
		et.begin();
		@SuppressWarnings("unchecked")
		List<Object[]> result = (List<Object[]>) (this.entityManager
				.createQuery("select l.entidad, l.operacion, count(l) from  LogAuditoria as l group by l.operacion, l.entidad  order by l.entidad, l.operacion asc"))
				.getResultList();
		et.commit();
		List<EstadisticaOperacion> estadisticas = new ArrayList<EstadisticaOperacion>();
		for (Object[] r : result) {
			estadisticas.add(new EstadisticaOperacion((String) r[0],
					(String) r[1], (int) (long) r[2]));
		}

		return estadisticas;
	}

	public EstadisticaOperacion getEstadistica(String entidad, String operacion) {
		EntityTransaction et = this.entityManager.getTransaction();
		et.begin();
		@SuppressWarnings("unchecked")
		List<Object[]> result = (List<Object[]>) (this.entityManager
				.createQuery("select l.entidad, l.operacion, count(l) from  LogAuditoria as l where l.operacion = "
						+ operacion
						+ " and l.entidad='"
						+ entidad
						+ "' group by l.operacion, l.entidad  order by l.entidad, l.operacion asc"))
				.getResultList();
		et.commit();
		EstadisticaOperacion estadistica = null;
		Object[] r = result.get(0);
		if (result != null && !result.isEmpty()) {
			estadistica = new EstadisticaOperacion((String) r[0],
					(String) r[1], (int) (long) r[2]);
		}
		return estadistica;
	}

	public  List<EstadisticaOperacion> getEstadistica(String entidad) {
		EntityTransaction et = this.entityManager.getTransaction();
		et.begin();
		@SuppressWarnings("unchecked")
		List<Object[]> result = (List<Object[]>) (this.entityManager
				.createQuery("select l.entidad, l.operacion, count(l) from  LogAuditoria as l where l.entidad='"
						+ entidad
						+ "' group by l.operacion, l.entidad  order by l.entidad, l.operacion asc"))
				.getResultList();
		et.commit();
		List<EstadisticaOperacion> estadisticas = new ArrayList<EstadisticaOperacion>();
		for (Object[] r : result) {
			estadisticas.add(new EstadisticaOperacion((String) r[0],
					(String) r[1], (int) (long) r[2]));
		}

		return estadisticas;
	}
}

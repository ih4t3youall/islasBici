package jIslas.DAOImpl;

import jIslas.DAO.EstacionDAO;
import jIslas.model.Estacion;

import java.util.List;

public class EstacionDAOImpl implements EstacionDAO {

	private GenericDao genericDao = new GenericDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Estacion> getEstaciones() {
		
		return (List<Estacion>) (List<?>)(getGenericDao().getAll(Estacion.class));
	}

	@Override
	public Estacion getEstacionById(Long id) {
		return (Estacion)getGenericDao().getObjectById(Estacion.class, id);
	}

	@Override
	public void altaEstacion(Estacion estacion) {
		getGenericDao().alta(estacion);

	}

	@Override
	public void updateEstacion(Estacion estacion) {
		getGenericDao().update(estacion);

	}

	@Override
	public void eliminarEstacion(Estacion estacion) {
		getGenericDao().eliminar(estacion);

	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

}

package jIslas.DAOImpl;

import java.util.List;

import jIslas.DAO.AlquilerDAO;
import jIslas.model.Alquiler;

public class AlquilerDAOImpl implements AlquilerDAO {
	
	private GenericDao genericDao = new GenericDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Alquiler> getAlquileres() {
		
		return (List<Alquiler>) (List<?>)(getGenericDao().getAll(Alquiler.class));
	}

	@Override
	public Alquiler getAlquilerById(Long id) {
		return (Alquiler)getGenericDao().getObjectById(Alquiler.class, id);
	}

	@Override
	public void altaAlquiler(Alquiler alquiler) {
		getGenericDao().alta(alquiler);

	}

	@Override
	public void updateAlquiler(Alquiler alquiler) {
		getGenericDao().update(alquiler);

	}

	@Override
	public void eliminarAlquiler(Alquiler alquiler) {
		getGenericDao().eliminar(alquiler);

	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

}

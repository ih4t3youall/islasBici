package jIslas.DAOImpl;

import jIslas.DAO.RegistroEstacionDAO;
import jIslas.model.RegistroEstacion;

import java.util.List;

public class RegistroEstacionDAOImpl implements RegistroEstacionDAO {

	private GenericDao genericDao = new GenericDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroEstacion> getRegistroEstaciones() {
		
		return (List<RegistroEstacion>) (List<?>)(getGenericDao().getAll(RegistroEstacion.class));
	}

	@Override
	public RegistroEstacion getRegistroEstacionById(Long id) {
		return (RegistroEstacion)getGenericDao().getObjectById(RegistroEstacion.class, id);
	}

	@Override
	public void altaRegistroEstacion(RegistroEstacion registroEstacion) {
		getGenericDao().alta(registroEstacion);

	}

	@Override
	public void updateRegistroEstacion(RegistroEstacion registroEstacion) {
		getGenericDao().update(registroEstacion);

	}

	@Override
	public void eliminarRegistroEstacion(RegistroEstacion registroEstacion) {
		getGenericDao().eliminar(registroEstacion);

	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

}

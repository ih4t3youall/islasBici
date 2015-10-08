package jIslas.DAOImpl;

import jIslas.DAO.RegistroUsuarioDAO;
import jIslas.model.RegistroUsuario;

import java.util.List;

public class RegistroUsuarioDAOImpl implements RegistroUsuarioDAO {

	private GenericDao genericDao = new GenericDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroUsuario> getRegistroUsuarios() {
		
		return (List<RegistroUsuario>) (List<?>)(getGenericDao().getAll(RegistroUsuario.class));
	}

	@Override
	public RegistroUsuario getRegistroUsuarioById(Long id) {
		return (RegistroUsuario)getGenericDao().getObjectById(RegistroUsuario.class, id);
	}

	@Override
	public void altaRegistroUsuario(RegistroUsuario registroUsuario) {
		getGenericDao().alta(registroUsuario);

	}

	@Override
	public void updateRegistroUsuario(RegistroUsuario registroUsuario) {
		getGenericDao().update(registroUsuario);

	}

	@Override
	public void eliminarRegistroUsuario(RegistroUsuario registroUsuario) {
		getGenericDao().eliminar(registroUsuario);

	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

}

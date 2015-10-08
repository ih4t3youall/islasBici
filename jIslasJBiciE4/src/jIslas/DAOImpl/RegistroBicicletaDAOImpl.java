package jIslas.DAOImpl;

import jIslas.DAO.RegistroBicicletaDAO;
import jIslas.model.RegistroBicicleta;

import java.util.List;

public class RegistroBicicletaDAOImpl implements RegistroBicicletaDAO {

	private GenericDao genericDao = new GenericDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroBicicleta> getRegistroBicicletas() {
		
		return (List<RegistroBicicleta>) (List<?>)(getGenericDao().getAll(RegistroBicicleta.class));
	}

	@Override
	public RegistroBicicleta getRegistroBicicletaById(Long id) {
		return (RegistroBicicleta)getGenericDao().getObjectById(RegistroBicicleta.class, id);
	}

	@Override
	public void altaRegistroBicicleta(RegistroBicicleta registroBicicleta) {
		getGenericDao().alta(registroBicicleta);

	}

	@Override
	public void updateRegistroBicicleta(RegistroBicicleta registroBicicleta) {
		getGenericDao().update(registroBicicleta);

	}

	@Override
	public void eliminarRegistroBicicleta(RegistroBicicleta registroBicicleta) {
		getGenericDao().eliminar(registroBicicleta);

	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}


}

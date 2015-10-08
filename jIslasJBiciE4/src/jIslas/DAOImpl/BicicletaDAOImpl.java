package jIslas.DAOImpl;

import jIslas.DAO.BicicletaDAO;
import jIslas.model.Bicicleta;

import java.util.List;

public class BicicletaDAOImpl implements BicicletaDAO {
	private GenericDao genericDao = new GenericDao();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Bicicleta> getBicicletas() {
		
		return (List<Bicicleta>) (List<?>)(getGenericDao().getAll(Bicicleta.class));
	}

	@Override
	public Bicicleta getBicicletaById(Long id) {
		return (Bicicleta)getGenericDao().getObjectById(Bicicleta.class, id);
	}

	@Override
	public void altaBicicleta(Bicicleta bicicleta) {
		getGenericDao().alta(bicicleta);

	}

	@Override
	public void updateBicicleta(Bicicleta bicicleta) {
		getGenericDao().update(bicicleta);

	}

	@Override
	public void eliminarBicicleta(Bicicleta bicicleta) {
		getGenericDao().eliminar(bicicleta);

	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

}

package rest;

import java.util.List;

import jIslas.DAO.EstadisticasDAO;
import jIslas.Utils.DAOFactory;

public class EstadisticasServices {

	EstadisticasDAO estadisticasDao;

	public EstadisticasServices() {
		estadisticasDao = DAOFactory.getEstadisticasDao();
	}

	public EstadisticaOperacion getEstadisticaOperacion(String entidad,
			String operacion) {
		return estadisticasDao.getEstadistica(entidad, operacion);
	}
	public List<EstadisticaOperacion> getEstadisticaOperacion(String entidad) {
		return estadisticasDao.getEstadistica(entidad);
	}

	public List<EstadisticaOperacion> getEstadisticas() {
		return estadisticasDao.getAll();
	}

}
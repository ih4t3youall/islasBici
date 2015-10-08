package jIslas.DAO;

import java.util.List;

import rest.EstadisticaOperacion;

public interface EstadisticasDAO {
		
	public List<EstadisticaOperacion> getAll();
	public EstadisticaOperacion getEstadistica(String entidad, String operacion);
	public List<EstadisticaOperacion> getEstadistica(String entidad);
}

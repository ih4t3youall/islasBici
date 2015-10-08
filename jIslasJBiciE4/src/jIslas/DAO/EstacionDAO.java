package jIslas.DAO;

import jIslas.model.Estacion;

import java.util.List;

public interface EstacionDAO {
	public List<Estacion> getEstaciones();

	public Estacion getEstacionById(Long id);

	public void altaEstacion(Estacion estacion);

	public void updateEstacion(Estacion estacion);
	
	public void eliminarEstacion(Estacion estacion);

}

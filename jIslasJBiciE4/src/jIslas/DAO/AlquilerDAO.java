package jIslas.DAO;

import jIslas.model.Alquiler;

import java.util.List;

public interface AlquilerDAO {
	public List<Alquiler> getAlquileres();

	public Alquiler getAlquilerById(Long id);

	public void altaAlquiler(Alquiler alquiler);

	public void updateAlquiler(Alquiler alquiler);
	
	public void eliminarAlquiler(Alquiler alquiler);
}

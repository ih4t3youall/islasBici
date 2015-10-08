package jIslas.DAO;

import jIslas.model.RegistroEstacion;

import java.util.List;

public interface RegistroEstacionDAO {
	public List<RegistroEstacion> getRegistroEstaciones();

	public RegistroEstacion getRegistroEstacionById(Long id);

	public void altaRegistroEstacion(RegistroEstacion registroEstacion);

	public void updateRegistroEstacion(RegistroEstacion registroEstacion);
	
	public void eliminarRegistroEstacion(RegistroEstacion registroEstacion);


}

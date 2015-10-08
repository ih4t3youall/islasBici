package jIslas.DAO;

import jIslas.model.RegistroBicicleta;

import java.util.List;

public interface RegistroBicicletaDAO {
	public List<RegistroBicicleta> getRegistroBicicletas();

	public RegistroBicicleta getRegistroBicicletaById(Long id);

	public void altaRegistroBicicleta(RegistroBicicleta registroBicicleta);

	public void updateRegistroBicicleta(RegistroBicicleta registroBicicleta);
	
	public void eliminarRegistroBicicleta(RegistroBicicleta registroBicicleta);

}

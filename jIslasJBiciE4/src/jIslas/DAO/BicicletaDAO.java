package jIslas.DAO;

import jIslas.model.Bicicleta;

import java.util.List;

public interface BicicletaDAO {
	public List<Bicicleta> getBicicletas();

	public Bicicleta getBicicletaById(Long id);

	public void altaBicicleta(Bicicleta bicicleta);

	public void updateBicicleta(Bicicleta bicicleta);
	
	public void eliminarBicicleta(Bicicleta bicicleta);

}

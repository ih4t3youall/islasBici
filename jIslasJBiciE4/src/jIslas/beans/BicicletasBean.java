package jIslas.beans;

import jIslas.Utils.DAOFactory;
import jIslas.model.Bicicleta;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BicicletasBean {

	List<Bicicleta> bicicletas = null;

	Bicicleta bicicletaSeleccionada;

	@PostConstruct
	public void init() {
		bicicletas = DAOFactory.getBicicletaDAO().getBicicletas();
	}

	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(List<Bicicleta> Bicicletas) {
		this.bicicletas = Bicicletas;
	}

	public Bicicleta getBicicletaSeleccionada() {
		return bicicletaSeleccionada;
	}

	public void setBicicletaSeleccionada(Bicicleta Bicicleta) {
		this.bicicletaSeleccionada = Bicicleta;
	}

	public String eliminar(Bicicleta bicicleta) {

		DAOFactory.getBicicletaDAO().eliminarBicicleta(bicicleta);
		return "adminBicicletas";
		
	}

	public void modificar(Bicicleta bicicleta) {

		DAOFactory.getBicicletaDAO().updateBicicleta(bicicleta);
	}
}
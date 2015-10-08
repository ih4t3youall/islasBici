package jIslas.beans;

import jIslas.Utils.DAOFactory;
import jIslas.model.Estacion;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EstacionesBean {

	List<Estacion> estaciones = null;

	Estacion EstacionSeleccionada;

	@PostConstruct
	public void init() {
		estaciones = DAOFactory.getEstacionDAO().getEstaciones();
	}

	public List<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(List<Estacion> estaciones) {
		this.estaciones = estaciones;
	}

	public Estacion getEstacionSeleccionada() {
		return EstacionSeleccionada;
	}

	public void setEstacionSeleccionada(Estacion Estacion) {
		this.EstacionSeleccionada = Estacion;
	}

	public String eliminar(Estacion Estacion) {

		DAOFactory.getEstacionDAO().eliminarEstacion(Estacion);
		return "adminEstaciones";
		
	}

	public void modificar(Estacion Estacion) {

		DAOFactory.getEstacionDAO().updateEstacion(Estacion);
	}
}
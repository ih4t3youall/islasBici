package jIslas.beans;

import jIslas.Utils.DAOFactory;
import jIslas.model.Estacion;
import jIslas.model.EstadoEstacion;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class EstacionBean {
	private Estacion estacion = new Estacion();

	public Estacion getEstacion() {
		return this.estacion;
	}

	public Long getId() {
		return getEstacion().getId();
	}

	public EstadoEstacion getEstado() {
		return getEstacion().getEstado();
	}

	public void setEstado(EstadoEstacion estado) {
		getEstacion().setEstado(estado);
	}

	public String getNombre() {
		return getEstacion().getNombre();
	}

	public String estacionSeleccionada(Estacion estacion) {

		this.estacion = estacion;
		return "modificarEstacion";
	}

	public void setNombre(String nombre) {
		getEstacion().setNombre(nombre);
	}

	public String getDireccion() {
		return getEstacion().getDireccion();
	}

	public void setDireccion(String direccion) {
		getEstacion().setDireccion(direccion);
	}
	public float getUbicacionX() {
		return getEstacion().getUbicacionX();
	}
	public float getUbicacionY() {
		return getEstacion().getUbicacionY();
	}
	public void setUbicacionX(float ubicacionX) {
		getEstacion().setUbicacionX(ubicacionX);
	}
	public void setUbicacionY(float ubicacionY) {
		getEstacion().setUbicacionY(ubicacionY);
	}
	public Integer getCantidadDeEstacionamientos(){
		return getEstacion().getCantidadDeEstacionamientos();
	}

	public SelectItem[] getEstados(){
		SelectItem[] items = new SelectItem[EstadoEstacion.values().length];
		int i = 0;
		for (EstadoEstacion g : EstadoEstacion.values()) {
			items[i++] = new SelectItem(g, g.toString());
		}
		return items;
	}
	
	public String registrar() {
		try {
			DAOFactory.getEstacionDAO().altaEstacion(getEstacion());

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"La estacion a sido dada de alta exitosamente",
							"Fue direccionado al menú administrador"));
			this.estacion = new Estacion();
			return "admin";

		} catch (Exception e) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"La estacion no ha sido dada de alta exitosamente",null
									));
			throw e;
		}
	}
}

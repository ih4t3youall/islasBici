package jIslas.beans;

import jIslas.Utils.DAOFactory;
import jIslas.model.Bicicleta;
import jIslas.model.Estacion;
import jIslas.model.EstadoBicicleta;
import jIslas.model.RegistroBicicleta;
import jIslas.model.Sexo;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class BicicletaBean {
	private Bicicleta bicicleta = new Bicicleta();

	public Bicicleta getBicicleta() {
		return this.bicicleta;
	}

	public Long getId() {
		return getBicicleta().getId();
	}

	public EstadoBicicleta getEstado() {
		return getBicicleta().getEstado();
	}

	public void setEstado(EstadoBicicleta estado) {
		getBicicleta().setEstado(estado);
	}

	public String getIdentificador() {
		return getBicicleta().getIdentificador();
	}
	public String bicicletaSeleccionada(Bicicleta bicicleta){
		
		this.bicicleta = bicicleta;
		return "modificarBicicleta";
	}

	public void setIdentificador(String identificador) {
		getBicicleta().setIdentificador(identificador);
	}

	public Date getFechaDeIngreso() {
		return getBicicleta().getFechaDeIngreso();
	}

	public void setFechaDeIngreso(Date fechaDeIngreso) {
		getBicicleta().setFechaDeIngreso(fechaDeIngreso);
	}

	public Estacion getEstacion() {
		return getBicicleta().getEstacion();
	}
	public SelectItem[] getEstaciones(){
		List<Estacion> values = DAOFactory.getEstacionDAO().getEstaciones();
		SelectItem[] items = new SelectItem[values.size()];
		int i = 0;
		for (Estacion g : values) {
			items[i++] = new SelectItem(g, g.getNombre());
		}
		return items;
	}
	public void setEstacion(Estacion estacion) {
		getBicicleta().setEstacion(estacion);
	}

	public List<RegistroBicicleta> getHitorial() {
		return getBicicleta().getHitorial();
	}

	public void setHitorial(List<RegistroBicicleta> hitorial) {
		getBicicleta().setHitorial(hitorial);
	}
	public SelectItem[] getEstados() {
		SelectItem[] items = new SelectItem[EstadoBicicleta.values().length];
		int i = 0;
		for (EstadoBicicleta g : EstadoBicicleta.values()) {
			items[i++] = new SelectItem(g, g.toString());
		}
		return items;
	}

	public String registrar() {
		try {
			DAOFactory.getBicicletaDAO().altaBicicleta(getBicicleta());

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"La bicicleta a sido dada de alta exitosamente",
							"Fue direccionado al menú administrador"));
			this.bicicleta = new Bicicleta();
			return "admin";

		} catch (Exception e) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"La bicicleta no ha sido dada de alta exitosamente",
									"Por favor, informeselá al nuevo administrador"));
			throw e;
		}
	}

}

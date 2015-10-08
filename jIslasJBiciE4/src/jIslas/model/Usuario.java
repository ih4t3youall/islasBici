package jIslas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "USUARIO_ID", referencedColumnName = "PERSONA_ID")
public class Usuario extends Persona {
	@OneToMany(mappedBy = "usuario")
	private List<Alquiler> alquileres;
	@OneToMany(mappedBy = "usuario")
	private List<RegistroUsuario> historial;
	@Enumerated(EnumType.STRING)
	private EstadoUsuario estadoActual = EstadoUsuario.HABILITADO;

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setEstado(EstadoUsuario estado) {
		this.estadoActual = estado;
	}

	public EstadoUsuario getEstado() {
		return estadoActual;
	}

	public void setHistorial(List<RegistroUsuario> historial) {
		this.historial = historial;
	}

	public List<RegistroUsuario> getHistorial() {
		return historial;
	}

}

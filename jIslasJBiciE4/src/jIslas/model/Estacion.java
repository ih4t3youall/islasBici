package jIslas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Estacion {
	
	private String nombre;
	private float ubicacionX;
	private float ubicacionY;
	private String direccion;
	@OneToMany(mappedBy="estacion")
	private List<RegistroEstacion> historial;
	private Integer cantidadDeEstacionamientos = 0;
	@OneToMany(mappedBy="estacion")
	private List<Bicicleta> bicicletasDisponibles;
	@Enumerated(EnumType.STRING)
	private EstadoEstacion estadoActual;
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getUbicacionX() {
		return ubicacionX;
	}
	public void setUbicacionX(float ubicacionX) {
		this.ubicacionX = ubicacionX;
	}
	public float getUbicacionY() {
		return ubicacionY;
	}
	public void setUbicacionY(float ubicacionY) {
		this.ubicacionY = ubicacionY;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	
	public Integer getCantidadDeEstacionamientos() {
		return cantidadDeEstacionamientos;
	}
	public void setCantidadDeEstacionamientos(Integer cantidadDeEstacionamientos) {
		this.cantidadDeEstacionamientos = cantidadDeEstacionamientos;
	}
	public List<Bicicleta> getBicicletas() {
		return bicicletasDisponibles;
	}
	public void setBicicletas(List<Bicicleta> bicicletas) {
		this.bicicletasDisponibles = bicicletas;
	}
	public void setHistorial(List<RegistroEstacion> historial) {
		this.historial = historial;
	}
	public List<RegistroEstacion> getHistorial() {
		return historial;
	}
	public void setEstado(EstadoEstacion estado) {
		this.estadoActual = estado;
	}
	public EstadoEstacion getEstado() {
		return estadoActual;
	}
	
	

}

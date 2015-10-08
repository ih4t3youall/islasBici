package jIslas.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Bicicleta {
	@Enumerated(EnumType.STRING)
	private EstadoBicicleta estadoActual;
	private String identificador;
	private Date fechaDeIngreso;
	@ManyToOne(optional=true)
	private Estacion estacion;
	@OneToMany(mappedBy="bicicleta")
	private List<RegistroBicicleta> hitorial;
	@Id
	@GeneratedValue
	private Long id;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoBicicleta getEstado() {
		return estadoActual;
	}

	public void setEstado(EstadoBicicleta estado) {
		this.estadoActual = estado;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Date getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(Date fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public List<RegistroBicicleta> getHitorial() {
		return hitorial;
	}

	public void setHitorial(List<RegistroBicicleta> hitorial) {
		this.hitorial = hitorial;
	}

}

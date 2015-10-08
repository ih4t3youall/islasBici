package jIslas.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Alquiler {

	@OneToMany()
	private List<Bicicleta> bicicletas;
	private Date fechaDeAlquiler;
	private Date fechaDeDevolucion;
	@ManyToOne(optional=false)
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;
	@ManyToOne(optional=false)
	private Estacion origen;
	@ManyToOne(optional=false)
	private Estacion destino;
	@Id @GeneratedValue
	@Column(name = "ALQUILER_ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(List<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}

	public Date getFechaDeAlquiler() {
		return fechaDeAlquiler;
	}

	public void setFechaDeAlquiler(Date fechaDeAlquiler) {
		this.fechaDeAlquiler = fechaDeAlquiler;
	}

	public Date getFechaDeDevolucion() {
		return fechaDeDevolucion;
	}

	public void setFechaDeDevolucion(Date fechaDeDevolucion) {
		this.fechaDeDevolucion = fechaDeDevolucion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estacion getOrigen() {
		return origen;
	}

	public void setOrigen(Estacion origen) {
		this.origen = origen;
	}

	public Estacion getDestino() {
		return destino;
	}

	public void setDestino(Estacion destino) {
		this.destino = destino;
	}

}

package jIslas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class RegistroBicicleta {
	private Date fecha;
	@Enumerated(EnumType.STRING)
	private EstadoBicicleta estado;
	@ManyToOne(optional=false)
	private Persona originante;
	@ManyToOne(optional=false)
	private Bicicleta bicicleta;
	@Id @GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoBicicleta getEstado() {
		return estado;
	}

	public void setEstado(EstadoBicicleta estado) {
		this.estado = estado;
	}

	public Persona getOriginante() {
		return originante;
	}

	public void setOriginante(Persona originante) {
		this.originante = originante;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}
}

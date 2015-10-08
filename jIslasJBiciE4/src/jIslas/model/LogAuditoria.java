package jIslas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LogAuditoria {
	private Long id;
	private String operacion;
	private Date timeStamp;
	private String entidad;
	private Long idEntidad;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public LogAuditoria() {
	};

	public LogAuditoria(String operacion, Date timeStamp, String entidad,
			Long idEntidad) {
		super();
		this.operacion = operacion;
		this.timeStamp = timeStamp;
		this.entidad = entidad;
		this.idEntidad = idEntidad;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public Long getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

}

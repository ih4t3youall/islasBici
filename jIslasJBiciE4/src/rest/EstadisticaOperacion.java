package rest;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstadisticaOperacion {
	private String entidad;
	private String operacion;
	private Integer cantidad;

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public EstadisticaOperacion() {

	}

	public EstadisticaOperacion(String entidad, String operacion,
			Integer cantidad) {
		super();
		this.entidad = entidad;
		this.operacion = operacion;
		this.cantidad = cantidad;
	}


}

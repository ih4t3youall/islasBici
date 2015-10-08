package jIslas.model;

public enum EstadoEstacion {
	OPERATIVA("Operativa"),
	CERRADA("Cerrada"), 
	ENCONTRUCCION("En construcción");

	private final String value;

	private EstadoEstacion(String value) {
		this.value = value;
	}

	public String getValue() {
		return name();
	}

	public String toString() {
		return value;
	}
}

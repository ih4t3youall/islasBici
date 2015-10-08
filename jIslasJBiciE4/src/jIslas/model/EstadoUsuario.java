package jIslas.model;

public enum EstadoUsuario {

   HABILITADO("Habilitado"), 
   DESHABILITADODEF("Deshabilitado Defenitivamente"),
   DESHABILITADOTEM("Deshabilitado Temporalmente");

	private final String value;

	private EstadoUsuario(String value) {
		this.value = value;
	}

	public String getValue() {
		return name();
	}

	public String toString() {
		return value;
	}
}
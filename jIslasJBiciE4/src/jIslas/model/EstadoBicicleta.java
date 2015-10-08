package jIslas.model;

public enum EstadoBicicleta {
	APTAPARAUSO("Apta para uso"), 
	ENREPARACION("En reparación"), 
	DESUSO("En desuso"), 
	DENUNCIADA("Denunciada");	

	public final String value;

	private EstadoBicicleta(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return value;
	}
}

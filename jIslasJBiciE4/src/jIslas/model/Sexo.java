package jIslas.model;

public enum Sexo {

	MASCULINO("Masculino"), FEMENINO("Femenino");
	
	private final String value;

	private Sexo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public String toString(){
		return value;
	}
	public String getLabel() {
	    return value;
	}
}

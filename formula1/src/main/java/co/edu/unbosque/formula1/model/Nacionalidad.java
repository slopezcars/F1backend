package co.edu.unbosque.formula1.model;

public class Nacionalidad {

	private int idNacionalidad;
	private String nombre;

	public Nacionalidad() {
	}

	public Nacionalidad(int idNacionalidad, String nombre) {
		this.idNacionalidad = idNacionalidad;
		this.nombre = nombre;
	}

	public int getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

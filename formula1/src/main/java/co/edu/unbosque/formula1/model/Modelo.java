package co.edu.unbosque.formula1.model;

public class Modelo {

	private int idModelo;
	private String nombre;

	public Modelo() {
	}

	public Modelo(String nombre) {
		this.nombre = nombre;
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

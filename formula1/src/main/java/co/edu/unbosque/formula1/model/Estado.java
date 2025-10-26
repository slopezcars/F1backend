package co.edu.unbosque.formula1.model;

public class Estado {
	
	private boolean  idEstado;
	private String nombre;
	
	public Estado() {
		
	}

	public Estado( String nombre) {
		this.nombre = nombre;
	}

	public boolean isIdEstado() {
		return idEstado;
	}

	public void setIdEstado(boolean idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}

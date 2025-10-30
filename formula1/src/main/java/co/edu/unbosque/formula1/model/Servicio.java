
package co.edu.unbosque.formula1.model;

public class Servicio {

	private int idServicio;
	private String descripcion;

	public Servicio() {
	}

	public Servicio(int idServicio, String descripcion) {
		this.idServicio = idServicio;
		this.descripcion = descripcion;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

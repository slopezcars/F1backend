package co.edu.unbosque.formula1.model;

public class TipoPenalizacion {
	private int idTipoPenalizacion;
	private String nombre;
	private String descripcion;

	public TipoPenalizacion() {

	}

	public TipoPenalizacion(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdTipoPenalizacion() {
		return idTipoPenalizacion;
	}

	public void setIdTipoPenalizacion(int idTipoPenalizacion) {
		this.idTipoPenalizacion = idTipoPenalizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

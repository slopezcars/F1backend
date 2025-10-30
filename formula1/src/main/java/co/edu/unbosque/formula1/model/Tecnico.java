package co.edu.unbosque.formula1.model;

public class Tecnico {
	private int id;
	private int idEspecialidad;

	public Tecnico() {
	}

	public Tecnico(int id, int idEspecialidad) {
		this.id = id;
		this.idEspecialidad = idEspecialidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

}

package co.edu.unbosque.formula1.model;

public class Especialidad {
	private int id_especialidad;
    private String nombre;
    public Especialidad() {
		// TODO Auto-generated constructor stub
	}
    
	public Especialidad(int id_especialidad, String nombre) {
		super();
		this.id_especialidad = id_especialidad;
		this.nombre = nombre;
	}

	public int getId_especialidad() {
		return id_especialidad;
	}
	public void setId_especialidad(int id_especialidad) {
		this.id_especialidad = id_especialidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
}

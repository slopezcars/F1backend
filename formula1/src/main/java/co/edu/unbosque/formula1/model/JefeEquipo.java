package co.edu.unbosque.formula1.model;

import java.time.LocalDate;

public class JefeEquipo {
	private int id;
	private LocalDate fechaInicio;

	public JefeEquipo() {
	}

	public JefeEquipo(int id, LocalDate fechaInicio) {
		this.id = id;
		this.fechaInicio = fechaInicio;
	}
	private Empleado empleado;

	public Empleado getEmpleado() {
	    return empleado;
	}

	public void setEmpleado(Empleado empleado) {
	    this.empleado = empleado;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}

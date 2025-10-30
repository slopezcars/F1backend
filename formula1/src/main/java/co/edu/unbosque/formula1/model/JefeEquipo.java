package co.edu.unbosque.formula1.model;

import java.time.LocalDate;

public class JefeEquipo {
	 private int id;
	 private LocalDate fechaInicio;
	 public JefeEquipo() {
		// TODO Auto-generated constructor stub
	}
	public JefeEquipo(int id, LocalDate fechaInicio) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
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

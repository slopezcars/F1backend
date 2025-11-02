package co.edu.unbosque.formula1.dto;

import java.time.LocalDate;

public class PenalizacionCarreraDTO {
	private int idCarrera;
	private String carrera;
	private LocalDate fecha;
	private int totalPenalizacion;
	private double minutoPerdido;

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getTotalPenalizacion() {
		return totalPenalizacion;
	}

	public void setTotalPenalizacion(int totalPenalizacion) {
		this.totalPenalizacion = totalPenalizacion;
	}

	public double getMinutoPerdido() {
		return minutoPerdido;
	}

	public void setMinutoPerdido(double minutoPerdido) {
		this.minutoPerdido = minutoPerdido;
	}
}

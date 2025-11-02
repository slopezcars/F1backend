package co.edu.unbosque.formula1.dto;

import java.time.LocalDate;

public class ResumenCarreraDTO {
	private int idCarrera;
	private String carrera;
	private LocalDate fecha;
	private String circuito;
	private String jefeEquipo;
	private int totalPiloto;
	private String pilotoGanador;
	private int totalPenalizacion;
	private int minutosPenalizado;

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

	public String getCircuito() {
		return circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	public String getJefeEquipo() {
		return jefeEquipo;
	}

	public void setJefeEquipo(String jefeEquipo) {
		this.jefeEquipo = jefeEquipo;
	}

	public int getTotalPiloto() {
		return totalPiloto;
	}

	public void setTotalPiloto(int totalPiloto) {
		this.totalPiloto = totalPiloto;
	}

	public String getPilotoGanador() {
		return pilotoGanador;
	}

	public void setPilotoGanador(String pilotoGanador) {
		this.pilotoGanador = pilotoGanador;
	}

	public int getTotalPenalizacion() {
		return totalPenalizacion;
	}

	public void setTotalPenalizacion(int totalPenalizacion) {
		this.totalPenalizacion = totalPenalizacion;
	}

	public int getMinutosPenalizado() {
		return minutosPenalizado;
	}

	public void setMinutosPenalizado(int minutosPenalizado) {
		this.minutosPenalizado = minutosPenalizado;
	}
}

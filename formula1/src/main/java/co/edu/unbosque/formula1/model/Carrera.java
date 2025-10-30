package co.edu.unbosque.formula1.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Carrera {
	private int idCarrera;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private int idJefeEquipo;
	private int idCircuito;
	private String nombre;
	private LocalDate fecha;

	public Carrera() {
	}

	public Carrera(int idCarrera, LocalTime horaInicio, LocalTime horaFin, int idJefeEquipo, int idCircuito,
			String nombre, LocalDate fecha) {
		this.idCarrera = idCarrera;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.idJefeEquipo = idJefeEquipo;
		this.idCircuito = idCircuito;
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public int getIdJefeEquipo() {
		return idJefeEquipo;
	}

	public void setIdJefeEquipo(int idJefeEquipo) {
		this.idJefeEquipo = idJefeEquipo;
	}

	public int getIdCircuito() {
		return idCircuito;
	}

	public void setIdCircuito(int idCircuito) {
		this.idCircuito = idCircuito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}

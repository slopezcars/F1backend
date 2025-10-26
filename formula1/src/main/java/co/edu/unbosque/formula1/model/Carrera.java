package co.edu.unbosque.formula1.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Carrera {
	private int id;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private String nombre;
	private LocalDate fecha;
	private int idJefeEquipo;
	private int idCircuito;

	public Carrera() {
	}

	public Carrera(LocalTime horaInicio, LocalTime horaFin, String nombre, LocalDate fecha, int idJefeEquipo,
			int idCircuito) {
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.nombre = nombre;
		this.fecha = fecha;
		this.idJefeEquipo = idJefeEquipo;
		this.idCircuito = idCircuito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}

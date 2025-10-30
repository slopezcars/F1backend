package co.edu.unbosque.formula1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Empleado {

	private int id;
	private LocalDate fechaNacimiento;
	private String primerNombre;
	private String primerApellido;
	private int idNacionalidad;
	private int idEstado;

	public Empleado() {
	}

	public Empleado(int id, LocalDate fechaNacimiento, String primerNombre, String primerApellido, int idNacionalidad,
			int idEstado) {

		this.id = id;
		this.fechaNacimiento = fechaNacimiento;
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
		this.idNacionalidad = idNacionalidad;
		this.idEstado = idEstado;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public int getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
}

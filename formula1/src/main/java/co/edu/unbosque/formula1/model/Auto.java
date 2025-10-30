package co.edu.unbosque.formula1.model;

import java.time.LocalDate;

public class Auto {
	private String placa;
	private String numeroChasis;
	private int idmotor;
	private LocalDate fechaEstreno;
	private int idmodelo;

	public Auto() {
	}

	public Auto(String placa, String numeroChasis, int idmotor, LocalDate fechaEstreno, int idmodelo) {
		this.placa = placa;
		this.numeroChasis = numeroChasis;
		this.idmotor = idmotor;
		this.fechaEstreno = fechaEstreno;
		this.idmodelo = idmodelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNumeroChasis() {
		return numeroChasis;
	}

	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}

	public int getIdmotor() {
		return idmotor;
	}

	public void setIdmotor(int idmotor) {
		this.idmotor = idmotor;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public int getIdmodelo() {
		return idmodelo;
	}

	public void setIdmodelo(int idmodelo) {
		this.idmodelo = idmodelo;
	}

}

package co.edu.unbosque.formula1.model;

import java.time.LocalDate;

public class Auto {
	private LocalDate fechaEstreno;
	private int idmodelo;
	private int idmotor;
	private int numeroChasis;
	private String placa; // ¿? ---> que se hace

	public Auto() {
	}

	public Auto(LocalDate fechaEstreno, int idmodelo, int idmotor, int numeroChasis, String placa) {
		this.fechaEstreno = fechaEstreno;
		this.idmodelo = idmodelo;
		this.idmotor = idmotor;
		this.numeroChasis = numeroChasis;
		this.placa = placa;
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

	public int getIdmotor() {
		return idmotor;
	}

	public void setIdmotor(int idmotor) {
		this.idmotor = idmotor;
	}

	public int getNumeroChasis() {
		return numeroChasis;
	}

	public void setNumeroChasis(int numeroChasis) {
		this.numeroChasis = numeroChasis;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}

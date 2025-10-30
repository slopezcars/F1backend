package co.edu.unbosque.formula1.model;

import java.time.LocalDateTime;

public class Penalizacion {

	private int idPenalizacion;
	private LocalDateTime momento;
	private int tiempo;

	public Penalizacion() {
	}

	public Penalizacion(int idPenalizacion, LocalDateTime momento, int tiempo) {
		this.idPenalizacion = idPenalizacion;
		this.momento = momento;
		this.tiempo = tiempo;
	}

	public int getIdPenalizacion() {
		return idPenalizacion;
	}

	public void setIdPenalizacion(int idPenalizacion) {
		this.idPenalizacion = idPenalizacion;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

}

package co.edu.unbosque.formula1.dto;

import java.time.LocalDateTime;

public class PenalizacionPilotoDTO {
	private int idPiloto;
	private String piloto;
	private int idPenalizacion;
	private LocalDateTime momento;
	private double minutoPenalizado;

	public int getIdPiloto() {
		return idPiloto;
	}

	public void setIdPiloto(int idPiloto) {
		this.idPiloto = idPiloto;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
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

	public double getMinutoPenalizado() {
		return minutoPenalizado;
	}

	public void setMinutoPenalizado(double minutoPenalizado) {
		this.minutoPenalizado = minutoPenalizado;
	}
}

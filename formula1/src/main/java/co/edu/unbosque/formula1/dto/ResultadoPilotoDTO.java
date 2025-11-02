package co.edu.unbosque.formula1.dto;

import java.time.LocalDate;

public class ResultadoPilotoDTO {
	private int idPiloto;
	private String piloto;
	private int idCarrera;
	private String carrera;
	private LocalDate fecha;
	private int rankingFinal;

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

	public int getRankingFinal() {
		return rankingFinal;
	}

	public void setRankingFinal(int rankingFinal) {
		this.rankingFinal = rankingFinal;
	}
}

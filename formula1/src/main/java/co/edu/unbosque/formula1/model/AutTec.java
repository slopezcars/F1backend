package co.edu.unbosque.formula1.model;

import java.time.LocalTime;

public class AutTec {
	private String placa;
	private int idTecnico;
	private LocalTime horaEntrada;
	private LocalTime horaSalida;
	private int idServicio;

	public AutTec() {
	}

	public AutTec(String placa, int idTecnico, LocalTime horaEntrada, LocalTime horaSalida, int idServicio) {
		super();
		this.placa = placa;
		this.idTecnico = idTecnico;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.idServicio = idServicio;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

}

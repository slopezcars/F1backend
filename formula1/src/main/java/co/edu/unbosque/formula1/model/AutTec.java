package co.edu.unbosque.formula1.model;

import java.time.LocalDateTime;

public class AutTec {
	private String placa;        
    private int idTecnico;        
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private int idServicio;
    public AutTec() {
		// TODO Auto-generated constructor stub
	}
	public AutTec(String placa, int idTecnico, LocalDateTime horaEntrada, LocalDateTime horaSalida, int idServicio) {
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
	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
    
}

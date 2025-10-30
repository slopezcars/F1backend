package co.edu.unbosque.formula1.model;

import java.math.BigDecimal;

public class AutCir {

	private int idCircuito;
	private String placa;
	private BigDecimal velocidad;

	public AutCir() {
	}

	public AutCir(int idCircuito, String placa, BigDecimal velocidad) {
		this.idCircuito = idCircuito;
		this.placa = placa;
		this.velocidad = velocidad;
	}

	public int getIdCircuito() {
		return idCircuito;
	}

	public void setIdCircuito(int idCircuito) {
		this.idCircuito = idCircuito;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(BigDecimal velocidad) {
		this.velocidad = velocidad;
	}

}

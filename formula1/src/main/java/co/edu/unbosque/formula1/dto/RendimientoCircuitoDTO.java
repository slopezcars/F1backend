package co.edu.unbosque.formula1.dto;

public class RendimientoCircuitoDTO {
	private int idCircuito;
	private String circuito;
	private double promedioPosicionPiloto;

	public int getIdCircuito() {
		return idCircuito;
	}

	public void setIdCircuito(int idCircuito) {
		this.idCircuito = idCircuito;
	}

	public String getCircuito() {
		return circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	public double getPromedioPosicionPiloto() {
		return promedioPosicionPiloto;
	}

	public void setPromedioPosicionPiloto(double promedioPosicionPiloto) {
		this.promedioPosicionPiloto = promedioPosicionPiloto;
	}
}

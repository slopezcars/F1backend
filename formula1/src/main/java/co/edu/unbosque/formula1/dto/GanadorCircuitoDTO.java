package co.edu.unbosque.formula1.dto;

public class GanadorCircuitoDTO {
	private int idCircuito;
	private String circuito;
	private String carrera;
	private String pilotoGanador;

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

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getPilotoGanador() {
		return pilotoGanador;
	}

	public void setPilotoGanador(String pilotoGanador) {
		this.pilotoGanador = pilotoGanador;
	}
}

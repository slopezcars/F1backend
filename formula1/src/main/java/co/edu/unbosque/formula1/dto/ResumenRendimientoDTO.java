package co.edu.unbosque.formula1.dto;

public class ResumenRendimientoDTO {
	private int idPiloto;
	private String piloto;
	private long carrerasDisputadas;
	private double promedioPosicion;

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

	public long getCarrerasDisputadas() {
		return carrerasDisputadas;
	}

	public void setCarrerasDisputadas(long carrerasDisputadas) {
		this.carrerasDisputadas = carrerasDisputadas;
	}

	public double getPromedioPosicion() {
		return promedioPosicion;
	}

	public void setPromedioPosicion(double promedioPosicion) {
		this.promedioPosicion = promedioPosicion;
	}
}

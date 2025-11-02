package co.edu.unbosque.formula1.dto;

public class PodioPilotoDTO {
	private int idPiloto;
	private String piloto;
	private long primerosPuestos;
	private long segundosPuestos;
	private long tercerosPuestos;

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

	public long getPrimerosPuestos() {
		return primerosPuestos;
	}

	public void setPrimerosPuestos(long primerosPuestos) {
		this.primerosPuestos = primerosPuestos;
	}

	public long getSegundosPuestos() {
		return segundosPuestos;
	}

	public void setSegundosPuestos(long segundosPuestos) {
		this.segundosPuestos = segundosPuestos;
	}

	public long getTercerosPuestos() {
		return tercerosPuestos;
	}

	public void setTercerosPuestos(long tercerosPuestos) {
		this.tercerosPuestos = tercerosPuestos;
	}
}

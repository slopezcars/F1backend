package co.edu.unbosque.formula1.dto;

public class RendimientoTecnicoDTO {
	private int idTecnico;
	private String tecnico;
	private int totalServicioRealizado;

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public int getTotalServicioRealizado() {
		return totalServicioRealizado;
	}

	public void setTotalServicioRealizado(int totalServicioRealizado) {
		this.totalServicioRealizado = totalServicioRealizado;
	}
}

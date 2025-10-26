package co.edu.unbosque.formula1.model;

public class Penalizacion {

	private int idPenalizacion;
	private String momento;
	private double tiempo;

	public Penalizacion() {
	}

	public Penalizacion(String momento, double tiempo) {
		this.momento = momento;
		this.tiempo = tiempo;
	}

	public int getIdPenalizacion() {
		return idPenalizacion;
	}

	public void setIdPenalizacion(int idPenalizacion) {
		this.idPenalizacion = idPenalizacion;
	}

	public String getMomento() {
		return momento;
	}

	public void setMomento(String momento) {
		this.momento = momento;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

}

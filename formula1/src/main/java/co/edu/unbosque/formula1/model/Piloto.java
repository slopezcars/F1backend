package co.edu.unbosque.formula1.model;

public class Piloto {
	 private int id;
	 private int numLicencia;
	 
	 public Piloto() {
		// TODO Auto-generated constructor stub
	}
	public Piloto(int id, int numLicencia) {
		super();
		this.id = id;
		this.numLicencia = numLicencia;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumLicencia() {
		return numLicencia;
	}

	public void setNumLicencia(int numLicencia) {
		this.numLicencia = numLicencia;
	}

	 
}

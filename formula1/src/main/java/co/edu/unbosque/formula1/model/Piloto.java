package co.edu.unbosque.formula1.model;

public class Piloto {
	private int id;
	private String numLicencia;

	public Piloto() {
	}

	public Piloto(int id, String numLicencia) {
		this.id = id;
		this.numLicencia = numLicencia;
	}
	private Empleado empleado;

	public Empleado getEmpleado() {
	    return empleado;
	}

	public void setEmpleado(Empleado empleado) {
	    this.empleado = empleado;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumLicencia() {
		return numLicencia;
	}

	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}

}

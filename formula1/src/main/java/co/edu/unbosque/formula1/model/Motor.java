package co.edu.unbosque.formula1.model;

public class Motor {

	private int idmotor;
	private int tipoMotor;

	public Motor() {
	}

	
	public Motor(int idmotor, int tipoMotor) {
		super();
		this.idmotor = idmotor;
		this.tipoMotor = tipoMotor;
	}


	public int getIdmotor() {
		return idmotor;
	}

	public void setIdmotor(int idmotor) {
		this.idmotor = idmotor;
	}

	public int getTipoMotor() {
		return tipoMotor;
	}

	public void setTipoMotor(int tipoMotor) {
		this.tipoMotor = tipoMotor;
	}


}

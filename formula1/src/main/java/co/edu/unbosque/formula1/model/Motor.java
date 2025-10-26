package co.edu.unbosque.formula1.model;

public class Motor {

	private int idmotor;
	private int codigoMotor;

	public Motor() {
	}

	public Motor(int codigoMotor) {
		this.codigoMotor = codigoMotor;
	}

	public int getIdmotor() {
		return idmotor;
	}

	public void setIdmotor(int idmotor) {
		this.idmotor = idmotor;
	}

	public int getCodigoMotor() {
		return codigoMotor;
	}

	public void setCodigoMotor(int codigoMotor) {
		this.codigoMotor = codigoMotor;
	}

}

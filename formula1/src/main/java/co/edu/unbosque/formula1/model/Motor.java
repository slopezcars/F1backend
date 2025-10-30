package co.edu.unbosque.formula1.model;

public class Motor {

	private int idmotor;
	private String tipoMotor;

	public Motor() {
	}

	public Motor(int idmotor, String tipoMotor) {
		this.idmotor = idmotor;
		this.tipoMotor = tipoMotor;
	}

	public int getIdmotor() {
		return idmotor;
	}

	public void setIdmotor(int idmotor) {
		this.idmotor = idmotor;
	}

	public String getTipoMotor() {
		return tipoMotor;
	}

	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

}

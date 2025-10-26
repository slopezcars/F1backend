package co.edu.unbosque.formula1.model;

public class PenTipp {

	    private int idTipoPenalizacion;
	    private int penalizacionId;

	    public PenTipp() {
	    }

	    public PenTipp(int idTipoPenalizacion, int penalizacionId) {
	        this.idTipoPenalizacion = idTipoPenalizacion;
	        this.penalizacionId = penalizacionId;
	    }

	    public int getIdTipoPenalizacion() {
	        return idTipoPenalizacion;
	    }

	    public void setIdTipoPenalizacion(int idTipoPenalizacion) {
	        this.idTipoPenalizacion = idTipoPenalizacion;
	    }

	    public int getPenalizacionId() {
	        return penalizacionId;
	    }

	    public void setPenalizacionId(int penalizacionId) {
	        this.penalizacionId = penalizacionId;
	    }

	    
	}



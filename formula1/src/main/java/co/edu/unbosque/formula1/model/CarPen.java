package co.edu.unbosque.formula1.model;

public class CarPen {

    private int idCarrera;
    private int idPenalizacion;

    public CarPen() {
    }

    public CarPen(int idCarrera, int idPenalizacion) {
        this.idCarrera = idCarrera;
        this.idPenalizacion = idPenalizacion;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getIdPenalizacion() {
        return idPenalizacion;
    }

    public void setIdPenalizacion(int idPenalizacion) {
        this.idPenalizacion = idPenalizacion;
    }

   
}

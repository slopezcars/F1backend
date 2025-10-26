package co.edu.unbosque.formula1.model;

public class AutCir {

    private int idSector;
    private String placa;
    private double velocidad;

    public AutCir() {
    }

    public AutCir(int idSector, String placa, double velocidad) {
        this.idSector = idSector;
        this.placa = placa;
        this.velocidad = velocidad;
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    
}



package co.edu.unbosque.formula1.model;

public class Circuito {
	

	    private int idCircuito;     
	    private int numVueltas;     
	    private String nombre;      

	    public Circuito() {
	    }

	    public Circuito( int numVueltas, String nombre) {
	        this.numVueltas = numVueltas;
	        this.nombre = nombre;
	    }

	    public int getIdCircuito() {
	        return idCircuito;
	    }

	    public void setIdCircuito(int idCircuito) {
	        this.idCircuito = idCircuito;
	    }

	    public int getNumVueltas() {
	        return numVueltas;
	    }

	    public void setNumVueltas(int numVueltas) {
	        this.numVueltas = numVueltas;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    
	}




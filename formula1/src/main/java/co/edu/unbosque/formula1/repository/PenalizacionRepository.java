package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Penalizacion;

@Repository
public class PenalizacionRepository {
	
	@Autowired
	private ConexionDB conexionDB;

	public boolean crearPenalizacion(Penalizacion penalizacion) {
	    String sql = "INSERT INTO penalizacion (momento, tiempo) VALUES (?, ?)";

	    try (Connection connection = conexionDB.obtenerConexion();
	         PreparedStatement statement = connection.prepareStatement(sql)) {

	      
	        statement.setString(1, penalizacion.getMomento());
	        statement.setDouble(2, penalizacion.getTiempo());

	        int filasAfectadas = statement.executeUpdate();
	        return filasAfectadas > 0; 

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	}



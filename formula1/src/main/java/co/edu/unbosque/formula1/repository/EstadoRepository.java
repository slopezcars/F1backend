package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Estado;

@Repository
public class EstadoRepository {
	
	@Autowired
	private ConexionDB conexionDB;

	public boolean crearestado(Estado estado) {

		String sql = "INSERT INTO estado  (nombre) VALUES (?)";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

		
			statement.setString(1, estado.getNombre());
			
			int filasAfectadas = statement.executeUpdate();
			return filasAfectadas > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

}

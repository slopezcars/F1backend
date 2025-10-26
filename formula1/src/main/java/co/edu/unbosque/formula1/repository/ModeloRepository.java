package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Modelo;

@Repository
public class ModeloRepository {

	@Autowired
	private ConexionDB conexionDB;

	public boolean crearmodelo(Modelo modelo) {

		String sql = "INSERT INTO modelo (modelo) VALUES (?)";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, modelo.getNombre());

			int filasAfectadas = statement.executeUpdate();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
}

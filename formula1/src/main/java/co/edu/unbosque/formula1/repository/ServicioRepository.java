package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Servicio;

@Repository
public class ServicioRepository {

	@Autowired
	private ConexionDB conexionDB;

	public boolean crearservicio(Servicio servicio) {

		String sql = "INSERT INTO servicio (descripcion) VALUES (?)";

		try (Connection connection = conexionDB.obtenerConexion();

				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, servicio.getDescripcion());

			int filasAfectadas = statement.executeUpdate();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

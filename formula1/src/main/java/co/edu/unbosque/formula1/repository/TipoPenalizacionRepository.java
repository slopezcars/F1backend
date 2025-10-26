package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.TipoPenalizacion;

@Repository
public class TipoPenalizacionRepository {

	@Autowired
	private ConexionDB conexionDB;

	public boolean creartipopenalizacion(TipoPenalizacion tipoPenalizacion) {

		String sql = "INSERT INTO tipopenalizacion (nombre,descripcion) VALUES (?,?)";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, tipoPenalizacion.getNombre());
			statement.setString(2, tipoPenalizacion.getDescripcion());

			int filasAfectadas = statement.executeUpdate();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
}

package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Auto;

@Repository
public class AutoRepository {

	@Autowired
	private ConexionDB conexionDB;

	public boolean crearauto(Auto auto) {

		String sql = "INSERT INTO auto (fecha_estreno, id_modelo, id_motor, numero_chasis) VALUES (?,?,?,?)";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setTimestamp(1, Timestamp.valueOf(auto.getFechaEstreno().atStartOfDay()));
			statement.setInt(2, auto.getIdmodelo());
			statement.setInt(3, auto.getIdmotor());
			statement.setInt(3, auto.getNumeroChasis());

			int filasAfectadas = statement.executeUpdate();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
}

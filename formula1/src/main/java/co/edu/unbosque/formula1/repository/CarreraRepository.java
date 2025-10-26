package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Carrera;

@Repository
public class CarreraRepository {
	@Autowired
	private ConexionDB conexionDB;

	public boolean crearcarrera(Carrera carrera) {

		String sql = "INSERT INTO carrera (hora_inicio, hora_fin, nombre, fecha, id_jefe_equipo, id_circuito) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setTime(1, Time.valueOf(carrera.getHoraInicio()));
			statement.setTime(2, Time.valueOf(carrera.getHoraFin()));
			statement.setString(3, carrera.getNombre());
			statement.setDate(4, Date.valueOf(carrera.getFecha()));
			statement.setInt(5, carrera.getIdJefeEquipo());
			statement.setInt(6, carrera.getIdCircuito());

			int filasAfectadas = statement.executeUpdate();
			return filasAfectadas > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

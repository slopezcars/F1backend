package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Motor;

@Repository
public class MotorRepository {

	@Autowired
	private ConexionDB conexionDB;

	public boolean crearmotor(Motor motor) {

		String sql = "INSERT INTO motor (codigo_motor) VALUES (?)";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, motor.getCodigoMotor());

			int filasAfectadas = statement.executeUpdate();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}

}

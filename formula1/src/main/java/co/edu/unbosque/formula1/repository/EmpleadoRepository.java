package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Empleado;

@Repository
public class EmpleadoRepository {

	@Autowired
	private ConexionDB conexionDB;

	public boolean crearempleado(Empleado empleado) {

		String sql = "INSERT INTO empleado (fecha_nacimiento, primer_nombre, primer_apellido, id_nacionalidad, id_estado) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setTimestamp(1, Timestamp.valueOf(empleado.getFechaNacimiento().atStartOfDay()));
			statement.setString(2, empleado.getPrimerNombre());
			statement.setString(3, empleado.getPrimerApellido());
			statement.setInt(4, empleado.getIdNacionalidad());
			statement.setInt(5, empleado.getIdEstado());

			int filasAfectadas = statement.executeUpdate();
			return filasAfectadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

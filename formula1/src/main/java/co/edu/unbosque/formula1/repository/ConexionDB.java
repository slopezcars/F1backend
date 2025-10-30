package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ConexionDB {

	private static final String URL = "jdbc:mysql://localhost:3306/racedatav1";
	private static final String USURARIO = "root";
	private static final String CONTRASENIA = "12345678";

	public Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(URL, USURARIO, CONTRASENIA);
	}
}

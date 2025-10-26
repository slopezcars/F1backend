<<<<<<< HEAD
package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ConexionDB {

	private static final String URL = "jdbc:mysql://172.20.36.228:3306/formula1";
	private static final String USURARIO= "sofi";
	private static final String CONTRASENIA = "formula1";
	
	public Connection obtenerConexion () throws SQLException {
		return DriverManager.getConnection(URL,USURARIO,CONTRASENIA);
	}
}
=======
package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ConexionDB {

	private static final String URL = "jdbc:mysql://192.168.20.36:3306/formula1";
	private static final String USURARIO= "sofi";
	private static final String CONTRASENIA = "formula1";
	
	public Connection obtenerConexion () throws SQLException {
		return DriverManager.getConnection(URL,USURARIO,CONTRASENIA);
	}
}
>>>>>>> branch 'main' of https://github.com/slopezcars/F1backend.git

package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Nacionalidad;


@Repository
public class NacionalidadRepository {

    private ConexionDB conexionDB = new ConexionDB();

    public boolean crearNacionalidad(Nacionalidad nacionalidad) {
        String sql = "INSERT INTO nacionalidad (nombre) VALUES (?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nacionalidad.getNombre());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

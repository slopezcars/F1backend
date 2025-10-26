package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Circuito;

@Repository
public class CircuitoRepository {

    @Autowired
    private ConexionDB conexionDB;

    public boolean crearCircuito(Circuito circuito) {
        String sql = "INSERT INTO circuito (num_vueltas, nombre) VALUES (?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, circuito.getNumVueltas());
            statement.setString(2, circuito.getNombre());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0; 
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

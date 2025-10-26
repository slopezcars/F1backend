package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.AutCir;

@Repository
public class AutCirRepository {

    @Autowired
    private ConexionDB conexionDB;

    public boolean crearAutCir(AutCir autCir) {
        String sql = "INSERT INTO aut_cir (id_sector, placa, velocidad) VALUES (?, ?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, autCir.getIdSector());
            statement.setString(2, autCir.getPlaca());
            statement.setDouble(3, autCir.getVelocidad());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

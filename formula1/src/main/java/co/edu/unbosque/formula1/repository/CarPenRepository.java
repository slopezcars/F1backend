package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.CarPen;

@Repository
public class CarPenRepository {

    @Autowired
    private ConexionDB conexionDB;

    public boolean crearCarPen(CarPen carPen) {
        String sql = "INSERT INTO car_pen (id_carrera, id_penalizacion) VALUES (?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, carPen.getIdCarrera());
            statement.setInt(2, carPen.getIdPenalizacion());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

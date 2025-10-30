package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Motor;

@Repository
public class MotorRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo motor
    public boolean crearMotor(Motor motor) {
        String sql = "INSERT INTO motor (tipo_motor) VALUES (?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, motor.getTipoMotor());
            int filas = statement.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todos los motores
    public List<Motor> obtenerTodos() {
        List<Motor> motores = new ArrayList<>();
        String sql = "SELECT * FROM motor";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Motor motor = new Motor();
                motor.setIdmotor(rs.getInt("id_motor"));
                motor.setTipoMotor(rs.getInt("tipo_motor"));
                motores.add(motor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motores;
    }

    // Buscar por ID
    public Motor buscarPorId(int idmotor) {
        String sql = "SELECT * FROM motor WHERE id_motor = ?";
        Motor motor = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idmotor);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    motor = new Motor();
                    motor.setIdmotor(rs.getInt("id_motor"));
                    motor.setTipoMotor(rs.getInt("tipo_motor"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return motor;
    }

    // Editar motor
    public boolean editarMotor(Motor motor) {
        String sql = "UPDATE motor SET tipo_motor = ? WHERE id_motor = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, motor.getTipoMotor());
            statement.setInt(2, motor.getIdmotor());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar motor
    public boolean eliminarMotor(int idmotor) {
        String sql = "DELETE FROM motor WHERE id_motor = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idmotor);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

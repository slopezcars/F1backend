package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Auto;

@Repository
public class AutoRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo auto
    public boolean crearAuto(Auto auto) {
        String sql = "INSERT INTO auto (fecha_estreno, id_modelo, id_motor, numero_chasis) VALUES (?, ?, ?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, Date.valueOf(auto.getFechaEstreno()));
            statement.setInt(2, auto.getIdmodelo());
            statement.setInt(3, auto.getIdmotor());
            statement.setString(4, auto.getNumeroChasis());
            statement.setString(5, auto.getPlaca());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los autos
    public List<Auto> obtenerTodos() {
        List<Auto> autos = new ArrayList<>();
        String sql = "SELECT * FROM auto";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Auto auto = new Auto();
                auto.setFechaEstreno(rs.getDate("fecha_estreno").toLocalDate());
                auto.setIdmodelo(rs.getInt("id_modelo"));
                auto.setIdmotor(rs.getInt("id_motor"));
                auto.setNumeroChasis(rs.getString("numero_chasis"));
                auto.setPlaca(rs.getString("placa"));
                autos.add(auto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autos;
    }

    // Buscar auto por placa (clave primaria)
    public Auto buscarPorPlaca(String placa) {
        String sql = "SELECT * FROM auto WHERE placa = ?";
        Auto auto = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, placa);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    auto = new Auto();
                    auto.setFechaEstreno(rs.getDate("fecha_estreno").toLocalDate());
                    auto.setIdmodelo(rs.getInt("id_modelo"));
                    auto.setIdmotor(rs.getInt("id_motor"));
                    auto.setNumeroChasis(rs.getString("numero_chasis"));
                    auto.setPlaca(rs.getString("placa"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auto;
    }

    // Editar un auto existente (por placa)
    public boolean editarAuto(Auto auto) {
        String sql = "UPDATE auto SET fecha_estreno = ?, id_modelo = ?, id_motor = ?, numero_chasis = ? WHERE placa = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, Date.valueOf(auto.getFechaEstreno()));
            statement.setInt(2, auto.getIdmodelo());
            statement.setInt(3, auto.getIdmotor());
            statement.setString(4, auto.getNumeroChasis());
            statement.setString(5, auto.getPlaca());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar auto por placa
    public boolean eliminarAuto(String placa) {
        String sql = "DELETE FROM auto WHERE placa = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, placa);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

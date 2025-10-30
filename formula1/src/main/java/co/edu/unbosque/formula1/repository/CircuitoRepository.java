package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Circuito;

@Repository
public class CircuitoRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo circuito
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

    // Obtener todos los circuitos
    public List<Circuito> obtenerTodos() {
        List<Circuito> circuitos = new ArrayList<>();
        String sql = "SELECT * FROM circuito";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Circuito circuito = new Circuito();
                circuito.setIdCircuito(rs.getInt("id_circuito"));
                circuito.setNumVueltas(rs.getInt("num_vueltas"));
                circuito.setNombre(rs.getString("nombre"));
                circuitos.add(circuito);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return circuitos;
    }

    // Buscar un circuito por su ID
    public Circuito buscarPorId(int idCircuito) {
        String sql = "SELECT * FROM circuito WHERE id_circuito = ?";
        Circuito circuito = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCircuito);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    circuito = new Circuito();
                    circuito.setIdCircuito(rs.getInt("id_circuito"));
                    circuito.setNumVueltas(rs.getInt("num_vueltas"));
                    circuito.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return circuito;
    }

    // Editar un circuito existente
    public boolean editarCircuito(Circuito circuito) {
        String sql = "UPDATE circuito SET num_vueltas = ?, nombre = ? WHERE id_circuito = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, circuito.getNumVueltas());
            statement.setString(2, circuito.getNombre());
            statement.setInt(3, circuito.getIdCircuito());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un circuito por ID
    public boolean eliminarCircuito(int idCircuito) {
        String sql = "DELETE FROM circuito WHERE id_circuito = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCircuito);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

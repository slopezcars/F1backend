package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Estado;

@Repository
public class EstadoRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo estado
    public boolean crearEstado(Estado estado) {
        String sql = "INSERT INTO estado (nombre) VALUES (?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, estado.getNombre());
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los estados
    public List<Estado> obtenerTodos() {
        List<Estado> estados = new ArrayList<>();
        String sql = "SELECT * FROM estado";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("id_estado"));
                estado.setNombre(rs.getString("nombre"));
                estados.add(estado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estados;
    }

    // Buscar por ID
    public Estado buscarPorId(int id) {
        String sql = "SELECT * FROM estado WHERE id_estado = ?";
        Estado estado = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    estado = new Estado();
                    estado.setIdEstado(rs.getInt("id_estado"));
                    estado.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estado;
    }

    // Editar estado
    public boolean editarEstado(Estado estado) {
        String sql = "UPDATE estado SET nombre = ? WHERE id_estado = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, estado.getNombre());
            statement.setInt(2, estado.getIdEstado());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar estado
    public boolean eliminarEstado(int id) {
        String sql = "DELETE FROM estado WHERE id_estado = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

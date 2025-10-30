package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.TipoPenalizacion;

@Repository
public class TipoPenalizacionRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo tipo de penalización
    public boolean crearTipoPenalizacion(TipoPenalizacion tipo) {
        String sql = "INSERT INTO tipo_penalizacion (nombre, descripcion) VALUES (?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tipo.getNombre());
            statement.setString(2, tipo.getDescripcion());
            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los tipos de penalización
    public List<TipoPenalizacion> obtenerTodos() {
        List<TipoPenalizacion> tipos = new ArrayList<>();
        String sql = "SELECT * FROM tipo_penalizacion";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                TipoPenalizacion tp = new TipoPenalizacion();
                tp.setIdTipoPenalizacion(rs.getInt("id_tipo_penalizacion"));
                tp.setNombre(rs.getString("nombre"));
                tp.setDescripcion(rs.getString("descripcion"));
                tipos.add(tp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipos;
    }

    // Buscar tipo de penalización por ID
    public TipoPenalizacion buscarPorId(int id) {
        String sql = "SELECT * FROM tipo_penalizacion WHERE id_tipo_penalizacion = ?";
        TipoPenalizacion tipo = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    tipo = new TipoPenalizacion();
                    tipo.setIdTipoPenalizacion(rs.getInt("id_tipo_penalizacion"));
                    tipo.setNombre(rs.getString("nombre"));
                    tipo.setDescripcion(rs.getString("descripcion"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipo;
    }

    // Editar un tipo de penalización
    public boolean editarTipoPenalizacion(TipoPenalizacion tipo) {
        String sql = "UPDATE tipo_penalizacion SET nombre = ?, descripcion = ? WHERE id_tipo_penalizacion = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tipo.getNombre());
            statement.setString(2, tipo.getDescripcion());
            statement.setInt(3, tipo.getIdTipoPenalizacion());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar tipo de penalización
    public boolean eliminarTipoPenalizacion(int id) {
        String sql = "DELETE FROM tipo_penalizacion WHERE id_tipo_penalizacion = ?";

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

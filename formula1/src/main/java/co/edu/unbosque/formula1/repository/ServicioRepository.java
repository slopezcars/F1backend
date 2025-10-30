
package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Servicio;

@Repository
public class ServicioRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo servicio
    public boolean crearServicio(Servicio servicio) {
        String sql = "INSERT INTO servicio (descripcion) VALUES (?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, servicio.getDescripcion());
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los servicios
    public List<Servicio> obtenerTodos() {
        List<Servicio> servicios = new ArrayList<>();
        String sql = "SELECT * FROM servicio";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Servicio s = new Servicio();
                s.setIdServicio(rs.getInt("id_servicio"));
                s.setDescripcion(rs.getString("descripcion"));
                servicios.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servicios;
    }

    // Buscar un servicio por su ID
    public Servicio buscarPorId(int idServicio) {
        String sql = "SELECT * FROM servicio WHERE id_servicio = ?";
        Servicio servicio = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idServicio);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    servicio = new Servicio();
                    servicio.setIdServicio(rs.getInt("id_servicio"));
                    servicio.setDescripcion(rs.getString("descripcion"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servicio;
    }

    // Editar un servicio existente
    public boolean editarServicio(Servicio servicio) {
        String sql = "UPDATE servicio SET descripcion = ? WHERE id_servicio = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, servicio.getDescripcion());
            statement.setInt(2, servicio.getIdServicio());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un servicio por ID
    public boolean eliminarServicio(int idServicio) {
        String sql = "DELETE FROM servicio WHERE id_servicio = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idServicio);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

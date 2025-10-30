package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Nacionalidad;

@Repository
public class NacionalidadRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear una nueva nacionalidad
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

    // Obtener todas las nacionalidades
    public List<Nacionalidad> obtenerTodas() {
        List<Nacionalidad> nacionalidades = new ArrayList<>();
        String sql = "SELECT * FROM nacionalidad";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Nacionalidad nac = new Nacionalidad();
                nac.setIdNacionalidad(rs.getInt("id_nacionalidad"));
                nac.setNombre(rs.getString("nombre"));
                nacionalidades.add(nac);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nacionalidades;
    }

    // Buscar una nacionalidad por su ID
    public Nacionalidad buscarPorId(int idNacionalidad) {
        String sql = "SELECT * FROM nacionalidad WHERE id_nacionalidad = ?";
        Nacionalidad nacionalidad = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idNacionalidad);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    nacionalidad = new Nacionalidad();
                    nacionalidad.setIdNacionalidad(rs.getInt("id_nacionalidad"));
                    nacionalidad.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nacionalidad;
    }

    // Editar una nacionalidad existente
    public boolean editarNacionalidad(Nacionalidad nacionalidad) {
        String sql = "UPDATE nacionalidad SET nombre = ? WHERE id_nacionalidad = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nacionalidad.getNombre());
            statement.setInt(2, nacionalidad.getIdNacionalidad());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar una nacionalidad por ID
    public boolean eliminarNacionalidad(int idNacionalidad) {
        String sql = "DELETE FROM nacionalidad WHERE id_nacionalidad = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idNacionalidad);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

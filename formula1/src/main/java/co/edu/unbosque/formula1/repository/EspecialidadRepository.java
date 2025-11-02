package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Especialidad;

@Repository
public class EspecialidadRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear especialidad
    public boolean crearEspecialidad(Especialidad especialidad) {
        String sql = "INSERT INTO especialidad (nombre) VALUES (?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, especialidad.getNombre());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todas las especialidades
    public List<Especialidad> obtenerTodas() {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialidad";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Especialidad e = new Especialidad();
                e.setIdEspecialidad(rs.getInt("id_especialidad"));
                e.setNombre(rs.getString("nombre"));
                lista.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar por ID
    public Especialidad buscarPorId(int idEspecialidad) {
        String sql = "SELECT * FROM especialidad WHERE id_especialidad = ?";
        Especialidad especialidad = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idEspecialidad);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    especialidad = new Especialidad();
                    especialidad.setIdEspecialidad(rs.getInt("id_especialidad"));
                    especialidad.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return especialidad;
    }

    // Editar especialidad
    public boolean editarEspecialidad(Especialidad especialidad) {
        String sql = "UPDATE especialidad SET nombre = ? WHERE id_especialidad = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, especialidad.getNombre());
            statement.setInt(2, especialidad.getIdEspecialidad());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

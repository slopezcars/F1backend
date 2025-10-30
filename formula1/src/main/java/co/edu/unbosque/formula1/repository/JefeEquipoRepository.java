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

import co.edu.unbosque.formula1.model.JefeEquipo;

@Repository
public class JefeEquipoRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo jefe de equipo
    public boolean crearJefeEquipo(JefeEquipo jefeEquipo) {
        String sql = "INSERT INTO jefe_equipo (fecha_inicio) VALUES (?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, Date.valueOf(jefeEquipo.getFechaInicio()));
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los jefes de equipo
    public List<JefeEquipo> obtenerTodos() {
        List<JefeEquipo> jefes = new ArrayList<>();
        String sql = "SELECT * FROM jefe_equipo";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                JefeEquipo jefe = new JefeEquipo();
                jefe.setId(rs.getInt("id"));
                jefe.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
                jefes.add(jefe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jefes;
    }

    // Buscar jefe de equipo por ID
    public JefeEquipo buscarPorId(int id) {
        String sql = "SELECT * FROM jefe_equipo WHERE id = ?";
        JefeEquipo jefe = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    jefe = new JefeEquipo();
                    jefe.setId(rs.getInt("id"));
                    jefe.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jefe;
    }

    // Editar jefe de equipo
    public boolean editarJefeEquipo(JefeEquipo jefeEquipo) {
        String sql = "UPDATE jefe_equipo SET fecha_inicio = ? WHERE id = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, Date.valueOf(jefeEquipo.getFechaInicio()));
            statement.setInt(2, jefeEquipo.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar jefe de equipo
    public boolean eliminarJefeEquipo(int id) {
        String sql = "DELETE FROM jefe_equipo WHERE id = ?";

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

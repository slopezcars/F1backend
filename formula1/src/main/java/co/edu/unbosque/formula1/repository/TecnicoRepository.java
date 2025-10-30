package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Tecnico;

@Repository
public class TecnicoRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo técnico
    public boolean crearTecnico(Tecnico tecnico) {
        String sql = "INSERT INTO tecnico (id_especialidad) VALUES (?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, tecnico.getIdEspecialidad());
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los técnicos
    public List<Tecnico> obtenerTodos() {
        List<Tecnico> tecnicos = new ArrayList<>();
        String sql = "SELECT * FROM tecnico";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Tecnico tec = new Tecnico();
                tec.setId(rs.getInt("id"));
                tec.setIdEspecialidad(rs.getInt("id_especialidad"));
                tecnicos.add(tec);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tecnicos;
    }

    // Buscar técnico por ID
    public Tecnico buscarPorId(int id) {
        String sql = "SELECT * FROM tecnico WHERE id = ?";
        Tecnico tecnico = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    tecnico = new Tecnico();
                    tecnico.setId(rs.getInt("id"));
                    tecnico.setIdEspecialidad(rs.getInt("id_especialidad"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tecnico;
    }

    // Editar un técnico existente
    public boolean editarTecnico(Tecnico tecnico) {
        String sql = "UPDATE tecnico SET id_especialidad = ? WHERE id = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, tecnico.getIdEspecialidad());
            statement.setInt(2, tecnico.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar técnico por ID
    public boolean eliminarTecnico(int id) {
        String sql = "DELETE FROM tecnico WHERE id = ?";

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

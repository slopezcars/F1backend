package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Empleado;
import co.edu.unbosque.formula1.model.Especialidad;
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
        String sql = "SELECT t.id AS id_tecnico, t.id_especialidad, " +
                     "e.id AS id_empleado, e.primer_nombre, e.primer_apellido, " +
                     "e.fecha_nacimiento, e.id_nacionalidad, e.id_estado " +
                     "FROM tecnico t " +
                     "JOIN empleado e ON t.id_empleado = e.id";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Tecnico t = new Tecnico();
                t.setId(rs.getInt("id_tecnico"));
                t.setIdEspecialidad(rs.getInt("id_especialidad"));

                Empleado e = new Empleado();
                e.setId(rs.getInt("id_empleado"));
                e.setPrimerNombre(rs.getString("primer_nombre"));
                e.setPrimerApellido(rs.getString("primer_apellido"));
                e.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                e.setIdNacionalidad(rs.getInt("id_nacionalidad"));
                e.setIdEstado(rs.getInt("id_estado"));

                t.setEmpleado(e); // Asegúrate de tener: private Empleado empleado;

                tecnicos.add(t);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
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
    
 // Agregar una especialidad a un técnico
    public boolean agregarEspecialidadATecnico(int idTecnico, int idEspecialidad) {
        String sql = "INSERT INTO tec_esp (id_tecnico, id_especialidad) VALUES (?, ?)";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idTecnico);
            ps.setInt(2, idEspecialidad);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar una especialidad de un técnico
    public boolean eliminarEspecialidadDeTecnico(int idTecnico, int idEspecialidad) {
        String sql = "DELETE FROM tec_esp WHERE id_tecnico = ? AND id_especialidad = ?";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idTecnico);
            ps.setInt(2, idEspecialidad);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Mostrar todas las especialidades de un técnico
    public List<Especialidad> obtenerEspecialidadesDeTecnico(int idTecnico) {
        List<Especialidad> especialidades = new ArrayList<>();
        String sql = """
            SELECT e.id_especialidad, e.nombre
            FROM tec_esp te
            INNER JOIN especialidad e ON te.id_especialidad = e.id_especialidad
            WHERE te.id_tecnico = ?
        """;

        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idTecnico);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Especialidad esp = new Especialidad();
                    esp.setIdEspecialidad(rs.getInt("id_especialidad"));
                    esp.setNombre(rs.getString("nombre"));
                    especialidades.add(esp);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especialidades;
    }
}
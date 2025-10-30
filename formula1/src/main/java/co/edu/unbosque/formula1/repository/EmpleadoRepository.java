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

import co.edu.unbosque.formula1.model.Empleado;

@Repository
public class EmpleadoRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo empleado
    public boolean crearEmpleado(Empleado empleado) {
        String sql = "INSERT INTO empleado (fecha_nacimiento, primer_nombre, primer_apellido, id_nacionalidad, id_estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, Date.valueOf(empleado.getFechaNacimiento()));
            statement.setString(2, empleado.getPrimerNombre());
            statement.setString(3, empleado.getPrimerApellido());
            statement.setInt(4, empleado.getIdNacionalidad());
            statement.setInt(5, empleado.getIdEstado());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los empleados
    public List<Empleado> obtenerTodos() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id"));
                empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                empleado.setPrimerNombre(rs.getString("primer_nombre"));
                empleado.setPrimerApellido(rs.getString("primer_apellido"));
                empleado.setIdNacionalidad(rs.getInt("id_nacionalidad"));
                empleado.setIdEstado(rs.getInt("id_estado"));
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }

    // Buscar empleado por ID
    public Empleado buscarPorId(int id) {
        String sql = "SELECT * FROM empleado WHERE id = ?";
        Empleado empleado = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setId(rs.getInt("id"));
                    empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                    empleado.setPrimerNombre(rs.getString("primer_nombre"));
                    empleado.setPrimerApellido(rs.getString("primer_apellido"));
                    empleado.setIdNacionalidad(rs.getInt("id_nacionalidad"));
                    empleado.setIdEstado(rs.getInt("id_estado"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleado;
    }

    // Editar empleado
    public boolean editarEmpleado(Empleado empleado) {
        String sql = "UPDATE empleado SET fecha_nacimiento = ?, primer_nombre = ?, primer_apellido = ?, id_nacionalidad = ?, id_estado = ? WHERE id = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, Date.valueOf(empleado.getFechaNacimiento()));
            statement.setString(2, empleado.getPrimerNombre());
            statement.setString(3, empleado.getPrimerApellido());
            statement.setInt(4, empleado.getIdNacionalidad());
            statement.setInt(5, empleado.getIdEstado());
            statement.setInt(6, empleado.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar empleado
    public boolean eliminarEmpleado(int id) {
        String sql = "DELETE FROM empleado WHERE id = ?";

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

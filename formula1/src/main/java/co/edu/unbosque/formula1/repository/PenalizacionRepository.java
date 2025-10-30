package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Penalizacion;

@Repository
public class PenalizacionRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear penalización
    public boolean crearPenalizacion(Penalizacion penalizacion) {
        String sql = "INSERT INTO penalizacion (momento, tiempo) VALUES (?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLocalDateTime(1, penalizacion.getMomento());
            statement.setDouble(2, penalizacion.getTiempo());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todas
    public List<Penalizacion> obtenerTodas() {
        List<Penalizacion> penalizaciones = new ArrayList<>();
        String sql = "SELECT * FROM penalizacion";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Penalizacion p = new Penalizacion();
                p.setIdPenalizacion(rs.getInt("id_penalizacion"));
                p.setMomento(rs.getString("momento"));
                p.setTiempo(rs.getDouble("tiempo"));
                penalizaciones.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return penalizaciones;
    }

    // Buscar por ID
    public Penalizacion buscarPorId(int idPenalizacion) {
        String sql = "SELECT * FROM penalizacion WHERE id_penalizacion = ?";
        Penalizacion penalizacion = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idPenalizacion);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    penalizacion = new Penalizacion();
                    penalizacion.setIdPenalizacion(rs.getInt("id_penalizacion"));
                    penalizacion.setMomento(rs.getString("momento"));
                    penalizacion.setTiempo(rs.getDouble("tiempo"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return penalizacion;
    }

    // Editar penalización
    public boolean editarPenalizacion(Penalizacion penalizacion) {
        String sql = "UPDATE penalizacion SET momento = ?, tiempo = ? WHERE id_penalizacion = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, penalizacion.getMomento());
            statement.setDouble(2, penalizacion.getTiempo());
            statement.setInt(3, penalizacion.getIdPenalizacion());
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar penalización
    public boolean eliminarPenalizacion(int idPenalizacion) {
        String sql = "DELETE FROM penalizacion WHERE id_penalizacion = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idPenalizacion);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

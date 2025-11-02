package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.AutTec;

@Repository
public class AutTecRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear relación AutTec
    public boolean crearAutTec(AutTec autTec) {
        String sql = "INSERT INTO aut_tec (placa, id_tecnico, hora_entrada, hora_salida, id_servicio) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, autTec.getPlaca());
            statement.setInt(2, autTec.getIdTecnico());
            statement.setTime(3, Time.valueOf(autTec.getHoraEntrada()));
            statement.setTime(4, Time.valueOf(autTec.getHoraSalida()));
            statement.setInt(5, autTec.getIdServicio());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todas las relaciones
    public List<AutTec> obtenerTodas() {
        List<AutTec> auttecs = new ArrayList<>();
        String sql = "SELECT * FROM aut_tec";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                AutTec a = new AutTec();
                a.setPlaca(rs.getString("placa"));
                a.setIdTecnico(rs.getInt("id_tecnico"));
                a.setHoraEntrada(rs.getTime("hora_entrada").toLocalTime());
                a.setHoraSalida(rs.getTime("hora_salida").toLocalTime());
                a.setIdServicio(rs.getInt("id_servicio"));
                auttecs.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auttecs;
    }

    // Buscar relación por clave compuesta (placa + idTecnico)
    public AutTec buscarPorId(String placa, int idTecnico) {
        String sql = "SELECT * FROM aut_tec WHERE placa = ? AND id_tecnico = ?";
        AutTec autTec = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, placa);
            statement.setInt(2, idTecnico);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    autTec = new AutTec();
                    autTec.setPlaca(rs.getString("placa"));
                    autTec.setIdTecnico(rs.getInt("id_tecnico"));
                    autTec.setHoraEntrada(rs.getTime("hora_entrada").toLocalTime());
                    autTec.setHoraSalida(rs.getTime("hora_salida").toLocalTime());
                    autTec.setIdServicio(rs.getInt("id_servicio"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autTec;
    }

    // Editar relación
    public boolean editarAutTec(AutTec autTec) {
        String sql = "UPDATE aut_tec SET hora_entrada = ?, hora_salida = ?, id_servicio = ? WHERE placa = ? AND id_tecnico = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTime(1, Time.valueOf(autTec.getHoraEntrada()));
            statement.setTime(2, Time.valueOf(autTec.getHoraSalida()));
            statement.setInt(3, autTec.getIdServicio());
            statement.setString(4, autTec.getPlaca());
            statement.setInt(5, autTec.getIdTecnico());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar relación
    public boolean eliminarAutTec(String placa, int idTecnico) {
        String sql = "DELETE FROM aut_tec WHERE placa = ? AND id_tecnico = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, placa);
            statement.setInt(2, idTecnico);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

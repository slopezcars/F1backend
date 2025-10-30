package co.edu.unbosque.formula1.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.AutTec;

@Repository
public class AutTecRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un registro de AutTec
    public boolean crearAutTec(AutTec autTec) {
        String sql = "INSERT INTO aut_tec (placa, id_tecnico, hora_entrada, hora_salida, id_servicio) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, autTec.getPlaca());
            statement.setInt(2, autTec.getIdTecnico());            
            statement.setLocalTime(3, Timestamp.valueOf(autTec.getHoraEntrada()));
            statement.setTimestamp(4, Timestamp.valueOf(autTec.getHoraSalida()));
            
            statement.setInt(5, autTec.getIdServicio());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todos los registros
    public List<AutTec> obtenerTodos() {
        List<AutTec> lista = new ArrayList<>();
        String sql = "SELECT * FROM aut_tec";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                AutTec autTec = new AutTec();
                autTec.setPlaca(rs.getString("placa"));
                autTec.setIdTecnico(rs.getInt("id_tecnico"));
                autTec.setHoraEntrada(rs.getTimestamp("hora_entrada").toLocalDateTime());
                autTec.setHoraSalida(rs.getTimestamp("hora_salida").toLocalDateTime());
                autTec.setIdServicio(rs.getInt("id_servicio"));
                lista.add(autTec);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar por placa e idTecnico (clave compuesta)
    public AutTec buscarPorPlacaYTecnico(String placa, int idTecnico) {
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
                    autTec.setHoraEntrada(rs.getTimestamp("hora_entrada").toLocalDateTime());
                    autTec.setHoraSalida(rs.getTimestamp("hora_salida").toLocalDateTime());
                    autTec.setIdServicio(rs.getInt("id_servicio"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autTec;
    }

    // Editar un registro existente
    public boolean editarAutTec(AutTec autTec) {
        String sql = "UPDATE aut_tec SET hora_entrada = ?, hora_salida = ?, id_servicio = ? WHERE placa = ? AND id_tecnico = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTimestamp(1, Timestamp.valueOf(autTec.getHoraEntrada()));
            statement.setTimestamp(2, Timestamp.valueOf(autTec.getHoraSalida()));
            statement.setInt(3, autTec.getIdServicio());
            statement.setString(4, autTec.getPlaca());
            statement.setInt(5, autTec.getIdTecnico());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un registro
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

package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.AutCir;

@Repository
public class AutCirRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo registro de AutCir
    public boolean crearAutCir(AutCir autCir) {
        String sql = "INSERT INTO aut_cir (id_sector, placa, velocidad) VALUES (?, ?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, autCir.getIdSector());
            statement.setString(2, autCir.getPlaca());
            statement.setDouble(3, autCir.getVelocidad());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los registros
    public List<AutCir> obtenerTodos() {
        List<AutCir> lista = new ArrayList<>();
        String sql = "SELECT * FROM aut_cir";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                AutCir autCir = new AutCir();
                autCir.setIdSector(rs.getInt("id_sector"));
                autCir.setPlaca(rs.getString("placa"));
                autCir.setVelocidad(rs.getDouble("velocidad"));
                lista.add(autCir);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar por ID de sector
    public AutCir buscarPorId(int idSector) {
        String sql = "SELECT * FROM aut_cir WHERE id_sector = ?";
        AutCir autCir = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idSector);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    autCir = new AutCir();
                    autCir.setIdSector(rs.getInt("id_sector"));
                    autCir.setPlaca(rs.getString("placa"));
                    autCir.setVelocidad(rs.getDouble("velocidad"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autCir;
    }

    // Editar un registro existente
    public boolean editarAutCir(AutCir autCir) {
        String sql = "UPDATE aut_cir SET placa = ?, velocidad = ? WHERE id_sector = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, autCir.getPlaca());
            statement.setDouble(2, autCir.getVelocidad());
            statement.setInt(3, autCir.getIdSector());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un registro por ID de sector
    public boolean eliminarAutCir(int idSector) {
        String sql = "DELETE FROM aut_cir WHERE id_sector = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idSector);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

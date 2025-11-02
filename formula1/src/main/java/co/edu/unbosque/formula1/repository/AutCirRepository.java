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

    // Crear relación AutCir
    public boolean crearAutCir(AutCir autCir) {
        String sql = "INSERT INTO aut_cir (id_circuito, placa, velocidad) VALUES (?, ?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, autCir.getIdCircuito());
            statement.setString(2, autCir.getPlaca());
            statement.setBigDecimal(3, autCir.getVelocidad());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todas las relaciones
    public List<AutCir> obtenerTodas() {
        List<AutCir> lista = new ArrayList<>();
        String sql = "SELECT * FROM aut_cir";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                AutCir a = new AutCir();
                a.setIdCircuito(rs.getInt("id_circuito"));
                a.setPlaca(rs.getString("placa"));
                a.setVelocidad(rs.getBigDecimal("velocidad"));
                lista.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar relación por clave compuesta
    public AutCir buscarPorId(int idCircuito, String placa) {
        String sql = "SELECT * FROM aut_cir WHERE id_circuito = ? AND placa = ?";
        AutCir autCir = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCircuito);
            statement.setString(2, placa);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    autCir = new AutCir();
                    autCir.setIdCircuito(rs.getInt("id_circuito"));
                    autCir.setPlaca(rs.getString("placa"));
                    autCir.setVelocidad(rs.getBigDecimal("velocidad"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autCir;
    }

    // Editar relación
    public boolean editarAutCir(AutCir autCir) {
        String sql = "UPDATE aut_cir SET velocidad = ? WHERE id_circuito = ? AND placa = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setBigDecimal(1, autCir.getVelocidad());
            statement.setInt(2, autCir.getIdCircuito());
            statement.setString(3, autCir.getPlaca());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar relación
    public boolean eliminarAutCir(int idCircuito, String placa) {
        String sql = "DELETE FROM aut_cir WHERE id_circuito = ? AND placa = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCircuito);
            statement.setString(2, placa);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

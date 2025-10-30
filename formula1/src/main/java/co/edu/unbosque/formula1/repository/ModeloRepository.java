package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Modelo;

@Repository
public class ModeloRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear un nuevo modelo
    public boolean crearModelo(Modelo modelo) {
        String sql = "INSERT INTO modelo (nombre) VALUES (?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, modelo.getNombre());
            int filas = statement.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todos los modelos
    public List<Modelo> obtenerTodos() {
        List<Modelo> modelos = new ArrayList<>();
        String sql = "SELECT * FROM modelo";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setIdModelo(rs.getInt("id_modelo"));
                modelo.setNombre(rs.getString("nombre"));
                modelos.add(modelo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelos;
    }

    // Buscar por ID
    public Modelo buscarPorId(int idModelo) {
        String sql = "SELECT * FROM modelo WHERE id_modelo = ?";
        Modelo modelo = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idModelo);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    modelo = new Modelo();
                    modelo.setIdModelo(rs.getInt("id_modelo"));
                    modelo.setNombre(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }

    // Editar modelo
    public boolean editarModelo(Modelo modelo) {
        String sql = "UPDATE modelo SET nombre = ? WHERE id_modelo = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, modelo.getNombre());
            statement.setInt(2, modelo.getIdModelo());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar modelo
    public boolean eliminarModelo(int idModelo) {
        String sql = "DELETE FROM modelo WHERE id_modelo = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idModelo);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

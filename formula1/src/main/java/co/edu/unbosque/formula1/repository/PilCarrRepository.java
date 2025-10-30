package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.PilCarr;

@Repository
public class PilCarrRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear relación Piloto-Carrera
    public boolean crearPilCarr(PilCarr pilCarr) {
        String sql = "INSERT INTO pil_carr (id_piloto, id_carrera, ranking_final) VALUES (?, ?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, pilCarr.getIdPiloto());
            statement.setInt(2, pilCarr.getIdCarrera());
            statement.setInt(3, pilCarr.getRankingFinal());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todas las relaciones Piloto-Carrera
    public List<PilCarr> obtenerTodos() {
        List<PilCarr> lista = new ArrayList<>();
        String sql = "SELECT * FROM pil_carr";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                PilCarr pc = new PilCarr();
                pc.setIdPiloto(rs.getInt("id_piloto"));
                pc.setIdCarrera(rs.getInt("id_carrera"));
                pc.setRankingFinal(rs.getInt("ranking_final"));
                lista.add(pc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar una relación específica por id_piloto e id_carrera
    public PilCarr buscarPorIds(int idPiloto, int idCarrera) {
        String sql = "SELECT * FROM pil_carr WHERE id_piloto = ? AND id_carrera = ?";
        PilCarr pc = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idPiloto);
            statement.setInt(2, idCarrera);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    pc = new PilCarr();
                    pc.setIdPiloto(rs.getInt("id_piloto"));
                    pc.setIdCarrera(rs.getInt("id_carrera"));
                    pc.setRankingFinal(rs.getInt("ranking_final"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pc;
    }

    // Editar ranking final
    public boolean editarPilCarr(PilCarr pilCarr) {
        String sql = "UPDATE pil_carr SET ranking_final = ? WHERE id_piloto = ? AND id_carrera = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, pilCarr.getRankingFinal());
            statement.setInt(2, pilCarr.getIdPiloto());
            statement.setInt(3, pilCarr.getIdCarrera());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar relación Piloto-Carrera
    public boolean eliminarPilCarr(int idPiloto, int idCarrera) {
        String sql = "DELETE FROM pil_carr WHERE id_piloto = ? AND id_carrera = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idPiloto);
            statement.setInt(2, idCarrera);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

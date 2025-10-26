package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.PenTipp;

@Repository
public class PenTippRepository {
	
	@Autowired
	private ConexionDB conexionDB;

	public boolean crearpentipp(PenTipp penTipp) {
		String sql = "INSERT INTO pen_tipp (id_tipo_penalizacion, penalizacion_id) VALUES (?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, penTipp.getIdTipoPenalizacion());
            statement.setInt(2, penTipp.getPenalizacionId());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
}

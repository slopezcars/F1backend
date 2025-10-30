package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Piloto;

@Repository
public class PilotoRepository {

	@Autowired
	private ConexionDB conexionDB;

	// Crear piloto
	public boolean crearPiloto(Piloto piloto) {
		String sql = "INSERT INTO piloto (num_licencia) VALUES (?)";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, piloto.getNumLicencia());
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Listar todos los pilotos
	public List<Piloto> obtenerTodos() {
		List<Piloto> pilotos = new ArrayList<>();
		String sql = "SELECT * FROM piloto";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet rs = statement.executeQuery()) {

			while (rs.next()) {
				Piloto p = new Piloto();
				p.setId(rs.getInt("id_piloto"));
				p.setNumLicencia(rs.getString("num_licencia"));
				pilotos.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pilotos;
	}

	// Buscar piloto por ID
	public Piloto buscarPorId(int idPiloto) {
		String sql = "SELECT * FROM piloto WHERE id_piloto = ?";
		Piloto piloto = null;

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, idPiloto);

			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					piloto = new Piloto();
					piloto.setId(rs.getInt("id_piloto"));
					piloto.setNumLicencia(rs.getString("num_licencia"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return piloto;
	}

	// Editar piloto
	public boolean editarPiloto(Piloto piloto) {
		String sql = "UPDATE piloto SET num_licencia = ? WHERE id_piloto = ?";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, piloto.getNumLicencia());
			statement.setInt(2, piloto.getId());
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Eliminar piloto
	public boolean eliminarPiloto(int idPiloto) {
		String sql = "DELETE FROM piloto WHERE id_piloto = ?";

		try (Connection connection = conexionDB.obtenerConexion();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setInt(1, idPiloto);
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

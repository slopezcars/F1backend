package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Auto;
import co.edu.unbosque.formula1.model.Empleado;
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
	    String sql = "SELECT p.id AS id_piloto, p.num_licencia, " +
	                 "e.id AS id_empleado, e.primer_nombre, e.primer_apellido, " +
	                 "e.fecha_nacimiento, e.id_nacionalidad, e.id_estado " +
	                 "FROM piloto p " +
	                 "JOIN empleado e ON p.id_empleado = e.id";

	    try (Connection connection = conexionDB.obtenerConexion();
	         PreparedStatement statement = connection.prepareStatement(sql);
	         ResultSet rs = statement.executeQuery()) {

	        while (rs.next()) {
	            Piloto p = new Piloto();
	            p.setId(rs.getInt("id_piloto"));
	            p.setNumLicencia(rs.getString("num_licencia"));

	            // Crear el empleado asociado
	            Empleado e = new Empleado();
	            e.setId(rs.getInt("id_empleado"));
	            e.setPrimerNombre(rs.getString("primer_nombre"));
	            e.setPrimerApellido(rs.getString("primer_apellido"));
	            e.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
	            e.setIdNacionalidad(rs.getInt("id_nacionalidad"));
	            e.setIdEstado(rs.getInt("id_estado"));

	            p.setEmpleado(e); // Piloto debe tener atributo: private Empleado empleado;

	            pilotos.add(p);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
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
	// Asignar auto a piloto
	public boolean asignarAutoAPiloto(int idPiloto, String placaAuto) {
	    String sql = "INSERT INTO piloto_auto (id_piloto, placa_auto) VALUES (?, ?)";
	    try (Connection con = conexionDB.obtenerConexion();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, idPiloto);
	        ps.setString(2, placaAuto);
	        return ps.executeUpdate() > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	// Eliminar auto de piloto
	public boolean eliminarAutoDePiloto(int idPiloto, String placaAuto) {
	    String sql = "DELETE FROM piloto_auto WHERE id_piloto = ? AND placa_auto = ?";
	    try (Connection con = conexionDB.obtenerConexion();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, idPiloto);
	        ps.setString(2, placaAuto);
	        return ps.executeUpdate() > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	// Obtener autos de un piloto
	public List<Auto> obtenerAutosDePiloto(int idPiloto) {
	    List<Auto> autos = new ArrayList<>();
	    String sql = """
	        SELECT a.placa, a.numero_chasis, a.idmotor, a.fecha_estreno, a.idmodelo
	        FROM piloto_auto pa
	        INNER JOIN auto a ON pa.placa_auto = a.placa
	        WHERE pa.id_piloto = ?
	    """;

	    try (Connection con = conexionDB.obtenerConexion();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, idPiloto);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Auto auto = new Auto();
	                auto.setPlaca(rs.getString("placa"));
	                auto.setNumeroChasis(rs.getString("numero_chasis"));
	                auto.setIdmotor(rs.getInt("idmotor"));
	                auto.setFechaEstreno(rs.getDate("fecha_estreno").toLocalDate());
	                auto.setIdmodelo(rs.getInt("idmodelo"));
	                autos.add(auto);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return autos;
	}
	
	// Obtener pilotos de un auto
	public List<Piloto> obtenerPilotosDeAuto(String placaAuto) {
	    List<Piloto> pilotos = new ArrayList<>();
	    String sql = """
	        SELECT p.id, p.num_licencia, p.nombre, p.estado
	        FROM piloto_auto pa
	        INNER JOIN piloto p ON pa.id_piloto = p.id
	        WHERE pa.placa_auto = ?
	    """;

	    try (Connection con = conexionDB.obtenerConexion();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, placaAuto);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Piloto piloto = new Piloto();
	                piloto.setId(rs.getInt("id"));
	                piloto.setNumLicencia(rs.getString("num_licencia"));
	                pilotos.add(piloto);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pilotos;
	}
}

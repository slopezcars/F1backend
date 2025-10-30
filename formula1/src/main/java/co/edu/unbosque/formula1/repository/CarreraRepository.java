package co.edu.unbosque.formula1.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Carrera;

@Repository
public class CarreraRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear una nueva carrera
    public boolean crearCarrera(Carrera carrera) {
        String sql = "INSERT INTO carrera (hora_inicio, hora_fin,id_jefe_equipo, id_circuito, nombre,fecha) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

        	
            statement.setTime(1, Time.valueOf(carrera.getHoraInicio()));
            statement.setTime(2, Time.valueOf(carrera.getHoraFin()));
            statement.setString(3, carrera.getNombre());
            statement.setDate(4, Date.valueOf(carrera.getFecha()));
            statement.setInt(5, carrera.getIdJefeEquipo());
            statement.setInt(6, carrera.getIdCircuito());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todas las carreras
    public List<Carrera> obtenerTodas() {
        List<Carrera> carreras = new ArrayList<>();
        String sql = "SELECT * FROM carrera";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Carrera carrera = new Carrera();
                carrera.setIdCarrera(rs.getInt("id_Carrera"));
                carrera.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
                carrera.setHoraFin(rs.getTime("hora_fin").toLocalTime());
                carrera.setNombre(rs.getString("nombre"));
                carrera.setFecha(rs.getDate("fecha").toLocalDate());
                carrera.setIdJefeEquipo(rs.getInt("id_jefe_equipo"));
                carrera.setIdCircuito(rs.getInt("id_circuito"));
                carreras.add(carrera);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carreras;
    }

    // Buscar una carrera por su ID
    public Carrera buscarPorId(int idCarrera) {
        String sql = "SELECT * FROM carrera WHERE id = ?";
        Carrera carrera = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idCarrera);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    carrera = new Carrera();
                    carrera.setIdCarrera(rs.getInt("id_Carrera"));
                    carrera.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
                    carrera.setHoraFin(rs.getTime("hora_fin").toLocalTime());
                    carrera.setNombre(rs.getString("nombre"));
                    carrera.setFecha(rs.getDate("fecha").toLocalDate());
                    carrera.setIdJefeEquipo(rs.getInt("id_jefe_equipo"));
                    carrera.setIdCircuito(rs.getInt("id_circuito"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carrera;
    }

    // Editar una carrera existente
    public boolean editarCarrera(Carrera carrera) {
        String sql = "UPDATE carrera SET hora_inicio = ?, hora_fin = ?, nombre = ?, fecha = ?, id_jefe_equipo = ?, id_circuito = ? WHERE id = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTime(1, Time.valueOf(carrera.getHoraInicio()));
            statement.setTime(2, Time.valueOf(carrera.getHoraFin()));
            statement.setString(3, carrera.getNombre());
            statement.setDate(4, Date.valueOf(carrera.getFecha()));
            statement.setInt(5, carrera.getIdJefeEquipo());
            statement.setInt(6, carrera.getIdCircuito());
            statement.setInt(7, carrera.getIdCarrera());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar una carrera por ID
    public boolean eliminarCarrera(int id) {
        String sql = "DELETE FROM carrera WHERE id = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

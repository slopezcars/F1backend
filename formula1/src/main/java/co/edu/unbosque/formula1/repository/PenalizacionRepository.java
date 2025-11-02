package co.edu.unbosque.formula1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.formula1.model.Penalizacion;
import co.edu.unbosque.formula1.model.TipoPenalizacion;

@Repository
public class PenalizacionRepository {

    @Autowired
    private ConexionDB conexionDB;

    // Crear penalización
    public boolean crearPenalizacion(Penalizacion penalizacion) {
        String sql = "INSERT INTO penalizacion (momento, tiempo) VALUES (?, ?)";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTimestamp(1, Timestamp.valueOf(penalizacion.getMomento()));
            statement.setInt(2, penalizacion.getTiempo());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todas las penalizaciones
    public List<Penalizacion> obtenerTodas() {
        List<Penalizacion> penalizaciones = new ArrayList<>();
        String sql = "SELECT * FROM penalizacion";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Penalizacion p = new Penalizacion();
                p.setIdPenalizacion(rs.getInt("id_penalizacion"));
                p.setMomento(rs.getTimestamp("momento").toLocalDateTime());
                p.setTiempo(rs.getInt("tiempo"));
                penalizaciones.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return penalizaciones;
    }

    // Buscar penalización por ID
    public Penalizacion buscarPorId(int idPenalizacion) {
        String sql = "SELECT * FROM penalizacion WHERE id_penalizacion = ?";
        Penalizacion penalizacion = null;

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idPenalizacion);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    penalizacion = new Penalizacion();
                    penalizacion.setIdPenalizacion(rs.getInt("id_penalizacion"));
                    penalizacion.setMomento(rs.getTimestamp("momento").toLocalDateTime());
                    penalizacion.setTiempo(rs.getInt("tiempo"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return penalizacion;
    }

    // Editar penalización
    public boolean editarPenalizacion(Penalizacion penalizacion) {
        String sql = "UPDATE penalizacion SET momento = ?, tiempo = ? WHERE id_penalizacion = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setTimestamp(1, Timestamp.valueOf(penalizacion.getMomento()));
            statement.setInt(2, penalizacion.getTiempo());
            statement.setInt(3, penalizacion.getIdPenalizacion());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar penalización por ID
    public boolean eliminarPenalizacion(int idPenalizacion) {
        String sql = "DELETE FROM penalizacion WHERE id_penalizacion = ?";

        try (Connection connection = conexionDB.obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idPenalizacion);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
 // Asignar penalización a piloto
    public boolean agregarPenalizacionAPiloto(int idPiloto, int idPenalizacion) {
        String sql = "INSERT INTO pil_pen (id_piloto, id_penalizacion) VALUES (?, ?)";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPiloto);
            ps.setInt(2, idPenalizacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar penalización de piloto
    public boolean eliminarPenalizacionDePiloto(int idPiloto, int idPenalizacion) {
        String sql = "DELETE FROM pil_pen WHERE id_piloto = ? AND id_penalizacion = ?";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPiloto);
            ps.setInt(2, idPenalizacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener penalizaciones de un piloto
    public List<Penalizacion> obtenerPenalizacionesDePiloto(int idPiloto) {
        List<Penalizacion> penalizaciones = new ArrayList<>();
        String sql = """
            SELECT p.id_penalizacion, p.momento, p.tiempo
            FROM pil_pen pp
            INNER JOIN penalizacion p ON pp.id_penalizacion = p.id_penalizacion
            WHERE pp.id_piloto = ?
        """;
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPiloto);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Penalizacion pen = new Penalizacion();
                    pen.setIdPenalizacion(rs.getInt("id_penalizacion"));
                    pen.setMomento(rs.getTimestamp("momento").toLocalDateTime());
                    pen.setTiempo(rs.getInt("tiempo"));
                    penalizaciones.add(pen);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penalizaciones;
    }
 // Asignar penalización a carrera
    public boolean agregarPenalizacionACarrera(int idCarrera, int idPenalizacion) {
        String sql = "INSERT INTO car_pen (id_carrera, id_penalizacion) VALUES (?, ?)";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCarrera);
            ps.setInt(2, idPenalizacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar penalización de carrera
    public boolean eliminarPenalizacionDeCarrera(int idCarrera, int idPenalizacion) {
        String sql = "DELETE FROM car_pen WHERE id_carrera = ? AND id_penalizacion = ?";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCarrera);
            ps.setInt(2, idPenalizacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener penalizaciones de una carrera
    public List<Penalizacion> obtenerPenalizacionesDeCarrera(int idCarrera) {
        List<Penalizacion> penalizaciones = new ArrayList<>();
        String sql = """
            SELECT p.id_penalizacion, p.momento, p.tiempo
            FROM car_pen cp
            INNER JOIN penalizacion p ON cp.id_penalizacion = p.id_penalizacion
            WHERE cp.id_carrera = ?
        """;
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCarrera);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Penalizacion pen = new Penalizacion();
                    pen.setIdPenalizacion(rs.getInt("id_penalizacion"));
                    pen.setMomento(rs.getTimestamp("momento").toLocalDateTime());
                    pen.setTiempo(rs.getInt("tiempo"));
                    penalizaciones.add(pen);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penalizaciones;
    }
 // Asignar un tipo de penalización a una penalización
    public boolean asignarTipoAPenalizacion(int idPenalizacion, TipoPenalizacion tipo) {
        String sql = "INSERT INTO pen_tipp (id_penalizacion, id_tipo_penalizacion) VALUES (?, ?)";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPenalizacion);
            ps.setInt(2, tipo.getIdTipoPenalizacion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Quitar un tipo de penalización de una penalización
    public boolean quitarTipoDePenalizacion(int idPenalizacion, int idTipo) {
        String sql = "DELETE FROM pen_tipp WHERE id_penalizacion = ? AND id_tipo_penalizacion = ?";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPenalizacion);
            ps.setInt(2, idTipo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los tipos de una penalización
    public List<TipoPenalizacion> listarTiposDePenalizacion(int idPenalizacion) {
        List<TipoPenalizacion> tipos = new ArrayList<>();
        String sql = """
            SELECT t.id_tipo_penalizacion, t.nombre, t.descripcion
            FROM pen_tipp pt
            INNER JOIN tipo_penalizacion t ON pt.id_tipo_penalizacion = t.id_tipo_penalizacion
            WHERE pt.id_penalizacion = ?
        """;
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPenalizacion);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TipoPenalizacion tipo = new TipoPenalizacion();
                    tipo.setIdTipoPenalizacion(rs.getInt("id_tipo_penalizacion"));
                    tipo.setNombre(rs.getString("nombre"));
                    tipo.setDescripcion(rs.getString("descripcion"));
                    tipos.add(tipo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos;
    }
}

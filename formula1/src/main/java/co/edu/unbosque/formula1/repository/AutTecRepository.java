package co.edu.unbosque.formula1.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.formula1.model.AutTec;

public class AutTecRepository {

    private Connection connection;

    public AutTecRepository(Connection connection) {
        this.connection = connection;
    }

    // INSERTAR
    public void insertar(AutTec a) throws SQLException {
        String sql = "INSERT INTO auttec ( idTecnico, horaEntrada, horaSalida, idServicio) "
                   + "VALUES ( ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, a.getIdTecnico());
        stmt.setTime(2, Time.valueOf(a.getHoraEntrada()));
        stmt.setTime(3, Time.valueOf(a.getHoraSalida()));
        stmt.setInt(4, a.getIdServicio());
        stmt.executeUpdate();
    }

    // CONSULTAR TODOS
    public List<AutTec> obtenerTodos() throws SQLException {
        List<AutTec> lista = new ArrayList<>();

        String sql = "SELECT * FROM auttec";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            AutTec a = new AutTec(
                rs.getString("placa"),
                rs.getInt("idTecnico"),
                rs.getTime("horaEntrada").toLocalTime(),
                rs.getTime("horaSalida").toLocalTime(),
                rs.getInt("idServicio")
            );
            lista.add(a);
        }

        return lista;
    }

    // ACTUALIZAR (usa placa como identificador)
    public void actualizar(AutTec a) throws SQLException {
        String sql = "UPDATE auttec SET idTecnico=?, horaEntrada=?, horaSalida=?, idServicio=? "
                   + "WHERE placa=?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, a.getIdTecnico());
        stmt.setTime(2, Time.valueOf(a.getHoraEntrada()));
        stmt.setTime(3, Time.valueOf(a.getHoraSalida()));
        stmt.setInt(4, a.getIdServicio());
        stmt.setString(5, a.getPlaca());
        stmt.executeUpdate();
    }

    // ELIMINAR POR PLACA
    public void eliminar(String placa) throws SQLException {
        String sql = "DELETE FROM auttec WHERE placa=?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, placa);
        stmt.executeUpdate();
    }
}

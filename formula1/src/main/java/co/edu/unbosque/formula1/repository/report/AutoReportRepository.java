package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.VelocidadAutoDTO;
import co.edu.unbosque.formula1.dto.ServicioAutoDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class AutoReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public AutoReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<VelocidadAutoDTO> obtenerVelocidadAutos() {
        String sql = "SELECT * FROM vw_velocidad_autos_circuito";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            VelocidadAutoDTO dto = new VelocidadAutoDTO();
            dto.setPlaca(rs.getString("Placa"));
            dto.setModelo(rs.getString("Modelo"));
            dto.setCircuito(rs.getString("Circuito"));
            dto.setVelocidad(rs.getDouble("Velocidad"));
            return dto;
        });
    }

    public List<ServicioAutoDTO> obtenerServiciosAutos() {
        String sql = "SELECT * FROM vw_servicios_auto";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ServicioAutoDTO dto = new ServicioAutoDTO();
            dto.setPlaca(rs.getString("Placa"));
            dto.setTecnico(rs.getString("Tecnico"));
            dto.setServicio(rs.getString("Servicio"));
            Timestamp entrada = rs.getTimestamp("Hora_Entrada");
            Timestamp salida = rs.getTimestamp("Hora_Salida");
            if (entrada != null) dto.setHoraEntrada(entrada.toLocalDateTime());
            if (salida != null) dto.setHoraSalida(salida.toLocalDateTime());
            return dto;
        });
    }
}

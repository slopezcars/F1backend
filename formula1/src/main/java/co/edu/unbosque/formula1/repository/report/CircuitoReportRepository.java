package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.RendimientoCircuitoDTO;
import co.edu.unbosque.formula1.dto.GanadorCircuitoDTO;
import co.edu.unbosque.formula1.dto.ResumenCarreraDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CircuitoReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public CircuitoReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RendimientoCircuitoDTO> obtenerRendimientoCircuito() {
        String sql = "SELECT * FROM vw_rendimiento_circuito";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            RendimientoCircuitoDTO dto = new RendimientoCircuitoDTO();
            dto.setIdCircuito(rs.getInt("Id_Circuito"));
            dto.setCircuito(rs.getString("Circuito"));
            dto.setPromedioPosicionPiloto(rs.getDouble("Promedio_Posicion_Pilotos"));
            return dto;
        });
    }

    public List<GanadorCircuitoDTO> obtenerGanadorCircuito() {
        String sql = "SELECT * FROM vw_ganadores_circuito";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            GanadorCircuitoDTO dto = new GanadorCircuitoDTO();
            dto.setIdCircuito(rs.getInt("Id_Circuito"));
            dto.setCircuito(rs.getString("Circuito"));
            dto.setCarrera(rs.getString("Carrera"));
            dto.setPilotoGanador(rs.getString("Piloto_Ganador"));
            return dto;
        });
    }

    public List<ResumenCarreraDTO> obtenerResumenCarrera() {
        String sql = "SELECT * FROM vw_resumen_general_carrera";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ResumenCarreraDTO dto = new ResumenCarreraDTO();
            dto.setIdCarrera(rs.getInt("Id_Carrera"));
            dto.setCarrera(rs.getString("Carrera"));
            dto.setFecha(rs.getDate("Fecha").toLocalDate());
            dto.setCircuito(rs.getString("Circuito"));
            dto.setJefeEquipo(rs.getString("Jefe_Equipo"));
            dto.setTotalPiloto(rs.getInt("Total_Pilotos"));
            dto.setPilotoGanador(rs.getString("Piloto_Ganador"));
            dto.setTotalPenalizacion(rs.getInt("Total_Penalizaciones"));
            dto.setMinutosPenalizado(rs.getInt("Minutos_Penalizados"));
            return dto;
        });
    }
}

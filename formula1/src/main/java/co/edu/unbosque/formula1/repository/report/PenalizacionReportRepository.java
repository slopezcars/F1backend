package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.PenalizacionCarreraDTO;
import co.edu.unbosque.formula1.dto.PenalizacionPilotoDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PenalizacionReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public PenalizacionReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PenalizacionPilotoDTO> obtenerPenalizacionPiloto() {
        String sql = "SELECT * FROM vw_penalizaciones_piloto";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            PenalizacionPilotoDTO dto = new PenalizacionPilotoDTO();
            dto.setIdPiloto(rs.getInt("Id_Piloto"));
            dto.setPiloto(rs.getString("Piloto"));
            dto.setIdPenalizacion(rs.getInt("Id_Penalizacion"));
            dto.setMomento(rs.getTimestamp("Momento").toLocalDateTime());
            dto.setMinutoPenalizado(rs.getDouble("Minutos_Penalizados"));
            return dto;
        });
    }

    public List<PenalizacionCarreraDTO> obtenerPenalizacionCarrera() {
        String sql = "SELECT * FROM vw_penalizaciones_carrera";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            PenalizacionCarreraDTO dto = new PenalizacionCarreraDTO();
            dto.setIdCarrera(rs.getInt("Id_Carrera"));
            dto.setCarrera(rs.getString("Carrera"));
            dto.setFecha(rs.getDate("Fecha").toLocalDate());
            dto.setTotalPenalizacion(rs.getInt("Total_Penalizaciones"));
            dto.setMinutoPerdido(rs.getDouble("Minutos_Perdidos"));
            return dto;
        });
    }
}

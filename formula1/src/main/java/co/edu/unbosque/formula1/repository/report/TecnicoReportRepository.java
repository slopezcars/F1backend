package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.RendimientoTecnicoDTO;
import co.edu.unbosque.formula1.dto.AutoPorTecnicoDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class TecnicoReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public TecnicoReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RendimientoTecnicoDTO> obtenerRendimientoTecnico() {
        String sql = "SELECT * FROM vw_rendimiento_tecnicos";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            RendimientoTecnicoDTO dto = new RendimientoTecnicoDTO();
            dto.setIdTecnico(rs.getInt("idTecnico"));
            dto.setTecnico(rs.getString("tecnico"));
            dto.setTotalServicioRealizado(rs.getInt("totalServicioRealizado"));
            return dto;
        });
    }

    public List<AutoPorTecnicoDTO> obtenerAutoPorTecnico() {
        String sql = "SELECT * FROM vw_autos_por_tecnico";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            AutoPorTecnicoDTO dto = new AutoPorTecnicoDTO();
            dto.setIdTecnico(rs.getInt("idTecnico"));
            dto.setTecnico(rs.getString("tecnico"));
            dto.setAuto(rs.getString("auto"));
            dto.setServicio(rs.getString("servicio"));
            dto.setHoraEntrada(rs.getTimestamp("horaEntrada").toLocalDateTime());
            dto.setHoraSalida(rs.getTimestamp("horaSalida").toLocalDateTime());
            return dto;
        });
    }
}

package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.ResultadoPilotoDTO;
import co.edu.unbosque.formula1.dto.ResumenRendimientoDTO;
import co.edu.unbosque.formula1.dto.PodioPilotoDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResultadoPilotoReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public ResultadoPilotoReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ResultadoPilotoDTO> obtenerResultadoPilotos() {
        String sql = "SELECT * FROM vw_resultado_pilotos";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ResultadoPilotoDTO dto = new ResultadoPilotoDTO();
            dto.setIdPiloto(rs.getInt("idPiloto"));
            dto.setPiloto(rs.getString("piloto"));
            dto.setIdCarrera(rs.getInt("idCarrera"));
            dto.setCarrera(rs.getString("carrera"));
            dto.setFecha(rs.getDate("fecha").toLocalDate());
            dto.setRankingFinal(rs.getInt("rankingFinal"));
            return dto;
        });
    }

    public List<ResumenRendimientoDTO> obtenerResumenRendimiento() {
        String sql = "SELECT * FROM vw_resumen_rendimiento_piloto";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ResumenRendimientoDTO dto = new ResumenRendimientoDTO();
            dto.setIdPiloto(rs.getInt("idPiloto"));
            dto.setPiloto(rs.getString("piloto"));
            dto.setCarrerasDisputadas(rs.getLong("carrerasDisputadas"));
            dto.setPromedioPosicion(rs.getDouble("promedioPosicion"));
            return dto;
        });
    }

    public List<PodioPilotoDTO> obtenerPodiosPiloto() {
        String sql = "SELECT * FROM vw_podios_piloto";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            PodioPilotoDTO dto = new PodioPilotoDTO();
            dto.setIdPiloto(rs.getInt("idPiloto"));
            dto.setPiloto(rs.getString("piloto"));
            dto.setPrimerosPuestos(rs.getLong("primerosPuestos"));
            dto.setSegundosPuestos(rs.getLong("segundosPuestos"));
            dto.setTercerosPuestos(rs.getLong("tercerosPuestos"));
            return dto;
        });
    }
}

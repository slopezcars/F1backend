package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.RendimientoCircuitoDTO;
import co.edu.unbosque.formula1.dto.GanadorCircuitoDTO;
import co.edu.unbosque.formula1.dto.ResumenCarreraDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CircuitoReportRepository extends JpaRepository<Object, Integer> {

    @Query(value = "SELECT * FROM vw_rendimiento_circuito", nativeQuery = true)
    List<RendimientoCircuitoDTO> obtenerRendimientoCircuito();

    @Query(value = "SELECT * FROM vw_ganadores_circuito", nativeQuery = true)
    List<GanadorCircuitoDTO> obtenerGanadorCircuito();

    @Query(value = "SELECT * FROM vw_resumen_general_carrera", nativeQuery = true)
    List<ResumenCarreraDTO> obtenerResumenCarrera();
}

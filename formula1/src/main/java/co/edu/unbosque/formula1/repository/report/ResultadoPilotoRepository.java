package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.ResultadoPilotoDTO;
import co.edu.unbosque.formula1.dto.ResumenRendimientoDTO;
import co.edu.unbosque.formula1.dto.PodioPilotoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResultadoPilotoRepository extends JpaRepository<Object, Integer> {

    @Query(value = "SELECT * FROM vw_resultado_pilotos", nativeQuery = true)
    List<ResultadoPilotoDTO> obtenerResultadoPilotos();

    @Query(value = "SELECT * FROM vw_resumen_rendimiento_piloto", nativeQuery = true)
    List<ResumenRendimientoDTO> obtenerResumenRendimiento();

    @Query(value = "SELECT * FROM vw_podios_piloto", nativeQuery = true)
    List<PodioPilotoDTO> obtenerPodiosPiloto();
}

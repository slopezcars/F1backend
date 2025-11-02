package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.RendimientoTecnicoDTO;
import co.edu.unbosque.formula1.dto.AutoPorTecnicoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TecnicoReportRepository extends JpaRepository<Object, Integer> {

    @Query(value = "SELECT * FROM vw_rendimiento_tecnicos", nativeQuery = true)
    List<RendimientoTecnicoDTO> obtenerRendimientoTecnico();

    @Query(value = "SELECT * FROM vw_autos_por_tecnico", nativeQuery = true)
    List<AutoPorTecnicoDTO> obtenerAutoPorTecnico();
}

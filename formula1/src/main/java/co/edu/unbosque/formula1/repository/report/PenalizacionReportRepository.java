package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.PenalizacionPilotoDTO;
import co.edu.unbosque.formula1.dto.PenalizacionCarreraDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PenalizacionReportRepository extends JpaRepository<Object, Integer> {

    @Query(value = "SELECT * FROM vw_penalizaciones_piloto", nativeQuery = true)
    List<PenalizacionPilotoDTO> obtenerPenalizacionPiloto();

    @Query(value = "SELECT * FROM vw_penalizaciones_carrera", nativeQuery = true)
    List<PenalizacionCarreraDTO> obtenerPenalizacionCarrera();
}

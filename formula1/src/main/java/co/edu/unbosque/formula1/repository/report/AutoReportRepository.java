package co.edu.unbosque.formula1.repository.report;

import co.edu.unbosque.formula1.dto.VelocidadAutoDTO;
import co.edu.unbosque.formula1.dto.ServicioAutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutoReportRepository extends JpaRepository<Object, Integer> {

    @Query(value = "SELECT * FROM vw_velocidad_autos_circuito", nativeQuery = true)
    List<VelocidadAutoDTO> obtenerVelocidadAutos();

    @Query(value = "SELECT * FROM vw_servicios_auto", nativeQuery = true)
    List<ServicioAutoDTO> obtenerServiciosAutos();
}

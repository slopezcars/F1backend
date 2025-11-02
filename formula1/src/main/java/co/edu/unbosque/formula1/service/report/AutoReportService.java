package co.edu.unbosque.formula1.service.report;

import co.edu.unbosque.formula1.dto.VelocidadAutoDTO;
import co.edu.unbosque.formula1.dto.ServicioAutoDTO;
import co.edu.unbosque.formula1.repository.report.AutoReportRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutoReportService {

    private final AutoReportRepository repository;

    public AutoReportService(AutoReportRepository repository) {
        this.repository = repository;
    }

    public List<VelocidadAutoDTO> obtenerVelocidadAutos() {
        return repository.obtenerVelocidadAutos();
    }

    public List<ServicioAutoDTO> obtenerServiciosAutos() {
        return repository.obtenerServiciosAutos();
    }
}

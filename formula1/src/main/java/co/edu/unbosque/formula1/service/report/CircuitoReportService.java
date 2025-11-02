package co.edu.unbosque.formula1.service.report;

import co.edu.unbosque.formula1.dto.RendimientoCircuitoDTO;
import co.edu.unbosque.formula1.dto.GanadorCircuitoDTO;
import co.edu.unbosque.formula1.dto.ResumenCarreraDTO;
import co.edu.unbosque.formula1.repository.report.CircuitoReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitoReportService {

    private final CircuitoReportRepository repository;

    public CircuitoReportService(CircuitoReportRepository repository) {
        this.repository = repository;
    }

    public List<RendimientoCircuitoDTO> obtenerRendimientoCircuito() {
        return repository.obtenerRendimientoCircuito();
    }

    public List<GanadorCircuitoDTO> obtenerGanadorCircuito() {
        return repository.obtenerGanadorCircuito();
    }

    public List<ResumenCarreraDTO> obtenerResumenCarrera() {
        return repository.obtenerResumenCarrera();
    }
}

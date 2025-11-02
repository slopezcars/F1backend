package co.edu.unbosque.formula1.service.report;

import co.edu.unbosque.formula1.dto.PenalizacionPilotoDTO;
import co.edu.unbosque.formula1.dto.PenalizacionCarreraDTO;
import co.edu.unbosque.formula1.repository.report.PenalizacionReportRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PenalizacionReportService {

    private final PenalizacionReportRepository repository;

    public PenalizacionReportService(PenalizacionReportRepository repository) {
        this.repository = repository;
    }

    public List<PenalizacionPilotoDTO> obtenerPenalizacionPiloto() {
        return repository.obtenerPenalizacionPiloto();
    }

    public List<PenalizacionCarreraDTO> obtenerPenalizacionCarrera() {
        return repository.obtenerPenalizacionCarrera();
    }
}

package co.edu.unbosque.formula1.service.report;

import co.edu.unbosque.formula1.dto.RendimientoTecnicoDTO;
import co.edu.unbosque.formula1.dto.AutoPorTecnicoDTO;
import co.edu.unbosque.formula1.repository.report.TecnicoReportRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TecnicoReportService {

    private final TecnicoReportRepository repository;

    public TecnicoReportService(TecnicoReportRepository repository) {
        this.repository = repository;
    }

    public List<RendimientoTecnicoDTO> obtenerRendimientoTecnico() {
        return repository.obtenerRendimientoTecnico();
    }

    public List<AutoPorTecnicoDTO> obtenerAutoPorTecnico() {
        return repository.obtenerAutoPorTecnico();
    }
}

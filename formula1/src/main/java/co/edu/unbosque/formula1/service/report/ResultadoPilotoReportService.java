package co.edu.unbosque.formula1.service.report;

import co.edu.unbosque.formula1.dto.ResultadoPilotoDTO;
import co.edu.unbosque.formula1.dto.ResumenRendimientoDTO;
import co.edu.unbosque.formula1.dto.PodioPilotoDTO;
import co.edu.unbosque.formula1.repository.report.ResultadoPilotoReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoPilotoReportService {

    private final ResultadoPilotoReportRepository repository;

    public ResultadoPilotoReportService(ResultadoPilotoReportRepository repository) {
        this.repository = repository;
    }

    public List<ResultadoPilotoDTO> obtenerResultadoPilotos() {
        return repository.obtenerResultadoPilotos();
    }

    public List<ResumenRendimientoDTO> obtenerResumenRendimiento() {
        return repository.obtenerResumenRendimiento();
    }

    public List<PodioPilotoDTO> obtenerPodiosPiloto() {
        return repository.obtenerPodiosPiloto();
    }
}

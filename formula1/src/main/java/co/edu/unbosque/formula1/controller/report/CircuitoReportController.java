package co.edu.unbosque.formula1.controller.report;

import co.edu.unbosque.formula1.dto.RendimientoCircuitoDTO;
import co.edu.unbosque.formula1.dto.GanadorCircuitoDTO;
import co.edu.unbosque.formula1.dto.ResumenCarreraDTO;
import co.edu.unbosque.formula1.service.report.CircuitoReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report/circuito")
public class CircuitoReportController {

    private final CircuitoReportService service;

    public CircuitoReportController(CircuitoReportService service) {
        this.service = service;
    }

    @GetMapping("/rendimiento")
    public List<RendimientoCircuitoDTO> obtenerRendimientoCircuito() {
        return service.obtenerRendimientoCircuito();
    }

    @GetMapping("/ganador")
    public List<GanadorCircuitoDTO> obtenerGanadorCircuito() {
        return service.obtenerGanadorCircuito();
    }

    @GetMapping("/resumen")
    public List<ResumenCarreraDTO> obtenerResumenCarrera() {
        return service.obtenerResumenCarrera();
    }
}

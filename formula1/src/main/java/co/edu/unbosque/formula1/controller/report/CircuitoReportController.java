package co.edu.unbosque.formula1.controller.report;

import co.edu.unbosque.formula1.dto.RendimientoCircuitoDTO;
import co.edu.unbosque.formula1.dto.GanadorCircuitoDTO;
import co.edu.unbosque.formula1.dto.ResumenCarreraDTO;
import co.edu.unbosque.formula1.service.report.CircuitoReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CircuitoReportController {

    private final CircuitoReportService service;

    public CircuitoReportController(CircuitoReportService service) {
        this.service = service;
    }

    @GetMapping("/reporte/rendimiento-circuito")
    public List<RendimientoCircuitoDTO> getRendimientoCircuito() {
        return service.obtenerRendimientoCircuito();
    }

    @GetMapping("/reporte/ganador-circuito")
    public List<GanadorCircuitoDTO> getGanadorCircuito() {
        return service.obtenerGanadorCircuito();
    }

    @GetMapping("/reporte/resumen-carrera")
    public List<ResumenCarreraDTO> getResumenCarrera() {
        return service.obtenerResumenCarrera();
    }
}

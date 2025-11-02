package co.edu.unbosque.formula1.controller.report;

import co.edu.unbosque.formula1.dto.PenalizacionPilotoDTO;
import co.edu.unbosque.formula1.dto.PenalizacionCarreraDTO;
import co.edu.unbosque.formula1.service.report.PenalizacionReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PenalizacionReportController {

    private final PenalizacionReportService service;

    public PenalizacionReportController(PenalizacionReportService service) {
        this.service = service;
    }

    @GetMapping("/reporte/penalizacion-piloto")
    public List<PenalizacionPilotoDTO> getPenalizacionPiloto() {
        return service.obtenerPenalizacionPiloto();
    }

    @GetMapping("/reporte/penalizacion-carrera")
    public List<PenalizacionCarreraDTO> getPenalizacionCarrera() {
        return service.obtenerPenalizacionCarrera();
    }
}

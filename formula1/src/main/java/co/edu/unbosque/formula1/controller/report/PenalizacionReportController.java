package co.edu.unbosque.formula1.controller.report;

import co.edu.unbosque.formula1.dto.PenalizacionCarreraDTO;
import co.edu.unbosque.formula1.dto.PenalizacionPilotoDTO;
import co.edu.unbosque.formula1.service.report.PenalizacionReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report/penalizacion")
public class PenalizacionReportController {

    private final PenalizacionReportService service;

    public PenalizacionReportController(PenalizacionReportService service) {
        this.service = service;
    }

    @GetMapping("/piloto")
    public List<PenalizacionPilotoDTO> obtenerPenalizacionPiloto() {
        return service.obtenerPenalizacionPiloto();
    }

    @GetMapping("/carrera")
    public List<PenalizacionCarreraDTO> obtenerPenalizacionCarrera() {
        return service.obtenerPenalizacionCarrera();
    }
}

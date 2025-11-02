package co.edu.unbosque.formula1.controller.report;

import co.edu.unbosque.formula1.dto.RendimientoTecnicoDTO;
import co.edu.unbosque.formula1.dto.AutoPorTecnicoDTO;
import co.edu.unbosque.formula1.service.report.TecnicoReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TecnicoReportController {

    private final TecnicoReportService service;

    public TecnicoReportController(TecnicoReportService service) {
        this.service = service;
    }

    @GetMapping("/reporte/rendimiento-tecnico")
    public List<RendimientoTecnicoDTO> getRendimientoTecnico() {
        return service.obtenerRendimientoTecnico();
    }

    @GetMapping("/reporte/auto-por-tecnico")
    public List<AutoPorTecnicoDTO> getAutoPorTecnico() {
        return service.obtenerAutoPorTecnico();
    }
}

package co.edu.unbosque.formula1.controller.report;

import co.edu.unbosque.formula1.dto.RendimientoTecnicoDTO;
import co.edu.unbosque.formula1.dto.AutoPorTecnicoDTO;
import co.edu.unbosque.formula1.service.report.TecnicoReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report/tecnico")
public class TecnicoReportController {

    private final TecnicoReportService service;

    public TecnicoReportController(TecnicoReportService service) {
        this.service = service;
    }

    @GetMapping("/rendimiento")
    public List<RendimientoTecnicoDTO> obtenerRendimientoTecnico() {
        return service.obtenerRendimientoTecnico();
    }

    @GetMapping("/autos")
    public List<AutoPorTecnicoDTO> obtenerAutoPorTecnico() {
        return service.obtenerAutoPorTecnico();
    }
}

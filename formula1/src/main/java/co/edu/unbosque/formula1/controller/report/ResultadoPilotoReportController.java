package co.edu.unbosque.formula1.controller.report;

import co.edu.unbosque.formula1.dto.ResultadoPilotoDTO;
import co.edu.unbosque.formula1.dto.ResumenRendimientoDTO;
import co.edu.unbosque.formula1.dto.PodioPilotoDTO;
import co.edu.unbosque.formula1.service.report.ResultadoPilotoReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report/piloto")
public class ResultadoPilotoReportController {

    private final ResultadoPilotoReportService service;

    public ResultadoPilotoReportController(ResultadoPilotoReportService service) {
        this.service = service;
    }

    @GetMapping("/resultado")
    public List<ResultadoPilotoDTO> obtenerResultadoPilotos() {
        return service.obtenerResultadoPilotos();
    }

    @GetMapping("/resumen")
    public List<ResumenRendimientoDTO> obtenerResumenRendimiento() {
        return service.obtenerResumenRendimiento();
    }

    @GetMapping("/podio")
    public List<PodioPilotoDTO> obtenerPodiosPiloto() {
        return service.obtenerPodiosPiloto();
    }
}

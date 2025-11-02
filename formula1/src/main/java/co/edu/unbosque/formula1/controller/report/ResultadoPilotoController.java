package co.edu.unbosque.formula1.controller.report;

import co.edu.unbosque.formula1.dto.ResultadoPilotoDTO;
import co.edu.unbosque.formula1.dto.ResumenRendimientoDTO;
import co.edu.unbosque.formula1.dto.PodioPilotoDTO;
import co.edu.unbosque.formula1.service.report.ResultadoPilotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ResultadoPilotoController {

    private final ResultadoPilotoService service;

    public ResultadoPilotoController(ResultadoPilotoService service) {
        this.service = service;
    }

    @GetMapping("/reportes/resultado-pilotos")
    public List<ResultadoPilotoDTO> getResultadoPilotos() {
        return service.obtenerResultadoPilotos();
    }

    @GetMapping("/reportes/resumen-rendimiento")
    public List<ResumenRendimientoDTO> getResumenRendimiento() {
        return service.obtenerResumenRendimiento();
    }

    @GetMapping("/reportes/podios-piloto")
    public List<PodioPilotoDTO> getPodiosPiloto() {
        return service.obtenerPodiosPiloto();
    }
}

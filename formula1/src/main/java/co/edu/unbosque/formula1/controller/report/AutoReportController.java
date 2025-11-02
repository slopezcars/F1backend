package co.edu.unbosque.formula1.controller.report;

import co.edu.unbosque.formula1.dto.VelocidadAutoDTO;
import co.edu.unbosque.formula1.dto.ServicioAutoDTO;
import co.edu.unbosque.formula1.service.report.AutoReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AutoReportController {

    private final AutoReportService service;

    public AutoReportController(AutoReportService service) {
        this.service = service;
    }

    @GetMapping("/reportes/velocidad-autos")
    public List<VelocidadAutoDTO> getVelocidadAutos() {
        return service.obtenerVelocidadAutos();
    }

    @GetMapping("/reportes/servicios-autos")
    public List<ServicioAutoDTO> getServiciosAutos() {
        return service.obtenerServiciosAutos();
    }
}

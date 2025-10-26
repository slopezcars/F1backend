package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.Nacionalidad;
import co.edu.unbosque.formula1.service.NacionalidadService;

@RestController
@RequestMapping("/nacionalidad")
public class NacionalidadController {

    @Autowired
    private NacionalidadService nacionalidadService;

    @PostMapping("/crearnacionalidad")
    public ResponseEntity<Boolean> crearNacionalidad(Nacionalidad nacionalidad) {
        return new ResponseEntity<>(nacionalidadService.crearNacionalidad(nacionalidad), HttpStatus.ACCEPTED);
    }
}

package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.unbosque.formula1.model.Circuito;
import co.edu.unbosque.formula1.service.CircuitoService;

@RestController
@RequestMapping("/auto")
@CrossOrigin(origins = { "*" })

public class AutoController {

	@Autowired
    private CircuitoService circuitoService;

    @PostMapping("/crearcircuito")
    public ResponseEntity<Boolean> crearcircuito(Circuito circuito) {
        return new ResponseEntity<>(circuitoService.crearCircuito(circuito), HttpStatus.ACCEPTED);
    }
}

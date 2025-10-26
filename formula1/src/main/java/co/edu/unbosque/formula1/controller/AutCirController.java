package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.AutCir;
import co.edu.unbosque.formula1.service.AutCirService;

@RestController
public class AutCirController {

    @Autowired
    private AutCirService autCirService;

    @PostMapping("/crearautcir")
    public ResponseEntity<Boolean> crearautcir(AutCir autCir) {
        return new ResponseEntity<>(autCirService.crearAutCir(autCir), HttpStatus.ACCEPTED);
    }
}

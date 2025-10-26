package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.CarPen;
import co.edu.unbosque.formula1.service.CarPenService;

@RestController
public class CarPenController {

    @Autowired
    private CarPenService carPenService;

    @PostMapping("/crearcarpen")
    public ResponseEntity<Boolean> crearcarpen(CarPen carPen) {
        return new ResponseEntity<>(carPenService.crearCarPen(carPen), HttpStatus.ACCEPTED);
    }
}


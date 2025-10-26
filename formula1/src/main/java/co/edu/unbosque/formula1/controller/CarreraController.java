package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.Carrera;
import co.edu.unbosque.formula1.service.CarreraService;

@RestController
@RequestMapping("/carrera")
@CrossOrigin(origins = { "*" })

public class CarreraController {

	@Autowired
	private CarreraService carreraService;

	@PostMapping

	public ResponseEntity<Boolean> crearcarrera(Carrera carrera) {
		return new ResponseEntity<>(carreraService.crearcarrera(carrera), HttpStatus.ACCEPTED);
		
	}
}

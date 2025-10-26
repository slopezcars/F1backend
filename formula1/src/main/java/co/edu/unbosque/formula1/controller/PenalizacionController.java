package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.Penalizacion;
import co.edu.unbosque.formula1.service.PenalizacionService;

@RestController
@RequestMapping("/penalizacion")
@CrossOrigin(origins = { "*" })
public class PenalizacionController {
	
	@Autowired
	private PenalizacionService penalizacionServise;

	@PostMapping

	public ResponseEntity<Boolean> crearpenalizacion(Penalizacion penalizacion) {
		return new ResponseEntity<>(penalizacionServise.crearpenalizacion(penalizacion), HttpStatus.ACCEPTED);
		
	}

}

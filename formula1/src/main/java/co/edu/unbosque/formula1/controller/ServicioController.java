package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.Servicio;
import co.edu.unbosque.formula1.service.ServicioService;

@RestController
@RequestMapping("/servicio")
@CrossOrigin(origins = { "*" })

public class ServicioController {

	@Autowired
	private ServicioService servicioService;

	@PostMapping("/servicio")
	public ResponseEntity<Boolean> crearservicio(Servicio servicio) {
		return new ResponseEntity<>(servicioService.crearservicio(servicio), HttpStatus.ACCEPTED);
	}

}

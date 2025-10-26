package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.Modelo;
import co.edu.unbosque.formula1.service.ModeloService;

@RestController
@RequestMapping("/modelo")
@CrossOrigin(origins = { "*" })
public class ModeloController {

	@Autowired
	private ModeloService modeloService;

	@PostMapping("/crearmodelo")
	public ResponseEntity<Boolean> crearmodelo(Modelo modelo) {
		return new ResponseEntity<>(modeloService.crearmodelo(modelo), HttpStatus.ACCEPTED);
	}

}

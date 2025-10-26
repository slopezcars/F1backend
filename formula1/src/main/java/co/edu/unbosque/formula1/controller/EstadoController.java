package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.Estado;
import co.edu.unbosque.formula1.service.EstadoServise;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = { "*" })
public class EstadoController {
	
	@Autowired
	private EstadoServise estadoServise;

	@PostMapping

	public ResponseEntity<Boolean> crearestado(Estado estado) {
		return new ResponseEntity<>(estadoServise.crearestado(estado), HttpStatus.ACCEPTED);
		
	}

}

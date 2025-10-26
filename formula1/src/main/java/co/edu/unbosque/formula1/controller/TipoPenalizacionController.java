package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.TipoPenalizacion;

import co.edu.unbosque.formula1.service.TipoPenalizacionServise;

@RestController
@RequestMapping("/tipopenalizacion")
@CrossOrigin(origins = { "*" })
public class TipoPenalizacionController {
	
	@Autowired
	private TipoPenalizacionServise tipoPenalizacionServise;

	@PostMapping

	public ResponseEntity<Boolean> crearTipoPanalizacion(TipoPenalizacion tipoPenalizacion) {
		return new ResponseEntity<>(tipoPenalizacionServise.crearTipoPenalizacion(tipoPenalizacion), HttpStatus.ACCEPTED);
		
	}

}

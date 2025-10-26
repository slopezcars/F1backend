package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.TipoPenalizacion;
import co.edu.unbosque.formula1.service.TipoPenalizacionService;

@RestController
@RequestMapping("/tipopenalizacion")
@CrossOrigin(origins = { "*" })
public class TipoPenalizacionController {

	@Autowired
	private TipoPenalizacionService tipopenalizacionService;

	@PostMapping("/creartipopenalizacion")
	public ResponseEntity<Boolean> creartipopenalizacion(TipoPenalizacion tipopenalizacion) {
		return new ResponseEntity<>(tipopenalizacionService.creartipopenalizacion(tipopenalizacion),
				HttpStatus.ACCEPTED);
	}
}

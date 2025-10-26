package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.Auto;
import co.edu.unbosque.formula1.service.AutoService;

@RestController
@RequestMapping("/auto")
@CrossOrigin(origins = { "*" })

public class AutoController {

	@Autowired
	private AutoService autoService;

	@PostMapping("/crearauto")
	public ResponseEntity<Boolean> crearauto(Auto auto) {
		return new ResponseEntity<>(autoService.crearauto(auto), HttpStatus.ACCEPTED);
	}
}

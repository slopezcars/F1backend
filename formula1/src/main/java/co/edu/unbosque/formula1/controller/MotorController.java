package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.edu.unbosque.formula1.model.Motor;
import co.edu.unbosque.formula1.service.MotorService;

@RestController
@RequestMapping("/motor")
@CrossOrigin(origins = { "*" })

public class MotorController {

	@Autowired
	private MotorService motorService;

	@PostMapping("/crearmotor")
	public ResponseEntity<Boolean> crearmotor(Motor motor) {
		return new ResponseEntity<>(motorService.crearmotor(motor), HttpStatus.ACCEPTED);
	}

}

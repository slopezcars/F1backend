package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.Empleado;
import co.edu.unbosque.formula1.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = { "*" })
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@PostMapping("/crearempleado")
	public ResponseEntity<Boolean> crearempleado(Empleado empleado) {
		return new ResponseEntity<>(empleadoService.crearempleado(empleado), HttpStatus.ACCEPTED);
	}

}

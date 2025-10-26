package co.edu.unbosque.formula1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.PenTipp;
import co.edu.unbosque.formula1.service.PenTippServise;

@RestController
@RequestMapping("/pentipp")
@CrossOrigin(origins = { "*" })
public class PenTippController {
	
	@Autowired
	private PenTippServise penTippServise;

	@PostMapping

	public ResponseEntity<Boolean> crearpentipp(PenTipp penTipp) {
		return new ResponseEntity<>(penTippServise.crearpentipp(penTipp), HttpStatus.ACCEPTED);
		
	}

}

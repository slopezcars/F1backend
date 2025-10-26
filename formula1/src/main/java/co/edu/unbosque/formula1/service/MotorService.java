package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Motor;
import co.edu.unbosque.formula1.repository.MotorRepository;

@Service
public class MotorService {

	@Autowired
	private MotorRepository motorRepository;

	public boolean crearmotor(Motor motor) {
		return motorRepository.crearmotor(motor);
	}

}

package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Carrera;
import co.edu.unbosque.formula1.repository.CarreraRepository;

@Service
public class CarreraService {
	@Autowired
	private CarreraRepository carreraRepository;

	public boolean crearcarrera(Carrera carrera) {
		return carreraRepository.crearcarrera(carrera);
	}
}

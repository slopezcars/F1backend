package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.formula1.model.Penalizacion;
import co.edu.unbosque.formula1.repository.PenalizacionRepository;

@Service
public class PenalizacionServise {
	
	@Autowired

	private  PenalizacionRepository penalizacionRepository;

	public boolean crearpenalizacion(Penalizacion penalizacion) {

		return penalizacionRepository.crearPenalizacion(penalizacion);

	}

}

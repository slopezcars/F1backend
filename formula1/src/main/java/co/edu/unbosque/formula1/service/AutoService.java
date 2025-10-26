package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Auto;
import co.edu.unbosque.formula1.repository.AutoRepository;

@Service
public class AutoService {

	@Autowired
	private AutoRepository autoRepository;

	public boolean crearauto(Auto auto) {
		return autoRepository.crearauto(auto);
	}

}

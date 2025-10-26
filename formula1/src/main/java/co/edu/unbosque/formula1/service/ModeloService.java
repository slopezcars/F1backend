package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Modelo;
import co.edu.unbosque.formula1.repository.ModeloRepository;

@Service
public class ModeloService {

	@Autowired
	private ModeloRepository modeloRepository;

	public boolean crearmodelo(Modelo modelo) {
		return modeloRepository.crearmodelo(modelo);
	}

}

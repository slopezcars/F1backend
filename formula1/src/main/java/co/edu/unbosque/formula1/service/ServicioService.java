package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Servicio;
import co.edu.unbosque.formula1.repository.ServicioRepository;

@Service
public class ServicioService {

	@Autowired
	private ServicioRepository servicioRepository;

	public boolean crearservicio(Servicio servicio) {
		return servicioRepository.crearservicio(servicio);

	}

}

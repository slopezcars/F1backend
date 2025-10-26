package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Empleado;
import co.edu.unbosque.formula1.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	public boolean crearempleado(Empleado empleado) {
		return empleadoRepository.crearempleado(empleado);
	}

}

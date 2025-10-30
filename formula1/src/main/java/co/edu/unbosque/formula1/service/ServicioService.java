
package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Servicio;
import co.edu.unbosque.formula1.repository.ServicioRepository;

@Service
public class ServicioService {

	@Autowired
	private ServicioRepository servicioRepository;

	public boolean crearServicio(Servicio servicio) {
		return servicioRepository.crearServicio(servicio);
	}

	public List<Servicio> obtenerTodos() {
		return servicioRepository.obtenerTodos();
	}

	public Servicio buscarPorId(int idServicio) {
		return servicioRepository.buscarPorId(idServicio);
	}

	public boolean editarServicio(Servicio servicio) {
		return servicioRepository.editarServicio(servicio);
	}

	public boolean eliminarServicio(int idServicio) {
		return servicioRepository.eliminarServicio(idServicio);
	}
}
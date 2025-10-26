package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Estado;
import co.edu.unbosque.formula1.repository.EstadoRepository;


@Service
public class EstadoServise {

	@Autowired

	private EstadoRepository estadoRepository;

	public boolean crearestado(Estado estado) {

		return estadoRepository.crearestado(estado);

	}
}

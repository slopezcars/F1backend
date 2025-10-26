package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.TipoPenalizacion;
import co.edu.unbosque.formula1.repository.TipoPenalizacionRepository;

@Service
public class TipoPenalizacionServise {

	@Autowired

	private TipoPenalizacionRepository tipoPenalizacionRepository;
	public boolean crearTipoPenalizacion(TipoPenalizacion tipoPenalizacion) {

		return tipoPenalizacionRepository.crearTipoPenalizacion(tipoPenalizacion);
	}
}

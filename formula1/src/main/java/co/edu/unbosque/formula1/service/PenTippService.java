package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.PenTipp;
import co.edu.unbosque.formula1.repository.PenTippRepository;

@Service
public class PenTippService {
	
	@Autowired

	private PenTippRepository penTippRepository;
	public boolean crearpentipp(PenTipp penTipp) {

		return penTippRepository.crearpentipp(penTipp);
	}

}

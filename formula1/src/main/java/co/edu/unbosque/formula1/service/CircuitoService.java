
	package co.edu.unbosque.formula1.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import co.edu.unbosque.formula1.model.Circuito;
	import co.edu.unbosque.formula1.repository.CircuitoRepository;

	@Service
	public class CircuitoService {

	    @Autowired
	    private CircuitoRepository circuitoRepository;

	    public boolean crearCircuito(Circuito circuito) {
	        return circuitoRepository.crearCircuito(circuito);
	    }
	}




package co.edu.unbosque.formula1.service;

import java.util.List;

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

    public List<Circuito> obtenerTodos() {
        return circuitoRepository.obtenerTodos();
    }

    public Circuito buscarPorId(int idCircuito) {
        return circuitoRepository.buscarPorId(idCircuito);
    }

    public boolean editarCircuito(Circuito circuito) {
        return circuitoRepository.editarCircuito(circuito);
    }

    public boolean eliminarCircuito(int idCircuito) {
        return circuitoRepository.eliminarCircuito(idCircuito);
    }
}

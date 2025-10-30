package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Estado;
import co.edu.unbosque.formula1.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public boolean crearEstado(Estado estado) {
        return estadoRepository.crearEstado(estado);
    }

    public List<Estado> obtenerTodos() {
        return estadoRepository.obtenerTodos();
    }

    public Estado buscarPorId(int id) {
        return estadoRepository.buscarPorId(id);
    }

    public boolean editarEstado(Estado estado) {
        return estadoRepository.editarEstado(estado);
    }

    public boolean eliminarEstado(int id) {
        return estadoRepository.eliminarEstado(id);
    }
}

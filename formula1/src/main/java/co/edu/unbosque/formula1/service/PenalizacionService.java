package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Penalizacion;
import co.edu.unbosque.formula1.repository.PenalizacionRepository;

@Service
public class PenalizacionService {

    @Autowired
    private PenalizacionRepository penalizacionRepository;

    public boolean crearPenalizacion(Penalizacion penalizacion) {
        return penalizacionRepository.crearPenalizacion(penalizacion);
    }

    public List<Penalizacion> obtenerTodas() {
        return penalizacionRepository.obtenerTodas();
    }

    public Penalizacion buscarPorId(int idPenalizacion) {
        return penalizacionRepository.buscarPorId(idPenalizacion);
    }

    public boolean editarPenalizacion(Penalizacion penalizacion) {
        return penalizacionRepository.editarPenalizacion(penalizacion);
    }

    public boolean eliminarPenalizacion(int idPenalizacion) {
        return penalizacionRepository.eliminarPenalizacion(idPenalizacion);
    }
}

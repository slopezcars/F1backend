package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.PilCarr;
import co.edu.unbosque.formula1.repository.PilCarrRepository;

@Service
public class PilCarrService {

    @Autowired
    private PilCarrRepository pilCarrRepository;

    public boolean crearPilCarr(PilCarr pilCarr) {
        return pilCarrRepository.crearPilCarr(pilCarr);
    }

    public List<PilCarr> obtenerTodos() {
        return pilCarrRepository.obtenerTodos();
    }

    public PilCarr buscarPorIds(int idPiloto, int idCarrera) {
        return pilCarrRepository.buscarPorIds(idPiloto, idCarrera);
    }

    public boolean editarPilCarr(PilCarr pilCarr) {
        return pilCarrRepository.editarPilCarr(pilCarr);
    }

    public boolean eliminarPilCarr(int idPiloto, int idCarrera) {
        return pilCarrRepository.eliminarPilCarr(idPiloto, idCarrera);
    }
}

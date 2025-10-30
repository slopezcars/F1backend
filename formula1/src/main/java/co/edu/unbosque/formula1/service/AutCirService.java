package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.AutCir;
import co.edu.unbosque.formula1.repository.AutCirRepository;

@Service
public class AutCirService {

    @Autowired
    private AutCirRepository autCirRepository;

    public boolean crearAutCir(AutCir autCir) {
        return autCirRepository.crearAutCir(autCir);
    }

    public List<AutCir> obtenerTodos() {
        return autCirRepository.obtenerTodos();
    }

    public AutCir buscarPorId(int idSector) {
        return autCirRepository.buscarPorId(idSector);
    }

    public boolean editarAutCir(AutCir autCir) {
        return autCirRepository.editarAutCir(autCir);
    }

    public boolean eliminarAutCir(int idSector) {
        return autCirRepository.eliminarAutCir(idSector);
    }
}

package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.AutTec;
import co.edu.unbosque.formula1.repository.AutTecRepository;

@Service
public class AutTecService {

    @Autowired
    private AutTecRepository autTecRepository;

    public boolean crearAutTec(AutTec autTec) {
        return autTecRepository.crearAutTec(autTec);
    }

    public List<AutTec> obtenerTodos() {
        return autTecRepository.obtenerTodos();
    }

    public AutTec buscarPorPlacaYTecnico(String placa, int idTecnico) {
        return autTecRepository.buscarPorPlacaYTecnico(placa, idTecnico);
    }

    public boolean editarAutTec(AutTec autTec) {
        return autTecRepository.editarAutTec(autTec);
    }

    public boolean eliminarAutTec(String placa, int idTecnico) {
        return autTecRepository.eliminarAutTec(placa, idTecnico);
    }
}

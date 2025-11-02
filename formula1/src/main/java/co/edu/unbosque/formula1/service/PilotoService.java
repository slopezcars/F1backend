package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Auto;
import co.edu.unbosque.formula1.model.Piloto;
import co.edu.unbosque.formula1.repository.PilotoRepository;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    public boolean crearPiloto(Piloto piloto) {
        return pilotoRepository.crearPiloto(piloto);
    }

    public List<Piloto> obtenerTodos() {
        return pilotoRepository.obtenerTodos();
    }

    public Piloto buscarPorId(int idPiloto) {
        return pilotoRepository.buscarPorId(idPiloto);
    }

    public boolean editarPiloto(Piloto piloto) {
        return pilotoRepository.editarPiloto(piloto);
    }

    public boolean eliminarPiloto(int idPiloto) {
        return pilotoRepository.eliminarPiloto(idPiloto);
    }
    public boolean asignarAutoAPiloto(int idPiloto, String placaAuto) {
        return pilotoRepository.asignarAutoAPiloto(idPiloto, placaAuto);
    }

    public boolean eliminarAutoDePiloto(int idPiloto, String placaAuto) {
        return pilotoRepository.eliminarAutoDePiloto(idPiloto, placaAuto);
    }

    public List<Auto> obtenerAutosDePiloto(int idPiloto) {
        return pilotoRepository.obtenerAutosDePiloto(idPiloto);
    }

    public List<Piloto> obtenerPilotosDeAuto(String placaAuto) {
        return pilotoRepository.obtenerPilotosDeAuto(placaAuto);
    }

}

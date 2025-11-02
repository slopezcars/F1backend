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

    public List<AutCir> obtenerTodas() {
        return autCirRepository.obtenerTodas();
    }

    public AutCir buscarPorId(int idCircuito, String placa) {
        return autCirRepository.buscarPorId(idCircuito, placa);
    }

    public boolean editarAutCir(AutCir autCir) {
        return autCirRepository.editarAutCir(autCir);
    }

    public boolean eliminarAutCir(int idCircuito, String placa) {
        return autCirRepository.eliminarAutCir(idCircuito, placa);
    }
}

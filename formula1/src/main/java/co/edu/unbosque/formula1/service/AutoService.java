package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Auto;
import co.edu.unbosque.formula1.repository.AutoRepository;

@Service
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public boolean crearAuto(Auto auto) {
        return autoRepository.crearAuto(auto);
    }

    public List<Auto> obtenerTodos() {
        return autoRepository.obtenerTodos();
    }

    public Auto buscarPorPlaca(String placa) {
        return autoRepository.buscarPorPlaca(placa);
    }

    public boolean editarAuto(Auto auto) {
        return autoRepository.editarAuto(auto);
    }

    public boolean eliminarAuto(String placa) {
        return autoRepository.eliminarAuto(placa);
    }
}

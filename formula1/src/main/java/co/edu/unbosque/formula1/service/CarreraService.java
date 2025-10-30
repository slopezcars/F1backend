package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Carrera;
import co.edu.unbosque.formula1.repository.CarreraRepository;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public boolean crearCarrera(Carrera carrera) {
        return carreraRepository.crearCarrera(carrera);
    }

    public List<Carrera> obtenerTodas() {
        return carreraRepository.obtenerTodas();
    }

    public Carrera buscarPorId(int id) {
        return carreraRepository.buscarPorId(id);
    }

    public boolean editarCarrera(Carrera carrera) {
        return carreraRepository.editarCarrera(carrera);
    }

    public boolean eliminarCarrera(int id) {
        return carreraRepository.eliminarCarrera(id);
    }
}

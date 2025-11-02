package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Especialidad;
import co.edu.unbosque.formula1.repository.EspecialidadRepository;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public boolean crearEspecialidad(Especialidad especialidad) {
        return especialidadRepository.crearEspecialidad(especialidad);
    }

    public List<Especialidad> obtenerTodas() {
        return especialidadRepository.obtenerTodas();
    }

    public Especialidad buscarPorId(int idEspecialidad) {
        return especialidadRepository.buscarPorId(idEspecialidad);
    }

    public boolean editarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.editarEspecialidad(especialidad);
    }
}

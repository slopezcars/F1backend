package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Especialidad;
import co.edu.unbosque.formula1.model.Tecnico;
import co.edu.unbosque.formula1.repository.TecnicoRepository;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public boolean crearTecnico(Tecnico tecnico) {
        return tecnicoRepository.crearTecnico(tecnico);
    }

    public List<Tecnico> obtenerTodos() {
        return tecnicoRepository.obtenerTodos();
    }

    public Tecnico buscarPorId(int id) {
        return tecnicoRepository.buscarPorId(id);
    }

    public boolean editarTecnico(Tecnico tecnico) {
        return tecnicoRepository.editarTecnico(tecnico);
    }

    public boolean eliminarTecnico(int id) {
        return tecnicoRepository.eliminarTecnico(id);
    }
    public boolean agregarEspecialidadATecnico(int idTecnico, int idEspecialidad) {
        return tecnicoRepository.agregarEspecialidadATecnico(idTecnico, idEspecialidad);
    }

    public boolean eliminarEspecialidadDeTecnico(int idTecnico, int idEspecialidad) {
        return tecnicoRepository.eliminarEspecialidadDeTecnico(idTecnico, idEspecialidad);
    }

    public List<Especialidad> obtenerEspecialidadesDeTecnico(int idTecnico) {
        return tecnicoRepository.obtenerEspecialidadesDeTecnico(idTecnico);
    }
}

package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.JefeEquipo;
import co.edu.unbosque.formula1.repository.JefeEquipoRepository;

@Service
public class JefeEquipoService {

    @Autowired
    private JefeEquipoRepository jefeEquipoRepository;

    public boolean crearJefeEquipo(JefeEquipo jefeEquipo) {
        return jefeEquipoRepository.crearJefeEquipo(jefeEquipo);
    }

    public List<JefeEquipo> obtenerTodos() {
        return jefeEquipoRepository.obtenerTodos();
    }

    public JefeEquipo buscarPorId(int id) {
        return jefeEquipoRepository.buscarPorId(id);
    }

    public boolean editarJefeEquipo(JefeEquipo jefeEquipo) {
        return jefeEquipoRepository.editarJefeEquipo(jefeEquipo);
    }

    public boolean eliminarJefeEquipo(int id) {
        return jefeEquipoRepository.eliminarJefeEquipo(id);
    }
}

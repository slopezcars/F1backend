package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Modelo;
import co.edu.unbosque.formula1.repository.ModeloRepository;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public boolean crearModelo(Modelo modelo) {
        return modeloRepository.crearModelo(modelo);
    }

    public List<Modelo> obtenerTodos() {
        return modeloRepository.obtenerTodos();
    }

    public Modelo buscarPorId(int idModelo) {
        return modeloRepository.buscarPorId(idModelo);
    }

    public boolean editarModelo(Modelo modelo) {
        return modeloRepository.editarModelo(modelo);
    }

    public boolean eliminarModelo(int idModelo) {
        return modeloRepository.eliminarModelo(idModelo);
    }
}

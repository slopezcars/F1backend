package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.TipoPenalizacion;
import co.edu.unbosque.formula1.repository.TipoPenalizacionRepository;

@Service
public class TipoPenalizacionService {

    @Autowired
    private TipoPenalizacionRepository tipoPenalizacionRepository;

    public boolean crearTipoPenalizacion(TipoPenalizacion tipo) {
        return tipoPenalizacionRepository.crearTipoPenalizacion(tipo);
    }

    public List<TipoPenalizacion> obtenerTodos() {
        return tipoPenalizacionRepository.obtenerTodos();
    }

    public TipoPenalizacion buscarPorId(int id) {
        return tipoPenalizacionRepository.buscarPorId(id);
    }

    public boolean editarTipoPenalizacion(TipoPenalizacion tipo) {
        return tipoPenalizacionRepository.editarTipoPenalizacion(tipo);
    }

    public boolean eliminarTipoPenalizacion(int id) {
        return tipoPenalizacionRepository.eliminarTipoPenalizacion(id);
    }
}

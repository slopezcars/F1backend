package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.AutTec;
import co.edu.unbosque.formula1.repository.AutTecRepository;

@Service
public class AutTecService {

    private final AutTecRepository autTecRepository;

    public AutTecService(AutTecRepository autTecRepository) {
        this.autTecRepository = autTecRepository;
    }

    // CREAR
    public boolean crearAutTec(AutTec autTec) {
        try {
            autTecRepository.insertar(autTec);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // LISTAR TODO
    public List<AutTec> obtenerTodos() {
        try {
            return autTecRepository.obtenerTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // BUSCAR POR PLACA
    public AutTec buscarPorPlaca(String placa) {
        try {
            return autTecRepository.obtenerTodos()
                    .stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // EDITAR
    public boolean editarAutTec(AutTec autTec) {
        try {
            autTecRepository.actualizar(autTec);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminarAutTec(String placa) {
        try {
            autTecRepository.eliminar(placa);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

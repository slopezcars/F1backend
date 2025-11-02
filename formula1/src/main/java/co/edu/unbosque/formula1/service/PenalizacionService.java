package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Penalizacion;
import co.edu.unbosque.formula1.model.TipoPenalizacion;
import co.edu.unbosque.formula1.repository.PenalizacionRepository;

@Service
public class PenalizacionService {

    @Autowired
    private PenalizacionRepository penalizacionRepository;

    public boolean crearPenalizacion(Penalizacion penalizacion) {
        return penalizacionRepository.crearPenalizacion(penalizacion);
    }

    public List<Penalizacion> obtenerTodas() {
        return penalizacionRepository.obtenerTodas();
    }

    public Penalizacion buscarPorId(int idPenalizacion) {
        return penalizacionRepository.buscarPorId(idPenalizacion);
    }

    public boolean editarPenalizacion(Penalizacion penalizacion) {
        return penalizacionRepository.editarPenalizacion(penalizacion);
    }

    public boolean eliminarPenalizacion(int idPenalizacion) {
        return penalizacionRepository.eliminarPenalizacion(idPenalizacion);
    }
    public void agregarPenalizacionAPiloto(int idPiloto, int idPenalizacion) {
        penalizacionRepository.agregarPenalizacionAPiloto(idPiloto, idPenalizacion);
    }

    public void eliminarPenalizacionDePiloto(int idPiloto, int idPenalizacion) {
        penalizacionRepository.eliminarPenalizacionDePiloto(idPiloto, idPenalizacion);
    }

    public List<Penalizacion> obtenerPenalizacionesDePiloto(int idPiloto) {
        return penalizacionRepository.obtenerPenalizacionesDePiloto(idPiloto);
    }
    public void asignarPenalizacionACarrera(int idCarrera, int idPenalizacion) {
        penalizacionRepository.agregarPenalizacionACarrera(idCarrera, idPenalizacion);
    }
    public void eliminarPenalizacionDeCarrera(int idCarrera, int idPenalizacion) {
        penalizacionRepository.eliminarPenalizacionDeCarrera(idCarrera, idPenalizacion);
    }
    public List<Penalizacion> obtenerPenalizacionesDeCarrera(int idCarrera) {
        return penalizacionRepository.obtenerPenalizacionesDeCarrera(idCarrera);
    }
    public void asignarTipoAPenalizacion(int idPenalizacion, TipoPenalizacion tipo) {
        penalizacionRepository.asignarTipoAPenalizacion(idPenalizacion, tipo);
    }

    public void quitarTipoDePenalizacion(int idPenalizacion, int idTipo) {
        penalizacionRepository.quitarTipoDePenalizacion(idPenalizacion, idTipo);
    }

    public List<TipoPenalizacion> listarTiposDePenalizacion(int idPenalizacion) {
        return penalizacionRepository.listarTiposDePenalizacion(idPenalizacion);
    }
}
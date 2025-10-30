package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Nacionalidad;
import co.edu.unbosque.formula1.repository.NacionalidadRepository;

@Service
public class NacionalidadService {

    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    public boolean crearNacionalidad(Nacionalidad nacionalidad) {
        return nacionalidadRepository.crearNacionalidad(nacionalidad);
    }

    public List<Nacionalidad> obtenerTodas() {
        return nacionalidadRepository.obtenerTodas();
    }

    public Nacionalidad buscarPorId(int idNacionalidad) {
        return nacionalidadRepository.buscarPorId(idNacionalidad);
    }

    public boolean editarNacionalidad(Nacionalidad nacionalidad) {
        return nacionalidadRepository.editarNacionalidad(nacionalidad);
    }

    public boolean eliminarNacionalidad(int idNacionalidad) {
        return nacionalidadRepository.eliminarNacionalidad(idNacionalidad);
    }
}

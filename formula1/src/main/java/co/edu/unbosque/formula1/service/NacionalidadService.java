package co.edu.unbosque.formula1.service;

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
}


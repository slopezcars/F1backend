package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.AutCir;
import co.edu.unbosque.formula1.repository.AutCirRepository;

@Service
public class AutCirService {

    @Autowired
    private AutCirRepository autCirRepository;

    public boolean crearAutCir(AutCir autCir) {
        return autCirRepository.crearAutCir(autCir);
    }
}

package co.edu.unbosque.formula1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.CarPen;
import co.edu.unbosque.formula1.repository.CarPenRepository;

@Service
public class CarPenService {

    @Autowired
    private CarPenRepository carPenRepository;

    public boolean crearCarPen(CarPen carPen) {
        return carPenRepository.crearCarPen(carPen);
    }
}


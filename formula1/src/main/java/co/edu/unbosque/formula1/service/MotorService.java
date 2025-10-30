package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Motor;
import co.edu.unbosque.formula1.repository.MotorRepository;

@Service
public class MotorService {

    @Autowired
    private MotorRepository motorRepository;

    public boolean crearMotor(Motor motor) {
        return motorRepository.crearMotor(motor);
    }

    public List<Motor> obtenerTodos() {
        return motorRepository.obtenerTodos();
    }

    public Motor buscarPorId(int idmotor) {
        return motorRepository.buscarPorId(idmotor);
    }

    public boolean editarMotor(Motor motor) {
        return motorRepository.editarMotor(motor);
    }

    public boolean eliminarMotor(int idmotor) {
        return motorRepository.eliminarMotor(idmotor);
    }
}

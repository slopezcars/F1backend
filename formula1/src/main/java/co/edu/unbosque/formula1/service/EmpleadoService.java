package co.edu.unbosque.formula1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.formula1.model.Empleado;
import co.edu.unbosque.formula1.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public boolean crearEmpleado(Empleado empleado) {
        return empleadoRepository.crearEmpleado(empleado);
    }

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.obtenerTodos();
    }

    public Empleado buscarPorId(int id) {
        return empleadoRepository.buscarPorId(id);
    }

    public boolean editarEmpleado(Empleado empleado) {
        return empleadoRepository.editarEmpleado(empleado);
    }

    public boolean eliminarEmpleado(int id) {
        return empleadoRepository.eliminarEmpleado(id);
    }
}

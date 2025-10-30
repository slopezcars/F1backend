package co.edu.unbosque.formula1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.formula1.model.Empleado;
import co.edu.unbosque.formula1.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = { "" })
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // Crear empleado
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearEmpleado(@RequestBody Empleado empleado) {
        boolean creado = empleadoService.crearEmpleado(empleado);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar empleados
    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        List<Empleado> empleados = empleadoService.obtenerTodos();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    // Buscar empleado por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Empleado> buscarPorId(@PathVariable int id) {
        Empleado empleado = empleadoService.buscarPorId(id);
        if (empleado != null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar empleado
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarEmpleado(@PathVariable int id, @RequestBody Empleado empleado) {
        empleado.setId(id);
        boolean editado = empleadoService.editarEmpleado(empleado);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar empleado
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarEmpleado(@PathVariable int id) {
        boolean eliminado = empleadoService.eliminarEmpleado(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

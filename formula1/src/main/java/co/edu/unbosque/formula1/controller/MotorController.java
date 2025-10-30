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

import co.edu.unbosque.formula1.model.Motor;
import co.edu.unbosque.formula1.service.MotorService;

@RestController
@RequestMapping("/motor")
@CrossOrigin(origins = { "" })
public class MotorController {

    @Autowired
    private MotorService motorService;

    // Crear motor
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearMotor(@RequestBody Motor motor) {
        boolean creado = motorService.crearMotor(motor);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todos
    @GetMapping("/listar")
    public ResponseEntity<List<Motor>> listarMotores() {
        List<Motor> motores = motorService.obtenerTodos();
        return new ResponseEntity<>(motores, HttpStatus.OK);
    }

    // Buscar por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Motor> buscarPorId(@PathVariable int id) {
        Motor motor = motorService.buscarPorId(id);
        if (motor != null) {
            return new ResponseEntity<>(motor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar motor
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarMotor(@PathVariable int id, @RequestBody Motor motor) {
        motor.setIdmotor(id);
        boolean editado = motorService.editarMotor(motor);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar motor
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarMotor(@PathVariable int id) {
        boolean eliminado = motorService.eliminarMotor(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

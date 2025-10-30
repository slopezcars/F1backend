package co.edu.unbosque.formula1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.formula1.model.Carrera;
import co.edu.unbosque.formula1.service.CarreraService;

@RestController
@RequestMapping("/carrera")
@CrossOrigin(origins = { "" })
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    // Crear carrera
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearCarrera(@RequestBody Carrera carrera) {
        boolean creada = carreraService.crearCarrera(carrera);
        return new ResponseEntity<>(creada, creada ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todas las carreras
    @GetMapping("/listar")
    public ResponseEntity<List<Carrera>> obtenerTodas() {
        List<Carrera> carreras = carreraService.obtenerTodas();
        return new ResponseEntity<>(carreras, HttpStatus.OK);
    }

    // Buscar carrera por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Carrera> buscarPorId(@PathVariable int id) {
        Carrera carrera = carreraService.buscarPorId(id);
        if (carrera != null) {
            return new ResponseEntity<>(carrera, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar carrera
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarCarrera(@PathVariable int id, @RequestBody Carrera carrera) {
        carrera.setIdCarrera(id);
        boolean editada = carreraService.editarCarrera(carrera);
        return new ResponseEntity<>(editada, editada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar carrera
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarCarrera(@PathVariable int id) {
        boolean eliminada = carreraService.eliminarCarrera(id);
        return new ResponseEntity<>(eliminada, eliminada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

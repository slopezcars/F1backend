package co.edu.unbosque.formula1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.formula1.model.Especialidad;
import co.edu.unbosque.formula1.service.EspecialidadService;

@RestController
@RequestMapping("/especialidad")
@CrossOrigin(origins = { "http://localhost:8080" })
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearEspecialidad(@RequestBody Especialidad especialidad) {
        boolean creada = especialidadService.crearEspecialidad(especialidad);
        return new ResponseEntity<>(creada, creada ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Especialidad>> obtenerTodas() {
        List<Especialidad> lista = especialidadService.obtenerTodas();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Especialidad> buscarPorId(@PathVariable int id) {
        Especialidad especialidad = especialidadService.buscarPorId(id);
        if (especialidad != null) {
            return new ResponseEntity<>(especialidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarEspecialidad(@PathVariable int id, @RequestBody Especialidad especialidad) {
        especialidad.setIdEspecialidad(id);
        boolean editada = especialidadService.editarEspecialidad(especialidad);
        return new ResponseEntity<>(editada, editada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

   
}

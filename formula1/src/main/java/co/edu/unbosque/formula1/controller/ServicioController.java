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

import co.edu.unbosque.formula1.model.Servicio;
import co.edu.unbosque.formula1.service.ServicioService;

@RestController
@RequestMapping("/servicio")
@CrossOrigin(origins = { "" })
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // Crear servicio
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearServicio(@RequestBody Servicio servicio) {
        boolean creado = servicioService.crearServicio(servicio);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todos los servicios
    @GetMapping("/listar")
    public ResponseEntity<List<Servicio>> obtenerTodos() {
        List<Servicio> servicios = servicioService.obtenerTodos();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    // Buscar servicio por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Servicio> buscarPorId(@PathVariable int id) {
        Servicio servicio = servicioService.buscarPorId(id);
        if (servicio != null) {
            return new ResponseEntity<>(servicio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar servicio
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarServicio(@PathVariable int id, @RequestBody Servicio servicio) {
        servicio.setIdServicio(id);
        boolean editado = servicioService.editarServicio(servicio);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar servicio
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarServicio(@PathVariable int id) {
        boolean eliminado = servicioService.eliminarServicio(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

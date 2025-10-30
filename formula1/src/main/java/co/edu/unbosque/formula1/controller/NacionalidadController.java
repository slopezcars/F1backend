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

import co.edu.unbosque.formula1.model.Nacionalidad;
import co.edu.unbosque.formula1.service.NacionalidadService;

@RestController
@RequestMapping("/nacionalidad")
@CrossOrigin(origins = { "http://localhost:8080" })
public class NacionalidadController {

    @Autowired
    private NacionalidadService nacionalidadService;

    // Crear nacionalidad
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearNacionalidad(@RequestBody Nacionalidad nacionalidad) {
        boolean creada = nacionalidadService.crearNacionalidad(nacionalidad);
        return new ResponseEntity<>(creada, creada ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Obtener todas las nacionalidades
    @GetMapping("/listar")
    public ResponseEntity<List<Nacionalidad>> obtenerTodas() {
        List<Nacionalidad> nacionalidades = nacionalidadService.obtenerTodas();
        return new ResponseEntity<>(nacionalidades, HttpStatus.OK);
    }

    // Buscar nacionalidad por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Nacionalidad> buscarPorId(@PathVariable int id) {
        Nacionalidad nacionalidad = nacionalidadService.buscarPorId(id);
        if (nacionalidad != null) {
            return new ResponseEntity<>(nacionalidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar nacionalidad
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarNacionalidad(@PathVariable int id, @RequestBody Nacionalidad nacionalidad) {
        nacionalidad.setIdNacionalidad(id); // Asignas el ID recibido al objeto
        boolean editada = nacionalidadService.editarNacionalidad(nacionalidad);
        return new ResponseEntity<>(editada, editada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    // Eliminar nacionalidad
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarNacionalidad(@PathVariable int id) {
        boolean eliminada = nacionalidadService.eliminarNacionalidad(id);
        return new ResponseEntity<>(eliminada, eliminada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

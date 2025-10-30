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

import co.edu.unbosque.formula1.model.Estado;
import co.edu.unbosque.formula1.service.EstadoService;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = { "" })
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    // Crear estado
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearEstado(@RequestBody Estado estado) {
        boolean creado = estadoService.crearEstado(estado);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todos los estados
    @GetMapping("/listar")
    public ResponseEntity<List<Estado>> listarEstados() {
        List<Estado> estados = estadoService.obtenerTodos();
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    // Buscar por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable int id) {
        Estado estado = estadoService.buscarPorId(id);
        if (estado != null) {
            return new ResponseEntity<>(estado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar estado
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarEstado(@PathVariable int id, @RequestBody Estado estado) {
        estado.setIdEstado(id);
        boolean editado = estadoService.editarEstado(estado);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar estado
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarEstado(@PathVariable int id) {
        boolean eliminado = estadoService.eliminarEstado(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

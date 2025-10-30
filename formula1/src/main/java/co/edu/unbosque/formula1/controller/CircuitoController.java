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

import co.edu.unbosque.formula1.model.Circuito;
import co.edu.unbosque.formula1.service.CircuitoService;

@RestController
@RequestMapping("/circuito")
@CrossOrigin(origins = { "" })
public class CircuitoController {

    @Autowired
    private CircuitoService circuitoService;

    // Crear circuito
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearCircuito(@RequestBody Circuito circuito) {
        boolean creado = circuitoService.crearCircuito(circuito);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar circuitos
    @GetMapping("/listar")
    public ResponseEntity<List<Circuito>> listarCircuitos() {
        List<Circuito> circuitos = circuitoService.obtenerTodos();
        return new ResponseEntity<>(circuitos, HttpStatus.OK);
    }

    // Buscar circuito por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Circuito> buscarPorId(@PathVariable int id) {
        Circuito circuito = circuitoService.buscarPorId(id);
        if (circuito != null) {
            return new ResponseEntity<>(circuito, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar circuito
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarCircuito(@PathVariable int id, @RequestBody Circuito circuito) {
        circuito.setIdCircuito(id);
        boolean editado = circuitoService.editarCircuito(circuito);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar circuito
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarCircuito(@PathVariable int id) {
        boolean eliminado = circuitoService.eliminarCircuito(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

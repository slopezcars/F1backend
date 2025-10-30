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

import co.edu.unbosque.formula1.model.Tecnico;
import co.edu.unbosque.formula1.service.TecnicoService;

@RestController
@RequestMapping("/tecnico")
@CrossOrigin(origins = { "" })
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    // Crear técnico
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearTecnico(@RequestBody Tecnico tecnico) {
        boolean creado = tecnicoService.crearTecnico(tecnico);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todos los técnicos
    @GetMapping("/listar")
    public ResponseEntity<List<Tecnico>> obtenerTodos() {
        List<Tecnico> tecnicos = tecnicoService.obtenerTodos();
        return new ResponseEntity<>(tecnicos, HttpStatus.OK);
    }

    // Buscar técnico por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Tecnico> buscarPorId(@PathVariable int id) {
        Tecnico tecnico = tecnicoService.buscarPorId(id);
        if (tecnico != null) {
            return new ResponseEntity<>(tecnico, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar técnico
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarTecnico(@PathVariable int id, @RequestBody Tecnico tecnico) {
        tecnico.setId(id);
        boolean editado = tecnicoService.editarTecnico(tecnico);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar técnico
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarTecnico(@PathVariable int id) {
        boolean eliminado = tecnicoService.eliminarTecnico(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

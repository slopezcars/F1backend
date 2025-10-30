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

import co.edu.unbosque.formula1.model.AutCir;
import co.edu.unbosque.formula1.service.AutCirService;

@RestController
@RequestMapping("/autcir")
@CrossOrigin(origins = { "" })
public class AutCirController {

    @Autowired
    private AutCirService autCirService;

    // Crear AutCir
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearAutCir(@RequestBody AutCir autCir) {
        boolean creado = autCirService.crearAutCir(autCir);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Obtener todos los registros
    @GetMapping("/listar")
    public ResponseEntity<List<AutCir>> obtenerTodos() {
        List<AutCir> lista = autCirService.obtenerTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // Buscar por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<AutCir> buscarPorId(@PathVariable int id) {
        AutCir autCir = autCirService.buscarPorId(id);
        if (autCir != null) {
            return new ResponseEntity<>(autCir, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarAutCir(@PathVariable int id, @RequestBody AutCir autCir) {
        autCir.setIdSector(id);
        boolean editado = autCirService.editarAutCir(autCir);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarAutCir(@PathVariable int id) {
        boolean eliminado = autCirService.eliminarAutCir(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

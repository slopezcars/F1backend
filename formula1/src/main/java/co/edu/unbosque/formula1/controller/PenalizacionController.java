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

import co.edu.unbosque.formula1.model.Penalizacion;
import co.edu.unbosque.formula1.service.PenalizacionService;

@RestController
@RequestMapping("/penalizacion")
@CrossOrigin(origins = { "" })
public class PenalizacionController {

    @Autowired
    private PenalizacionService penalizacionService;

    // Crear
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearPenalizacion(@RequestBody Penalizacion penalizacion) {
        boolean creada = penalizacionService.crearPenalizacion(penalizacion);
        return new ResponseEntity<>(creada, creada ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todas
    @GetMapping("/listar")
    public ResponseEntity<List<Penalizacion>> listarPenalizaciones() {
        List<Penalizacion> lista = penalizacionService.obtenerTodas();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // Buscar por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Penalizacion> buscarPorId(@PathVariable int id) {
        Penalizacion penalizacion = penalizacionService.buscarPorId(id);
        if (penalizacion != null) {
            return new ResponseEntity<>(penalizacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarPenalizacion(@PathVariable int id, @RequestBody Penalizacion penalizacion) {
        penalizacion.setIdPenalizacion(id);
        boolean editada = penalizacionService.editarPenalizacion(penalizacion);
        return new ResponseEntity<>(editada, editada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarPenalizacion(@PathVariable int id) {
        boolean eliminada = penalizacionService.eliminarPenalizacion(id);
        return new ResponseEntity<>(eliminada, eliminada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

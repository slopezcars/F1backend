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

import co.edu.unbosque.formula1.model.TipoPenalizacion;
import co.edu.unbosque.formula1.service.TipoPenalizacionService;

@RestController
@RequestMapping("/tipo-penalizacion")
@CrossOrigin(origins = { "" })
public class TipoPenalizacionController {

    @Autowired
    private TipoPenalizacionService tipoPenalizacionService;

    // Crear tipo de penalización
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearTipoPenalizacion(@RequestBody TipoPenalizacion tipo) {
        boolean creado = tipoPenalizacionService.crearTipoPenalizacion(tipo);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todos los tipos de penalización
    @GetMapping("/listar")
    public ResponseEntity<List<TipoPenalizacion>> obtenerTodos() {
        List<TipoPenalizacion> tipos = tipoPenalizacionService.obtenerTodos();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // Buscar tipo de penalización por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoPenalizacion> buscarPorId(@PathVariable int id) {
        TipoPenalizacion tipo = tipoPenalizacionService.buscarPorId(id);
        if (tipo != null) {
            return new ResponseEntity<>(tipo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar tipo de penalización
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarTipoPenalizacion(@PathVariable int id, @RequestBody TipoPenalizacion tipo) {
        tipo.setIdTipoPenalizacion(id);
        boolean editado = tipoPenalizacionService.editarTipoPenalizacion(tipo);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar tipo de penalización
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarTipoPenalizacion(@PathVariable int id) {
        boolean eliminado = tipoPenalizacionService.eliminarTipoPenalizacion(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

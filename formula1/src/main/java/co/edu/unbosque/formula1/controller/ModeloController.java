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

import co.edu.unbosque.formula1.model.Modelo;
import co.edu.unbosque.formula1.service.ModeloService;

@RestController
@RequestMapping("/modelo")
@CrossOrigin(origins = { "" })
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    // Crear modelo
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearModelo(@RequestBody Modelo modelo) {
        boolean creado = modeloService.crearModelo(modelo);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todos los modelos
    @GetMapping("/listar")
    public ResponseEntity<List<Modelo>> listarModelos() {
        List<Modelo> modelos = modeloService.obtenerTodos();
        return new ResponseEntity<>(modelos, HttpStatus.OK);
    }

    // Buscar por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Modelo> buscarPorId(@PathVariable int id) {
        Modelo modelo = modeloService.buscarPorId(id);
        if (modelo != null) {
            return new ResponseEntity<>(modelo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar modelo
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarModelo(@PathVariable int id, @RequestBody Modelo modelo) {
        modelo.setIdModelo(id);
        boolean editado = modeloService.editarModelo(modelo);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar modelo
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarModelo(@PathVariable int id) {
        boolean eliminado = modeloService.eliminarModelo(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

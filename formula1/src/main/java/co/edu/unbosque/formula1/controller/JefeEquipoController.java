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

import co.edu.unbosque.formula1.model.JefeEquipo;
import co.edu.unbosque.formula1.service.JefeEquipoService;

@RestController
@RequestMapping("/jefeequipo")
@CrossOrigin(origins = { "" })
public class JefeEquipoController {

    @Autowired
    private JefeEquipoService jefeEquipoService;

    // Crear
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearJefeEquipo(@RequestBody JefeEquipo jefeEquipo) {
        boolean creado = jefeEquipoService.crearJefeEquipo(jefeEquipo);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar
    @GetMapping("/listar")
    public ResponseEntity<List<JefeEquipo>> listarJefes() {
        List<JefeEquipo> jefes = jefeEquipoService.obtenerTodos();
        return new ResponseEntity<>(jefes, HttpStatus.OK);
    }

    // Buscar por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<JefeEquipo> buscarPorId(@PathVariable int id) {
        JefeEquipo jefe = jefeEquipoService.buscarPorId(id);
        if (jefe != null) {
            return new ResponseEntity<>(jefe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarJefeEquipo(@PathVariable int id, @RequestBody JefeEquipo jefeEquipo) {
        jefeEquipo.setId(id);
        boolean editado = jefeEquipoService.editarJefeEquipo(jefeEquipo);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarJefeEquipo(@PathVariable int id) {
        boolean eliminado = jefeEquipoService.eliminarJefeEquipo(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

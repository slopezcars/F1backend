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

import co.edu.unbosque.formula1.model.Auto;
import co.edu.unbosque.formula1.service.AutoService;

@RestController
@RequestMapping("/auto")
@CrossOrigin(origins = { "" })
public class AutoController {

    @Autowired
    private AutoService autoService;

    // Crear auto
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearAuto(@RequestBody Auto auto) {
        boolean creado = autoService.crearAuto(auto);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todos
    @GetMapping("/listar")
    public ResponseEntity<List<Auto>> obtenerTodos() {
        List<Auto> autos = autoService.obtenerTodos();
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }

    // Buscar por placa
    @GetMapping("/buscar/{placa}")
    public ResponseEntity<Auto> buscarPorPlaca(@PathVariable String placa) {
        Auto auto = autoService.buscarPorPlaca(placa);
        if (auto != null) {
            return new ResponseEntity<>(auto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar por placa
    @PutMapping("/editar/{placa}")
    public ResponseEntity<Boolean> editarAuto(@PathVariable String placa, @RequestBody Auto auto) {
        auto.setPlaca(placa);
        boolean editado = autoService.editarAuto(auto);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar por placa
    @DeleteMapping("/eliminar/{placa}")
    public ResponseEntity<Boolean> eliminarAuto(@PathVariable String placa) {
        boolean eliminado = autoService.eliminarAuto(placa);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

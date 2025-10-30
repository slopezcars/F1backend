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

import co.edu.unbosque.formula1.model.PilCarr;
import co.edu.unbosque.formula1.service.PilCarrService;

@RestController
@RequestMapping("/pilcarr")
@CrossOrigin(origins = { "" })
public class PilCarrController {

    @Autowired
    private PilCarrService pilCarrService;

    // Crear relación Piloto-Carrera
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearPilCarr(@RequestBody PilCarr pilCarr) {
        boolean creado = pilCarrService.crearPilCarr(pilCarr);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todas las relaciones
    @GetMapping("/listar")
    public ResponseEntity<List<PilCarr>> obtenerTodos() {
        List<PilCarr> lista = pilCarrService.obtenerTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // Buscar por idPiloto y idCarrera
    @GetMapping("/buscar/{idPiloto}/{idCarrera}")
    public ResponseEntity<PilCarr> buscarPorIds(@PathVariable int idPiloto, @PathVariable int idCarrera) {
        PilCarr pc = pilCarrService.buscarPorIds(idPiloto, idCarrera);
        return new ResponseEntity<>(pc, pc != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    // Editar rankingFinal
    @PutMapping("/editar/{idPiloto}/{idCarrera}")
    public ResponseEntity<Boolean> editarPilCarr(@PathVariable int idPiloto, @PathVariable int idCarrera, @RequestBody PilCarr pilCarr) {
        pilCarr.setIdPiloto(idPiloto);
        pilCarr.setIdCarrera(idCarrera);
        boolean editado = pilCarrService.editarPilCarr(pilCarr);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar relación
    @DeleteMapping("/eliminar/{idPiloto}/{idCarrera}")
    public ResponseEntity<Boolean> eliminarPilCarr(@PathVariable int idPiloto, @PathVariable int idCarrera) {
        boolean eliminado = pilCarrService.eliminarPilCarr(idPiloto, idCarrera);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

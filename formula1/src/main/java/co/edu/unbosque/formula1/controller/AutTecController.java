package co.edu.unbosque.formula1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.formula1.model.AutTec;
import co.edu.unbosque.formula1.service.AutTecService;

@RestController
@RequestMapping("/autTec")
@CrossOrigin
public class AutTecController {

    @Autowired
    private AutTecService autTecService;

    // Crear relación AutTec
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearAutTec(@RequestBody AutTec autTec) {
        boolean creada = autTecService.crearAutTec(autTec);
        return new ResponseEntity<>(creada, creada ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Obtener todas las relaciones
    @GetMapping("/listar")
    public ResponseEntity<List<AutTec>> obtenerTodas() {
        List<AutTec> auttecs = autTecService.obtenerTodas();
        return new ResponseEntity<>(auttecs, HttpStatus.OK);
    }

    // Buscar relación por clave compuesta
    @GetMapping("/buscar")
    public ResponseEntity<AutTec> buscarPorId(@RequestParam String placa, @RequestParam int idTecnico) {
        AutTec autTec = autTecService.buscarPorId(placa, idTecnico);
        if (autTec != null) {
            return new ResponseEntity<>(autTec, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar relación
    @PutMapping("/editar")
    public ResponseEntity<Boolean> editarAutTec(@RequestBody AutTec autTec) {
        boolean editada = autTecService.editarAutTec(autTec);
        return new ResponseEntity<>(editada, editada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar relación por clave compuesta
    @DeleteMapping("/eliminar")
    public ResponseEntity<Boolean> eliminarAutTec(@RequestParam String placa, @RequestParam int idTecnico) {
        boolean eliminada = autTecService.eliminarAutTec(placa, idTecnico);
        return new ResponseEntity<>(eliminada, eliminada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

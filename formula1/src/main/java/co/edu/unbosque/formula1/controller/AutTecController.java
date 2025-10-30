package co.edu.unbosque.formula1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.formula1.model.AutTec;
import co.edu.unbosque.formula1.service.AutTecService;

@RestController
@RequestMapping("/aut-tec")
@CrossOrigin(origins = { "" })
public class AutTecController {

    @Autowired
    private AutTecService autTecService;

    // Crear relación auto-técnico
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearAutTec(@RequestBody AutTec autTec) {
        boolean creado = autTecService.crearAutTec(autTec);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar todas
    @GetMapping("/listar")
    public ResponseEntity<List<AutTec>> obtenerTodos() {
        List<AutTec> lista = autTecService.obtenerTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // Buscar por placa y técnico
    @GetMapping("/buscar/{placa}/{idTecnico}")
    public ResponseEntity<AutTec> buscarPorPlacaYTecnico(@PathVariable String placa, @PathVariable int idTecnico) {
        AutTec autTec = autTecService.buscarPorPlacaYTecnico(placa, idTecnico);
        if (autTec != null) {
            return new ResponseEntity<>(autTec, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar por placa e idTecnico
    @PutMapping("/editar/{placa}/{idTecnico}")
    public ResponseEntity<Boolean> editarAutTec(@PathVariable String placa, @PathVariable int idTecnico, @RequestBody AutTec autTec) {
        autTec.setPlaca(placa);
        autTec.setIdTecnico(idTecnico);
        boolean editado = autTecService.editarAutTec(autTec);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar por placa e idTecnico
    @DeleteMapping("/eliminar/{placa}/{idTecnico}")
    public ResponseEntity<Boolean> eliminarAutTec(@PathVariable String placa, @PathVariable int idTecnico) {
        boolean eliminado = autTecService.eliminarAutTec(placa, idTecnico);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

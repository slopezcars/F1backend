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
@CrossOrigin(origins = "*") // permitir todos los orígenes
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

    // Buscar por placa
    @GetMapping("/buscar/{placa}")
    public ResponseEntity<AutTec> buscarPorPlaca(@PathVariable String placa) {
        AutTec autTec = autTecService.buscarPorPlaca(placa);
        if (autTec != null) {
            return new ResponseEntity<>(autTec, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar por placa
    @PutMapping("/editar/{placa}")
    public ResponseEntity<Boolean> editarAutTec(@PathVariable String placa, @RequestBody AutTec autTec) {
        autTec.setPlaca(placa);
        boolean editado = autTecService.editarAutTec(autTec);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar por placa
    @DeleteMapping("/eliminar/{placa}")
    public ResponseEntity<Boolean> eliminarAutTec(@PathVariable String placa) {
        boolean eliminado = autTecService.eliminarAutTec(placa);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

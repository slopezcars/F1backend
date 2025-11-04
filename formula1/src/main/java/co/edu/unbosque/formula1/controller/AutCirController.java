package co.edu.unbosque.formula1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.formula1.model.AutCir;
import co.edu.unbosque.formula1.service.AutCirService;

@RestController
@RequestMapping("/autCir")
@CrossOrigin
public class AutCirController {

    @Autowired
    private AutCirService autCirService;

    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearAutCir(@RequestBody AutCir autCir) {
        boolean creada = autCirService.crearAutCir(autCir);
        return new ResponseEntity<>(creada, creada ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AutCir>> obtenerTodas() {
        List<AutCir> lista = autCirService.obtenerTodas();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<AutCir> buscarPorId(@RequestParam int idCircuito, @RequestParam String placa) {
        AutCir autCir = autCirService.buscarPorId(idCircuito, placa);
        if (autCir != null) {
            return new ResponseEntity<>(autCir, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<Boolean> editarAutCir(@RequestBody AutCir autCir) {
        boolean editada = autCirService.editarAutCir(autCir);
        return new ResponseEntity<>(editada, editada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Boolean> eliminarAutCir(@RequestParam int idCircuito, @RequestParam String placa) {
        boolean eliminada = autCirService.eliminarAutCir(idCircuito, placa);
        return new ResponseEntity<>(eliminada, eliminada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}

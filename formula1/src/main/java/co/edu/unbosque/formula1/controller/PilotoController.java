package co.edu.unbosque.formula1.controller;

import java.util.List;
import java.util.Map;

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
import co.edu.unbosque.formula1.model.Piloto;
import co.edu.unbosque.formula1.service.PilotoService;

@RestController
@RequestMapping("/piloto")
@CrossOrigin(origins = { "http://localhost:8080" })
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    // Crear piloto
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearPiloto(@RequestBody Piloto piloto) {
        boolean creado = pilotoService.crearPiloto(piloto);
        return new ResponseEntity<>(creado, creado ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Listar pilotos
    @GetMapping("/listar")
    public ResponseEntity<List<Piloto>> listarPilotos() {
        List<Piloto> pilotos = pilotoService.obtenerTodos();
        return new ResponseEntity<>(pilotos, HttpStatus.OK);
    }

    // Buscar por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Piloto> buscarPorId(@PathVariable int id) {
        Piloto piloto = pilotoService.buscarPorId(id);
        if (piloto != null) {
            return new ResponseEntity<>(piloto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar piloto
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarPiloto(@PathVariable int id, @RequestBody Piloto piloto) {
        piloto.setId(id);
        boolean editado = pilotoService.editarPiloto(piloto);
        return new ResponseEntity<>(editado, editado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar piloto
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarPiloto(@PathVariable int id) {
        boolean eliminado = pilotoService.eliminarPiloto(id);
        return new ResponseEntity<>(eliminado, eliminado ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
 // Asignar auto a piloto
    @PostMapping("/asignar-auto")
    public void asignarAuto(@RequestBody Map<String, Object> datos) {
        int idPiloto = (int) datos.get("idPiloto");
        String placa = (String) datos.get("placaAuto");
        pilotoService.asignarAutoAPiloto(idPiloto, placa);
    }

    // Eliminar auto de piloto
    @DeleteMapping("/eliminar-auto")
    public void eliminarAuto(@RequestBody Map<String, Object> datos) {
        int idPiloto = (int) datos.get("idPiloto");
        String placa = (String) datos.get("placaAuto");
        pilotoService.eliminarAutoDePiloto(idPiloto, placa);
    }

    // Ver autos de un piloto
    @GetMapping("/ver-autos/{idPiloto}")
    public List<Auto> verAutos(@PathVariable int idPiloto) {
        return pilotoService.obtenerAutosDePiloto(idPiloto);
    }

    // Ver pilotos de un auto
    @GetMapping("/ver-pilotos/{placaAuto}")
    public List<Piloto> verPilotos(@PathVariable String placaAuto) {
        return pilotoService.obtenerPilotosDeAuto(placaAuto);
    }
}

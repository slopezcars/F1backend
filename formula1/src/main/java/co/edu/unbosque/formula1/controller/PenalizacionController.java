package co.edu.unbosque.formula1.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.formula1.model.Penalizacion;
import co.edu.unbosque.formula1.model.TipoPenalizacion;
import co.edu.unbosque.formula1.service.PenalizacionService;

@RestController
@RequestMapping("/penalizacion")
@CrossOrigin(origins = { "http://localhost:8080" })
public class PenalizacionController {

    @Autowired
    private PenalizacionService penalizacionService;

    // Crear penalización
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearPenalizacion(@RequestBody Penalizacion penalizacion) {
        boolean creada = penalizacionService.crearPenalizacion(penalizacion);
        return new ResponseEntity<>(creada, creada ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // Obtener todas las penalizaciones
    @GetMapping("/listar")
    public ResponseEntity<List<Penalizacion>> obtenerTodas() {
        List<Penalizacion> penalizaciones = penalizacionService.obtenerTodas();
        return new ResponseEntity<>(penalizaciones, HttpStatus.OK);
    }

    // Buscar penalización por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Penalizacion> buscarPorId(@PathVariable int id) {
        Penalizacion penalizacion = penalizacionService.buscarPorId(id);
        if (penalizacion != null) {
            return new ResponseEntity<>(penalizacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Editar penalización
    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editarPenalizacion(@PathVariable int id, @RequestBody Penalizacion penalizacion) {
        penalizacion.setIdPenalizacion(id);
        boolean editada = penalizacionService.editarPenalizacion(penalizacion);
        return new ResponseEntity<>(editada, editada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    // Eliminar penalización
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarPenalizacion(@PathVariable int id) {
        boolean eliminada = penalizacionService.eliminarPenalizacion(id);
        return new ResponseEntity<>(eliminada, eliminada ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
 // Asignar penalización a piloto
    @PostMapping("/asignar-a-piloto")
    public void asignarPenalizacionAPiloto(@RequestBody Map<String, Object> datos) {
        int idPiloto = (int) datos.get("idPiloto");
        int idPenalizacion = (int) datos.get("idPenalizacion");
        penalizacionService.agregarPenalizacionAPiloto(idPiloto, idPenalizacion);
    }

    // Eliminar penalización de piloto
    @DeleteMapping("/eliminar-de-piloto")
    public void eliminarPenalizacionDePiloto(@RequestBody Map<String, Object> datos) {
        int idPiloto = (int) datos.get("idPiloto");
        int idPenalizacion = (int) datos.get("idPenalizacion");
        penalizacionService.eliminarPenalizacionDePiloto(idPiloto, idPenalizacion);
    }

    // Ver penalizaciones de un piloto
    @GetMapping("/ver-por-piloto/{idPiloto}")
    public List<Penalizacion> verPenalizacionesDePiloto(@PathVariable int idPiloto) {
        return penalizacionService.obtenerPenalizacionesDePiloto(idPiloto);
    }
 // Asignar penalización a carrera
    @PostMapping("/asignar-penalizacion-carrera")
    public void asignarPenalizacionACarrera(@RequestBody Map<String, Object> datos) {
        int idCarrera = (int) datos.get("idCarrera");
        int idPenalizacion = (int) datos.get("idPenalizacion");
        penalizacionService.asignarPenalizacionACarrera(idCarrera, idPenalizacion);
    }

    // Eliminar penalización de carrera
    @DeleteMapping("/eliminar-penalizacion-carrera")
    public void eliminarPenalizacionDeCarrera(@RequestBody Map<String, Object> datos) {
        int idCarrera = (int) datos.get("idCarrera");
        int idPenalizacion = (int) datos.get("idPenalizacion");
        penalizacionService.eliminarPenalizacionDeCarrera(idCarrera, idPenalizacion);
    }

    // Ver penalizaciones de una carrera
    @GetMapping("/ver-penalizaciones-carrera/{idCarrera}")
    public List<Penalizacion> verPenalizacionesDeCarrera(@PathVariable int idCarrera) {
        return penalizacionService.obtenerPenalizacionesDeCarrera(idCarrera);
    }
 // Asignar un tipo a penalización
    @PostMapping("/asignar-tipo")
    public void asignarTipo(@RequestBody Map<String, Object> datos) {
        int idPenalizacion = (int) datos.get("idPenalizacion");
        Map<String, Object> tipoMap = (Map<String, Object>) datos.get("tipo");
        TipoPenalizacion tipo = new TipoPenalizacion();
        tipo.setIdTipoPenalizacion((int) tipoMap.get("idTipoPenalizacion"));
        tipo.setNombre((String) tipoMap.get("nombre"));
        tipo.setDescripcion((String) tipoMap.get("descripcion"));
        penalizacionService.asignarTipoAPenalizacion(idPenalizacion, tipo);
    }

    // Quitar tipo de penalización
    @DeleteMapping("/quitar-tipo")
    public void quitarTipo(@RequestBody Map<String, Integer> datos) {
        int idPenalizacion = datos.get("idPenalizacion");
        int idTipo = datos.get("idTipo");
        penalizacionService.quitarTipoDePenalizacion(idPenalizacion, idTipo);
    }

    // Ver tipos de una penalización
    @GetMapping("/ver-tipos/{idPenalizacion}")
    public List<TipoPenalizacion> verTipos(@PathVariable int idPenalizacion) {
        return penalizacionService.listarTiposDePenalizacion(idPenalizacion);
    }
}

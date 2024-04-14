package com.example.Construccion.Historial.Controlador;

import com.example.Construccion.Historial.Modelo.Historial;
import com.example.Construccion.Historial.Servicios.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/historial")
public class HistorialController {

    private final HistorialService historialService;

    @Autowired
    public HistorialController(HistorialService historialService) {
        this.historialService = historialService;
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarHistorial
            (@RequestParam int idHistorial,
             @RequestParam int idEntidadAfectada,
             @RequestParam String tipoEntidad,
             @RequestParam int idEstadoAnterior,
             @RequestParam int idEstadoNuevo,
             @RequestParam Date fechaHoraCambio) {
        historialService.insertHistorial(idHistorial, idEntidadAfectada, tipoEntidad, idEstadoAnterior, idEstadoNuevo, fechaHoraCambio);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarHistorial
            (@PathVariable int id,
             @RequestParam int idEntidadAfectada,
             @RequestParam String tipoEntidad,
             @RequestParam int idEstadoAnterior,
             @RequestParam int idEstadoNuevo,
             @RequestParam Date fechaHoraCambio) {
        historialService.updateHistorial(id, idEntidadAfectada, tipoEntidad, idEstadoAnterior, idEstadoNuevo, fechaHoraCambio);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistorial(@PathVariable int id) {
        historialService.deleteHistorial(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Historial>> obtenerTodoElHistorial() {
        List<Historial> historial = historialService.findAllHistorial();
        return new ResponseEntity<>(historial, HttpStatus.OK);
    }
}

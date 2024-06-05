package com.example.Construccion.Commons.Controlador;

import com.example.Construccion.Habitaciones.Modelo.EstadoHabitacion;
import com.example.Construccion.Commons.Servicio.EstadoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estadohabitacion")
public class EstadoHabitacionController {

    private final EstadoHabitacionService estadoHabitacionService;

    @Autowired
    public EstadoHabitacionController(EstadoHabitacionService estadoHabitacionService) {
        this.estadoHabitacionService = estadoHabitacionService;
    }

    @GetMapping
    public ResponseEntity<List<EstadoHabitacion>> getAllEstadosHabitacion() {
        List<EstadoHabitacion> estadosHabitacion = estadoHabitacionService.getAllEstadosHabitacion();
        return new ResponseEntity<>(estadosHabitacion, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoHabitacion> getEstadoHabitacionById(@PathVariable("id") int id) {
        EstadoHabitacion estadoHabitacion = estadoHabitacionService.getEstadoHabitacionById(id);
        if (estadoHabitacion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estadoHabitacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoHabitacion> createEstadoHabitacion(@RequestBody EstadoHabitacion estadoHabitacion) {
        EstadoHabitacion createdEstadoHabitacion = estadoHabitacionService.saveEstadoHabitacion(estadoHabitacion);
        return new ResponseEntity<>(createdEstadoHabitacion, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoHabitacion(@PathVariable("id") int id) {
        estadoHabitacionService.deleteEstadoHabitacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

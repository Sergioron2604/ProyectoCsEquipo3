package com.example.Construccion.Commons.Controlador;



import com.example.Construccion.Commons.Servicio.EstadoReservaService;
import com.example.Construccion.Commons.Modelo.EstadoReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estadosreserva")
public class EstadoReservaController {

    private final EstadoReservaService estadoReservaService;

    @Autowired
    public EstadoReservaController(EstadoReservaService estadoReservaService) {
        this.estadoReservaService = estadoReservaService;
    }

    @GetMapping
    public ResponseEntity<List<EstadoReserva>> getAllEstadosReserva() {
        List<EstadoReserva> estadosReserva = estadoReservaService.getAllEstadosReserva();
        return new ResponseEntity<>(estadosReserva, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoReserva> getEstadoReservaById(@PathVariable("id") int id) {
        EstadoReserva estadoReserva = estadoReservaService.getEstadoReservaById(id);
        if (estadoReserva == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estadoReserva, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoReserva> createEstadoReserva(@RequestBody EstadoReserva estadoReserva) {
        EstadoReserva createdEstadoReserva = estadoReservaService.createEstadoReserva(estadoReserva);
        return new ResponseEntity<>(createdEstadoReserva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoReserva(@PathVariable("id") int id) {
        estadoReservaService.deleteEstadoReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

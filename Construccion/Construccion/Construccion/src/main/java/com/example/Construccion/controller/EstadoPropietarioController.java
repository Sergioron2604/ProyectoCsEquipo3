package com.example.Construccion.controller;

import com.example.Construccion.entity.EstadoPropietario;
import com.example.Construccion.service.EstadoPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estadospropietario")
public class EstadoPropietarioController {

    private final EstadoPropietarioService estadoPropietarioService;

    @Autowired
    public EstadoPropietarioController(EstadoPropietarioService estadoPropietarioService) {
        this.estadoPropietarioService = estadoPropietarioService;
    }

    @GetMapping
    public ResponseEntity<List<EstadoPropietario>> getAllEstadosPropietario() {
        List<EstadoPropietario> estadosPropietario = estadoPropietarioService.getAllEstadosPropietario();
        return new ResponseEntity<>(estadosPropietario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPropietario> getEstadoPropietarioById(@PathVariable("id") int id) {
        EstadoPropietario estadoPropietario = estadoPropietarioService.getEstadoPropietarioById(id);
        if (estadoPropietario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estadoPropietario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoPropietario> createEstadoPropietario(@RequestBody EstadoPropietario estadoPropietario) {
        EstadoPropietario createdEstadoPropietario = estadoPropietarioService.createEstadoPropietario(estadoPropietario);
        return new ResponseEntity<>(createdEstadoPropietario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoPropietario(@PathVariable("id") int id) {
        estadoPropietarioService.deleteEstadoPropietario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

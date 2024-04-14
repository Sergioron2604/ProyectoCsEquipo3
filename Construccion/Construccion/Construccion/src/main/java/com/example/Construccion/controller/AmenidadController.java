package com.example.Construccion.controller;

import com.example.Construccion.entity.Amenidad;
import com.example.Construccion.service.AmenidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/amenidades")
public class AmenidadController {

    private final AmenidadService amenidadService;

    @Autowired
    public AmenidadController(AmenidadService amenidadService) {
        this.amenidadService = amenidadService;
    }

    @GetMapping
    public ResponseEntity<List<Amenidad>> getAllAmenidades() {
        List<Amenidad> amenidades = amenidadService.getAllAmenidades();
        return new ResponseEntity<>(amenidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Amenidad> getAmenidadById(@PathVariable("id") int id) {
        Amenidad amenidad = amenidadService.getAmenidadById(id);
        if (amenidad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(amenidad, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Amenidad> getAmenidadByNombre(@PathVariable("nombre") String nombre) {
        Amenidad amenidad = amenidadService.getAmenidadByNombre(nombre);
        if (amenidad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(amenidad, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createAmenidad(@RequestBody Amenidad amenidad) {
        amenidadService.saveAmenidad(amenidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmenidad(@PathVariable("id") int id) {
        amenidadService.deleteAmenidad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

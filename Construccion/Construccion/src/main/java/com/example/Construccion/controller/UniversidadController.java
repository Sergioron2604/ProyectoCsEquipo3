package com.example.Construccion.controller;

import com.example.Construccion.entity.Universidad;
import com.example.Construccion.service.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/universidades")
public class UniversidadController {

    private final UniversidadService universidadService;

    @Autowired
    public UniversidadController(UniversidadService universidadService) {
        this.universidadService = universidadService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Void> crearUniversidad(@RequestBody Universidad universidad) {
        universidadService.saveUniversidad(universidad.getIdUniversidad(), universidad.getNombreUniversidad(), universidad.getDireccion(), universidad.getCiudad());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarUniversidad(@PathVariable int id, @RequestBody Universidad universidad) {
        universidadService.updateUniversidad(id, universidad.getNombreUniversidad(), universidad.getDireccion(), universidad.getCiudad());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUniversidad(@PathVariable int id) {
        universidadService.deleteUniversidad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Universidad>> obtenerTodasLasUniversidades() {
        List<Universidad> universidades = universidadService.findAllUniversidades();
        return new ResponseEntity<>(universidades, HttpStatus.OK);
    }
}

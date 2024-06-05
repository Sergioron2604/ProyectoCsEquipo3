package com.example.Construccion.Controller;

import com.example.Construccion.entity.EstadoEstudiante;
import com.example.Construccion.Service.EstadoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estadoestudiante")
public class EstadoEstudianteController {

    private final EstadoEstudianteService estadoEstudianteService;

    @Autowired
    public EstadoEstudianteController(EstadoEstudianteService estadoEstudianteService) {
        this.estadoEstudianteService = estadoEstudianteService;
    }

    @GetMapping
    public ResponseEntity<List<EstadoEstudiante>> getAllEstadosEstudiante() {
        List<EstadoEstudiante> estadosEstudiante = estadoEstudianteService.getAllEstadosEstudiante();
        return new ResponseEntity<>(estadosEstudiante, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoEstudiante> getEstadoEstudianteById(@PathVariable("id") int id) {
        EstadoEstudiante estadoEstudiante = estadoEstudianteService.getEstadoEstudianteById(id);
        if (estadoEstudiante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estadoEstudiante, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoEstudiante> createEstadoEstudiante(@RequestBody EstadoEstudiante estadoEstudiante) {
        EstadoEstudiante createdEstadoEstudiante = estadoEstudianteService.saveEstadoEstudiante(estadoEstudiante);
        return new ResponseEntity<>(createdEstadoEstudiante, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoEstudiante(@PathVariable("id") int id) {
        estadoEstudianteService.deleteEstadoEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

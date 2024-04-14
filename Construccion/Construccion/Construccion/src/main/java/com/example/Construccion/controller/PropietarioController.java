package com.example.Construccion.controller;

import com.example.Construccion.entity.Propietario;
import com.example.Construccion.service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    @Autowired
    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void> insertarPropietario(@RequestParam int idPropietario, @RequestParam String nombre,
                                                    @RequestParam String email, @RequestParam String telefono,
                                                    @RequestParam int idEstado, @RequestParam int idUniversidad) {
        propietarioService.insertPropietario(idPropietario, nombre, email, telefono, idEstado, idUniversidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarPropietario(@PathVariable int id, @RequestParam String nombre,
                                                      @RequestParam String email, @RequestParam String telefono,
                                                      @RequestParam int idEstado, @RequestParam int idUniversidad) {
        propietarioService.updatePropietario(id, nombre, email, telefono, idEstado, idUniversidad);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPropietario(@PathVariable int id) {
        propietarioService.deletePropietario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Propietario>> obtenerTodosLosPropietarios() {
        List<Propietario> propietarios = propietarioService.findAllPropietarios();
        return new ResponseEntity<>(propietarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> obtenerPropietarioPorId(@PathVariable int id) {
        Propietario propietario = propietarioService.findPropietarioById(id);
        if (propietario != null) {
            return new ResponseEntity<>(propietario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

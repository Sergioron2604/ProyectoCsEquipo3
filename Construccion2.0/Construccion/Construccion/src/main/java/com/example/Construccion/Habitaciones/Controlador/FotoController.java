package com.example.Construccion.Habitaciones.Controlador;

import com.example.Construccion.Habitaciones.Modelo.Foto;
import com.example.Construccion.Habitaciones.Servicios.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fotos")
public class FotoController {

    private final FotoService fotoService;

    @Autowired
    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @GetMapping
    public ResponseEntity<List<Foto>> getAllFotos() {
        List<Foto> fotos = fotoService.findAllFotos();
        return new ResponseEntity<>(fotos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foto> getFotoById(@PathVariable("id") int id) {
        Foto foto = fotoService.findFotoById(id);
        if (foto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foto, HttpStatus.OK);
    }

    @GetMapping("/habitacion/{idHabitacion}")
    public ResponseEntity<List<Foto>> getFotosByHabitacion(@PathVariable("idHabitacion") int idHabitacion) {
        List<Foto> fotos = fotoService.findFotosByHabitacion(idHabitacion);
        return new ResponseEntity<>(fotos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Foto> createFoto(@RequestBody Foto foto) {
        Foto createdFoto = fotoService.saveFoto(foto);
        return new ResponseEntity<>(createdFoto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoto(@PathVariable("id") int id) {
        if (fotoService.existsFoto(id)) {
            fotoService.deleteFoto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package com.example.Construccion.controller;

import com.example.Construccion.entity.Foto;
import com.example.Construccion.repository.FotoRepository;
import com.example.Construccion.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fotos")
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


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoto(@PathVariable("id") int id) {
        if (fotoService.existsFoto(id)) {
            fotoService.deleteFoto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/subir")
    public ResponseEntity<Foto> createFoto(@RequestBody Foto foto) {
        Foto createdFoto = fotoService.saveFoto(foto);
        return new ResponseEntity<>(createdFoto, HttpStatus.CREATED);
    }

    @GetMapping("/formatos")
    public List<String> obtenerFormatosPermitidos() {
        return fotoService.obtenerFormatosPermitidos();
    }
}

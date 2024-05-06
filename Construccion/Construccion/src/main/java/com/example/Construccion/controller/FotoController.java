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

    @Autowired
    private FotoService fotoService;

    /* Se agregan los 3 escenarios funcionales para que pueda funcionar la historia de usuario usando
       los parametro de excepciones y carga de productos */

    @PostMapping("/subirfoto")
    public ResponseEntity<?> subirFoto(@RequestParam("file") MultipartFile file,
                                       @RequestParam("idHabitacion") int idHabitacion) {
        try {
            fotoService.SubirFoto(file, idHabitacion);
            return ResponseEntity.ok("Imagen subida exitosamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al subir la imagen.");
        }
    }

    @GetMapping("/fotos")
    public List<Foto> obtenerTodasLasFotos() {
        return fotoService.obtenerTodasLasFotos();
    }
}

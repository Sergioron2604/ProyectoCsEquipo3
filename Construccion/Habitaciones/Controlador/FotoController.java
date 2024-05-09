package com.example.Construccion.Habitaciones.Controlador;

import com.example.Construccion.Habitaciones.Modelo.Foto;
import com.example.Construccion.Habitaciones.Servicios.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fotos")
public class FotoController {

    @Autowired
    private FotoService fotoService;

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

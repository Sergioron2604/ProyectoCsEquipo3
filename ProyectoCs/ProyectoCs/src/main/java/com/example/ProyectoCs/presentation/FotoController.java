package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.FotoDTO;
import com.example.ProyectoCs.application.usescase.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/fotos")
public class FotoController {

    private final FotoService fotoService;

    @Autowired
    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @PostMapping
    public ResponseEntity<String> subirFoto(@RequestParam("archivo") MultipartFile archivo,
                                            @RequestParam("idAlojamiento") Integer idAlojamiento) {
        FotoDTO fotoDTO = new FotoDTO();
        fotoDTO.setArchivo(archivo);
        fotoDTO.setIdAlojamiento(idAlojamiento);

        try {
            String urlFoto = fotoService.subirFoto(fotoDTO);
            return ResponseEntity.ok().body(urlFoto);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la foto");
        }
    }
}


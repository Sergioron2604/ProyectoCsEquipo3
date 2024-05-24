package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.FotoDTO;
import com.example.ProyectoCs.application.usescase.FotoService;
import com.example.ProyectoCs.application.dto.AlojamientoDTO;
import com.example.ProyectoCs.application.usescase.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/alojamientos")
public class AlojamientoController {

    private final AlojamientoService alojamientoService;
    private final FotoService fotoService;

    @Autowired
    public AlojamientoController(AlojamientoService alojamientoService , FotoService fotoService) {
        this.alojamientoService = alojamientoService;
        this.fotoService = fotoService;
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<AlojamientoDTO>> filtrarAlojamientos(
            @RequestParam double precioMin,
            @RequestParam double precioMax,
            @RequestParam String ciudad,
            @RequestParam boolean tieneLavanderia,
            @RequestParam boolean tieneRoomie,
            @RequestParam boolean tieneParqueaderoBicicleta) {
        List<AlojamientoDTO> alojamientosFiltrados = alojamientoService.filtrarAlojamientos(
                precioMin, precioMax, ciudad, tieneLavanderia, tieneRoomie, tieneParqueaderoBicicleta);
        return ResponseEntity.ok(alojamientosFiltrados);
    }

    @PostMapping("/crear/alojamiento")
    public ResponseEntity<String> crearAlojamiento(@RequestBody AlojamientoDTO alojamientoDTO) {
        try {
            alojamientoService.crearNuevaHabitacion(alojamientoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("La habitación se ha creado exitosamente.");
        } catch (MessagingException | jakarta.mail.MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la habitación: " + e.getMessage());
        }
    }

    @PostMapping("/foto")
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
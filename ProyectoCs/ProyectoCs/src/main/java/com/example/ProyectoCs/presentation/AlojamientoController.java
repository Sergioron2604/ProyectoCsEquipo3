package com.example.ProyectoCs.presentation;


import com.example.ProyectoCs.application.dto.AlojamientoDTO;
import com.example.ProyectoCs.application.usescase.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/alojamientos")
public class AlojamientoController {

    private final AlojamientoService alojamientoService;

    @Autowired
    public AlojamientoController(AlojamientoService alojamientoService) {
        this.alojamientoService = alojamientoService;
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

    @PostMapping("/crear")
    public ResponseEntity<String> crearNuevaHabitacion(@RequestBody AlojamientoDTO alojamientoDTO) {
        try {
            alojamientoService.crearNuevaHabitacion(alojamientoDTO);
            return ResponseEntity.ok("Nueva habitación creada con éxito.");
        } catch (MessagingException e) {
            return ResponseEntity.badRequest().body("Error al crear la habitación: " + e.getMessage());
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
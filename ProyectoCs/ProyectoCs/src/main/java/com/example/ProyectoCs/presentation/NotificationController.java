package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.application.usescase.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<String> registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        try {
            estudianteService.registrarEstudiante(estudianteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante registrado y correo de bienvenida enviado.");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el correo de bienvenida.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el estudiante.");
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable String email) throws MessagingException, jakarta.mail.MessagingException {
        try {
            estudianteService.eliminarEstudiante(email);
            return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante registrado y correo de bienvenida enviado.");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el correo de eliminación.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el estudiante.");
        }

    }
}

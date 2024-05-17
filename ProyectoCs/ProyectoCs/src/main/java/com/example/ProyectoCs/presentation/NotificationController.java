package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.application.dto.PropietarioDTO;
import com.example.ProyectoCs.application.usescase.EstudianteService;
import com.example.ProyectoCs.application.usescase.PropietarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {

    @Autowired
    private EstudianteService estudianteService;
    private final PropietarioService propietarioService;



    @PostMapping("registrar/usuario")
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

    @DeleteMapping("/estudiante/{email}")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable String email) throws MessagingException, jakarta.mail.MessagingException {
        try {
            estudianteService.eliminarEstudiante(email);
            return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante eliminado y correo de eliminación enviado.");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el correo de eliminación.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el estudiante.");
        }

    }

    @PostMapping("registrar/propietario")
    public ResponseEntity<String> registrarPropietario(@RequestBody PropietarioDTO propietarioDTO) {
        try {
            propietarioService.registrarPropietario(propietarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Propietario registrado exitosamente");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el correo de bienvenida");
        }
    }

    @DeleteMapping("/propietarios/{email}")
    public ResponseEntity<String> eliminarPropietario(@PathVariable String email) {
        try {
            propietarioService.eliminarPropietario(email);
            return ResponseEntity.status(HttpStatus.CREATED).body("Propietario eliminado y correo de eliminicación enviado.");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el correo de eliminación.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el propietario.");
        }
}
}



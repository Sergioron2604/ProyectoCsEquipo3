package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.application.dto.PropietarioDTO;
import com.example.ProyectoCs.application.usescase.EstudianteService;
import com.example.ProyectoCs.application.usescase.PropietarioService;
import com.example.ProyectoCs.application.usescase.AlojamientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/v1/propietarios")
@RequiredArgsConstructor
public class PropietarioController {

    @Autowired
    private EstudianteService estudianteService;
    private final PropietarioService propietarioService;

    private final AlojamientoService alojamientoService;


    @PostMapping("/registrar")
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



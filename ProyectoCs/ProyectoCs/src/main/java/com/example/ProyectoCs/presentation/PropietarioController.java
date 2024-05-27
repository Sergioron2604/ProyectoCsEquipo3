package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.PropietarioDTO;
import com.example.ProyectoCs.application.usecase.PropietarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("api/v1/propietarios")
public class PropietarioController {

    private final PropietarioUseCase propietarioUseCase;

    @Autowired
    public PropietarioController(PropietarioUseCase propietarioUseCase) {
        this.propietarioUseCase = propietarioUseCase;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPropietario(@RequestBody PropietarioDTO propietarioDTO) {
        try {
            propietarioUseCase.registrarPropietario(propietarioDTO);
            return ResponseEntity.ok("Propietario registrado exitosamente.");
        } catch (IllegalStateException | IllegalArgumentException | MessagingException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

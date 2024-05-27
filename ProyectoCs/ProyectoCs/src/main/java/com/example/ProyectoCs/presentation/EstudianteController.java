package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.application.usecase.ReservaUseCase;
import com.example.ProyectoCs.application.dto.ReservaDTO;
import com.example.ProyectoCs.infrastructure.gateway.EstudianteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("api/v1/estudiantes")
public class EstudianteController {

    private final EstudianteGateway estudianteGateway;
    private final ReservaUseCase reservaUseCase;

    @Autowired
    public EstudianteController(EstudianteGateway estudianteGateway ,ReservaUseCase reservaUseCase) {
        this.estudianteGateway = estudianteGateway;
        this.reservaUseCase = reservaUseCase;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        try {
            estudianteGateway.registrarEstudiante(estudianteDTO);
            return new ResponseEntity<>("Estudiante registrado exitosamente", HttpStatus.CREATED);
        } catch (IllegalStateException | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (MessagingException | jakarta.mail.MessagingException e) {
            return new ResponseEntity<>("Error al enviar la notificación", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{email}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable String email) {
        try {
            estudianteGateway.eliminarEstudiante(email);
            return new ResponseEntity<>("Estudiante eliminado exitosamente", HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (MessagingException | jakarta.mail.MessagingException e) {
            return new ResponseEntity<>("Error al enviar la notificación", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear/reserva")
    public ResponseEntity<String> createReserva(@RequestBody ReservaDTO reservaDTO) throws MessagingException, jakarta.mail.MessagingException {
        reservaUseCase.saveReserva(reservaDTO);
        return ResponseEntity.ok("Reserva creada exitosamente");
    }


    @DeleteMapping("/{idReserva}")
    public ResponseEntity<String> cancelarReserva(@PathVariable int idReserva) {
        String resultado = reservaUseCase.cancelarReserva(idReserva);
        return ResponseEntity.ok(resultado);
    }
}

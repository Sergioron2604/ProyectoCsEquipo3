package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.EstudianteDTO;
import com.example.ProyectoCs.application.dto.ReservaDTO;
import com.example.ProyectoCs.infrastructure.gateway.EstudianteGateway;
import com.example.ProyectoCs.infrastructure.gateway.ReservaGateway;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("api/v1/estudiantes")
@Api(tags = "Estudiantes ", description = "Operaciones relacionadas con Estudiantes")
public class EstudianteController {

    private final EstudianteGateway estudianteGateway;
    private final ReservaGateway reservaGateway;

    @Autowired
    public EstudianteController(EstudianteGateway estudianteGateway ,ReservaGateway reservaGateway) {
        this.estudianteGateway = estudianteGateway;
        this.reservaGateway = reservaGateway;
    }


    @ApiOperation(value = "Registrar un estudiante")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Estudiante registrado exitosamente"),
            @ApiResponse(code = 400, message = "Error al registrar el estudiante"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
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


    @ApiOperation(value = "Eliminar un estudiante por correo electrónico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Estudiante eliminado exitosamente"),
            @ApiResponse(code = 400, message = "Error al eliminar el estudiante"),
            @ApiResponse(code = 404, message = "El estudiante no fue encontrado")
    })
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


    @ApiOperation(value = "Crear una reserva")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reserva creada correctamente"),
            @ApiResponse(code = 400, message = "No se pudo crear la reserva"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })
    @PostMapping("/crear")
    public ResponseEntity<String> crearReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            // Validar si el correo electrónico del estudiante existe en la base de datos antes de crear la reserva
            if (!estudianteGateway.estudianteExistente(reservaDTO.getEmailEstudiante())) {
                return ResponseEntity.badRequest().body("El estudiante no está registrado");
            }
            reservaGateway.saveReserva(reservaDTO);
            return ResponseEntity.ok("La reserva se ha creado correctamente.");
        } catch (MessagingException | jakarta.mail.MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la reserva: " + e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body("No se pudo crear la reserva: " + e.getMessage());
        }
    }

    @ApiOperation(value = "Cancelar una reserva por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reserva cancelada correctamente"),
            @ApiResponse(code = 400, message = "No se pudo cancelar la reserva"),
    })
    @PostMapping("/cancelar/{idReserva}")
    public ResponseEntity<String> cancelarReserva(@PathVariable int idReserva) {
        try {
            String mensaje = reservaGateway.cancelarReserva(idReserva);
            return ResponseEntity.ok(mensaje);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body("No se pudo cancelar la reserva: " + e.getMessage());
        }

    }
    }

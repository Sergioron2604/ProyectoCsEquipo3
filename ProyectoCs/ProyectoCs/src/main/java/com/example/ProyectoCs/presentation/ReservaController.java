package com.example.ProyectoCs.presentation;

import com.example.ProyectoCs.application.dto.ReservaDTO;
import com.example.ProyectoCs.application.usescase.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<String> crearReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            reservaService.saveReserva(reservaDTO);
            return ResponseEntity.ok("Reserva creada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cancelar/{idReserva}")
    public ResponseEntity<String> cancelarReserva(@PathVariable int idReserva) {
        try {
            String mensaje = reservaService.cancelarReserva(idReserva);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

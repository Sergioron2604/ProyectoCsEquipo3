package com.example.Construccion.Habitaciones.Controlador;

import com.example.Construccion.Habitaciones.Modelo.Reserva;
import com.example.Construccion.Habitaciones.Servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }


    @PostMapping
    public void insertarReserva(@RequestParam int idReserva, @RequestParam int idEstudiante, @RequestParam int idHabitacion, @RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam int idEstado) {
        reservaService.insertarReserva(idReserva, idEstudiante, idHabitacion, fechaInicio, fechaFin, idEstado);
    }


    @PostMapping("/{id}")
    public void actualizarReserva(@PathVariable int id, @RequestParam int idEstudiante, @RequestParam int idHabitacion, @RequestParam Date fechaInicio, @RequestParam Date fechaFin, @RequestParam int idEstado) {
        reservaService.actualizarReserva(id, idEstudiante, idHabitacion, fechaInicio, fechaFin, idEstado);
    }


    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable int id) {
        reservaService.eliminarReserva(id);
    }

    @GetMapping
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaService.obtenerTodasLasReservas();
    }


    @GetMapping("/{id}")
    public Reserva obtenerReservaPorId(@PathVariable int id) {
        return reservaService.obtenerReservaPorId(id);
    }
}

package com.example.Construccion.service;

import com.example.Construccion.entity.Reserva;
import com.example.Construccion.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


    public void insertarReserva(int idReserva, int idEstudiante, int idHabitacion, Date fechaInicio, Date fechaFin, int idEstado) {
        reservaRepository.insertReserva(idReserva, idEstudiante, idHabitacion, fechaInicio, fechaFin, idEstado);
    }


    public void actualizarReserva(int idReserva, int idEstudiante, int idHabitacion, Date fechaInicio, Date fechaFin, int idEstado) {
        reservaRepository.updateReserva(idReserva, idEstudiante, idHabitacion, fechaInicio, fechaFin, idEstado);
    }


    public void eliminarReserva(int idReserva) {
        reservaRepository.deleteReserva(idReserva);
    }

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAllReservas();
    }


    public Reserva obtenerReservaPorId(int idReserva) {
        return reservaRepository.findByidReserva(idReserva);
    }
}

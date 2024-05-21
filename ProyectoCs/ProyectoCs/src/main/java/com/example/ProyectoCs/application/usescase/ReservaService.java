package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.ReservaDTO;
import com.example.ProyectoCs.domain.model.Alojamiento;
import com.example.ProyectoCs.domain.model.EstadoReserva;
import com.example.ProyectoCs.domain.model.Reserva;
import com.example.ProyectoCs.domain.repository.AlojamientoRepository;
import com.example.ProyectoCs.domain.repository.EstadoReservaRepository;
import com.example.ProyectoCs.domain.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AlojamientoRepository alojamientoRepository;


    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    public void saveReserva(ReservaDTO reservaDTO) {
        Alojamiento alojamiento = alojamientoRepository.findById(reservaDTO.getIdAlojamiento())
                .orElseThrow(() -> new IllegalArgumentException("Alojamiento no encontrado"));

        if (alojamiento.getEstadoHabitacion().getIdEstadoHabitacion() != 1) {
            throw new IllegalStateException("No se puede reservar un alojamiento ocupado.");
        }

        if (tieneConflictosDeReserva(reservaDTO)) {
            throw new IllegalStateException("La reserva tiene conflictos con otras reservas existentes.");
        }
        Reserva reserva = convertToEntity(reservaDTO);
        reservaRepository.save(reserva);
    }

    private boolean tieneConflictosDeReserva(ReservaDTO nuevaReserva) {
        List<Reserva> reservasExistentes = reservaRepository.findAll();
        Date nuevaInicio = nuevaReserva.getFechaInicio();
        Date nuevaFin = nuevaReserva.getFechaFin();

        return reservasExistentes.stream()
                .anyMatch(reservaExistente ->
                        reservaExistente.getAlojamiento().getIdAlojamiento() == nuevaReserva.getIdAlojamiento() &&
                                !reservaExistente.getFechaFin().before(nuevaInicio) &&
                                !reservaExistente.getFechaInicio().after(nuevaFin));
    }


    private Reserva convertToEntity(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        reserva.setIdReserva(reservaDTO.getIdReserva());
        reserva.setFechaInicio(reservaDTO.getFechaInicio());
        reserva.setFechaFin(reservaDTO.getFechaFin());

        Alojamiento alojamiento = alojamientoRepository.findById(reservaDTO.getIdAlojamiento()).orElseThrow(() -> new IllegalArgumentException("Alojamiento no encontrado"));
        reserva.setAlojamiento(alojamiento);

        EstadoReserva estadoReserva = estadoReservaRepository.findById(reservaDTO.getIdEstadoReserva()).orElseThrow(() -> new IllegalArgumentException("Estado de reserva no encontrado"));
        reserva.setEstadoReserva(estadoReserva);

        return reserva;
    }

    public String cancelarReserva(int idReserva) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(idReserva);
        if (reservaOptional.isPresent()) {
            Reserva reserva = reservaOptional.get();
            // Verificar que la reserva está activa y que faltan 3 horas o más para la reserva
            if (reserva.getEstadoReserva().getIdEstadoReserva() == 1 &&
                    new Date().getTime() <= reserva.getFechaInicio().getTime() - 3 * 60 * 60 * 1000) {
                // Cambiar el estado de la reserva a cancelado (2)
                reserva.getEstadoReserva().setIdEstadoReserva(2);
                reservaRepository.save(reserva);
                return "La reserva ha sido cancelada exitosamente.";
            } else {
                return "No se puede cancelar la reserva. La reserva ya está en curso o el tiempo mínimo para cancelar ha pasado.";
            }
        }
        return "Reserva no encontrada.";
    }






}




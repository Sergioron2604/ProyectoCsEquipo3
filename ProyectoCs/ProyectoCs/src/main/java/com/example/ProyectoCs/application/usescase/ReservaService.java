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

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AlojamientoRepository alojamientoRepository;

    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    public void saveReserva(ReservaDTO reservaDTO) {
        Reserva reserva = convertToEntity(reservaDTO);
        reservaRepository.save(reserva);
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
}

package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.EstadoReservaDTO;
import com.example.ProyectoCs.domain.model.EstadoReserva;
import com.example.ProyectoCs.domain.repository.EstadoReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoReservaService {

    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    public void saveEstadoReserva(EstadoReservaDTO estadoReservaDTO) {
        EstadoReserva estadoReserva = convertToEntity(estadoReservaDTO);
        estadoReservaRepository.save(estadoReserva);
    }

    private EstadoReserva convertToEntity(EstadoReservaDTO estadoReservaDTO) {
        EstadoReserva estadoReserva = new EstadoReserva();
        estadoReserva.setIdEstadoReserva(estadoReservaDTO.getIdEstadoReserva());
        estadoReserva.setEstadoReserva(estadoReservaDTO.getEstadoReserva());
        return estadoReserva;
    }
}

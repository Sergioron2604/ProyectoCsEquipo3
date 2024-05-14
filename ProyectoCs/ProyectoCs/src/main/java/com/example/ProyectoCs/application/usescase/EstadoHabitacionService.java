package com.example.ProyectoCs.application.usescase;

import com.example.ProyectoCs.application.dto.EstadoHabitacionDTO;
import com.example.ProyectoCs.domain.model.EstadoHabitacion;
import com.example.ProyectoCs.domain.repository.EstadoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoHabitacionService {

    @Autowired
    private EstadoHabitacionRepository estadoHabitacionRepository;

    public void saveEstadoHabitacion(EstadoHabitacionDTO estadoHabitacionDTO) {
        EstadoHabitacion estadoHabitacion = convertToEntity(estadoHabitacionDTO);
        estadoHabitacionRepository.save(estadoHabitacion);
    }

    private EstadoHabitacion convertToEntity(EstadoHabitacionDTO estadoHabitacionDTO) {
        EstadoHabitacion estadoHabitacion = new EstadoHabitacion();
        estadoHabitacion.setIdEstadoHabitacion(estadoHabitacionDTO.getIdEstadoHabitacion());
        estadoHabitacion.setEstadoHabitacion(estadoHabitacionDTO.getEstadoHabitacion());
        return estadoHabitacion;
    }
}

package com.example.Construccion.service;

import com.example.Construccion.entity.EstadoHabitacion;
import com.example.Construccion.repository.EstadoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EstadoHabitacionService {

    @Autowired
    private EstadoHabitacionRepository estadoHabitacionRepository;

    public EstadoHabitacion saveEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        return estadoHabitacionRepository.save(estadoHabitacion);
    }

    public EstadoHabitacion updateEstadoHabitacion(int idEstadoHabitacion, String estadoHabitacion) {
        EstadoHabitacion estadoHabitacionToUpdate = estadoHabitacionRepository.findEstadoHabitacionById(idEstadoHabitacion);
        if (estadoHabitacionToUpdate != null) {
            estadoHabitacionToUpdate.setEstadoHabitacion(estadoHabitacion);
            return estadoHabitacionRepository.save(estadoHabitacionToUpdate);
        }
        return null;
    }

    public void deleteEstadoHabitacion(int idEstadoHabitacion) {
        estadoHabitacionRepository.deleteEstadoHabitacion(idEstadoHabitacion);
    }

    public List<EstadoHabitacion> getAllEstadosHabitacion() {
        return estadoHabitacionRepository.findAllEstadosHabitacion();
    }

    public EstadoHabitacion getEstadoHabitacionById(int idEstadoHabitacion) {
        return estadoHabitacionRepository.findEstadoHabitacionById(idEstadoHabitacion);
    }
}

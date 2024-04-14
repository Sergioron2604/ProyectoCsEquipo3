package com.example.CRUDsb.service;

import com.example.CRUDsb.entity.Habitacion;
import com.example.CRUDsb.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    HabitacionRepository habitacionRepository;

    public List<Habitacion> getHabitacion() {
        return habitacionRepository.findAll();
    }

    public Optional<Habitacion> getHabitaciones(Long id) {
        return habitacionRepository.findById(id);
    }

    public void saveOrUpdate(Habitacion habitacion) {
        habitacionRepository.save(habitacion);
    }

    public void delete(Long id) {
        habitacionRepository.deleteById(id);
    }

    public Optional<Double> obtenerPrecioPorId(Long id) {
        return habitacionRepository.findById(id).map(Habitacion::getPrecio);
    }
}


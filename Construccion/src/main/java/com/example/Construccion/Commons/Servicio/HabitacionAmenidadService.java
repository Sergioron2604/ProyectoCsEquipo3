package com.example.Construccion.Commons.Servicio;

import com.example.Construccion.Commons.Repositorio.HabitacionAmenidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitacionAmenidadService {

    private final HabitacionAmenidadRepository habitacionAmenidadRepository;

    @Autowired
    public HabitacionAmenidadService(HabitacionAmenidadRepository habitacionAmenidadRepository) {
        this.habitacionAmenidadRepository = habitacionAmenidadRepository;
    }


    @Transactional
    public void insertarRelacionHabitacionAmenidad(int idHabitacion, int idAmenidad) {
        habitacionAmenidadRepository.insertarRelacionHabitacionAmenidad(idHabitacion, idAmenidad);
    }


    @Transactional
    public void eliminarRelacionHabitacionAmenidad(int idHabitacion, int idAmenidad) {
        habitacionAmenidadRepository.eliminarRelacionHabitacionAmenidad(idHabitacion, idAmenidad);
    }


    @Transactional
    public void eliminarRelacionesPorIdHabitacion(int idHabitacion) {
        habitacionAmenidadRepository.eliminarRelacionesPorIdHabitacion(idHabitacion);
    }


    @Transactional
    public void eliminarRelacionesPorIdAmenidad(int idAmenidad) {
        habitacionAmenidadRepository.eliminarRelacionesPorIdAmenidad(idAmenidad);
    }
}

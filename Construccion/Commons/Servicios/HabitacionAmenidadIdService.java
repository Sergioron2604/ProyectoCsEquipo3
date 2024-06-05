package com.example.Construccion.Commons.Servicios;

import com.example.Construccion.Commons.Repositorio.HabitacionAmenidadIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitacionAmenidadIdService {

    private final HabitacionAmenidadIdRepository habitacionAmenidadIdRepository;

    @Autowired
    public HabitacionAmenidadIdService(HabitacionAmenidadIdRepository habitacionAmenidadIdRepository) {
        this.habitacionAmenidadIdRepository = habitacionAmenidadIdRepository;
    }


    @Transactional
    public void insertarRelacionHabitacionAmenidad(int idHabitacion, int idAmenidad) {
        habitacionAmenidadIdRepository.insertarRelacionHabitacionAmenidad(idHabitacion, idAmenidad);
    }


    @Transactional
    public void eliminarRelacionHabitacionAmenidad(int idHabitacion, int idAmenidad) {
        habitacionAmenidadIdRepository.eliminarRelacionHabitacionAmenidad(idHabitacion, idAmenidad);
    }


    @Transactional
    public void eliminarRelacionesPorIdHabitacion(int idHabitacion) {
        habitacionAmenidadIdRepository.eliminarRelacionesPorIdHabitacion(idHabitacion);
    }


    @Transactional
    public void eliminarRelacionesPorIdAmenidad(int idAmenidad) {
        habitacionAmenidadIdRepository.eliminarRelacionesPorIdAmenidad(idAmenidad);
    }
}

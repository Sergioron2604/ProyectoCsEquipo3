package com.example.Construccion.Service;

import com.example.Construccion.entity.Habitacion;
import com.example.Construccion.Repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public void crearHabitacion(String nombreHabitacion, String descripcion, String direccion, String ciudad, double precio, int idPropietario, int idEstado) {
        habitacionRepository.crearHabitacion(nombreHabitacion, descripcion, direccion, ciudad, precio, idPropietario, idEstado);
    }

    public void borrarHabitacion(int idHabitacion) {
        habitacionRepository.borrarHabitacion(idHabitacion);
    }

    public void actualizarHabitacion(int idHabitacion, String nombreHabitacion, String descripcion, String direccion, String ciudad, double precio, int idPropietario, int idEstado) {
        habitacionRepository.actualizarHabitacion(idHabitacion, nombreHabitacion, descripcion, direccion, ciudad, precio, idPropietario, idEstado);
    }

    public Habitacion buscarHabitacionPorId(int idHabitacion) {
        return habitacionRepository.buscarHabitacionPorId(idHabitacion);
    }

    public List<Habitacion> findAll() {
        return habitacionRepository.findAll();
    }
}

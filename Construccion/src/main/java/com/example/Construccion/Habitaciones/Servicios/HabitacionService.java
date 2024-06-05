package com.example.Construccion.Habitaciones.Servicios;

import com.example.Construccion.Auditoria.Servicios.AuditoriaServiceImpl;
import com.example.Construccion.Habitaciones.Modelo.Habitacion;
import com.example.Construccion.Habitaciones.Repositorio.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;
    private final AuditoriaServiceImpl auditoriaService;
    private static final int NUMERO_ERRORES_PARA_AUDITORIA = 3;
    private int contadorErrores = 0;


    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository, AuditoriaServiceImpl auditoriaService) {
        this.habitacionRepository = habitacionRepository;
        this.auditoriaService = auditoriaService;
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
    
    @Transactional
    public Habitacion buscarPorId(int id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    @Transactional
    public Habitacion guardar(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    @Transactional
    public void cambiarPrecioHabitacionPorId(int idHabitacion, double nuevoPrecio) {
        try {
            Habitacion habitacion = habitacionRepository.findById(idHabitacion).orElse(null);
            if (habitacion != null) {
                habitacion.setPrecio(nuevoPrecio);
                habitacionRepository.save(habitacion);
            } else {
                throw new IllegalArgumentException("La habitación con ID " + idHabitacion + " no existe");
            }
        } catch (Exception e) {
            contadorErrores++;
            if (contadorErrores >= NUMERO_ERRORES_PARA_AUDITORIA) {
                auditoriaService.registrarError("Error al cambiar el precio de la habitación con ID: " + idHabitacion);
                contadorErrores = 0;
            }
            throw e;
        }
    }


}



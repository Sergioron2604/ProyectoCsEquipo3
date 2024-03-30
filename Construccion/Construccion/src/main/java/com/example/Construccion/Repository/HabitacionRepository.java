package com.example.Construccion.repository;

import com.example.Construccion.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Habitacion (nombre_habitacion, descripcion, direccion, ciudad, precio, id_propietario, id_estado) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void crearHabitacion(String nombreHabitacion, String descripcion, String direccion, String ciudad, double precio, int idPropietario, int idEstado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Habitacion WHERE id_habitacion = ?1", nativeQuery = true)
    void borrarHabitacion(int idHabitacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Habitacion SET nombre_habitacion = ?2, descripcion = ?3, direccion = ?4, ciudad = ?5, precio = ?6, id_propietario = ?7, id_estado = ?8 " +
            "WHERE id_habitacion = ?1", nativeQuery = true)
    void actualizarHabitacion(int idHabitacion, String nombreHabitacion, String descripcion, String direccion, String ciudad, double precio, int idPropietario, int idEstado);

    @Query(value = "SELECT * FROM Habitacion WHERE id_habitacion = ?1", nativeQuery = true)
    Habitacion buscarHabitacionPorId(int idHabitacion);

    @Query(value = "SELECT * FROM Habitacion", nativeQuery = true)
    List<Habitacion> findAll();
}

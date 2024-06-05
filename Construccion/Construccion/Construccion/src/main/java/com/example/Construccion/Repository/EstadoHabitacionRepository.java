package com.example.Construccion.Repository;

import com.example.Construccion.entity.EstadoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoHabitacionRepository extends JpaRepository<EstadoHabitacion, Integer> {


    @Modifying
    @Query(value = "INSERT INTO Estado_Habitacion (estado_habitacion) VALUES (?1)", nativeQuery = true)
    void insertEstadoHabitacion(String estadoHabitacion);


    @Modifying
    @Query(value = "UPDATE Estado_Habitacion SET estado_habitacion = ?2 WHERE id_estado_habitacion = ?1", nativeQuery = true)
    void updateEstadoHabitacion(int idEstadoHabitacion, String estadoHabitacion);


    @Modifying
    @Query(value = "DELETE FROM Estado_Habitacion WHERE id_estado_habitacion = ?1", nativeQuery = true)
    void deleteEstadoHabitacion(int idEstadoHabitacion);

    @Query(value = "SELECT * FROM Estado_Habitacion", nativeQuery = true)
    List<EstadoHabitacion> findAllEstadosHabitacion();

    @Query(value = "SELECT * FROM Estado_Habitacion WHERE id_estado_habitacion = ?1", nativeQuery = true)
    EstadoHabitacion findEstadoHabitacionById(int idEstadoHabitacion);
}

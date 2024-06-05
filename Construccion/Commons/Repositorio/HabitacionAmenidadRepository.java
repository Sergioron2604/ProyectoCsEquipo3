package com.example.Construccion.Commons.Repositorio;

import com.example.Construccion.Commons.Modelo.HabitacionAmenidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionAmenidadRepository extends JpaRepository<HabitacionAmenidad, Integer> {


    @Modifying
    @Query(value = "INSERT INTO Habitacion_Amenidad (id_habitacion, id_amenidad) VALUES (?1, ?2)", nativeQuery = true)
    void insertarRelacionHabitacionAmenidad(int idHabitacion, int idAmenidad);


    @Modifying
    @Query(value = "DELETE FROM Habitacion_Amenidad WHERE id_habitacion = ?1 AND id_amenidad = ?2", nativeQuery = true)
    void eliminarRelacionHabitacionAmenidad(int idHabitacion, int idAmenidad);


    @Modifying
    @Query(value = "DELETE FROM Habitacion_Amenidad WHERE id_habitacion = ?1", nativeQuery = true)
    void eliminarRelacionesPorIdHabitacion(int idHabitacion);


    @Modifying
    @Query(value = "DELETE FROM Habitacion_Amenidad WHERE id_amenidad = ?1", nativeQuery = true)
    void eliminarRelacionesPorIdAmenidad(int idAmenidad);
}

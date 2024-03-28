package com.example.CRUDsb.repository;

import com.example.CRUDsb.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {


    @Query("SELECT h.precio FROM Habitacion h WHERE h.idHabitacion = :idHabitacion")
    Optional<Double> findPrecioById(@Param("idHabitacion") Long idHabitacion);

}
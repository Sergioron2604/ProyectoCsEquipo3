package com.example.CRUDsb.repository;

import com.example.CRUDsb.entity.HabitacionAmenidad;
import com.example.CRUDsb.entity.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionAmenidadRepository extends JpaRepository<HabitacionAmenidad, Long> {


}

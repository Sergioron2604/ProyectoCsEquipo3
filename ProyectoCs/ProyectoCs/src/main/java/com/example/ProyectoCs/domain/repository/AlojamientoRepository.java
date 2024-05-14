package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Integer> {
}

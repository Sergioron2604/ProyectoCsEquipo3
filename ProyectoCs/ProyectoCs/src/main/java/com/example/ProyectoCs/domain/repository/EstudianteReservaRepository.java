package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.EstudianteReserva;
import com.example.ProyectoCs.domain.model.EstudianteReservaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteReservaRepository extends JpaRepository<EstudianteReserva, EstudianteReservaId> {
}

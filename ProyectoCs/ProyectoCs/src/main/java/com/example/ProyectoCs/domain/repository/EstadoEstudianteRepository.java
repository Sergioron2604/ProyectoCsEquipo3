package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.EstadoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEstudianteRepository extends JpaRepository<EstadoEstudiante, Integer> {
}

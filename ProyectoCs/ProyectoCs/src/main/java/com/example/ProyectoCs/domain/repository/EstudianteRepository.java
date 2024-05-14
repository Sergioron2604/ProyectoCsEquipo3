package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, UUID> {
    Estudiante findByIdEstudiante(UUID idEstudiante);
    Estudiante findByEmail(String email);
}
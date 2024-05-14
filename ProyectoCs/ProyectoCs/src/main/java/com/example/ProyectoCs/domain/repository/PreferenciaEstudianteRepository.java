package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.PreferenciaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenciaEstudianteRepository extends JpaRepository<PreferenciaEstudiante, Integer> {
}

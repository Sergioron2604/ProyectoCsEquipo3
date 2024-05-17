package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.Estudiante;
import com.example.ProyectoCs.domain.model.Universidad;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.UUID;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer> {
}

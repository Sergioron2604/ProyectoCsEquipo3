package com.example.ProyectoCs.domain.repository;
import com.example.ProyectoCs.domain.model.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Integer> {
    Optional<Alojamiento> findById(Integer idAlojamiento);
}

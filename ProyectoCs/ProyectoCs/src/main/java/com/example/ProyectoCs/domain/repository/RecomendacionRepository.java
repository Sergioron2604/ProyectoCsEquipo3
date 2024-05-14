package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.Recomendacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacionRepository extends JpaRepository<Recomendacion, Integer> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}

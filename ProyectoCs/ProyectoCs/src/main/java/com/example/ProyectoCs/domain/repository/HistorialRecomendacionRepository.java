package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.HistorialRecomendacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRecomendacionRepository extends JpaRepository<HistorialRecomendacion, Integer> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}

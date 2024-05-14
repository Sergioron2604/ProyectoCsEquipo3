package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.EstadoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoHabitacionRepository extends JpaRepository<EstadoHabitacion, Integer> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}


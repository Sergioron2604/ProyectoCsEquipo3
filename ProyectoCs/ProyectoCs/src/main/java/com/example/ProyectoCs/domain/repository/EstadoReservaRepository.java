package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Integer> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}

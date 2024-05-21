package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.Reserva;
import com.example.ProyectoCs.application.dto.ReservaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}

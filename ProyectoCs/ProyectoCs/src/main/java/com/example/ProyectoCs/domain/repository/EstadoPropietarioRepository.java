package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.EstadoPropietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPropietarioRepository extends JpaRepository<EstadoPropietario, Integer> {
}
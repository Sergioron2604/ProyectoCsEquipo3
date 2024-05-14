package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer> {

}

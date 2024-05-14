package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer> {
}
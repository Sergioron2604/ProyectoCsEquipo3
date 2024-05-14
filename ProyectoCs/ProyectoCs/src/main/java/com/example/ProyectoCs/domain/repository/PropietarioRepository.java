package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}


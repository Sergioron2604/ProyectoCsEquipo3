package com.example.ProyectoCs.domain.repository;

import com.example.ProyectoCs.domain.model.ComportamientoBusqueda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComportamientoBusquedaRepository extends JpaRepository<ComportamientoBusqueda, Integer> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}

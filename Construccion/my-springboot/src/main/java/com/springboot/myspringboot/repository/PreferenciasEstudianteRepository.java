package com.springboot.myspringboot.repository;
import com.springboot.myspringboot.entity.PreferenciasEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenciasEstudianteRepository extends JpaRepository< PreferenciasEstudiante, Long> {

}


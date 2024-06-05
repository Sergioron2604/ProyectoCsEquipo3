package com.springboot.myspringboot.repository;

import com.springboot.myspringboot.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Estudiante, Long> {

}

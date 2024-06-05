package com.example.Construccion.UsuarioPropietarios.Repositorio;

import com.example.Construccion.UsuarioPropietarios.Modelo.EstadoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoEstudianteRepository extends JpaRepository<EstadoEstudiante, Integer> {


    @Modifying
    @Query(value = "INSERT INTO Estado_Estudiante (estado_estudiante) VALUES (?1)", nativeQuery = true)
    void insertEstadoEstudiante(String estadoEstudiante);


    @Modifying
    @Query(value = "UPDATE Estado_Estudiante SET estado_estudiante = ?2 WHERE id_estado_estudiante = ?1", nativeQuery = true)
    void updateEstadoEstudiante(int idEstadoEstudiante, String estadoEstudiante);


    @Modifying
    @Query(value = "DELETE FROM Estado_Estudiante WHERE id_estado_estudiante = ?1", nativeQuery = true)
    void deleteEstadoEstudiante(int idEstadoEstudiante);

    @Query(value = "SELECT * FROM Estado_Estudiante", nativeQuery = true)
    List<EstadoEstudiante> findAllEstadosEstudiante();


    @Query(value = "SELECT * FROM Estado_Estudiante WHERE id_estado_estudiante = ?1", nativeQuery = true)
    EstadoEstudiante findEstadoEstudianteById(int idEstadoEstudiante);
}


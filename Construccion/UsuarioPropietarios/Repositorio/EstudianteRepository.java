package com.example.Construccion.UsuarioPropietarios.Repositorio;

import com.example.Construccion.PreferenciaEstudiante.Modelo.PreferenciaEstudiante;
import com.example.Construccion.UsuarioPropietarios.Modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Estudiante (id_estudiante, nombre, edad, email, telefono, id_universidad, id_estado) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void insertEstudiante(int idEstudiante, String nombre, int edad, String email, String telefono, int idUniversidad, int idEstado);


    @Modifying
    @Query(value = "UPDATE Estudiante SET nombre = ?2, edad = ?3, email = ?4, telefono = ?5, id_universidad = ?6, id_estado = ?7 " +
            "WHERE id_estudiante = ?1", nativeQuery = true)
    void updateEstudiante(int idEstudiante, String nombre, int edad, String email, String telefono, int idUniversidad, int idEstado);


    @Modifying
    @Query(value = "DELETE FROM Estudiante WHERE id_estudiante = ?1", nativeQuery = true)
    void deleteEstudiante(int idEstudiante);


    @Query(value = "SELECT * FROM Estudiante", nativeQuery = true)
    List<Estudiante> findAllEstudiantes();

    @Query(value = "SELECT * FROM Estudiante WHERE id_estudiante = ?1", nativeQuery = true)
    Estudiante findEstudianteById(int idEstudiante);

    @Query(value = "SELECT * FROM Preferencia_Estudiante WHERE id_estudiante = ?1", nativeQuery = true)
    PreferenciaEstudiante findPreferenciasEstudianteById(int idEstudiante);

    @Query(value = "SELECT * FROM Estudiante e JOIN Preferencia_Estudiante p ON e.id_estudiante = p.id_estudiante WHERE p.id_estudiante = ?1", nativeQuery = true)
    Estudiante findEstudianteByPreferenciaEstudianteId(int idEstudiante);


}

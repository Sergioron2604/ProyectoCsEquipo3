package com.example.Construccion.Commons.Repositorio;

import com.example.Construccion.Commons.Modelo.EstudianteReserva;
import com.example.Construccion.Commons.Modelo.EstudianteReservaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteReservaIdRepository extends JpaRepository<EstudianteReserva, EstudianteReservaId> {


    @Modifying
    @Query(value = "INSERT INTO Estudiante_Reserva (id_estudiante, id_reserva) VALUES (?1, ?2)", nativeQuery = true)
    void insertEstudianteReserva(int idEstudiante, int idReserva);

    @Modifying
    @Query(value = "DELETE FROM Estudiante_Reserva WHERE id_estudiante = ?1 AND id_reserva = ?2", nativeQuery = true)
    void deleteEstudianteReserva(int idEstudiante, int idReserva);


    @Query(value = "SELECT * FROM Estudiante_Reserva", nativeQuery = true)
    List<EstudianteReserva> findAllEstudiantesReserva();


    @Query(value = "SELECT * FROM Estudiante_Reserva WHERE id_estudiante = ?1", nativeQuery = true)
    List<EstudianteReserva> findReservasByEstudiante(int idEstudiante);


    @Query(value = "SELECT * FROM Estudiante_Reserva WHERE id_reserva = ?1", nativeQuery = true)
    List<EstudianteReserva> findEstudiantesByReserva(int idReserva);
}

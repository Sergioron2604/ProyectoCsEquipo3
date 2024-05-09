package com.example.Construccion.Commons.Repositorio;

import com.example.Construccion.Commons.Modelo.EstudianteReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EstudianteReservaRepository extends JpaRepository<EstudianteReserva, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Estudiante_Reserva (id_estudiante, id_reserva) VALUES (?1, ?2)", nativeQuery = true)
    void crearEstudianteReserva(long idEstudiante, long idReserva);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Estudiante_Reserva WHERE id_estudiante = ?1 AND id_reserva = ?2", nativeQuery = true)
    void borrarEstudianteReserva(long idEstudiante, long idReserva);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Estudiante_Reserva SET id_estudiante = ?2, id_reserva = ?3 WHERE id_estudiante = ?1", nativeQuery = true)
    void actualizarEstudianteReserva(long idEstudiante, long newIdEstudiante, long newIdReserva);

    @Query(value = "SELECT * FROM Estudiante_Reserva WHERE id_estudiante = ?1 AND id_reserva = ?2", nativeQuery = true)
    EstudianteReserva buscarEstudianteReserva(long idEstudiante, long idReserva);

    @Query(value = "SELECT * FROM Estudiante_Reserva", nativeQuery = true)
    List<EstudianteReserva> findAll();
}

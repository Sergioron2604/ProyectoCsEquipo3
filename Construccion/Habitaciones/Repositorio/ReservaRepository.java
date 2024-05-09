package com.example.Construccion.Habitaciones.Repositorio;

import com.example.Construccion.Habitaciones.Modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {


    @Modifying
    @Query(value = "INSERT INTO Reserva (id_reserva, id_estudiante, id_habitacion, fecha_inicio, fecha_fin, id_estado) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void insertReserva(int idReserva, int idEstudiante, int idHabitacion, Date fechaInicio, Date fechaFin, int idEstado);


    @Modifying
    @Query(value = "UPDATE Reserva SET id_estudiante = ?2, id_habitacion = ?3, fecha_inicio = ?4, fecha_fin = ?5, id_estado = ?6 " +
            "WHERE id_reserva = ?1", nativeQuery = true)
    void updateReserva(int idReserva, int idEstudiante, int idHabitacion, Date fechaInicio, Date fechaFin, int idEstado);


    @Modifying
    @Query(value = "DELETE FROM Reserva WHERE id_reserva = ?1", nativeQuery = true)
    void deleteReserva(int idReserva);


    @Query(value = "SELECT * FROM Reserva", nativeQuery = true)
    List<Reserva> findAllReservas();


    Reserva findByidReserva(int idReserva);
}

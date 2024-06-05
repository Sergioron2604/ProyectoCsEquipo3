package com.example.Construccion.Commons.Repositorio;

import com.example.Construccion.Commons.Modelo.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Integer> {


    @Modifying
    @Query(value = "INSERT INTO Estado_Reserva (estado_reserva) VALUES (?1)", nativeQuery = true)
    void insertEstadoReserva(String estadoReserva);


    @Modifying
    @Query(value = "UPDATE Estado_Reserva SET estado_reserva = ?2 WHERE id_estado_reserva = ?1", nativeQuery = true)
    void updateEstadoReserva(int idEstadoReserva, String estadoReserva);


    @Modifying
    @Query(value = "DELETE FROM Estado_Reserva WHERE id_estado_reserva = ?1", nativeQuery = true)
    void deleteEstadoReserva(int idEstadoReserva);


    @Query(value = "SELECT * FROM Estado_Reserva", nativeQuery = true)
    List<EstadoReserva> findAllEstadosReserva();


    @Query(value = "SELECT * FROM Estado_Reserva WHERE id_estado_reserva = ?1", nativeQuery = true)
    EstadoReserva findEstadoReservaById(int idEstadoReserva);
}


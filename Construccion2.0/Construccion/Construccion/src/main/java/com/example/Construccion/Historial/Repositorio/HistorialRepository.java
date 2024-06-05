package com.example.Construccion.Historial.Repositorio;

import com.example.Construccion.Historial.Modelo.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface HistorialRepository extends JpaRepository<Historial, Integer> {


    @Modifying
    @Query(value = "INSERT INTO Historial (id_historial, id_entidad_afectada, tipo_entidad, id_estado_anterior, id_estado_nuevo, fecha_hora_cambio) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void insertHistorial(int idHistorial, int idEntidadAfectada, String tipoEntidad, int idEstadoAnterior, int idEstadoNuevo, Date fechaHoraCambio);


    @Modifying
    @Query(value = "UPDATE Historial SET id_entidad_afectada = ?2, tipo_entidad = ?3, id_estado_anterior = ?4, id_estado_nuevo = ?5, fecha_hora_cambio = ?6 " +
            "WHERE id_historial = ?1", nativeQuery = true)
    void updateHistorial(int idHistorial, int idEntidadAfectada, String tipoEntidad, int idEstadoAnterior, int idEstadoNuevo, Date fechaHoraCambio);


    @Modifying
    @Query(value = "DELETE FROM Historial WHERE id_historial = ?1", nativeQuery = true)
    void deleteHistorial(int idHistorial);


    @Query(value = "SELECT * FROM Historial", nativeQuery = true)
    List<Historial> findAllHistorial();
}

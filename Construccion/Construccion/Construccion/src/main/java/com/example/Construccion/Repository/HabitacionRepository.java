package com.example.Construccion.Repository;

import com.example.Construccion.entity.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Habitacion (nombre_habitacion, descripcion, direccion, ciudad, precio, id_propietario, id_estado) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void crearHabitacion(String nombreHabitacion, String descripcion, String direccion, String ciudad, double precio, int idPropietario, int idEstado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Habitacion WHERE id_habitacion = ?1", nativeQuery = true)
    void borrarHabitacion(int idHabitacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Habitacion SET nombre_habitacion = ?2, descripcion = ?3, direccion = ?4, ciudad = ?5, precio = ?6, id_propietario = ?7, id_estado = ?8 " +
            "WHERE id_habitacion = ?1", nativeQuery = true)
    void actualizarHabitacion(int idHabitacion, String nombreHabitacion, String descripcion, String direccion, String ciudad, double precio, int idPropietario, int idEstado);

    @Query(value = "SELECT * FROM Habitacion WHERE id_habitacion = ?1", nativeQuery = true)
    Habitacion buscarHabitacionPorId(int idHabitacion);

    @Query(value = "SELECT h.* FROM Habitacion h " +
            "JOIN Estado_Habitacion eh ON h.id_estado = eh.id_estado_habitacion " +
            "WHERE eh.estado_habitacion = 'Disponible' " +
            "AND h.precio <= ?2 " +
            "AND h.ciudad = (SELECT ciudad FROM Universidad WHERE id_universidad = ?3) " +
            "AND NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM Reserva r " +
            "    WHERE r.id_habitacion = h.id_habitacion " +
            "    AND r.fecha_inicio <= ?4 " +
            "    AND r.fecha_fin >= ?5)", nativeQuery = true)
    List<Habitacion> buscarHabitacionesDisponiblesPorPreferencias(int idHabitacion, double presupuestoMaximo, long idUniversidad, Date fechaInicio, Date fechaFin);

    @Query(value = "SELECT * FROM Habitacion", nativeQuery = true)
    List<Habitacion> findAll();

    @Query(value = "SELECT * FROM Habitacion h WHERE h.id_estado = 1 AND EXISTS (SELECT 1 FROM Habitacion_Amenidad ha JOIN Amenidades a ON ha.id_amenidad = a.id_amenidad WHERE ha.id_habitacion = h.id_habitacion AND a.nombre_amenidad IN ('roomie', 'lavandería', 'parqueadero'))", nativeQuery = true)
    List<Habitacion> findHabitacionesDesocupadasConNecesidades();

}

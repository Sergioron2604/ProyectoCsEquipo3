package com.example.Construccion.repository;

import com.example.Construccion.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Comentario (id_comentario, id_habitacion, id_estudiante, comentario) " +
            "VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertComentario(int idComentario, int idHabitacion, int idEstudiante, String comentario);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Comentario SET comentario = ?2 WHERE id_comentario = ?1", nativeQuery = true)
    void updateComentario(int idComentario, String comentario);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Comentario WHERE id_comentario = ?1", nativeQuery = true)
    void deleteComentario(int idComentario);


    @Query(value = "SELECT * FROM Comentario WHERE id_habitacion = ?1", nativeQuery = true)
    List<Comentario> findByHabitacion(int idHabitacion);


    @Query(value = "SELECT * FROM Comentario WHERE id_estudiante = ?1", nativeQuery = true)
    List<Comentario> findByEstudiante(int idEstudiante);
}

package com.example.Construccion.repository;

import com.example.Construccion.entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer> {


    @Modifying
    @Query(value = "INSERT INTO Foto (id_foto, id_habitacion, url) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void insertFoto(int idFoto, int idHabitacion, String url);


    @Modifying
    @Query(value = "UPDATE Foto SET url = ?2 WHERE id_foto = ?1", nativeQuery = true)
    void updateFoto(int idFoto, String url);


    @Modifying
    @Query(value = "DELETE FROM Foto WHERE id_foto = ?1", nativeQuery = true)
    void deleteFoto(int idFoto);


    @Query(value = "SELECT * FROM Foto WHERE id_habitacion = ?1", nativeQuery = true)
    List<Foto> findFotosByHabitacion(int idHabitacion);
}

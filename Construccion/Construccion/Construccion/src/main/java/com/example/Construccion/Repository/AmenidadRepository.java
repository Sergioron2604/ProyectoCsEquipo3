package com.example.Construccion.Repository;

import com.example.Construccion.entity.Amenidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenidadRepository extends JpaRepository<Amenidad, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Amenidad (nombre_amenidad) VALUES (?1)", nativeQuery = true)
    void insertAmenidad(String nombreAmenidad);

    @Modifying
    @Query(value = "UPDATE Amenidad SET nombre_amenidad = ?2 WHERE id_amenidad = ?1", nativeQuery = true)
    void updateAmenidad(int idAmenidad, String nombreAmenidad);

    @Modifying
    @Query(value = "DELETE FROM Amenidad WHERE id_amenidad = ?1", nativeQuery = true)
    void deleteAmenidadById(int idAmenidad);

    @Query(value = "SELECT * FROM Amenidad WHERE nombre_amenidad = ?1", nativeQuery = true)
    Amenidad findByNombreAmenidad(String nombreAmenidad);

    @Query(value = "SELECT * FROM Amenidad WHERE id_amenidad = ?1", nativeQuery = true)
    Amenidad findByIdAmenidad(int idAmenidad);

    @Query(value = "SELECT * FROM Amenidad", nativeQuery = true)
    List<Amenidad> findAllAmenidades();
}

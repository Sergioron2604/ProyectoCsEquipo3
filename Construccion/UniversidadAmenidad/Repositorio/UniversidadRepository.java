package com.example.Construccion.UniversidadAmenidad.Repositorio;

import com.example.Construccion.UniversidadAmenidad.Modelo.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer> {


    @Modifying
    @Query(value = "INSERT INTO Universidad (id_universidad, nombre_universidad, direccion, ciudad) " +
            "VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void saveUniversidad(int idUniversidad, String nombreUniversidad, String direccion, String ciudad);


    @Modifying
    @Query(value = "UPDATE Universidad SET nombre_universidad = ?2, direccion = ?3, ciudad = ?4 " +
            "WHERE id_universidad = ?1", nativeQuery = true)
    void updateUniversidad(int idUniversidad, String nombreUniversidad, String direccion, String ciudad);


    @Modifying
    @Query(value = "DELETE FROM Universidad WHERE id_universidad = ?1", nativeQuery = true)
    void deleteUniversidad(int idUniversidad);


    @Query(value = "SELECT * FROM Universidad", nativeQuery = true)
    List<Universidad> findAllUniversidades();
}

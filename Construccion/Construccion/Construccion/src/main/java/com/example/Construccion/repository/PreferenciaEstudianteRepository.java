package com.example.Construccion.repository;

import com.example.Construccion.entity.PreferenciaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferenciaEstudianteRepository extends JpaRepository<PreferenciaEstudiante, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Preferencia_Estudiante (id_preferencia, id_estudiante, presupuesto_maximo, desea_roomie, desea_lavanderia, necesita_parqueadero_bicicleta) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void insertPreferenciaEstudiante(int idPreferencia, int idEstudiante, double presupuestoMaximo, boolean deseaRoomie, boolean deseaLavanderia, boolean necesitaParqueaderoBicicleta);


    @Modifying
    @Query(value = "UPDATE Preferencia_Estudiante SET presupuesto_maximo = ?3, desea_roomie = ?4, desea_lavanderia = ?5, necesita_parqueadero_bicicleta = ?6 " +
            "WHERE id_preferencia = ?1 AND id_estudiante = ?2", nativeQuery = true)
    void updatePreferenciaEstudiante(int idPreferencia, int idEstudiante, double presupuestoMaximo, boolean deseaRoomie, boolean deseaLavanderia, boolean necesitaParqueaderoBicicleta);


    @Modifying
    @Query(value = "DELETE FROM Preferencia_Estudiante WHERE id_preferencia = ?1 AND id_estudiante = ?2", nativeQuery = true)
    void deletePreferenciaEstudiante(int idPreferencia, int idEstudiante);


    @Query(value = "SELECT * FROM Preferencia_Estudiante WHERE id_preferencia = ?1 AND id_estudiante = ?2", nativeQuery = true)
    PreferenciaEstudiante findPreferenciaEstudianteById(int idPreferencia, int idEstudiante);


    @Query(value = "SELECT * FROM Preferencia_Estudiante", nativeQuery = true)
    List<PreferenciaEstudiante> findAllPreferenciasEstudiantes();
}

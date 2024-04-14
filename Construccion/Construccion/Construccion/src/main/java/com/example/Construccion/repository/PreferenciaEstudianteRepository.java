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
    @Query(value = "INSERT INTO Preferencia_Estudiante (id_preferencia, id_estudiante, tipo_espacio, presupuesto_maximo, distancia_maxima, desea_roomie, necesita_parqueadero_bicicleta) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void insertPreferenciaEstudiante(int idPreferencia, int idEstudiante, String tipoEspacio, double presupuestoMaximo, double distanciaMaxima, boolean deseaRoomie, boolean necesitaParqueaderoBicicleta);


    @Modifying
    @Query(value = "UPDATE Preferencia_Estudiante SET tipo_espacio = ?3, presupuesto_maximo = ?4, distancia_maxima = ?5, desea_roomie = ?6, necesita_parqueadero_bicicleta = ?7 " +
            "WHERE id_preferencia = ?1 AND id_estudiante = ?2", nativeQuery = true)
    void updatePreferenciaEstudiante(int idPreferencia, int idEstudiante, String tipoEspacio, double presupuestoMaximo, double distanciaMaxima, boolean deseaRoomie, boolean necesitaParqueaderoBicicleta);


    @Modifying
    @Query(value = "DELETE FROM Preferencia_Estudiante WHERE id_preferencia = ?1 AND id_estudiante = ?2", nativeQuery = true)
    void deletePreferenciaEstudiante(int idPreferencia, int idEstudiante);


    @Query(value = "SELECT * FROM Preferencia_Estudiante WHERE id_preferencia = ?1 AND id_estudiante = ?2", nativeQuery = true)
    PreferenciaEstudiante findPreferenciaEstudianteById(int idPreferencia, int idEstudiante);


    @Query(value = "SELECT * FROM Preferencia_Estudiante", nativeQuery = true)
    List<PreferenciaEstudiante> findAllPreferenciasEstudiantes();
}

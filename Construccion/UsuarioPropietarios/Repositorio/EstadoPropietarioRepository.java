package com.example.Construccion.UsuarioPropietarios.Repositorio;

import com.example.Construccion.UsuarioPropietarios.Modelo.EstadoPropietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoPropietarioRepository extends JpaRepository<EstadoPropietario, Integer> {


    @Modifying
    @Query(value = "INSERT INTO Estado_Propietario (id_estado_propietario, estado_propietario) VALUES (?1, ?2)", nativeQuery = true)
    void insertEstadoPropietario(int idEstadoPropietario, String estadoPropietario);


    @Modifying
    @Query(value = "UPDATE Estado_Propietario SET estado_propietario = ?2 WHERE id_estado_propietario = ?1", nativeQuery = true)
    void updateEstadoPropietario(int idEstadoPropietario, String estadoPropietario);


    @Modifying
    @Query(value = "DELETE FROM Estado_Propietario WHERE id_estado_propietario = ?1", nativeQuery = true)
    void deleteEstadoPropietario(int idEstadoPropietario);

    @Query(value = "SELECT * FROM Estado_Propietario", nativeQuery = true)
    List<EstadoPropietario> findAllEstadosPropietario();


    @Query(value = "SELECT * FROM Estado_Propietario WHERE id_estado_propietario = ?1", nativeQuery = true)
    EstadoPropietario findEstadoPropietarioById(int idEstadoPropietario);
}

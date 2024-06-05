package com.example.Construccion.UsuarioPropietarios.Repositorio;

import com.example.Construccion.UsuarioPropietarios.Modelo.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Propietario (id_propietario, nombre, email, telefono, id_estado, id_universidad) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void insertPropietario(int idPropietario, String nombre, String email, String telefono, int idEstado, int idUniversidad);


    @Modifying
    @Query(value = "UPDATE Propietario SET nombre = ?2, email = ?3, telefono = ?4, id_estado = ?5, id_universidad = ?6 " +
            "WHERE id_propietario = ?1", nativeQuery = true)
    void updatePropietario(int idPropietario, String nombre, String email, String telefono, int idEstado, int idUniversidad);


    @Modifying
    @Query(value = "DELETE FROM Propietario WHERE id_propietario = ?1", nativeQuery = true)
    void deletePropietario(int idPropietario);


    @Query(value = "SELECT * FROM Propietario", nativeQuery = true)
    List<Propietario> findAllPropietarios();


    @Query(value = "SELECT * FROM Propietario WHERE id_propietario = ?1", nativeQuery = true)
    Propietario findPropietarioBy(int idpropietario);
}

package com.example.Construccion.UniversidadAmenidad.Modelo;
import com.example.Construccion.UsuariosPropietarios.Modelo.Propietario;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Universidad")

public class Universidad {

    @Id
    @Column(name = "id_universidad")
    private int idUniversidad;

    @Column(name = "nombre_universidad")
    private String nombreUniversidad;

    private String direccion;

    private String ciudad;

    @OneToMany(mappedBy = "universidad")
    private Set<Propietario> propietarios;
}
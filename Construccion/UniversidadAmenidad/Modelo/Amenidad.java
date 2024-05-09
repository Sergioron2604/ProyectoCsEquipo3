package com.example.Construccion.UniversidadAmenidad.Modelo;
import com.example.Construccion.UsuarioPropietarios.Modelo.Propietario;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Amenidad")

public class Amenidad {

    @Id
    @Column(name = "id_amenidad")
    private int idAmenidad;

    @Column(name = "nombre_amenidad")
    private String nombreAmenidad;

    @ManyToMany(mappedBy = "amenidades")
    private Set<Propietario> propietarios;
}
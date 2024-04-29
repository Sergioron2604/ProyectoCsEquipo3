package com.example.Construccion.entity;
import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "Propietario")

public class Propietario {

    @Id
    @Column(name = "id_propietario")
    private int idPropietario;

    private String nombre;

    private String email;

    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoPropietario estadoPropietario;

    @ManyToOne
    @JoinColumn(name = "id_universidad")
    private Universidad universidad;

    @ManyToMany
    @JoinTable(
            name = "Propietario_Amenidades",
            joinColumns = @JoinColumn(name = "id_propietario"),
            inverseJoinColumns = @JoinColumn(name = "id_amenidad")
    )
    private Set<Amenidad> amenidades;
}
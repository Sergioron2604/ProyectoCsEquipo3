package com.example.Construccion.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Habitacion")
public class Habitacion {

    @Id
    @Column(name = "id_habitacion")
    private int idHabitacion;

    @Column(name = "nombre_habitacion")
    private String nombreHabitacion;

    private String descripcion;

    private String direccion;

    private String ciudad;

    private double precio;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoHabitacion estadoHabitacion;

    @ManyToMany
    @JoinTable(
            name = "Habitacion_Amenidad",
            joinColumns = @JoinColumn(name = "id_habitacion"),
            inverseJoinColumns = @JoinColumn(name = "id_amenidad")
    )
    private Set<Amenidad> amenidades;

    @OneToMany(mappedBy = "habitacion")
    private Set<Comentario> comentarios;
}
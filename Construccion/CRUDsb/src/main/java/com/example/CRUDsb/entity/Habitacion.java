package com.example.CRUDsb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Habitacion")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "nombre_habitacion")
    private String nombreHabitacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoHabitacion estadoHabitacion;

    @OneToMany(mappedBy = "habitacion")
    private Set<HabitacionAmenidad> habitacionAmenidades;

    @OneToMany(mappedBy = "habitacion")
    private Set<Comentario> comentarios;

    @OneToMany(mappedBy = "habitacion")
    private Set<Foto> fotos;

    @OneToMany(mappedBy = "habitacion")
    private Set<Reserva> reservas;

}

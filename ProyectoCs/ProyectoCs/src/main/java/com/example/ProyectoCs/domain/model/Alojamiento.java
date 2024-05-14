package com.example.ProyectoCs.domain.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Alojamiento")
public class Alojamiento {

    @Id
    @Column(name = "id_alojamiento")
    private int idAlojamiento;

    @Column(name = "nombre_alojamiento", length = 50)
    private String nombreAlojamiento;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "ciudad", length = 50)
    private String ciudad;

    @Column(name = "precio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoHabitacion estadoHabitacion;

    @ManyToOne
    @JoinColumn(name = "TipoAlojamientoID")
    private TipoAlojamiento tipoAlojamiento;

    @Column(name = "TieneLavanderia")
    private boolean tieneLavanderia;

    @Column(name = "TieneRoomie")
    private boolean tieneRoomie;

    @Column(name = "TieneParqueaderoBicicleta")
    private boolean tieneParqueaderoBicicleta;

}

package com.example.CRUDsb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class HabitacionAmenidadId implements Serializable {

    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "id_amenidad")
    private Integer idAmenidad;
}

package com.example.CRUDsb.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Entity
@Table(name = "Amenidades")
public class Amenidad {

    @Id
    @Column(name = "id_amenidad")
    private Integer idAmenidad;

    @Column(name = "nombre_amenidad")
    private String nombreAmenidad;

    @OneToMany(mappedBy = "amenidad")
    private Set<HabitacionAmenidad> habitacionAmenidades;
}

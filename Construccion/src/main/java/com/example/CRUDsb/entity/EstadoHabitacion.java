package com.example.CRUDsb.entity;
import jakarta.persistence.*;
import java.util.Set;

import lombok.Data;

@Data
@Entity
@Table(name = "Estado_Habitacion")
public class EstadoHabitacion {
    @Id
    @Column(name = "id_estado_habitacion")
    private Integer idEstadoHabitacion;

    @Column(name = "estado_habitacion")
    private String estadoHabitacion;

    @OneToMany(mappedBy = "estadoHabitacion")
    private Set<Habitacion> habitaciones;

}

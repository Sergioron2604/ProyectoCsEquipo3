package com.example.CRUDsb.entity;
import jakarta.persistence.*;
import java.util.Set;

import lombok.Data;

@Data
@Entity
@Table(name = "Habitacion_Amenidad")
public class HabitacionAmenidad {

    @EmbeddedId
    private HabitacionAmenidadId id;

    @ManyToOne
    @MapsId("idHabitacion")
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    @ManyToOne
    @MapsId("idAmenidad")
    @JoinColumn(name = "id_amenidad")
    private Amenidad amenidad;

}

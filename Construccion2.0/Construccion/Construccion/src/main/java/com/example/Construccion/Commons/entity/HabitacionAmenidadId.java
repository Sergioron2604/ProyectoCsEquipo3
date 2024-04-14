package com.example.Construccion.Commons.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import lombok.Data;

@Data
@Embeddable
public class HabitacionAmenidadId implements Serializable {

    @Column(name = "id_habitacion")
    private int idHabitacion;

    @Column(name = "id_amenidad")
    private int idAmenidad;
}

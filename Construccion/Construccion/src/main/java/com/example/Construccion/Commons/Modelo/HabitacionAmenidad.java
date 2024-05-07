package com.example.Construccion.Commons.Modelo;
import com.example.Construccion.UniversidadAmenidad.Modelo.Amenidad;
import com.example.Construccion.Habitaciones.Modelo.Habitacion;
import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Habitacion_Amenidad")

public class HabitacionAmenidad {

    @EmbeddedId
    private HabitacionAmenidadId id;

    @ManyToOne
    @MapsId("idHabitacion")
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion")
    private Habitacion habitacion;

    @ManyToOne
    @MapsId("idAmenidad")
    @JoinColumn(name = "id_amenidad", referencedColumnName = "id_amenidad")
    private Amenidad amenidad;

    // Constructor vacío
    public HabitacionAmenidad() {
    }

}


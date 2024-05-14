package com.example.ProyectoCs.domain.model;
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Estudiante_Reserva")
public class EstudianteReserva {

    @EmbeddedId
    private EstudianteReservaId id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_reserva", insertable = false, updatable = false)
    private Reserva reserva;
}

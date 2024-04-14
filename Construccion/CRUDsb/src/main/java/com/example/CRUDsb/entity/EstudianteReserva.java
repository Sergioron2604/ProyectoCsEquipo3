package com.example.CRUDsb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Estudiante_Reserva")
public class EstudianteReserva {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

}

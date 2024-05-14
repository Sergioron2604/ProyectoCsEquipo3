package com.example.ProyectoCs.domain.model;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class EstudianteReservaId implements Serializable {

    @Column(name = "id_estudiante")
    private int idEstudiante;

    @Column(name = "id_reserva")
    private int idReserva;
}

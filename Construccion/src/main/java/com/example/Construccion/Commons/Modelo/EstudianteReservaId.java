package com.example.Construccion.Commons.Modelo;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class EstudianteReservaId implements Serializable {

    @Column(name = "id_estudiante")
    private int idEstudiante;

    @Column(name = "id_reserva")
    private int idReserva;

}

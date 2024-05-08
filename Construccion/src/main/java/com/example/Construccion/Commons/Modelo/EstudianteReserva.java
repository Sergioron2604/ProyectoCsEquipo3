package com.example.Construccion.Commons.Modelo;
import com.example.Construccion.Habitaciones.Modelo.Reserva;
import com.example.Construccion.UsuariosPropietarios.Modelo.Estudiante;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Estudiante_Reserva")

public class EstudianteReserva {

    @EmbeddedId
    private EstudianteReservaId id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", insertable = false, updatable = false)
    private Reserva reserva;

}
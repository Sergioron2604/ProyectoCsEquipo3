package com.example.Construccion.Habitaciones.Modelo;
import com.example.Construccion.Commons.Modelo.EstadoReserva;
import com.example.Construccion.UsuarioPropietarios.Modelo.Estudiante;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    @Column(name = "id_reserva")
    private int idReserva;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoReserva estadoReserva;

    @ManyToMany
    @JoinTable(
            name = "Estudiante_Reserva",
            joinColumns = @JoinColumn(name = "id_reserva"),
            inverseJoinColumns = @JoinColumn(name = "id_estudiante")
    )
    private Set<Estudiante> estudiantes;
}

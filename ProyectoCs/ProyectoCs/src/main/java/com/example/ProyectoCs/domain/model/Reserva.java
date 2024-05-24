package com.example.ProyectoCs.domain.model;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private int idReserva;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_alojamiento")
    private Alojamiento alojamiento;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoReserva estadoReserva;
}

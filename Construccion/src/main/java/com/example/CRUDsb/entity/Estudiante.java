package com.example.CRUDsb.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Entity
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_universidad")
    private Universidad universidad;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEstudiante estado;

    @OneToMany(mappedBy = "estudiante")
    private Set<Comentario> comentarios;

    @OneToMany(mappedBy = "estudiante")
    private Set<Reserva> reservas;

    @OneToOne(mappedBy = "estudiante")
    private PreferenciaEstudiante preferencia;
}

package com.example.ProyectoCs.domain.model;
import lombok.Data;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;


@Data
@Entity
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID idEstudiante;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "edad", nullable = false)
    private int edad;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_universidad")
    private Universidad universidad;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEstudiante estadoEstudiante;
}

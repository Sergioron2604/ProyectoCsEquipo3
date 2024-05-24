package com.example.ProyectoCs.domain.model;
import lombok.Data;
import jakarta.persistence.*;
import java.util.UUID;
@Data
@Entity
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID idEstudiante;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "email")
    private String email;

     @Column(name = "contraseña")
     private String contraseña;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_universidad")
    private Universidad universidad;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEstudiante estadoEstudiante;

}

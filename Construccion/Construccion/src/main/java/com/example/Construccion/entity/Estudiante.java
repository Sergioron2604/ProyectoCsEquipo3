package com.example.Construccion.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
@Data
@Entity
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @Column(name = "id_estudiante")
    private int idEstudiante;

    private String nombre;

    private int edad;

    private String email;

    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_universidad")
    private Universidad universidad;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEstudiante estadoEstudiante;

    @OneToMany(mappedBy = "estudiante")
    private Set<Comentario> comentarios;
}

package com.example.Construccion.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
//import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @Column(name = "id_estudiante")
    private int idEstudiante;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @Column(name = "Email", nullable = false)
   // @Email(message = "El formato del correo electrónico es inválido")
    private String email;

    @Column(name = "Telefono", nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_universidad", nullable = false)
    private Universidad universidad;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadoEstudiante estadoEstudiante;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private Set<Comentario> comentarios;

    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private PreferenciaEstudiante preferenciaEstudiante;
}

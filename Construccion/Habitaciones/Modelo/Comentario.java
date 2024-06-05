package com.example.Construccion.Habitaciones.Modelo;
import com.example.Construccion.UsuarioPropietarios.Modelo.Estudiante;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Comentario")
public class Comentario {

    @Id
    @Column(name = "id_comentario")
    private int idComentario;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @Column(columnDefinition = "TEXT")
    private String comentario;
}
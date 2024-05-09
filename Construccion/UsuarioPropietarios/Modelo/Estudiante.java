package com.example.Construccion.UsuarioPropietarios.Modelo;
import com.example.Construccion.Habitaciones.Modelo.Comentario;
import com.example.Construccion.UniversidadAmenidad.Modelo.Universidad;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
// import javax.validation.constraints.Email;
// import javax.validation.constraints.NotBlank;


@Data
@Entity
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @Column(name = "Email", nullable = false)
    //@Email(message = "Debe ingresar un correo electrónico válido")
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


    @Column(name = "id_preferencia")
    private Integer idPreferencia;
}


package com.springboot.myspringboot.entity;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "Estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Student_Id", unique = true, nullable = false)
    private Long studentId;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @Column(name = "Email", nullable = false )
    private String email;

    @Column(name = "Telefono", nullable = false)
    private long telefono;

    @Column(name = "Id_Estado_Estudiante", nullable = false)
    private String idEstadoEstudiante;


    @OneToOne(mappedBy = "estudiante")
    private PreferenciasEstudiante preferenciasEstudiante;

}

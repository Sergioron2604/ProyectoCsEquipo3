package com.example.CRUDsb.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;


@Data
@Entity
@Table(name = "Estado_Estudiante")
public class EstadoEstudiante {

    @Id
    @Column(name = "id_estado_estudiante")
    private Integer idEstadoEstudiante;

    @Column(name = "estado_estudiante")
    private String estadoEstudiante;

    @OneToMany(mappedBy = "estado")
    private Set<Estudiante> estudiantes;
}

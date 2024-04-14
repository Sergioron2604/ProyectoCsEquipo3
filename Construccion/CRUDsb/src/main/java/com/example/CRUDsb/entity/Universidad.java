package com.example.CRUDsb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Universidad")

public class Universidad {

    @Id
    @Column(name = "id_universidad")
    private Integer idUniversidad;

    @Column(name = "nombre_universidad")
    private String nombreUniversidad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @OneToMany(mappedBy = "universidad")
    private Set<Estudiante> estudiantes;


}

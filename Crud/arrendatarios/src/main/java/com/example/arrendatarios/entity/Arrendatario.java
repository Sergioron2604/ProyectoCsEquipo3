package com.example.arrendatarios.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Arrendatarios")

public class Arrendatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Cedula", unique = true, nullable = false)
    private double IdPropietario;
    private String Nombre;
    @Column(name = "Correo", unique = true, nullable = false)
    private String Email;
    private long Telefono;
    private boolean EstadoPropietario;

}

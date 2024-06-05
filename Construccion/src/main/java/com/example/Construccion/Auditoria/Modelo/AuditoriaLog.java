package com.example.Construccion.Auditoria.Modelo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "auditoria_log")
public class AuditoriaLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private Date fecha;

}

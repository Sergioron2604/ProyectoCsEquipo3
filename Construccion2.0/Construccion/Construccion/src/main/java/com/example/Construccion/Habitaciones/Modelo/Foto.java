package com.example.Construccion.Habitaciones.Modelo;
import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Foto")
public class Foto {

    @Id
    @Column(name = "id_foto")
    private int idFoto;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    private String url;
}
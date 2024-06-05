package com.example.CRUDsb.entity;
import jakarta.persistence.*;
import java.util.Set;

import lombok.Data;

@Data
@Entity
@Table(name = "Foto")
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Integer idFoto;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    @Column(name = "url")
    private String url;

}

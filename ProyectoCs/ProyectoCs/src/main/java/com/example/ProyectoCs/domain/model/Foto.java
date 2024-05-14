package com.example.ProyectoCs.domain.model;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Foto")
public class Foto {

    @Id
    @Column(name = "id_foto")
    private int idFoto;

    @ManyToOne
    @JoinColumn(name = "id_alojamiento")
    private Alojamiento alojamiento;

    @Column(name = "url", length = 255)
    private String url;
}

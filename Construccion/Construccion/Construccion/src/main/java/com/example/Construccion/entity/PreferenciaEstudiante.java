package com.example.Construccion.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Preferencia_Estudiante")

public class PreferenciaEstudiante {

    @Id
    @Column(name = "id_preferencia")
    private int idPreferencia;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @Column(name = "presupuesto_maximo")
    private double presupuestoMaximo;

    @Column(name = "desea_roomie")
    private boolean deseaRoomie;

    @Column(name = "desea_lavanderia")
    private boolean deseaLavanderia;

    @Column(name = "necesita_parqueadero_bicicleta")
    private boolean necesitaParqueaderoBicicleta;
}